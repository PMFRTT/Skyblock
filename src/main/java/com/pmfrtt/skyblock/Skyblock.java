package com.pmfrtt.skyblock;

import com.pmfrtt.skyblock.Economy.EconomyCommands;
import com.pmfrtt.skyblock.Economy.EconomyFileManager;
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
    private QuestEventHandler questEventHandler = new QuestEventHandler(this);

    private EconomyCommands economyCommands = new EconomyCommands(this);
    public EconomyFileManager economyFileManager = new EconomyFileManager(this);

    private SkyblockEventHandler skyblockEventHandler = new SkyblockEventHandler(this);

    @Override
    public void onEnable() {
        CoreMain.setPlugin(this);
        questEventHandler.initialize();
        skyblockEventHandler.initialize();
        economyFileManager.readFromFile();
        getCommand("quest").setExecutor(questCommands);
        getCommand("balance").setExecutor(economyCommands);
        getCommand("money").setExecutor(economyCommands);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
