package com.excelsus.createmodern;

import static com.simibubi.create.AllTags.*;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import com.simibubi.create.content.AllSections;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.entry.ItemEntry;

public class AllModernItems {
	private static final CreateRegistrate REGISTRATE = CreateModern.registrate()
		.creativeModeTab(() -> CreateModern.MODERN_CREATIVE_TAB);

	static {
		REGISTRATE.startSection(AllSections.PALETTES);
	}

	public static final ItemEntry<Item> RAW_CHROME =
		taggedIngredient("raw_chrome", forgeItemTag("raw_materials/chrome"), forgeItemTag("raw_materials"));

	public static final ItemEntry<Item> RAW_URANIUM =
		taggedIngredient("raw_uranium", forgeItemTag("raw_materials/uranium"), forgeItemTag("raw_materials"));

	@SafeVarargs
	private static ItemEntry<Item> taggedIngredient(String name, TagKey<Item>... tags) {
		return REGISTRATE.item(name, Item::new)
			.tag(tags)
			.register();
	}

	// Load this class
	public static void register() {}
}
