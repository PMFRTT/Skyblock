package com.pmfrtt.skyblock;

import com.pmfrtt.skyblock.Economy.Economy;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class SkyblockEventHandler implements Listener {

    Skyblock main;

    public SkyblockEventHandler(Skyblock main) {
        this.main = main;
    }

    public void initialize() {
        Bukkit.getPluginManager().registerEvents(this, main);
    }

    @EventHandler
    private void onPlayerJoin(PlayerJoinEvent e) {
        if (!Economy.playerBalance.containsKey(e.getPlayer())) {
            if (main.economyFileManager.containsPlayer(e.getPlayer())) {
                main.economyFileManager.readFromFile();
            } else {
                main.economyFileManager.writeToFile(e.getPlayer(), 0);
            }
        }

    }

    @EventHandler
    private void onCobbleForm(BlockFormEvent e) {

        if (e.getBlock().getType().equals(Material.LAVA)) {
            e.setCancelled(true);
            Location l = e.getBlock().getLocation();
            Random random = new Random();
            int chance = random.nextInt(1000);
            World world = Bukkit.getWorld("world");
            if (chance >= 998) {
                l.getBlock().setType(Material.DIAMOND_ORE);
                world.playSound(l, Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);
                world.playSound(l, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            } else if (chance <= 995 && chance >= 988) {
                l.getBlock().setType(Material.LAPIS_ORE);
                world.playSound(l, Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);
                world.playSound(l, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            } else if (chance <= 955 && chance >= 952) {
                l.getBlock().setType(Material.EMERALD_ORE);
                world.playSound(l, Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);
                world.playSound(l, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            } else if (chance <= 945 && chance >= 935) {
                l.getBlock().setType(Material.IRON_ORE);
                world.playSound(l, Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);
                world.playSound(l, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            } else if (chance <= 900 && chance >= 893) {
                l.getBlock().setType(Material.REDSTONE_ORE);
                world.playSound(l, Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);
                world.playSound(l, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            } else if (chance <= 875 && chance >= 845) {
                l.getBlock().setType(Material.COAL_ORE);
                world.playSound(l, Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);
                world.playSound(l, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            } else if (chance <= 7) {
                l.getBlock().setType(Material.GOLD_ORE);
                world.playSound(l, Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);
                world.playSound(l, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            } else {
                l.getBlock().setType(Material.COBBLESTONE);
                world.playSound(l, Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);
            }
        }
    }

    @EventHandler
    private void playerInteraction(PlayerInteractEvent e) {
        if (e.getItem().getType().equals(Material.POTION)) {
            if(e.getClickedBlock().getType().equals(Material.SAND)){
                e.getClickedBlock().setType(Material.CLAY);
                e.getPlayer().getItemInHand().setType(Material.GLASS_BOTTLE);
                e.setCancelled(true);
            }
        }
    }


}
