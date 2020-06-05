package com.pmfrtt.skyblock.Quests;

import core.CoreBungeeCordClient;
import core.Utils;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Quest {

    public Material required;
    public int amountRequired;

    public int submitted;

    public Material reward;
    public int amountReward;

    public boolean finished;

    public Quest(Material required, int amountRequired, Material reward, int amountReward, boolean finished) {
        this.required = required;
        this.amountRequired = amountRequired;
        this.reward = reward;
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
        }else if(amountRequired > 64){
            Lore.add(Utils.colorize("&c-" + amountRequired / 64 + " Stack und " + amountRequired % 64 + " Items"));
        }else{
            Lore.add(Utils.colorize("&c-" + amountRequired % 64  + " Items"));
        }
        Lore.add("");
        Lore.add(Utils.colorize("&a+" + amountReward + " " + Quests.getMaterialName(reward)));
        QuestItemMeta.setLore(Lore);

        QuestItem.setItemMeta(QuestItemMeta);
        return QuestItem;
    }

    public static void submitItems(int amount) {

    }


}
