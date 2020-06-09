package com.pmfrtt.skyblock;

import com.pmfrtt.skyblock.Economy.EconomyCommands;
import com.pmfrtt.skyblock.Economy.EconomyFileManager;
import com.pmfrtt.skyblock.Quests.QuestCommands;
import com.pmfrtt.skyblock.Quests.QuestEventHandler;
import com.pmfrtt.skyblock.Shop.ShopCommands;
import com.pmfrtt.skyblock.Shop.ShopEventHandler;
import core.core.CoreMain;
import org.bukkit.plugin.java.JavaPlugin;



public final class Skyblock extends JavaPlugin {

    private ShopCommands shopCommands = new ShopCommands(this);
    private ShopEventHandler shopEventHandler = new ShopEventHandler(this);

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
        shopEventHandler.initialize();
        economyFileManager.readFromFile();
        getCommand("quest").setExecutor(questCommands);
        getCommand("balance").setExecutor(economyCommands);
        getCommand("money").setExecutor(economyCommands);
        getCommand("sell").setExecutor(shopCommands);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


}
