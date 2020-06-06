package com.pmfrtt.skyblock.Economy;

import com.pmfrtt.skyblock.Skyblock;
import core.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.text.DecimalFormat;

public class EconomyCommands implements CommandExecutor {

    Skyblock main;

    public EconomyCommands(Skyblock main) {
        this.main = main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = null;
        if (sender instanceof Player) {
            player = (Player) sender;
        }

        if (command.getLabel().equalsIgnoreCase("balance")) {
            if (main.economyFileManager.containsPlayer(player)) {
                main.economyFileManager.readFromFile();
            } else {
                main.economyFileManager.writeToFile(player, 0);
            }
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            String numberAsString = decimalFormat.format(Economy.playerBalance.get(player));
            player.sendMessage(Utils.colorize("Du hast &a" + numberAsString + "&f€"));
            main.economyFileManager.writeToFile(player, Economy.playerBalance.get(player));
        } else if (command.getLabel().equals("money")) {
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("send")) {
                    if (Bukkit.getPlayer(args[1]) != null) {
                        try {
                            Player sendTo = Bukkit.getPlayer(args[1]);
                            Float amount = Float.parseFloat(args[2]);
                            Economy.sendMoney(player, sendTo, amount);
                            player.sendMessage(Utils.getPrefix("Economy") + Utils.colorize("Du hast &c" + amount + "&f€ an &b" + sendTo.getDisplayName() + " &fgesendet!"));
                            sendTo.sendMessage(Utils.getPrefix("Economy") + Utils.colorize("Du hast &a" + amount + "&f€ von &b" + player.getDisplayName() + " &ferhalten!"));
                        } catch (Exception e) {
                            player.sendMessage(Utils.getPrefix("Economy") + Utils.colorize("Verwende &6/money send <Name> <Betrag>&f um Geld zu versenden!"));
                            e.printStackTrace();
                            return false;
                        }
                    } else {
                        player.sendMessage(Utils.getPrefix("Economy") + Utils.colorize("Verwende &6/money send <Name> <Betrag>&f um Geld zu versenden!"));
                        return false;
                    }
                }else if(args[0].equalsIgnoreCase("request")){
                    if (Bukkit.getPlayer(args[1]) != null) {
                        try {
                            Player sendTo = Bukkit.getPlayer(args[1]);
                            Float amount = Float.parseFloat(args[2]);

                            player.sendMessage(Utils.getPrefix("Economy") + Utils.colorize("Du hast &b" + sendTo.getDisplayName() + "&f nach &a" + amount + "&f€ gefragt!"));
                            sendTo.sendMessage(Utils.getPrefix("Economy") + Utils.colorize("&b" + player.getDisplayName() + " &fbenötigt &c" + amount + "&f€!"));

                        }catch(Exception e){
                            player.sendMessage(Utils.getPrefix("Economy") + Utils.colorize("Verwende &6/money request <Name> <Betrag>&f um Geld anzufragen!"));
                            e.printStackTrace();
                            return false;
                        }
                    }else{
                        player.sendMessage(Utils.getPrefix("Economy") + Utils.colorize("Verwende &6/money request <Name> <Betrag>&f um Geld anzufragen!"));
                    }
                }
            } else {
                player.sendMessage(Utils.getPrefix("Economy") + Utils.colorize("Verwende &6/money <request/send> <Name> <Betrag>"));
                return false;
            }
        }

        return false;
    }
}
