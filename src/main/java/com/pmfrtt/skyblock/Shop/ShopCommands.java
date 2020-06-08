package com.pmfrtt.skyblock.Shop;

import com.pmfrtt.skyblock.Skyblock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShopCommands implements CommandExecutor {
    Skyblock main;

    public ShopCommands(Skyblock main) {
        this.main = main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = null;
        if(sender instanceof  Player){
            player = (Player) sender;
        }

        if (command.getLabel().equalsIgnoreCase("sell")) {
            if(!Sell.sellInventoryMap.containsKey(player)){
                Sell.addPlayerInventory(player);
                player.openInventory(Sell.sellInventoryMap.get(player).openSellInventory());
            }else{
                player.openInventory(Sell.sellInventoryMap.get(player).openSellInventory());
            }
        }




        return false;
    }
}
