package com.excelsus.createmodern;

import com.mojang.logging.LogUtils;
import com.simibubi.create.Create;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

import org.slf4j.Logger;

public class CreateModern implements ModInitializer {
	public static final String ID = "create_modern";
	public static final String NAME = "CreateModern";
	public static final Logger LOGGER = LogUtils.getLogger();

	// raw CHROME!
	public static final Item RAW_CHROME =
		Registry.register(Registry.ITEM, new ResourceLocation(ID, "raw_chrome"),
			new Item(new FabricItemSettings()));

	@Override
	public void onInitialize() {
		LOGGER.info("Create addon mod [{}] loading alongside Create [{}]!", NAME, Create.VERSION);
	}

	public static ResourceLocation id(String path) {
		return new ResourceLocation(ID, path);
	}
}
