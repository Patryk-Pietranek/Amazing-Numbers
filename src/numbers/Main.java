package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<String> propertiesList;

    public static void main(String[] args) {
        printStartingInfo();
        String[] properties = {"EVEN", "ODD", "BUZZ", "DUCK", "PALINDROMIC", "GAPFUL", "SPY", "SQUARE", "SUNNY", "JUMPING", "HAPPY", "SAD",
                "-EVEN", "-ODD", "-BUZZ", "-DUCK", "-PALINDROMIC", "-GAPFUL", "-SPY", "-SQUARE", "-SUNNY", "-JUMPING", "-HAPPY", "-SAD"};
        propertiesList = Arrays.asList(properties);
        do {
            System.out.println("Enter a request:");
            String input = scanner.nextLine();
            String[] inputArray = input.split(" ");
            long number = Long.parseLong(inputArray[0]);
            int consecutive = 0;
            boolean next = false;
            NumbersController numbersController = new NumbersController();
            numbersController.setNumber(number);
            if (inputArray.length == 2) {
                consecutive = Integer.parseInt(inputArray[1]);
                numbersController.setConsecutive(consecutive);
            } else if (inputArray.length > 2) {
                consecutive = Integer.parseInt(inputArray[1]);
                numbersController.setConsecutive(consecutive);
                List<String> userProperties = new ArrayList<>(Arrays.asList(inputArray).subList(2, inputArray.length));
                List<String> wrongProperties = new ArrayList<>();
                numbersController.setUserProperties(userProperties);
                next = checkInput(userProperties, wrongProperties);
            }
            if (next) {
                continue;
            }
            if (number < 0) {
                continue;
            }
            if (!numbersController.getExit()) {
                numbersController.start();
            } else {
                break;
            }
        } while (true);

    }

    private static void printStartingInfo() {
        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("* the first parameter represents a starting number;");
        System.out.println("* the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and a properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }

    private static boolean checkInput(List<String> userProperties, List<String> wrongProperties) {
        int wrongPropCounter = 0;
        for (int i = 0; i < userProperties.size(); i++) {
            if (!propertiesList.contains(userProperties.get(i).toUpperCase())) {
                wrongPropCounter++;
                wrongProperties.add(userProperties.get(i));
            }
        }
        if (wrongPropCounter == 1) {
            System.out.println("The property [" + wrongProperties.get(0) + "] is wrong.\n" +
                    "Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            return true;
        } else if (wrongPropCounter > 1) {
            System.out.print("The properties [");
            for (int i = 0; i < wrongProperties.size(); i++) {
                if (i != wrongProperties.size() - 1) {
                    System.out.print(wrongProperties.get(i) + ", ");
                }
            }
            System.out.println("] are wrong");
            System.out.println("Available properties:\n" +
                    "[EVEN, ODD, BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            return true;
        }
        boolean exit = false;
        for (int i = 0; i < userProperties.size(); i++) {
            exit = false;
            for (int j = 0; j < userProperties.size(); j++) {
                if (userProperties.get(i).contains(userProperties.get(j)) && i != j && (userProperties.get(i).contains("-") || userProperties.get(j).contains("-"))) {
                    System.out.println("The request contains mutually exclusive properties: [" + userProperties.get(i).toUpperCase() + ", " + userProperties.get(j).toUpperCase() + "]\n" +
                            "There are no numbers with these properties.");
                    exit = true;
                    break;
                }
            }
            if (exit) {
                break;
            }
        }
        if (exit) {
            exit = false;
            return true;
        }
        if (userProperties.contains("even") && userProperties.contains("odd")) {
            System.out.println("The request contains mutually exclusive properties: [EVEN, ODD]\n" +
                    "There are no numbers with these properties.");
            return true;
        }
        if (userProperties.contains("-even") && userProperties.contains("-odd")) {
            System.out.println("The request contains mutually exclusive properties: [-EVEN, -ODD]\n" +
                    "There are no numbers with these properties.");
            return true;
        }
        if (userProperties.contains("duck") && userProperties.contains("spy")) {
            System.out.println("The request contains mutually exclusive properties: [DUCK, SPY]\n" +
                    "There are no numbers with these properties.");
            return true;
        }
        if (userProperties.contains("-duck") && userProperties.contains("-spy")) {
            System.out.println("The request contains mutually exclusive properties: [-DUCK, -SPY]\n" +
                    "There are no numbers with these properties.");
            return true;
        }
        if (userProperties.contains("sunny") && userProperties.contains("square")) {
            System.out.println("The request contains mutually exclusive properties: [SUNNY, SQUARE]\n" +
                    "There are no numbers with these properties.");
            return true;
        }
        if (userProperties.contains("happy") && userProperties.contains("sad")) {
            System.out.println("The request contains mutually exclusive properties: [HAPPY, SAD]\n" +
                    "There are no numbers with these properties.");
            return true;
        }
        if (userProperties.contains("-happy") && userProperties.contains("-sad")) {
            System.out.println("The request contains mutually exclusive properties: [-HAPPY, -SAD]\n" +
                    "There are no numbers with these properties.");
            return true;
        }
        return false;
    }
}

