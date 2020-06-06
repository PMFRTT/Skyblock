package com.pmfrtt.skyblock.Quests;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Random;

public class Quests {

    public static HashMap<Integer, Quest> questsEasy= new HashMap<>();
    public static HashMap<Integer, Quest> questsMedium= new HashMap<>();
    public static HashMap<Integer, Quest> questsHard= new HashMap<>();

    private static int multiplier = 8;

    private static final QuestRequirements questRequirements = new QuestRequirements();


    public static Quest createNewQuest(String difficulty) {
        QuestRequirements questRequirements = new QuestRequirements();
        Random random = new Random();
        Requirement requirement = questRequirements.getRequirement(difficulty);
        Quest quest = new Quest(requirement.getMaterial(), (random.nextInt(requirement.max - requirement.min) + requirement.min) * multiplier, requirement.reward, false);
        return quest;
    }

    public static String getMaterialName(Material material) {
        String temp = material.name();

        temp = temp.replace("_", " ");
        temp = StringUtils.lowerCase(temp);
        temp = StringUtils.capitalize(temp);

        return temp;
    }


}
