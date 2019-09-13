package net.quetzi.compasscoords;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.quetzi.compasscoords.references.References;

/**
 * Created by Quetzi on 12/06/15.
 */

@Mod(value = References.MODID)
public class CompassCoords
{
    public static CompassCoords instance;

    public CompassCoords()
    {
        instance = this;
        MinecraftForge.EVENT_BUS.register(new CompassEventHandler());
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, Config.CLIENT_SPEC);
    }
}
