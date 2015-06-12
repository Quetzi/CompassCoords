package net.quetzi.compasscoords;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.quetzi.compasscoords.references.References;
import org.apache.logging.log4j.Logger;

/**
 * Created by Quetzi on 12/06/15.
 */

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION, acceptableRemoteVersions = "*")
public class CompassCoords {

    public Logger log;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        log = event.getModLog();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(new CompassEventHandler());
    }
}
