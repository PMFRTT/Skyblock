package com.pmfrtt.skyblock.Quests;

import com.pmfrtt.skyblock.Economy.Economy;
import com.pmfrtt.skyblock.Economy.EconomyFileManager;
import com.pmfrtt.skyblock.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class QuestEventHandler implements Listener {

    Skyblock main;

    public QuestEventHandler(Skyblock main) {
        this.main = main;
    }

    private static final QuestInventory questInventory = new QuestInventory();


    public void initialize() {
        Bukkit.getPluginManager().registerEvents(this, main);
    }


    @EventHandler
    private void onInventoryClick(InventoryClickEvent e) {
        if (e.getClickedInventory() != null) {
            int index = 0;
            switch (e.getSlot()) {
                case 10:
                case 19:
                    index = 0;
                    break;
                case 12:
                case 21:
                    index = 1;
                    break;
                case 14:
                case 23:
                    index = 2;
                    break;
                case 16:
                case 25:
                    index = 3;
                    break;
            }
            Inventory clickedInventory = e.getClickedInventory();
            if (e.getCurrentItem().equals(questInventory.switchToEasy)) {
                e.getWhoClicked().openInventory(QuestInventory.getInventory("easy"));
            } else if (e.getCurrentItem().equals(questInventory.switchToMedium)) {
                e.getWhoClicked().openInventory(QuestInventory.getInventory("medium"));
            } else if (e.getCurrentItem().equals(questInventory.switchToHard)) {
                e.getWhoClicked().openInventory(QuestInventory.getInventory("hard"));
            } else if (e.getCurrentItem().equals(questInventory.cancelQuest)) {


                if (e.getClickedInventory().equals(QuestInventory.questInventoryEasy)) {
                    e.setCancelled(true);
                    Quests.questsEasy.remove(index);
                    main.economyFileManager.writeToFile((Player) e.getWhoClicked(), Economy.playerBalance.get((Player) e.getWhoClicked()));
                    e.getClickedInventory().setItem(e.getSlot(), null);
                    QuestInventory.updateInventory(e.getClickedInventory());
                }

                else if (e.getClickedInventory().equals(QuestInventory.questInventoryMedium)) {
                    e.setCancelled(true);
                    Quests.questsMedium.remove(index);
                    main.economyFileManager.writeToFile((Player) e.getWhoClicked(), Economy.playerBalance.get((Player) e.getWhoClicked()));
                    e.getClickedInventory().setItem(e.getSlot(), null);
                    QuestInventory.updateInventory(e.getClickedInventory());
                }

                else if (e.getClickedInventory().equals(QuestInventory.questInventoryHard)) {
                    e.setCancelled(true);
                    Quests.questsHard.remove(index);
                    main.economyFileManager.writeToFile((Player) e.getWhoClicked(), Economy.playerBalance.get((Player) e.getWhoClicked()));
                    e.getClickedInventory().setItem(e.getSlot(), null);
                    QuestInventory.updateInventory(e.getClickedInventory());
                }




            } else if (QuestInventory.questInventoryEasy.equals(clickedInventory)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(new ItemStack(e.getCurrentItem().getType()), Quests.questsEasy.get(index).amountRequired)) {
                    final int[] i = {0};
                    int finalIndex = index;
                    BukkitTask runnable1 = new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (Quests.questsEasy.get(finalIndex) != null && i[0] < Quests.questsEasy.get(finalIndex).amountRequired / 2) {
                                e.getWhoClicked().getInventory().removeItem(new ItemStack(e.getCurrentItem().getType(), 2));
                                Player player = (Player) e.getWhoClicked();
                                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1, 1);
                                i[0]++;
                            } else {
                                Economy.addMoney((Player) e.getWhoClicked(), Quests.questsEasy.get(finalIndex).amountReward / 100);
                                Quests.questsEasy.remove(finalIndex);
                                main.economyFileManager.writeToFile((Player) e.getWhoClicked(), Economy.playerBalance.get((Player) e.getWhoClicked()));
                                e.getClickedInventory().setItem(e.getSlot(), null);
                                QuestInventory.updateInventory(e.getClickedInventory());
                                cancel();
                            }
                        }
                    }.runTaskTimer(main, 0, 1L);
                }
                e.setCancelled(true);
            } else if (QuestInventory.questInventoryMedium.equals(clickedInventory)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(new ItemStack(e.getCurrentItem().getType()), Quests.questsMedium.get(index).amountRequired)) {
                    final int[] i = {0};
                    int finalIndex = index;
                    BukkitTask runnable2 = new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (Quests.questsMedium.get(finalIndex) != null && i[0] < Quests.questsMedium.get(finalIndex).amountRequired / 2) {
                                e.getWhoClicked().getInventory().removeItem(new ItemStack(e.getCurrentItem().getType(), 2));
                                Player player = (Player) e.getWhoClicked();
                                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1, 1);
                                i[0]++;
                            } else {
                                Economy.addMoney((Player) e.getWhoClicked(), Quests.questsMedium.get(finalIndex).amountReward / 100);
                                Quests.questsMedium.remove(finalIndex);
                                main.economyFileManager.writeToFile((Player) e.getWhoClicked(), Economy.playerBalance.get((Player) e.getWhoClicked()));
                                e.getClickedInventory().setItem(e.getSlot(), null);
                                QuestInventory.updateInventory(e.getClickedInventory());
                                cancel();
                            }
                        }
                    }.runTaskTimer(main, 0, 1L);
                }
                e.setCancelled(true);
            } else if (QuestInventory.questInventoryHard.equals(clickedInventory)) {
                if (e.getWhoClicked().getInventory().containsAtLeast(new ItemStack(e.getCurrentItem().getType()), Quests.questsHard.get(index).amountRequired)) {
                    final int[] i = {0};
                    int finalIndex = index;
                    BukkitTask runnable3 = new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (Quests.questsHard.get(finalIndex) != null && i[0] < Quests.questsHard.get(finalIndex).amountRequired / 2) {
                                e.getWhoClicked().getInventory().removeItem(new ItemStack(e.getCurrentItem().getType(), 2));
                                Player player = (Player) e.getWhoClicked();
                                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1, 1);
                                i[0]++;
                            } else {
                                Economy.addMoney((Player) e.getWhoClicked(), Quests.questsHard.get(finalIndex).amountReward / 100);
                                Quests.questsHard.remove(finalIndex);
                                main.economyFileManager.writeToFile((Player) e.getWhoClicked(), Economy.playerBalance.get((Player) e.getWhoClicked()));
                                e.getClickedInventory().setItem(e.getSlot(), null);
                                QuestInventory.updateInventory(e.getClickedInventory());
                                cancel();
                            }
                        }
                    }.runTaskTimer(main, 0, 1L);
                }
                e.setCancelled(true);
            }
        }
    }


}
