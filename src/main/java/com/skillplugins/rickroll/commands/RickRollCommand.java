package com.skillplugins.rickroll.commands;

import com.skillplugins.rickroll.config.configs.MainConfig;
import com.skillplugins.rickroll.libs.XSound;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class RickRollCommand implements CommandExecutor {

    private final MainConfig mainConfig;

    public RickRollCommand(final @NotNull MainConfig mainConfig) {
        this.mainConfig = mainConfig;
    }

    @Override
    public boolean onCommand(@NotNull final CommandSender commandSender, @NotNull final Command command, @NotNull final String s, @NotNull final String[] args) {
        if (!(commandSender instanceof ConsoleCommandSender)
                && !commandSender.hasPermission(mainConfig.getString(MainConfig.ADMIN_PERMISSION))) {
            commandSender.sendMessage(mainConfig.getString(MainConfig.NO_PERMISSION));
            return false;
        }

        final TextComponent textComponent = new TextComponent(mainConfig.getString(MainConfig.MESSAGE_RECEIVER));
        textComponent.setBold(true);
        textComponent.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, mainConfig.getString(MainConfig.VIDEO_LINK)));

        final Collection<? extends Player> players = args.length == 0
                ? Bukkit.getOnlinePlayers() : Collections.singletonList(Bukkit.getPlayer(args[0]));

        players.stream().filter(player -> Objects.nonNull(player) && (args.length > 0 || !player.equals(commandSender)))
                .forEach(player -> {
                    player.spigot().sendMessage(textComponent);
                    player.playSound(player.getLocation(), XSound.BLOCK_NOTE_BLOCK_PLING.parseSound(), 1, 1);
                });

        commandSender.sendMessage(mainConfig.getString(MainConfig.MESSAGE_SENDER));
        return false;
    }
}
