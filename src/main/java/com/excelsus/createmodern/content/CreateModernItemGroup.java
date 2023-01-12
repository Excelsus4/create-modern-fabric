package com.excelsus.createmodern.content;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import com.excelsus.createmodern.AllModernItems;
import com.excelsus.createmodern.CreateModern;

import io.github.fabricators_of_create.porting_lib.util.ItemGroupUtil;

public class CreateModernItemGroup extends CreativeModeTab {
	public CreateModernItemGroup() {
		super(ItemGroupUtil.expandArrayAndGetId(), CreateModern.ID);
	}

	@Override
	public ItemStack makeIcon() {
		return AllModernItems.RAW_CHROME.asStack();
	}
}
