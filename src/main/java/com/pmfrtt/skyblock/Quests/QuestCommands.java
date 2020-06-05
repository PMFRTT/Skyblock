package com.pmfrtt.skyblock.Quests;

import com.pmfrtt.skyblock.Skyblock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QuestCommands implements CommandExecutor {

    Skyblock main;

    public QuestCommands(Skyblock main){
            this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = null;
        if(sender instanceof Player){
            player = (Player) sender;
        }

        if(command.getLabel().equalsIgnoreCase("quest")){
            player.sendMessage("commandexecutor is working!");
            player.openInventory(QuestInventory.getInventory());
            return true;
        }
        return false;
    }
}
