package me.border.safetyfirst.command;

import me.border.spigotutilities.baseutils.ChatUtils;
import me.border.spigotutilities.command.ICommand;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

import static me.border.spigotutilities.baseutils.CommandUtils.*;

public class SafetyFirstCommand extends ICommand {
    public SafetyFirstCommand() {
        super("safetyfirst", false, "safetyfirst.use");
    }

    @Override
    public boolean commandUsed(CommandSender sender, String[] args) {
        if (!argsCheck(sender, 1, args))
            return false;

        Player target = Bukkit.getPlayerExact(args[0]);
        if (!offlineCheck(target, sender, args[0]))
            return false;

        ItemStack item = target.getInventory().getHelmet();
        if (item != null){
            target.getInventory().setHelmet(new ItemStack(Material.AIR));
            Map<Integer, ItemStack> fallItems = target.getInventory().addItem(item);
            if (!fallItems.isEmpty()){
                fallItems.forEach((i, itemStack) -> target.getWorld().dropItem(target.getLocation(), itemStack));
                ChatUtils.sendMsg(target, "Messages.ItemsFell");
            } else {
                ChatUtils.sendMsg(target, "Messages.ItemsMoved");
            }
        }


        return false;
    }
}
