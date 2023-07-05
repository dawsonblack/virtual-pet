package org.wcci.virtualpet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrganicShelter organicShelter = new OrganicShelter();
        RoboticShelter roboticShelter = new RoboticShelter();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Hello! ");
        UI.promptAddPet(scanner, organicShelter, roboticShelter);

        String nextTask = "";
        while (!nextTask.equals("quit")) {
            System.out.println("What would you like to do next?");
            nextTask = scanner.nextLine();

            switch (nextTask) {
                case "add pet":
                    UI.promptAddPet(scanner, organicShelter, roboticShelter);
                    break;
                case "check hunger":
                case "check starvation":
                case "check overfeeding":
                case "check thirst":
                case "check dehydration":
                case "check overwatering":
                case "check tiredness":
                case "check low oil":
                case "check no oil":
                case "check overoiling":
                case "check low charge":
                case "check no charge":
                case "check overcharged":
                case "check age":
                    UI.promptPetStatus(scanner, organicShelter, roboticShelter, nextTask);
                    break;
                case "feed":
                case "water":
                case "oil":
                case "charge":
                    UI.promptFoodWaterOilCharge(scanner, organicShelter, roboticShelter, nextTask);
                    break;
                case "check chance of trick":
                    UI.promptChanceOfTrick(scanner, organicShelter, roboticShelter);
                case "train":
                    UI.promptTrain(scanner, organicShelter, roboticShelter);
            }
        }
        scanner.close();


    }
}
