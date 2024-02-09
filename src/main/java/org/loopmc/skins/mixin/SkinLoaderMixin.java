package org.loopmc.skins.mixin;

import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.entity.living.player.RemoteClientPlayerEntity;
import net.minecraft.text.StringUtils;
import net.minecraft.world.World;
import org.loopmc.skins.LoopSkins;
import org.loopmc.skins.SkinUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RemoteClientPlayerEntity.class)
public class SkinLoaderMixin {
	//public void getModernData() {
	//	LoopSkins.LOGGER.info("WAT");
	//}

	@Overwrite
	public void registerCloak(CallbackInfo ci) {
		//this.cape = "http://skins.minecraft.net/MinecraftCloaks/" + StringUtils.stripFormatting(this.name) + ".png";
		//this.cloak = this.cape;
		LoopSkins.LOGGER.info("WAT");
	}


}
