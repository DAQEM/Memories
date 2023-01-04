package com.daqem.memories;

import com.daqem.memories.config.Config;
import com.daqem.memories.config.ConfigBuilder;
import com.daqem.memories.event.EventClientTick;
import com.mojang.logging.LogUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;

public class Memories {
    public static final String MOD_ID = "memories";
    public static final Logger LOGGER = LogUtils.getLogger();
    public static Config CONFIG = new Config();

    public static void init() {
        new ConfigBuilder().buildConfig();
        registerEvents();
    }

    private static void registerEvents() {
        EventClientTick.registerEvent();
    }

    public static ResourceLocation getId(String id) {
        return new ResourceLocation(MOD_ID, id);
    }

    public static MutableComponent translatable(String str) {
        return Component.translatable(MOD_ID + "." + str);
    }

    public static MutableComponent translatable(String str, Object... objects) {
        return Component.translatable(MOD_ID + "." + str, objects);
    }

    public static MutableComponent literal(String str) {
        return Component.literal(str);
    }

}
