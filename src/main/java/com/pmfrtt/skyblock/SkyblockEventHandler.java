package com.pmfrtt.skyblock;

import com.pmfrtt.skyblock.Economy.Economy;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockFormEvent;
import org.bukkit.event.player.PlayerJoinEvent;

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
    private void onCobbleForm(BlockFormEvent e){

        if(e.getBlock().getType().equals(Material.LAVA)){
            e.setCancelled(true);
            Location l = e.getBlock().getLocation();
            Random random = new Random();
            int chance = random.nextInt(1000);
            World world = Bukkit.getWorld("world");
           if(chance > 995){
               l.getBlock().setType(Material.DIAMOND_ORE);
               world.playSound(l, Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);
               world.playSound(l, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
           }else if (chance < 995 && chance > 975){
               l.getBlock().setType(Material.LAPIS_ORE);
               world.playSound(l, Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);

           }
           else if (chance < 955 && chance > 945){
               l.getBlock().setType(Material.EMERALD_ORE);
               world.playSound(l, Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);
               world.playSound(l, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

           }
           else if (chance < 945 && chance > 900){
               l.getBlock().setType(Material.IRON_ORE);
               world.playSound(l, Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);

           }
           else if (chance < 900 && chance > 875){
               l.getBlock().setType(Material.REDSTONE_ORE);
               world.playSound(l, Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);

           }
           else if (chance <875 && chance > 825){
               l.getBlock().setType(Material.COAL_ORE);
               world.playSound(l, Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);

           }else{
               l.getBlock().setType(Material.COBBLESTONE);
               world.playSound(l, Sound.BLOCK_LAVA_EXTINGUISH, 1, 1);
           }
        }
    }


}
