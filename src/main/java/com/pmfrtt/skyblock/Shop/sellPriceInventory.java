package com.pmfrtt.skyblock.Shop;

import core.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class sellPriceInventory {

    public static Inventory sellPriceInventory = Bukkit.createInventory(null, 54, Utils.colorize("&dPreisliste"));

    public static Inventory getSellPriceInventory(){

        int i = 0;
        for(Map.Entry<Material, Float> entry : SalePriceMap.salePriceMap.entrySet()){
            if(i < 53){

                ItemStack temp = new ItemStack(entry.getKey());
                ItemMeta tempMeta = temp.getItemMeta();
                List<String> lore = new ArrayList<String>();
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                lore.add(Utils.colorize("&6" + decimalFormat.format(entry.getValue() / 100) + "€"));
                tempMeta.setLore(lore);
                temp.setItemMeta(tempMeta);

                sellPriceInventory.setItem(i, temp);



                i++;
            }
        }












        return sellPriceInventory;
    }

}
