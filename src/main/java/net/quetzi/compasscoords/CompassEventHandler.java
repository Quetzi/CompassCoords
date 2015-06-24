package net.quetzi.compasscoords;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
                    String message = String.format("<" + Minecraft.getMinecraft().thePlayer.getName() + "> " + CompassCoords.messageText, event.pos.getX(), event.pos.getY(), event.pos.getZ());
                    ((EntityPlayerMP) event.entityPlayer).mcServer.getConfigurationManager().sendChatMsg(new ChatComponentText(message));
                }
            }
        }
    }
}
