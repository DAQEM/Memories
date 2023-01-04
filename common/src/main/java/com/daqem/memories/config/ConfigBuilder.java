package com.daqem.memories.config;

import com.daqem.memories.Memories;
import com.daqem.memories.MemoriesExpectPlatform;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;

public class ConfigBuilder {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final String CONFIG_FILE_NAME = "memories.json";
    private final File configFile;

    public ConfigBuilder() {
        this.configFile = MemoriesExpectPlatform.getConfigDirectory().resolve(CONFIG_FILE_NAME).toFile();
    }

    public void buildConfig() {
        createConfigFile();
        if (readConfigFile()) {
            writeConfigFile();
        }
    }

    private boolean readConfigFile() {
        try {
            Reader reader = Files.newBufferedReader(configFile.toPath());
            Config config = GSON.fromJson(reader, Config.class);
            if (config == null) {
                return true;
            } else {
                Memories.CONFIG = config;
            }
        } catch (IOException e) {
            Memories.LOGGER.error("Failed to read config file: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    private void writeConfigFile() {
        String jsonString = GSON.toJson(Memories.CONFIG);

        if (configFile.canWrite()) {
            try {
                Files.write(configFile.toPath(), jsonString.getBytes());
            } catch (IOException e) {
                Memories.LOGGER.error("Failed to write config file: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    private void createConfigFile() {
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                Memories.LOGGER.error("Failed to create config file: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
