package com.pmfrtt.skyblock.Economy;

import core.Utils;
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

    public static void sendMoney(Player sendBy, Player sendTo, float amount) {
        if (playerBalance.get(sendBy) >= amount) {
            deductMoney(sendBy, amount);
            addMoney(sendTo, amount);
        }else{
            sendBy.sendMessage(Utils.getPrefix("Economy") + Utils.colorize("Du hast nicht genug Geld, um &b" + sendTo.getDisplayName() + " &c" + amount + " &fzu senden!"));
        }
    }


}
