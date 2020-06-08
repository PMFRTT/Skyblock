package com.pmfrtt.skyblock.Shop;

import core.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.Objects;

public class SellInventory {


    private Player player;


    public Inventory sellInventory;
    private float sellPrice;

    public SellInventory(Player player) {
        this.player = player;
        sellInventory = Bukkit.createInventory(player, 54, "Verkaufen");
    }

    public static ItemStack sell = new ItemStack(Material.LIME_STAINED_GLASS_PANE);
    public static ItemStack price = new ItemStack(Material.GOLD_INGOT);
    public static ItemStack checkItemPrices = new ItemStack(Material.BOOK);


    public Inventory openSellInventory() {

        for (int i = 45; i < 52; i++) {
            sellInventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        }
        sellInventory.setItem(45, checkItemPrices);
        sellInventory.setItem(52, price);
        sellInventory.setItem(53, sell);
        updateInventory();

        return sellInventory;
    }

    public void updateInventory() {
        getSalePrice();
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        ItemMeta priceMeta = price.getItemMeta();
        assert priceMeta != null;
        priceMeta.setDisplayName(Utils.colorize("&6" + decimalFormat.format(sellPrice / 100) + "€"));
        price.setItemMeta(priceMeta);

        for (int i = 45; i < 52; i++) {
            sellInventory.setItem(i, new ItemStack(Material.GRAY_STAINED_GLASS_PANE));
        }

        ItemMeta sellMeta = sell.getItemMeta();
        sellMeta.setDisplayName(Utils.colorize("&aVerkaufen"));
        sell.setItemMeta(sellMeta);

        ItemMeta checkItemPricesMeta = checkItemPrices.getItemMeta();
        checkItemPricesMeta.setDisplayName(Utils.colorize("&dPreisliste"));
        checkItemPrices.setItemMeta(checkItemPricesMeta);

        sellInventory.setItem(45, checkItemPrices);
        sellInventory.setItem(52, price);
        sellInventory.setItem(53, sell);
    }

    public float getSalePrice() {
        float salePrice = 0;
        for (int i = 0; i <= 44; i++) {
            if (sellInventory.getItem(i) != null) {
                if (SalePriceMap.salePriceMap.containsKey(Objects.requireNonNull(sellInventory.getItem(i)).getType())) {
                    salePrice += SalePriceMap.salePriceMap.get(Objects.requireNonNull(sellInventory.getItem(i)).getType()) * Objects.requireNonNull(sellInventory.getItem(i)).getAmount();
                } else {
                    ItemStack remove = sellInventory.getItem(i);
                    assert remove != null;
                    sellInventory.remove(remove);
                    player.getInventory().addItem(remove);
                }
            }
        }
        sellPrice = salePrice;
        return salePrice;
    }


}
