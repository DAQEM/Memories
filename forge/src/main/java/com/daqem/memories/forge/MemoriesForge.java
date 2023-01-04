package com.daqem.memories.forge;

import com.daqem.memories.Memories;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Memories.MOD_ID)
public class MemoriesForge {
    public MemoriesForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(Memories.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        DistExecutor.safeRunForDist(
                () -> SideProxyForge.Client::new,
                () -> SideProxyForge.Server::new
        );
    }
}
