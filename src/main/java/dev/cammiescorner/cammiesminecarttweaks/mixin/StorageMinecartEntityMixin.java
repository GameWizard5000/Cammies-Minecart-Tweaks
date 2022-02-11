package dev.cammiescorner.cammiesminecarttweaks.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.StorageMinecartEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = StorageMinecartEntity.class, priority = 9999)
public class StorageMinecartEntityMixin {
	@Inject(method = "interact", at = @At("HEAD"), cancellable = true)
	public void minecarttweaks$heckUMojang(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> info) {
		ItemStack stack = player.getStackInHand(hand);

		if(player.isSneaking() && stack.isOf(Items.CHAIN))
			info.setReturnValue(ActionResult.success(true));
	}
}
