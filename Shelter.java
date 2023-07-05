package org.wcci.virtualpet;

import java.util.HashMap;

abstract class Shelter<P extends Pet> {
    final static double HOUR_IN_MONTHS = 0.0013889;
    protected int currentTime;

    protected HashMap<String, P> pets;
    
    public Shelter() {
        pets = new HashMap<>();
        this.currentTime = 8;
    }

    public void add(P pet) {
        String name = pet.getName();
        pets.put(name, pet);
    }

    public void adopt(String name) {
        pets.remove(name);
    }

    public int size() {
        return pets.size();
    }

    public boolean containsPet(String name) {
        return pets.containsKey(name);
    }

    public P getPet(String name) {
        return pets.get(name);
    }

    public double averageChanceOfTrick(String trickName) {
        double average = 0.0;
        for (Pet pet : pets.values()) {
            average += pet.chanceOfTrick(trickName);
        }
        return average / pets.size();
    }

    public HashMap<String, Integer> parseString(String string) {
        String name;
        Integer amount;

        String[] infoArray = string.split(", ");

        HashMap<String, Integer> infoParsed = new HashMap<>();
        for (String pet : infoArray) {
            int colon = pet.indexOf(":");

            name = pet.substring(0, colon);
            amount = Integer.parseInt(pet.substring(colon + 1));
            infoParsed.put(name, amount);
        }
        return infoParsed;
    }
}
