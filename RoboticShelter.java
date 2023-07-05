package org.wcci.virtualpet;

import java.util.HashMap;

public class RoboticShelter extends Shelter<RoboticPet> {

    private HashMap<Integer, Integer> chargingTimes = new HashMap<>();

    public void charge(String string) {
        HashMap<String, Integer> chargingInfo = parseString(string);

        for (String pet : chargingInfo.keySet()) {
            int amount = chargingInfo.get(pet);
            pets.get(pet).charge(amount);
        }
    }

    public void chargeAll(int amount) {
        for (RoboticPet pet : pets.values()) {
            pet.charge(amount);
        }
    }

    public void setChargingSchedule(String string) {
        Integer time;
        Integer amount;
        String[] scheduleAsString = string.split(", ");

        for (String window : scheduleAsString) {
            int colon = window.indexOf(":");
            if (colon == -1) {
                chargingTimes.put(Integer.parseInt(window), 1);
                continue;
            }

            time = Integer.parseInt(window.substring(0, colon));
            amount = Integer.parseInt(window.substring(colon + 1));
            chargingTimes.put(time, amount);
        }
    }

    public void removeChargingSchedule() {
        chargingTimes.clear();
    }

    public boolean isChargedAt(int hour) {
        return chargingTimes.containsKey(hour);
    }

    public void oil(String string) {
        HashMap<String, Integer> oilInfo = parseString(string);

        for (String pet : oilInfo.keySet()) {
            int amount = oilInfo.get(pet);
            pets.get(pet).oil(amount);
        }
    }

    public void oilAll(int amount) {
        for (RoboticPet pet : pets.values()) {
            pet.oil(amount);
        }
    }

    public void trainAll(String trickName) {
        for (RoboticPet pet : pets.values()) {
            pet.train(trickName);
        }
    }

    public void timePassed(int hours) {
        for (RoboticPet pet : pets.values()) {
            pet.setAgeInMonths(pet.getAgeInMonths() + HOUR_IN_MONTHS * hours);
            pet.changeOilLevel(-1*hours);

            for (int i = 0; i < hours; i++) {
                currentTime++;
                if (currentTime > 23)
                    currentTime %= 24;
                if (chargingTimes.containsKey(currentTime))
                    pet.charge(chargingTimes.get(currentTime));
                pet.changeCharge(-1);
            }
        }
    }
}
