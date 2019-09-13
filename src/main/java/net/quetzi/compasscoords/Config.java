package net.quetzi.compasscoords;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class Config {
    public static final ClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;

    static {
        final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static String announceText;

    public static void load() {
        CLIENT.announceText.get();
    }

    public static class ClientConfig {
        public ForgeConfigSpec.ConfigValue<String> announceText;

        ClientConfig(ForgeConfigSpec.Builder builder) {
            builder.push("settings");
            announceText = builder
                    .comment("Set the Message when you right click with the compass, use %s where you want each coordinate to go")
                    .define("AnnounceText", "My location is: %s, %s, %s");
            builder.pop();
        }
    }
}
