package com.pmfrtt.skyblock.Economy;

import com.pmfrtt.skyblock.Skyblock;
import core.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

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
            if (main.economyFileManager.containsPlayer(player)) {
                main.economyFileManager.readFromFile();
            } else {
                main.economyFileManager.writeToFile(player, 0);
            }
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            String numberAsString = decimalFormat.format(Economy.playerBalance.get(player));
            player.sendMessage(Utils.colorize("Du hast &a" + numberAsString + "&f€"));
            main.economyFileManager.writeToFile(player, Economy.playerBalance.get(player));
        }

        return false;
    }
}
