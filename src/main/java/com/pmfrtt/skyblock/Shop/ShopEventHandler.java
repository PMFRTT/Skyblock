package com.pmfrtt.skyblock.Shop;

import com.pmfrtt.skyblock.Economy.Economy;
import com.pmfrtt.skyblock.Skyblock;
import core.Utils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.inventory.Inventory;

import java.text.DecimalFormat;

public class ShopEventHandler implements Listener {

    Skyblock main;

    public ShopEventHandler(Skyblock main) {
        this.main = main;
    }

    public void initialize() {
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    private void onInventoryClick(InventoryClickEvent e) {
        if(!Sell.sellInventoryMap.containsKey((Player)e.getWhoClicked())){
            Sell.addPlayerInventory((Player) e.getWhoClicked());
        }
        if (e.getClickedInventory() != null) {
            if (e.getClickedInventory().equals(Sell.sellInventoryMap.get((Player) e.getWhoClicked()).sellInventory)) {
                if (e.getCurrentItem() != null) {
                    if (e.getCurrentItem().equals(SellInventory.price)) {
                        float f = Sell.sellInventoryMap.get(e.getWhoClicked()).getSalePrice();
                        Sell.sellInventoryMap.get(e.getWhoClicked()).updateInventory();
                        e.setCancelled(true);
                    } else if (e.getCurrentItem().equals(SellInventory.sell)) {
                        float amount = Sell.sellInventoryMap.get((Player) e.getWhoClicked()).getSalePrice() / 100;
                        Player player = (Player) e.getWhoClicked();
                        player.closeInventory();
                        Economy.addMoney(player, amount);
                        main.economyFileManager.writeToFile((Player) e.getWhoClicked(), Economy.playerBalance.get((Player) e.getWhoClicked()));
                        DecimalFormat decimalFormat = new DecimalFormat("0.00");
                        e.getWhoClicked().sendMessage(Utils.getPrefix("Sell") + Utils.colorize("Du hast durch deinen Verkauf &a" + decimalFormat.format(Sell.sellInventoryMap.get((Player) e.getWhoClicked()).getSalePrice() / 100) + "&f€ erhalten!"));
                        Sell.sellInventoryMap.remove(player);
                        e.setCancelled(true);
                    } else if (e.getCurrentItem().equals(SellInventory.checkItemPrices)) {
                        e.getWhoClicked().closeInventory();
                        e.getWhoClicked().openInventory(sellPriceInventory.getSellPriceInventory());
                    } else if (e.getSlot() > 44) {
                        e.setCancelled(true);
                    }
                }
            }
        }

    }
}