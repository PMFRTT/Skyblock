package com.pmfrtt.skyblock.Quests;

import org.apache.commons.lang.StringUtils;
import org.bukkit.Material;

import java.util.HashMap;
import java.util.Random;

public class Quests {

    public static HashMap<Integer, Quest> quests= new HashMap<Integer, Quest>();
    private static int multiplier = 8;

    private static final QuestRequirements questRequirements = new QuestRequirements();


    public static Quest createNewQuest() {
        Random random = new Random();
        Requirement requirement = Requirement.getRequirement();
        Quest quest = new Quest(requirement.getMaterial(), (random.nextInt(requirement.max - requirement.min) + requirement.min) * multiplier,Material.MUSIC_DISC_WARD, 1, false);

        return quest;
    }

    private void hasFInishedQuest() {
        //TODO
        // - clear old quest and generate new one
        // - give reward
        // - play sound

    }

    private void deleteQuest(Quest quest) {

    }

    public static String getMaterialName(Material material) {
        String temp = material.name();

        temp = temp.replace("_", " ");
        temp = StringUtils.lowerCase(temp);
        temp = StringUtils.capitalize(temp);

        return temp;
    }


}
