package com.pmfrtt.skyblock.Quests;

import core.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Quest {

    public Material required;
    public int amountRequired;

    public float amountReward;

    public boolean finished;

    public Quest(Material required, int amountRequired, float amountReward, boolean finished) {
        this.required = required;
        this.amountRequired = amountRequired;
        this.amountReward = amountReward;
        this.finished = finished;
    }

    public ItemStack getQuestItem() {
        ItemStack QuestItem = new ItemStack(required);
        ItemMeta QuestItemMeta = QuestItem.getItemMeta();
        QuestItemMeta.setDisplayName(Utils.colorize("&rFarme &b" + amountRequired + "&f " + Quests.getMaterialName(required)));

        ArrayList<String> Lore = new ArrayList<String>();
        Lore.add(Utils.colorize("&c-" + amountRequired + " " + Quests.getMaterialName(required)));
        if (amountRequired >= 128) {
            Lore.add(Utils.colorize("&c-" + amountRequired / 64 + " Stacks und " + amountRequired % 64 + " Items"));
        } else if (amountRequired > 64) {
            Lore.add(Utils.colorize("&c-" + amountRequired / 64 + " Stack und " + amountRequired % 64 + " Items"));
        } else {
            Lore.add(Utils.colorize("&c-" + amountRequired % 64 + " Items"));
        }
        Lore.add("");
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        Lore.add(Utils.colorize("&a+" + decimalFormat.format(amountReward / 100) + "€"));
        Lore.add(Utils.colorize("&a+" + decimalFormat.format(amountReward / amountRequired / 100) + "€ pro Item"));
        QuestItemMeta.setLore(Lore);

        QuestItem.setItemMeta(QuestItemMeta);
        return QuestItem;
    }

}
