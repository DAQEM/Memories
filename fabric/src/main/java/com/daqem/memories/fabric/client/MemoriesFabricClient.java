package com.daqem.memories.fabric.client;

import com.daqem.memories.Memories;
import net.fabricmc.api.ClientModInitializer;

public class MemoriesFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        Memories.init();
    }
}
