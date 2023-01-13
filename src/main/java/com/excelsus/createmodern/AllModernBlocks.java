package com.excelsus.createmodern;

import static com.simibubi.create.AllTags.*;
import static com.simibubi.create.foundation.data.ModelGen.*;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;

import com.excelsus.createmodern.content.contraptions.components.centrifuge.CentrifugeBlock;
import com.simibubi.create.AllItems;
import com.simibubi.create.content.AllSections;
import com.simibubi.create.content.contraptions.components.millstone.MillstoneBlock;
import com.simibubi.create.foundation.block.BlockStressDefaults;
import com.simibubi.create.foundation.data.AssetLookup;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.data.SharedProperties;
import com.tterrag.registrate.providers.loot.RegistrateBlockLootTables;
import com.tterrag.registrate.util.entry.BlockEntry;

import me.alphamode.forgetags.Tags;

public class AllModernBlocks {
	private static final CreateRegistrate REGISTRATE = CreateModern.registrate()
		.creativeModeTab(() -> CreateModern.MODERN_CREATIVE_TAB);

	static {
		REGISTRATE.startSection(AllSections.PALETTES);
	}

	public static final BlockEntry<Block> CHROME_ORE = REGISTRATE.block("chrome_ore", Block::new)
		.initialProperties(() -> Blocks.GOLD_ORE)
		.properties(p -> p.color(MaterialColor.METAL))
		.properties(p -> p.requiresCorrectToolForDrops()
			.sound(SoundType.STONE))
		.transform(pickaxeOnly())
		.loot((lt, b) -> lt.add(b,
			RegistrateBlockLootTables.createSilkTouchDispatchTable(b,
				RegistrateBlockLootTables.applyExplosionDecay(b, LootItem.lootTableItem(AllModernItems.RAW_CHROME.get())
					.apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))))))
		.tag(BlockTags.NEEDS_IRON_TOOL)
		.tag(Tags.Blocks.ORES)
		.transform(tagBlockAndItem("ores/chrome", "ores_in_ground/stone"))
		.tag(Tags.Items.ORES)
		.build()
		.register();

	static {
		REGISTRATE.startSection(AllSections.KINETICS);
	}

	public static final BlockEntry<CentrifugeBlock> CENTRIFUGE = REGISTRATE.block("centrifuge", CentrifugeBlock::new)
		.initialProperties(SharedProperties::stone)
		.properties(p -> p.color(MaterialColor.METAL))
		.transform(pickaxeOnly())
		.blockstate((c, p) -> p.simpleBlock(c.getEntry(), AssetLookup.partialBaseModel(c, p)))
		.transform(BlockStressDefaults.setImpact(16.0))
		.item()
		.transform(customItemModel())
		.register();

	// Load this class
	public static void register() {}
}
