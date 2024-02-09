package org.loopmc.skins.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import org.loopmc.skins.LoopSkins;

import net.minecraft.client.gui.screen.TitleScreen;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {

	@Inject(method = "init", at = @At("TAIL"))
	public void loopSkins$onInit(CallbackInfo ci) {
		LoopSkins.LOGGER.info("Why, it does work after all!");
	}
}
