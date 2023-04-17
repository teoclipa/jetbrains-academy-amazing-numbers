package numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        System.out.println("""
                Welcome to Amazing Numbers!
                                    
                Supported requests:
                  - enter a natural number to know its properties;
                  - enter two natural numbers to obtain the properties of the list:
                    * the first parameter represents a starting number;
                    * the second parameter shows how many consecutive numbers are to be printed;
                  - two natural numbers and properties to search for;
                  - a property preceded by minus must not be present in numbers;
                  - separate the parameters with one space;
                  - enter 0 to exit.
                      """);

        while (true) {
            System.out.println("Enter a request:");
            ArrayList<String> request = new ArrayList<>(Arrays.asList(scanner.nextLine().trim().split(" ")));
            if (request.size() == 1) {
                long number = Long.parseLong(request.get(0));
                if (number == 0) {
                    System.out.println("Goodbye");
                    break;
                }
                if (!(number > 0)) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    continue;
                }
                singleNumberRequest(number);
            }

            if (request.size() == 2) {
                long number = Long.parseLong(request.get(0));
                long consecutiveNumbers = Long.parseLong(request.get(1));

                if (!(number > 0)) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    continue;
                }

                if (!(consecutiveNumbers > 0)) {
                    System.out.println("The second parameter should be a natural number.");
                    continue;
                }
                twoNumbersRequest(number, consecutiveNumbers);
            }
            if (request.size() == 3) {
                long startNumber = Long.parseLong(request.get(0));
                long numbersCount = Long.parseLong(request.get(1));
                String property = request.get(2);

                if (!(startNumber > 0)) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    continue;
                }

                if (!(numbersCount > 0)) {
                    System.out.println("The second parameter should be a natural number.");
                    continue;
                }
                boolean isNegative = false;
                String newProperty = property;
                if (property.contains("-")) {
                    isNegative = true;
                    newProperty = property.substring(1);
                }
                boolean isProperty = false;
                for (Properties prop : Properties.values()) {
                    if (newProperty.equalsIgnoreCase(prop.name())) {
                        isProperty = true;
                        break;
                    }
                }
                if (!isProperty) {
                    System.out.println("The property [" + property + "] is wrong.");
                    System.out.println("Available properties: " + Arrays.toString(Properties.values()));
                    continue;
                }
                searchSinglePropertyRequest(startNumber, numbersCount, newProperty, isNegative);
            }

            if (request.size() > 3) {
                long startNumber = Long.parseLong(request.get(0));
                long numbersCount = Long.parseLong(request.get(1));
                ArrayList<String> propertiesList = request.subList(2, request.size()).stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));
                HashMap<String, Boolean> propertiesWithState = new HashMap<>();

                for (String prop : propertiesList) {
                    if (prop.contains("-")) {
                        propertiesWithState.put(prop.substring(1), false);
                    } else {
                        propertiesWithState.put(prop, true);
                    }
                }


                if (!(startNumber > 0)) {
                    System.out.println("The first parameter should be a natural number or zero.");
                    continue;
                }

                if (!(numbersCount > 0)) {
                    System.out.println("The second parameter should be a natural number.");
                    continue;
                }

                if ((propertiesList.contains("ODD") && propertiesList.contains("EVEN"))) {
                    System.out.println("The request contains mutually exclusive properties: ");
                    System.out.println("[ODD, EVEN]");
                    System.out.println("There are no numbers with these properties.");
                    continue;
                } else if ((propertiesList.contains("-ODD") && propertiesList.contains("-EVEN"))) {
                    System.out.println("The request contains mutually exclusive properties: ");
                    System.out.println("[-ODD, -EVEN]");
                    System.out.println("There are no numbers with these properties.");
                    continue;
                } else if ((propertiesList.contains("DUCK") && propertiesList.contains("SPY"))) {
                    System.out.println("The request contains mutually exclusive properties: ");
                    System.out.println("[DUCK, SPY]");
                    System.out.println("There are no numbers with these properties.");
                    continue;
                } else if ((propertiesList.contains("-DUCK") && propertiesList.contains("-SPY"))) {
                    System.out.println("The request contains mutually exclusive properties: ");
                    System.out.println("[-DUCK, -SPY]");
                    System.out.println("There are no numbers with these properties.");
                    continue;
                } else if ((propertiesList.contains("SUNNY") && propertiesList.contains("SQUARE"))) {
                    System.out.println("The request contains mutually exclusive properties: ");
                    System.out.println("[SUNNY, SQUARE]");
                    System.out.println("There are no numbers with these properties.");
                    continue;
                } else if ((propertiesList.contains("-SUNNY") && propertiesList.contains("-SQUARE"))) {
                    System.out.println("The request contains mutually exclusive properties: ");
                    System.out.println("[-SUNNY, -SQUARE]");
                    System.out.println("There are no numbers with these properties.");
                    continue;
                } else if ((propertiesList.contains("SAD") && propertiesList.contains("HAPPY"))) {
                    System.out.println("The request contains mutually exclusive properties: ");
                    System.out.println("[HAPPY, SAD]");
                    System.out.println("There are no numbers with these properties.");
                    continue;
                } else if ((propertiesList.contains("-SAD") && propertiesList.contains("-HAPPY"))) {
                    System.out.println("The request contains mutually exclusive properties: ");
                    System.out.println("[-HAPPY, -SAD]");
                    System.out.println("There are no numbers with these properties.");
                    continue;
                }

                boolean isMutual = false;
                for (String s : propertiesList) {
                    if (s.contains("-")) {
                        String opposite = s.substring(1);
                        if (propertiesList.contains(opposite)) {
                            System.out.println("The request contains mutually exclusive properties: ");
                            System.out.printf("[%s, %s]\n", s, opposite);
                            System.out.println("There are no numbers with these properties.");
                            isMutual = true;
                            break;
                        }

                    }
                }
                if (isMutual) {
                    continue;
                }

                ArrayList<String> errorProperties = new ArrayList<>(propertiesWithState.keySet());

                for (Properties property : Properties.values()) {
                    errorProperties.remove(property.name());
                }

                if (errorProperties.size() == 1) {
                    System.out.println("The property " + errorProperties + " is wrong.");
                    System.out.println("Available properties: " + Arrays.toString(Properties.values()));
                    continue;
                } else if (errorProperties.size() != 0) {
                    System.out.println("The properties " + errorProperties + " are wrong.");
                    System.out.println("Available properties: " + Arrays.toString(Properties.values()));
                    continue;
                }
                searchMultiplePropertiesRequest(startNumber, numbersCount, propertiesWithState);
            }
        }

    }


    public static void checkAllNumberProperties(long number) {
        ParityNumber.checkParity(number);
        BuzzNumber.checkBuzz(number);
        DuckNumber.checkDuck(number);
        PalindromicNumber.checkPalindrome(number);
        GapfulNumber.checkGapful(number);
        SpyNumber.checkSpy(number);
        SquareNumber.checkSquare(number);
        SunnyNumber.checkSunny(number);
        JumpingNumber.checkJumping(number);
        HappyNumber.checkHappy(number);
        SadNumber.checkSad(number);
    }

    public static void singleNumberRequest(long number) {
        System.out.println("Properties of " + number);

        checkAllNumberProperties(number);

        for (Properties property : Properties.values()) {
            printProperty(property);
        }
        Properties.resetProperties();
    }

    public static void printProperty(Properties property) {
        System.out.println(property.name() + ": " + property.hasProperty);
    }


    public static void twoNumbersRequest(long number, long consecutiveNumbers) {

        for (int i = 0; i < consecutiveNumbers; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(number).append(" is ");
            checkAllNumberProperties(number);
            for (Properties property : Properties.values()) {
                if (property.hasProperty) {
                    sb.append(property).append(", ");
                }
            }
            if (sb.toString().endsWith(", ")) {
                sb.delete(sb.length() - 2, sb.length());
            }
            System.out.println(sb);
            number++;
            Properties.resetProperties();
        }
    }

    public static void searchSinglePropertyRequest(long startNumber, long numbersCount, String property, boolean isNegative) {

        int countNumbersFound = 0;
        // initialize the start point
        while (countNumbersFound != numbersCount) {
            StringBuilder sb = new StringBuilder();

            checkAllNumberProperties(startNumber);
            if (!isNegative) {
                if (Properties.valueOf(property.toUpperCase()).hasProperty) {
                    sb.append(startNumber).append(" is ");
                    for (Properties prop : Properties.values()) {
                        if (prop.hasProperty) {
                            sb.append(prop).append(", ");
                        }
                    }
                    if (sb.toString().endsWith(", ")) {
                        sb.delete(sb.length() - 2, sb.length());
                    }
                    System.out.println(sb);
                    countNumbersFound++;

                }
                startNumber++;

                Properties.resetProperties();
            } else {
                if (!Properties.valueOf(property.toUpperCase()).hasProperty) {
                    sb.append(startNumber).append(" is ");
                    for (Properties prop : Properties.values()) {
                        if (prop.hasProperty) {
                            sb.append(prop).append(", ");
                        }
                    }
                    if (sb.toString().endsWith(", ")) {
                        sb.delete(sb.length() - 2, sb.length());
                    }
                    System.out.println(sb);
                    countNumbersFound++;

                }
                startNumber++;

                Properties.resetProperties();
            }
        }

    }

    public static void searchMultiplePropertiesRequest(long startNumber, long numbersCount, HashMap<String, Boolean> propertiesWithState) {

        int countNumbersFound = 0;
        // initialize the start point
        while (countNumbersFound != numbersCount) {
            StringBuilder sb = new StringBuilder();
            checkAllNumberProperties(startNumber);

            int countProperties = 0;
            for (String property : propertiesWithState.keySet()) {
                boolean state = propertiesWithState.get(property);
                if (!state) {
                    if (!Properties.valueOf(property).hasProperty) {
                        countProperties++;
                    }
                } else {
                    if (Properties.valueOf(property).hasProperty) {
                        countProperties++;
                    }
                }
                if (countProperties == propertiesWithState.size()) {
                    sb.append(startNumber).append(" is ");
                    for (Properties prop : Properties.values()) {
                        if (prop.hasProperty) {
                            sb.append(prop).append(", ");
                        }
                    }

                    if (sb.toString().endsWith(", ")) {
                        sb.delete(sb.length() - 2, sb.length());
                    }
                    System.out.println(sb);
                    countNumbersFound++;
                }
            }
            startNumber++;
            Properties.resetProperties();
        }
    }
}