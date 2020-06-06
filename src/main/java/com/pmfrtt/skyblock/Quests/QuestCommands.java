package com.pmfrtt.skyblock.Quests;

import com.pmfrtt.skyblock.Skyblock;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class QuestCommands implements CommandExecutor {

    Skyblock main;

    public QuestCommands(Skyblock main) {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        Player player = null;
        if (sender instanceof Player) {
            player = (Player) sender;
        }

        if (command.getLabel().equalsIgnoreCase("quest")) {
            if (args.length == 1) {
                QuestInventory.initializeSwitchers();
                if (args[0].equalsIgnoreCase("easy")) {
                    assert player != null;
                    player.openInventory(QuestInventory.getInventory("easy"));
                    return true;
                } else if (args[0].equalsIgnoreCase("medium")) {
                    assert player != null;
                    player.openInventory(QuestInventory.getInventory("medium"));
                    return true;
                } else if (args[0].equalsIgnoreCase("hard")) {
                    assert player != null;
                    player.openInventory(QuestInventory.getInventory("hard"));
                    return true;
                }
            } else {
                assert player != null;
                player.openInventory(QuestInventory.getInventory("easy"));

                return true;
            }
        }
        return false;
    }
}
