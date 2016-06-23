package net.quetzi.compasscoords;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.quetzi.compasscoords.references.References;

/**
 * Created by Quetzi on 12/06/15.
 */

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, dependencies = "required-after:Forge@[12.18.0.1981,);", acceptableRemoteVersions = "*")
public class CompassCoords
{
    public static Configuration config;
    public static String        messageText;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();

        messageText = config.getString("messageText", "Messages", "My location is: %s, %s, %s", "Set the Message when you right click with the compass, use %s where you want each coordinate to go");

        config.save();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new CompassEventHandler());
    }
}
