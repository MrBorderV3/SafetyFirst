package me.border.safetyfirst;

import me.border.safetyfirst.command.SafetyFirstCommand;
import me.border.spigotutilities.plugin.Setting;
import me.border.spigotutilities.plugin.SpigotPlugin;

import java.util.EnumSet;

public class SafetyFirst extends SpigotPlugin {

    @Override
    protected void enable() {
        registerCommand(new SafetyFirstCommand());
    }

    @Override
    protected void load() {
        getSettings().addAll(EnumSet.of(Setting.DISABLE_ENTITY_REFERENCE, Setting.DISABLE_ENTITY_REFERENCE));
    }

    @Override
    protected void disable() {

    }
}
