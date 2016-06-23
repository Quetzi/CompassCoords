package net.quetzi.compasscoords;

import net.minecraft.entity.player.EntityPlayerMP;
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
    public void onItemUse(PlayerInteractEvent event)
    {
        if (!event.getWorld().isRemote && event.getEntityPlayer().getHeldItemMainhand() != null && event.getEntityPlayer().getHeldItemMainhand().getItem() == Items.COMPASS && !event.getEntityPlayer().capabilities.isCreativeMode)
        {
            if (event.getResult() == PlayerInteractEvent.RightClickItem.Result.ALLOW)
            {
                if (event.getEntityPlayer() instanceof EntityPlayerMP)
                {
                    String message = String.format("<" + event.getEntityPlayer().getGameProfile().getName() + "> " + CompassCoords.messageText, event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
                    ((EntityPlayerMP) event.getEntityPlayer()).mcServer.getPlayerList().sendChatMsg(new TextComponentString(message));
                }
            }
        }
    }
}
