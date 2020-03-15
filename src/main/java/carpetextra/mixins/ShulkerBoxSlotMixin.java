package carpetextra.mixins;

import carpetextra.CarpetExtraSettings;
import net.minecraft.container.ShulkerBoxSlot;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShulkerBoxSlot.class)
public abstract class ShulkerBoxSlotMixin
{
    @Inject(method = "canInsert", at = @At("HEAD"), cancellable = true)
    private void onCanInsert(ItemStack stack, CallbackInfoReturnable<Boolean> cir)
    {
        if (CarpetExtraSettings.compactShulkerBoxes)
            cir.setReturnValue(true);
    }
}
