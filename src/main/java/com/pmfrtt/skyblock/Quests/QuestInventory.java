package com.pmfrtt.skyblock.Quests;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class QuestInventory {

    public static Inventory questInventory = Bukkit.createInventory(null, 27);
    private static ItemStack empty = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);


    public static Inventory getInventory() {

        if (Quests.quests.isEmpty()) {
            for (int i = 0; i < 4; i++) {
                int index = i + 10 + i;
                Quest quest = Quests.createNewQuest();
                questInventory.setItem(index, quest.getQuestItem());
                Quests.quests.put(i, quest);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int index = i + 10 + i;
                Quest quest = Quests.quests.get(i);
                questInventory.setItem(index, quest.getQuestItem());
            }
        }

        for (int i = 0; i < 27; i++) {
            if (questInventory.getItem(i) == null) {
                ItemMeta temp = empty.getItemMeta();
                temp.setDisplayName("--");
                empty.setItemMeta(temp);
                questInventory.setItem(i, empty);
            }
        }


        //TODO
        // - fill inv with quest items


        return questInventory;
    }


    public static void updateInventory() {
        if (Quests.quests.isEmpty()) {
            for (int i = 0; i < 4; i++) {
                int index = i + 10 + i;
                Quest quest = Quests.createNewQuest();
                questInventory.setItem(index, quest.getQuestItem());
                Quests.quests.put(i, quest);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                if (!Quests.quests.containsKey(i)) {
                    int index = i + 10 + i;
                    Quest quest = Quests.createNewQuest();
                    questInventory.setItem(index, quest.getQuestItem());
                    Quests.quests.put(i, quest);
                }

            }
        }

        for (
                int i = 0;
                i < 27; i++) {
            if (questInventory.getItem(i) == null) {
                ItemMeta temp = empty.getItemMeta();
                temp.setDisplayName("--");
                empty.setItemMeta(temp);
                questInventory.setItem(i, empty);
            }
        }
    }


}
