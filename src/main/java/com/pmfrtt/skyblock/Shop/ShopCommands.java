package com.pmfrtt.skyblock.Shop;

import com.pmfrtt.skyblock.Skyblock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ShopCommands implements CommandExecutor {
    Skyblock main;

    public ShopCommands(Skyblock main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        return false;
    }
}
