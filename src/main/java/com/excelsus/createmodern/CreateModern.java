package com.excelsus.createmodern;


import com.excelsus.createmodern.content.CreateModernItemGroup;
import com.mojang.logging.LogUtils;
import com.simibubi.create.Create;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.tterrag.registrate.util.nullness.NonNullSupplier;

import net.fabricmc.api.ModInitializer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

import org.slf4j.Logger;

public class CreateModern implements ModInitializer {
	public static final String ID = "create_modern";
	public static final String NAME = "CreateModern";
	public static final Logger LOGGER = LogUtils.getLogger();

	private static final NonNullSupplier<CreateRegistrate> REGISTRATE = CreateRegistrate.lazy(ID);
	public static CreativeModeTab MODERN_CREATIVE_TAB = new CreateModernItemGroup();

	@Override
	public void onInitialize() {
		LOGGER.info("Create addon mod [{}] loading alongside Create [{}]!", NAME, Create.VERSION);
		onCtor();
	}

	public static void onCtor() {
		AllModernBlocks.register();
		AllModernItems.register();
		AllModernTileEntities.register();

		REGISTRATE.get().register();
	}

	public static CreateRegistrate registrate() {
		return REGISTRATE.get();
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}
}
