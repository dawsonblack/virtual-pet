package org.wcci.virtualpet;

import java.util.HashMap;
import java.util.Scanner;

public class UI {
    public static void promptAddPet(Scanner scanner, OrganicShelter organicShelter, RoboticShelter roboticShelter) {
        System.out.println(
                "What kind of pet would you like to put in? You can choose a dog or a cat, and it can be robotic or organic.");
        String petType = scanner.nextLine().toLowerCase();

        while (!petType.equals("organic dog") && !petType.equals("organic cat")
                && !petType.equals("robotic dog") && !petType.equals("robotic cat")) {
            System.out.println("Unknown pet type. Please choose either a dog or cat, and choose organic or robotic.");
            petType = scanner.nextLine().toLowerCase();
        }

        System.out.println("Please choose a name for your " + petType + ".");
        String petName = scanner.nextLine().toLowerCase();

        if (petType.equals("organic dog")) {
            organicShelter.add(new OrganicDog(petName));
        
        } else if (petType.equals("organic cat")) {
            organicShelter.add(new OrganicCat(petName));
        
        } else if (petType.equals("robotic dog")) {
            roboticShelter.add(new RoboticDog(petName));
        
        } else if (petType.equals("robotic cat")) {
            roboticShelter.add(new RoboticCat(petName));
        
        } else {
            System.out.println("Only robotic/organic cats/dogs are allowed!");
            return;
        }

        System.out.println("Success! Your pet has been added to the shelter.");
    }

    public static void promptFoodWaterOilCharge(Scanner scanner, OrganicShelter organicShelter, RoboticShelter roboticShelter, String action) {
        HashMap<String, String> pastTense = new HashMap<>();
        pastTense.put("feed", "fed");
        pastTense.put("water", "watered");
        pastTense.put("oil", "oiled");
        pastTense.put("charge", "charged");

        System.out.println("Please enter the names of the pets you would like to "
                + action + " followed by a colon, followed by the amount you want to " + action
                + " them, like this: \"Spot:1, Fido:3\"");
        String info = scanner.nextLine().toLowerCase();

        if (action.equals("feed")) {
            organicShelter.feed(info);
        } else if (action.equals("water")) {
            organicShelter.water(info);
        } else if (action.equals("charge")) {
            roboticShelter.charge(info);
        } else if (action.equals("oil")) {
            roboticShelter.oil(info);
        } else {
            System.out.println("Error, unknown action!");
            return;
        }

        System.out.println("Success! Your pets have been successfully " + pastTense.get(action) + ".");
    }

    public static void promptPetStatus(Scanner scanner, OrganicShelter organicShelter, RoboticShelter roboticShelter, String statusCommand) {
        System.out.println("Please enter the name of the pet you would like to check");
        String name = scanner.nextLine().toLowerCase();

        boolean status = false;
        switch (statusCommand) {
            case "check hunger":
                status = organicShelter.getPet(name).isHungry();
                break;
            case "check starvation":
                status = organicShelter.getPet(name).isStarving();
                break;
            case "check overfeeding":
                status = organicShelter.getPet(name).isOverfed();
                break;
            case "check thirst":
                status = organicShelter.getPet(name).isThirsty();
                break;
            case "check dehydration":
                status = organicShelter.getPet(name).isDehydrated();
                break;
            case "check overwatering":
                status = organicShelter.getPet(name).isOverwatered();
                break;
            case "check tiredness":
                status = organicShelter.getPet(name).isTired();
                break;
            case "check low oil":
                status = roboticShelter.getPet(name).needsOil();
                break;
            case "check no oil":
                status = roboticShelter.getPet(name).outOfOil();
                break;
            case "check overoiling":
                status = roboticShelter.getPet(name).isOverOiled();
                break;
            case "check low charge":
                status = roboticShelter.getPet(name).needsCharging();
                break;
            case "check no charge":
                status = roboticShelter.getPet(name).isDead();
                break;
            case "check overcharged":
                status = roboticShelter.getPet(name).isOverCharged();
                break;
            case "check age":
                double age = roboticShelter.getPet(name).getAgeInMonths();
                System.out.println("Status returns: " + age);
                break;
        }

        if (statusCommand != "check age") {
            System.out.println("Status returns: " + status);
        }
    }

    public static void promptChanceOfTrick(Scanner scanner, OrganicShelter organicShelter, RoboticShelter roboticShelter) {
        System.out.println("Enter the pet you would like to check on: ");
        String name = scanner.nextLine().toLowerCase();

        System.out.println("Enter the trick you would like to check the chance of: ");
        String trickName = scanner.nextLine().toLowerCase();

        double chanceOfTrick;
        if (roboticShelter.containsPet(name)) {
            chanceOfTrick = roboticShelter.getPet(name).chanceOfTrick(trickName);
        } else {
            chanceOfTrick = organicShelter.getPet(name).chanceOfTrick(trickName);
        }

        System.out.println("The chance of " + name + " doing trick " + trickName + " is " + chanceOfTrick + ".");
    }

    public static void promptTrain(Scanner scanner, OrganicShelter organicShelter, RoboticShelter roboticShelter) {
        System.out.println("Enter the name of the pet you would like to train: ");
        String name = scanner.nextLine().toLowerCase();

        System.out.println("Enter the trick you would like to train: ");
        String trick = scanner.nextLine().toLowerCase();

        if (roboticShelter.containsPet(name)) {
            roboticShelter.getPet(name).train(trick);
        } else {
            organicShelter.getPet(name).train(trick);
        }
    }
}
