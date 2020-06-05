package com.pmfrtt.skyblock.Quests;

import com.pmfrtt.skyblock.Economy.Economy;
import com.pmfrtt.skyblock.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class QuestEventHandler implements Listener {

    Skyblock main;

    public QuestEventHandler(Skyblock main) {
        this.main = main;
    }


    public void initialize() {
        Bukkit.getPluginManager().registerEvents(this, main);
    }


    @EventHandler
    private void onInventoryClick(InventoryClickEvent e) {
        if (e.getClickedInventory() != null) {
            if (e.getClickedInventory().equals(QuestInventory.questInventory)) {
                int index = 0;
                switch (e.getSlot()) {
                    case 10:
                        index = 0;
                        break;
                    case 12:
                        index = 1;
                        break;
                    case 14:
                        index = 2;
                        break;
                    case 16:
                        index = 3;
                        break;
                }

                if (e.getWhoClicked().getInventory().containsAtLeast(new ItemStack(e.getCurrentItem().getType()), Quests.quests.get(index).amountRequired)) {
                    final int[] i = {0};
                    int finalIndex = index;
                    BukkitTask runnable = new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (i[0] < Quests.quests.get(finalIndex).amountRequired / 2) {
                                e.getWhoClicked().getInventory().removeItem(new ItemStack(e.getCurrentItem().getType(), 2));
                                Player player = (Player) e.getWhoClicked();
                                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1, 1);
                                i[0]++;
                            } else {
                                e.getWhoClicked().getInventory().addItem(new ItemStack(Quests.quests.get(finalIndex).reward, Quests.quests.get(finalIndex).amountReward));
                                Quests.quests.remove(finalIndex);
                                Economy.addMoney((Player) e.getWhoClicked(), 1000);
                                QuestInventory.questInventory.setItem(e.getSlot(), null);
                                QuestInventory.updateInventory();
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
