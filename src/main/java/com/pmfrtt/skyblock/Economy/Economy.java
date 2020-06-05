package com.pmfrtt.skyblock.Economy;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class Economy {

    public static HashMap<Player, Integer> playerBalance = new HashMap<Player, Integer>();

    public static void addMoney(Player player, int amount) {
        playerBalance.put(player, playerBalance.get(player) + amount);
    }


    public static void deductMoney(Player player, int amount) {
        playerBalance.put(player, playerBalance.get(player) - amount);
    }


}
