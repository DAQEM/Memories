package com.daqem.memories.screenshot;

import com.daqem.memories.Memories;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.Screenshot;
import net.minecraft.network.chat.Style;

public class ScreenshotHandler {

    public static int screenshotCount = 0;

    public static void takeScreenshot() {
        screenshotCount++;
        Minecraft minecraft = Minecraft.getInstance();
        Screenshot.grab(minecraft.gameDirectory, minecraft.getMainRenderTarget(), (component) ->
                minecraft.execute(() -> {
                    if (Memories.CONFIG.enabledMessages) {
                        Style linkStyle = component.toFlatList().get(1).getStyle();
                        minecraft.gui.getChat().addMessage(Memories.translatable("chat.prefix")
                                .withStyle(Style.EMPTY
                                        .withColor(ChatFormatting.DARK_GREEN)
                                        .withBold(true))
                                .append(" ")
                                .append(Memories.translatable("chat.divider")
                                        .withStyle(Style.EMPTY
                                                .withColor(ChatFormatting.GRAY)
                                                .withBold(false)))
                                .append(" ")
                                .append(Memories.translatable("chat.screenshot", screenshotCount)
                                        .withStyle(linkStyle
                                                .withColor(ChatFormatting.GREEN)
                                                .withBold(false)
                                                .withUnderlined(true)))
                        );
                    }
                })
        );
    }
}
