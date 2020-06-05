package com.pmfrtt.skyblock;

import com.pmfrtt.skyblock.Economy.EconomyCommands;
import com.pmfrtt.skyblock.Quests.QuestCommands;
import com.pmfrtt.skyblock.Quests.QuestEventHandler;
import com.pmfrtt.skyblock.Shop.ShopCommands;
import core.CoreMain;
import org.bukkit.plugin.java.JavaPlugin;

//TODO
// - Test multiple world for one server
// - add Shop interface
// -

public final class Skyblock extends JavaPlugin {

    private ShopCommands shopCommands = new ShopCommands(this);
    private QuestCommands questCommands = new QuestCommands(this);
    private EconomyCommands economyCommands = new EconomyCommands(this);
    private QuestEventHandler questEventHandler = new QuestEventHandler(this);

    @Override
    public void onEnable() {
        CoreMain.setPlugin(this);
        questEventHandler.initialize();
        getCommand("quest").setExecutor(questCommands);
        getCommand("balance").setExecutor(economyCommands);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
