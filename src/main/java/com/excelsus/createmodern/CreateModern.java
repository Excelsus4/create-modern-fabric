package com.excelsus.createmodern;

import static com.excelsus.createmodern.AllItems.*;

import com.mojang.logging.LogUtils;
import com.simibubi.create.Create;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import org.slf4j.Logger;

public class CreateModern implements ModInitializer {
	public static final String ID = "create_modern";
	public static final String NAME = "CreateModern";
	public static final Logger LOGGER = LogUtils.getLogger();

	// ==== TUTORIAL CODES ====
	// raw CHROME!
	public static final Item RAW_CHROME =
		Registry.register(Registry.ITEM, new ResourceLocation(ID, "raw_chrome"),
			new Item(new FabricItemSettings()));

	public static CreativeModeTab TAB;
	// ========

	@Override
	public void onInitialize() {
		LOGGER.info("Create addon mod [{}] loading alongside Create [{}]!", NAME, Create.VERSION);
		FabricItemGroupBuilder builder = FabricItemGroupBuilder.create(new ResourceLocation(ID, "tab"));
		builder.appendItems((stacks) -> {
			stacks.add(new ItemStack(RAW_CHROME));
		});
		builder.icon(() -> new ItemStack(RAW_CHROME));
		TAB = builder.build();

	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}
}
