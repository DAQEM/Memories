package com.daqem.memories.forge;

import com.daqem.memories.Memories;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class SideProxyForge {

    SideProxyForge() {
    }

    public static class Server extends SideProxyForge {
        Server() {
            Memories.LOGGER.error("This is a client-side mod. Please do not install it on a server.");
        }
    }

    public static class Client extends SideProxyForge {

        Client() {
            IEventBus eventBus = MinecraftForge.EVENT_BUS;
            IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

            Memories.init();
        }
    }
}
