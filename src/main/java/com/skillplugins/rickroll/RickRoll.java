package com.skillplugins.rickroll;

import com.skillplugins.rickroll.commands.RickRollCommand;
import com.skillplugins.rickroll.config.configs.MainConfig;
import org.bukkit.plugin.java.JavaPlugin;

public class RickRoll extends JavaPlugin {

    @Override
    public void onEnable() {
        final MainConfig mainConfig = new MainConfig();
        mainConfig.init();

        getCommand("rickroll").setExecutor(new RickRollCommand(mainConfig));
    }

}
