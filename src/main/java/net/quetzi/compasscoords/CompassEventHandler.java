package net.quetzi.compasscoords;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerUseItemEvent;

/**
 * Created by Quetzi on 12/06/15.
 */
public class CompassEventHandler {

    @SubscribeEvent
    public void onItemUse(PlayerUseItemEvent event) {

        if (event.entityPlayer.getCurrentEquippedItem().getItem() == Items.compass && !event.entityPlayer.capabilities.isCreativeMode) {
            if (event.entityPlayer instanceof EntityPlayerMP) {
                String message = String.format("My location is: %s, %s, %s", event.entityPlayer.getPlayerCoordinates().posX, event.entityPlayer.getPlayerCoordinates().posY, event.entityPlayer.getPlayerCoordinates().posZ);
                ((EntityPlayerMP) event.entityPlayer).mcServer.getConfigurationManager().sendChatMsg(new ChatComponentText(message));
            }
        }
    }
}
