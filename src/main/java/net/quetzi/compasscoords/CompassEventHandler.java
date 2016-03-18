package net.quetzi.compasscoords;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * Created by Quetzi on 12/06/15.
 */
public class CompassEventHandler {

    @SubscribeEvent
    public void onItemUse(PlayerInteractEvent event) {

        if (!event.world.isRemote && event.entityPlayer.getHeldEquipment() != null && event.entityPlayer.getHeldEquipment() == Items.compass && !event.entityPlayer.capabilities.isCreativeMode) {
            if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
                if (event.entityPlayer instanceof EntityPlayerMP) {
                    String message = String.format("<" + event.entityPlayer.getGameProfile().getName() + "> " + CompassCoords.messageText, event.pos.getX(), event.pos.getY(), event.pos.getZ());
                    ((EntityPlayerMP) event.entityPlayer).mcServer.getPlayerList().sendChatMsg(new TextComponentString(message));
                }
            }
        }
    }
}
