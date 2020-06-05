package com.pmfrtt.skyblock.Quests;

import org.bukkit.Material;


public class QuestRequirements {

    public QuestRequirements() {

    }

    private static Requirement carrot = new Requirement(Material.CARROT, 2, 16);
    private static Requirement potato = new Requirement(Material.POTATO, 2, 16);
    private static Requirement wheat = new Requirement(Material.WHEAT, 2, 16);
    private static Requirement log = new Requirement(Material.OAK_LOG, 8, 16);
    private static Requirement cobblestone = new Requirement(Material.COBBLESTONE, 16, 32);

    public static Requirement[] easyRequirements = {
            carrot, potato, wheat, log, cobblestone
    };
}