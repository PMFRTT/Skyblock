package com.pmfrtt.skyblock.Economy;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class Economy {

    public static HashMap<Player, Float> playerBalance = new HashMap<>();

    public static void addMoney(Player player, float amount) {
        playerBalance.put(player, playerBalance.get(player) + amount);
    }


    public static void deductMoney(Player player, float amount) {
        playerBalance.put(player, playerBalance.get(player) - amount);
    }


}
