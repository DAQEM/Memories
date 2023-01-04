package com.daqem.memories.fabric;

import com.daqem.memories.MemoriesExpectPlatform;
import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class MemoriesExpectPlatformImpl {
    /**
     * This is our actual method to {@link MemoriesExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
