package com.daqem.memories.forge;

import com.daqem.memories.MemoriesExpectPlatform;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class MemoriesExpectPlatformImpl {
    /**
     * This is our actual method to {@link MemoriesExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }
}
