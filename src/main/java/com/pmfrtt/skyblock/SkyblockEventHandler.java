package com.pmfrtt.skyblock;

import com.pmfrtt.skyblock.Economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

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


}
