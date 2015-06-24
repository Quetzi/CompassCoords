package net.quetzi.compasscoords;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

/**
 * Created by Quetzi on 12/06/15.
 */
public class CompassEventHandler {

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void onItemUse(PlayerInteractEvent event) {

        if (!event.world.isRemote && event.entityPlayer.getCurrentEquippedItem() != null && event.entityPlayer.getCurrentEquippedItem().getItem() == Items.compass && !event.entityPlayer.capabilities.isCreativeMode) {
            if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
                if (event.entityPlayer instanceof EntityPlayerMP) {
                    String message = String.format("<" + event.entityPlayer.getGameProfile().getName() + "> " + CompassCoords.messageText, event.x, event.y, event.z);
                    ((EntityPlayerMP) event.entityPlayer).mcServer.getConfigurationManager().sendChatMsg(new ChatComponentText(message));
                }
            }
        }
    }
}
