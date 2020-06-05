package com.pmfrtt.skyblock.Economy;

import com.pmfrtt.skyblock.Skyblock;
import core.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EconomyCommands implements CommandExecutor {

    Skyblock main;

    public EconomyCommands(Skyblock main) {
        this.main = main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = null;
        if (sender instanceof Player) {
            player = (Player) sender;
        }

        if (command.getLabel().equalsIgnoreCase("balance")) {
            if (Economy.playerBalance.containsKey(player)) {
                player.sendMessage(Utils.colorize("Du hast &a" + Economy.playerBalance.get(player).toString() + "&f€"));
            } else {
                Economy.playerBalance.put(player, 2000);
            }
        }

        return false;
    }
}
