package com.pmfrtt.skyblock.Shop;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;

public class Sell {


    public static HashMap<Player, SellInventory> sellInventoryMap = new HashMap<>();


    public static void addPlayerInventory(Player player) {
        SellInventory sellInventory = new SellInventory(player);
        sellInventoryMap.put(player, sellInventory);
    }

    public static void updateAllInv(){
        for(SellInventory sellInventory : sellInventoryMap.values()){
            sellInventory.updateInventory();
        }
    }

}
