package com.pmfrtt.skyblock.Quests;

import org.bukkit.Material;

import java.util.Random;


public class QuestRequirements {

    public QuestRequirements() {

    }

    private Requirement carrot = new Requirement(Material.CARROT, 2, 16, 4, 6);
    private Requirement potato = new Requirement(Material.POTATO, 2, 16, 4, 6);
    private Requirement wheat = new Requirement(Material.WHEAT, 2, 16, 4, 6);
    private Requirement log = new Requirement(Material.OAK_LOG, 8, 16, 8, 10);
    private Requirement cobblestone = new Requirement(Material.COBBLESTONE, 16, 32, 2, 4);
    private Requirement rottenFlesh = new Requirement(Material.ROTTEN_FLESH, 4, 8, 6, 10);
    private Requirement bone = new Requirement(Material.BONE, 4, 8, 6, 10);
    private Requirement string = new Requirement(Material.STRING, 4, 8, 10, 12);
    private Requirement sapling = new Requirement(Material.OAK_SAPLING, 2, 4, 4, 6);
    private Requirement apple = new Requirement(Material.APPLE, 1, 4, 8, 12);
    private Requirement stick = new Requirement(Material.STICK, 8, 16, 2, 4);
    private Requirement bread = new Requirement(Material.BREAD, 8, 16, 12, 16);
    //private static Requirement cobblestone = new Requirement(Material.COBBLESTONE, 16, 32);
    //private static Requirement rottenFlesh = new Requirement(Material.ROTTEN_FLESH, 4, 8);
    //private static Requirement bone = new Requirement(Material.BONE, 4, 8);
    //private static Requirement string = new Requirement(Material.STRING, 4, 8);

    public Requirement[] easyRequirements = {
            carrot, potato, wheat, log, cobblestone, rottenFlesh, bone, string, sapling, apple, stick, bread
    };

    private Requirement fermentedSpiderEye = new Requirement(Material.FERMENTED_SPIDER_EYE, 2, 4, 50, 300);




    public Requirement[] mediumRequirements = {
            fermentedSpiderEye
    };

    private Requirement diamond = new Requirement(Material.DIAMOND, 2,3,150,100000);

    public Requirement[] hardRequirements = {
diamond
    };

    public Requirement getRequirement(String difficulty) {


        Random random = new Random();


        switch (difficulty) {
            case "easy":
                int i = random.nextInt(easyRequirements.length);
                return easyRequirements[i];
            case "medium":
                int j = random.nextInt(mediumRequirements.length);
                return mediumRequirements[j];
            case "hard":
                int k = random.nextInt(hardRequirements.length);
                return hardRequirements[k];
            default:
                int l = random.nextInt(0);
                return easyRequirements[l];
        }

    }
}