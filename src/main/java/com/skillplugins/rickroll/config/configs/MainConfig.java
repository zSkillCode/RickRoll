package com.skillplugins.rickroll.config.configs;

import com.skillplugins.rickroll.config.Configurable;
import com.skillplugins.rickroll.utils.Pair;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MainConfig extends Configurable {

    public static final String ADMIN_PERMISSION = "admin_permission";
    public static final String NO_PERMISSION = "no_permission";
    public static final String VIDEO_LINK = "video_link";
    public static final String MESSAGE_RECEIVER = "message_receiver";
    public static final String MESSAGE_SENDER = "message_sender";
    public static final String MESSAGE_SENDER_ALL = "message_sender_all";

    private static final String PATH = "plugins/RickRoll/config.yml";

    public void init() {
        super.init();
    }

    @Override
    protected String filePath() {
        return PATH;
    }

    @Override
    protected void configure(final @NotNull List<Pair<String, Object>> list) {
        list.add(new Pair<>(ADMIN_PERMISSION, "rickroll.admin"));
        list.add(new Pair<>(NO_PERMISSION, "&cYou are not allowed to do that!"));
        list.add(new Pair<>(VIDEO_LINK, "https://www.youtube.com/watch?v=a3Z7zEc7AXQ"));
        list.add(new Pair<>(MESSAGE_RECEIVER, "\n\n&7Since our store was partially offline yesterday, we are now giving away one month of free &6VIP&7! Click &e&lHERE &7to claim it!\n\n"));
        list.add(new Pair<>(MESSAGE_SENDER, "&aThe player(s( was/were rick rolled!"));
    }

    @Override
    public String getString(final @NotNull String path) {
        return super.getString(path).replace("&", "§");
    }
}
