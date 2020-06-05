package com.pmfrtt.skyblock.Quests;

import org.bukkit.Material;

import java.util.Random;

import static com.pmfrtt.skyblock.Quests.QuestRequirements.easyRequirements;


public class Requirement {

    public Material material;
    public int  min;
    public int max;
    public int amount;


    public Requirement(Material material, int min, int max) {
        this.material = material;
        this.min = min;
        this.max = max;
        getAmount();
    }

    public static Requirement getRequirement(){
        Random random = new Random();
        int i = random.nextInt(easyRequirements.length);
        return easyRequirements[i];
    }

    public Material getMaterial(){
        return this.material;
    }

    public void getAmount(){
            Random random = new Random();
            this.amount = (random.nextInt(max - min) + min);
    }

}
