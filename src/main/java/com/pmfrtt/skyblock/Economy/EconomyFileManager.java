package com.pmfrtt.skyblock.Economy;

import com.pmfrtt.skyblock.Skyblock;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EconomyFileManager {

    Skyblock main;

    public EconomyFileManager(Skyblock main) {
        this.main = main;
    }


    public void readFromFile() {
        try {
            File dataFolder = main.getDataFolder();
            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }

            File economyFile = new File(main.getDataFolder(), "economy.yml");
            if (!economyFile.exists()) {
                economyFile.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader(economyFile));

            List<String> lines = new ArrayList<String>();
            String currentline;
            while ((currentline = reader.readLine()) != null) {
                lines.add(currentline);
            }

            for (String string : lines) {
                UUID uuid = UUID.fromString(string.substring(0, 36));
                float balance = Float.parseFloat(string.substring(37));
                Economy.playerBalance.put(Bukkit.getPlayer(uuid), balance);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean containsPlayer(Player player) {

        boolean temp = false;

        try {

            UUID uuid = player.getUniqueId();

            File dataFolder = main.getDataFolder();
            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }

            File economyFile = new File(main.getDataFolder(), "economy.yml");
            if (!economyFile.exists()) {
                economyFile.createNewFile();
            }

            BufferedReader reader = new BufferedReader(new FileReader(economyFile));


            List<String> lines = new ArrayList<String>();
            String currentline;
            while ((currentline = reader.readLine()) != null) {
                lines.add(currentline);
            }

            for (String string : lines) {
                if (string.contains(uuid.toString())) {
                    temp = true;
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
        return temp;
    }

    public void writeToFile(Player player, float amount) {
        try {

            File dataFolder = main.getDataFolder();
            if (!dataFolder.exists()) {
                dataFolder.mkdir();
            }

            File economyFile = new File(main.getDataFolder(), "economy.yml");
            if (!economyFile.exists()) {
                economyFile.createNewFile();
            }

            FileWriter fileWriter = new FileWriter(economyFile, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            BufferedReader reader = new BufferedReader(new FileReader(economyFile));


            List<String> lines = new ArrayList<String>();
            String currentline;
            while ((currentline = reader.readLine()) != null) {
                lines.add(currentline);
            }

            PrintWriter clear = new PrintWriter(economyFile);
            clear.close();

            for (String string : lines) {
                if (!string.contains(player.getUniqueId().toString())) {
                    printWriter.println(string);
                    printWriter.flush();
                }
            }

            printWriter.println(player.getUniqueId() + " " + amount);
            printWriter.flush();

            printWriter.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
