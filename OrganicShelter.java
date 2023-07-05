package org.wcci.virtualpet;

import java.util.HashMap;

public class OrganicShelter extends Shelter<OrganicPet> {

    private HashMap<Integer, Integer> feedingTimes;

    public OrganicShelter() {
        super();
        this.feedingTimes = new HashMap<>();
    }

    public void feed(String string) {
        HashMap<String, Integer> feedingInfo = parseString(string);

        for (String pet : feedingInfo.keySet()) {
            int amount = feedingInfo.get(pet);
            pets.get(pet).feed(amount);
        }
    }

    public void feedAll(int amount) {
        for (OrganicPet pet : pets.values()) {
            pet.feed(amount);
        }
    }

    public void setFeedingSchedule(String string) {
        Integer time;
        Integer amount;
        String[] scheduleAsString = string.split(", ");

        for (String window : scheduleAsString) {
            int colon = window.indexOf(":");
            if (colon == -1) {
                feedingTimes.put(Integer.parseInt(window), 1);
                continue;
            }

            time = Integer.parseInt(window.substring(0, colon));
            amount = Integer.parseInt(window.substring(colon + 1));
            feedingTimes.put(time, amount);
        }
    }

    public void removeFeedingSchedule() {
        feedingTimes.clear();
    }

    public boolean isFedAt(int hour) {
        return feedingTimes.containsKey(hour);
    }

    public void giveSnack(String string) {
        String[] petsToSnack = string.split(", ");
        for (String pet : petsToSnack) {
            pets.get(pet).giveSnack();
        }
    }

    public void giveAllSnack() {
        for (OrganicPet pet : pets.values()) {
            pet.giveSnack();
        }
    }

    public void water(String string) {
        HashMap<String, Integer> waterInfo = parseString(string);

        for (String pet : waterInfo.keySet()) {
            int amount = waterInfo.get(pet);
            pets.get(pet).water(amount);
        }
    }

    public void waterAll(int amount) {
        for (OrganicPet pet : pets.values()) {
            pet.water(amount);
        }
    }

    public void trainAll(String trickName) {
        for (OrganicPet pet : pets.values()) {
            pet.train(trickName);
        }
    }

    public void timePassed(int hours) {
        for (OrganicPet pet : pets.values()) {
            pet.setAgeInMonths(pet.getAgeInMonths() + HOUR_IN_MONTHS * hours);
            pet.changeThirst(hours);
            pet.changeTiredness(hours);

            for (int i = 0; i < hours; i++) {
                currentTime++;
                if (currentTime > 23)
                    currentTime %= 24;
                if (feedingTimes.containsKey(currentTime))
                    pet.feed(feedingTimes.get(currentTime));
                pet.changeHunger(1);
            }
        }
    }
}