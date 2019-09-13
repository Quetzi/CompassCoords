package net.quetzi.compasscoords;

import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

/**
 * Created by Quetzi on 12/06/15.
 */
public class CompassEventHandler
{
    @SubscribeEvent
    public void onItemUse(PlayerInteractEvent.RightClickItem event)
    {
        if (event.getWorld().isRemote &&
            event.getItemStack().getItem().equals(Items.COMPASS) &&
            !event.getPlayer().isCreative() &&
            !event.getPlayer().isSneaking())
        {
            if (event.getResult() == PlayerInteractEvent.RightClickItem.Result.ALLOW)
            {
                String message = String.format("<" + event.getPlayer().getGameProfile().getName() + "> " + Config.CLIENT.announceText.get(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
                event.getPlayer().sendStatusMessage(new StringTextComponent(message), false);
            }
        }
    }
}
