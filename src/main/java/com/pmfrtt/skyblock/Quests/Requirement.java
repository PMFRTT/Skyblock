package com.pmfrtt.skyblock.Quests;

import org.bukkit.Material;

import java.util.Random;



public class Requirement {

    public Material material;
    public int min;
    public int max;
    public int amount;
    public int minReward;
    public int maxReward;
    public float reward;


    public Requirement(Material material, int min, int max, int minReward, int maxReward) {
        this.material = material;
        this.min = min;
        this.max = max;
        this.minReward = minReward;
        this.maxReward = maxReward;
        getAmount();
        getReward();
    }

    public Material getMaterial() {
        return this.material;
    }

    public void getAmount() {
        Random random = new Random();
        this.amount = (random.nextInt(max - min) + min);
    }

    public void getReward() {
        Random random = new Random();
        int temp = random.nextInt(maxReward - minReward) + minReward;
        this.reward = (temp * amount * 8);
    }

}
