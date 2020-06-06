package com.pmfrtt.skyblock.Quests;

import core.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.entity.ItemMergeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class QuestInventory {


    public static Inventory questInventoryEasy = Bukkit.createInventory(null, 36, Utils.colorize("&aEinfache Quests"));
    public static Inventory questInventoryMedium = Bukkit.createInventory(null, 36, Utils.colorize("&6Mittlere Quests"));
    public static Inventory questInventoryHard = Bukkit.createInventory(null, 36, Utils.colorize("&cSchwere Quests"));
    private static ItemStack empty = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);

    public static ItemStack switchToEasy = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
    public static ItemStack switchToMedium = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
    public static ItemStack switchToHard = new ItemStack(Material.RED_STAINED_GLASS_PANE);
    public static ItemStack cancelQuest = new ItemStack(Material.BARRIER);

    public static void initializeSwitchers() {
        ItemMeta switchToEasyMeta = switchToEasy.getItemMeta();
        ItemMeta switchToMediumMeta = switchToMedium.getItemMeta();
        ItemMeta switchToHardMeta = switchToHard.getItemMeta();
        ItemMeta cancelQuestMeta = cancelQuest.getItemMeta();
        switchToEasyMeta.setDisplayName(Utils.colorize("&aEinfach"));
        switchToMediumMeta.setDisplayName(Utils.colorize("&6Mittel"));
        switchToHardMeta.setDisplayName(Utils.colorize("&cSchwer"));
        cancelQuestMeta.setDisplayName(Utils.colorize("&4Quest Abbrechen"));
        switchToEasy.setItemMeta(switchToEasyMeta);
        switchToMedium.setItemMeta(switchToMediumMeta);
        switchToHard.setItemMeta(switchToHardMeta);
        cancelQuest.setItemMeta(cancelQuestMeta);
    }


    public static Inventory getInventory(String difficulty) {

        switch (difficulty) {
            case "easy":
                if (Quests.questsEasy.isEmpty()) {
                    for (int i = 0; i < 4; i++) {
                        int index = i + 10 + i;
                        Quest quest = Quests.createNewQuest("easy");
                        questInventoryEasy.setItem(index, quest.getQuestItem());
                        Quests.questsEasy.put(i, quest);
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        int index = 2 * i + 10;
                        Quest quest = Quests.questsEasy.get(i);
                        questInventoryEasy.setItem(index, quest.getQuestItem());
                    }

                }

                for (int i = 0; i < 35; i++) {
                    if (questInventoryEasy.getItem(i) == null) {
                        ItemMeta temp = empty.getItemMeta();
                        temp.setDisplayName("--");
                        empty.setItemMeta(temp);
                        questInventoryEasy.setItem(i, empty);
                    }
                }
                for (int i = 0; i < 4; i++) {
                    int index = 2 * i + 19;
                    questInventoryEasy.setItem(index, cancelQuest);
                }
                questInventoryEasy.setItem(35, switchToMedium);
                return questInventoryEasy;

            case "medium":
                if (Quests.questsMedium.isEmpty()) {
                    for (int i = 0; i < 4; i++) {
                        int index = i + 10 + i;
                        Quest quest = Quests.createNewQuest("medium");
                        questInventoryMedium.setItem(index, quest.getQuestItem());
                        Quests.questsMedium.put(i, quest);
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        int index = i + 10 + i;
                        Quest quest = Quests.questsMedium.get(i);
                        questInventoryMedium.setItem(index, quest.getQuestItem());
                    }
                }

                for (int i = 0; i < 36; i++) {
                    if (questInventoryMedium.getItem(i) == null) {
                        if (i != 27 && i != 35) {
                            ItemMeta temp = empty.getItemMeta();
                            temp.setDisplayName("--");
                            empty.setItemMeta(temp);
                            questInventoryMedium.setItem(i, empty);
                        }

                    }
                }
                for (int i = 0; i < 4; i++) {
                    int index = 2 * i + 19;
                    questInventoryMedium.setItem(index, cancelQuest);
                }
                questInventoryMedium.setItem(35, switchToHard);
                questInventoryMedium.setItem(27, switchToEasy);
                return questInventoryMedium;

            case "hard":
                if (Quests.questsHard.isEmpty()) {
                    for (int i = 0; i < 4; i++) {
                        int index = i + 10 + i;
                        Quest quest = Quests.createNewQuest("hard");
                        questInventoryHard.setItem(index, quest.getQuestItem());
                        Quests.questsHard.put(i, quest);
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        int index = i + 10 + i;
                        Quest quest = Quests.questsHard.get(i);
                        questInventoryHard.setItem(index, quest.getQuestItem());
                    }
                }

                for (int i = 0; i < 36; i++) {
                    if (questInventoryHard.getItem(i) == null) {
                        if (i != 27) {
                            ItemMeta temp = empty.getItemMeta();
                            temp.setDisplayName("--");
                            empty.setItemMeta(temp);
                            questInventoryHard.setItem(i, empty);
                        }

                    }

                }
                for (int i = 0; i < 4; i++) {
                    int index = 2 * i + 19;
                    questInventoryHard.setItem(index, cancelQuest);
                }
                questInventoryHard.setItem(27, switchToMedium);
                return questInventoryHard;
            default:
                if (Quests.questsEasy.isEmpty()) {
                    for (int i = 0; i < 4; i++) {
                        int index = i + 10 + i;
                        Quest quest = Quests.createNewQuest("easy");
                        questInventoryEasy.setItem(index, quest.getQuestItem());
                        Quests.questsEasy.put(i, quest);
                    }
                } else {
                    for (int i = 0; i < 4; i++) {
                        int index = i + i;
                        Quest quest = Quests.questsEasy.get(i);
                        questInventoryEasy.setItem(index, quest.getQuestItem());
                    }
                }

                for (int i = 0; i < 27; i++) {
                    if (questInventoryEasy.getItem(i) == null) {
                        ItemMeta temp = empty.getItemMeta();
                        temp.setDisplayName("--");
                        empty.setItemMeta(temp);
                        questInventoryEasy.setItem(i, empty);
                    }
                }
                return questInventoryEasy;
        }
    }

    public static void updateInventory(Inventory inv) {

        if (questInventoryEasy.equals(inv)) {
            if (Quests.questsEasy.isEmpty()) {
                for (int i = 0; i < 4; i++) {
                    int index = i + 10 + i;
                    Quest quest = Quests.createNewQuest("easy");
                    questInventoryEasy.setItem(index, quest.getQuestItem());
                    Quests.questsEasy.put(i, quest);
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    int index = i + 10 + i;
                    if (!Quests.questsEasy.containsKey(i)) {
                        Quest quest = Quests.createNewQuest("easy");
                        questInventoryEasy.setItem(index, quest.getQuestItem());
                        Quests.questsEasy.put(i, quest);
                    } else {
                        Quest quest = Quests.questsEasy.get(i);
                        questInventoryEasy.setItem(index, quest.getQuestItem());
                    }

                }
                for (int i = 0; i < 4; i++) {
                    int index = 2 * i + 19;
                    questInventoryEasy.setItem(index, cancelQuest);
                }
            }

            for (int i = 0; i < 27; i++) {
                if (questInventoryEasy.getItem(i) == null) {
                    ItemMeta temp = empty.getItemMeta();
                    temp.setDisplayName("--");
                    empty.setItemMeta(temp);
                    questInventoryEasy.setItem(i, empty);
                }
            }
        } else if (questInventoryMedium.equals(inv)) {
            if (Quests.questsMedium.isEmpty()) {
                for (int i = 0; i < 4; i++) {
                    int index = i + 10 + i;
                    Quest quest = Quests.createNewQuest("medium");
                    questInventoryMedium.setItem(index, quest.getQuestItem());
                    Quests.questsMedium.put(i, quest);
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    int index = i + 10 + i;
                    if (!Quests.questsMedium.containsKey(i)) {
                        Quest quest = Quests.createNewQuest("easy");
                        questInventoryMedium.setItem(index, quest.getQuestItem());
                        Quests.questsMedium.put(i, quest);
                    } else {
                        Quest quest = Quests.questsMedium.get(i);
                        questInventoryMedium.setItem(index, quest.getQuestItem());
                    }
                }
            }

            for (int i = 0; i < 27; i++) {
                if (questInventoryMedium.getItem(i) == null) {
                    ItemMeta temp = empty.getItemMeta();
                    temp.setDisplayName("--");
                    empty.setItemMeta(temp);
                    questInventoryMedium.setItem(i, empty);
                }
            }
            for (int i = 0; i < 4; i++) {
                int index = 2 * i + 19;
                questInventoryMedium.setItem(index, cancelQuest);
            }
        } else if (questInventoryHard.equals(inv)) {
            if (Quests.questsHard.isEmpty()) {
                for (int i = 0; i < 4; i++) {
                    int index = i + 10 + i;
                    Quest quest = Quests.createNewQuest("hard");
                    questInventoryHard.setItem(index, quest.getQuestItem());
                    Quests.questsHard.put(i, quest);
                }
            } else {
                for (int i = 0; i < 4; i++) {
                    int index = i + 10 + i;
                    if (!Quests.questsHard.containsKey(i)) {
                        Quest quest = Quests.createNewQuest("easy");
                        questInventoryHard.setItem(index, quest.getQuestItem());
                        Quests.questsHard.put(i, quest);
                    } else {
                        Quest quest = Quests.questsHard.get(i);
                        questInventoryHard.setItem(index, quest.getQuestItem());
                    }
                }
            }

            for (int i = 0; i < 27; i++) {
                if (questInventoryHard.getItem(i) == null) {
                    ItemMeta temp = empty.getItemMeta();
                    temp.setDisplayName("--");
                    empty.setItemMeta(temp);
                    questInventoryHard.setItem(i, empty);
                }
            }
            for (int i = 0; i < 4; i++) {
                int index = 2 * i + 19;
                questInventoryHard.setItem(index, cancelQuest);
            }
        }
    }
}
