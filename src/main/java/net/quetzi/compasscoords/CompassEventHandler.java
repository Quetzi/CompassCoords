package net.quetzi.compasscoords;

import net.minecraft.init.Items;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Quetzi on 12/06/15.
 */
public class CompassEventHandler
{
    @SubscribeEvent
    public void onItemUse(PlayerInteractEvent.RightClickItem event)
    {
        if (!event.getWorld().isRemote &&
            event.getItemStack().getItem().equals(Items.COMPASS) &&
            !event.getEntityPlayer().capabilities.isCreativeMode &&
            !event.getEntityPlayer().isSneaking())
        {
            if (event.getResult() == PlayerInteractEvent.RightClickItem.Result.ALLOW)
            {
                String message = String.format("<" + event.getEntityPlayer().getGameProfile().getName() + "> " + CompassCoords.messageText, event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
                event.getEntityPlayer().sendStatusMessage(new TextComponentString(message), false);
            }
        }
    }
}
