package com.daqem.memories.event;

import com.daqem.memories.Memories;
import com.daqem.memories.config.Config;
import com.daqem.memories.screenshot.ScreenshotHandler;
import dev.architectury.event.events.client.ClientTickEvent;
import net.minecraft.client.multiplayer.ClientLevel;

public class EventClientTick {

    public static int passedTicks = 0;

    public static void registerEvent() {
        ClientTickEvent.CLIENT_LEVEL_POST.register(EventClientTick::onTick);
    }

    public static void onTick(ClientLevel level) {
        passedTicks++;

        Config config = Memories.CONFIG;

        if (passedTicks % 20 == 0) {
            Memories.LOGGER.info("Passed ticks: " + passedTicks + "  " + config.firstScreenshotTicks + " " + config.screenshotDelayTicks);
        }
        if (passedTicks == config.firstScreenshotTicks) {
            Memories.LOGGER.error("Taking first screenshot");
            ScreenshotHandler.takeScreenshot();
        } else if ((passedTicks - config.firstScreenshotTicks) % config.screenshotDelayTicks == 0) {
            ScreenshotHandler.takeScreenshot();
            Memories.LOGGER.error("Taking screenshot");
        }
    }
}
