package com.excelsus.createmodern.mixin;

import com.excelsus.createmodern.CreateModern;

import net.minecraft.client.Minecraft;

import net.minecraft.client.main.GameConfig;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class CreateModernMixin {
	@Inject(method = "<init>", at = @At("TAIL"))
	private void example$init(GameConfig gameConfig, CallbackInfo ci) {
		CreateModern.LOGGER.info("Hello from the Create Fabric Addon Template!");
		CreateModern.LOGGER.info("In case the creator of this mod forgets to remove this example code, here's");
		CreateModern.LOGGER.info("the path to their main class. Hopefully you can track down the culprit using it: [{}]", CreateModern.class.getName());
	}
}
