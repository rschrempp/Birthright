import java.util.Scanner;
public class NewGame {
    static Scanner input = new Scanner(System.in);

    public static void newGameIntroduction() {
        System.out.println("Welcome, adventurer... to the Forgotten Realms. An ancient evil has returned to Baldur's Gate, \n" +
                "intent on devouring it from the inside out. The fate of Faerûn lies in your hands. Alone, you may resist. \n" +
                "But together, you can overcome.\n");
    }

    public static void newGamePlayerCharacterList() {
        System.out.println("Please choose one of the Origin characters below. Or, create your own. \n");
        System.out.println("1. Astarion\n" + "2. Lae'zel\n" + "3. Gale\n" + "4. Shadowheart\n" + "5. Wyll\n" +
                "6. Karlach\n" + "7. The Dark Urge\n" + "8. I want to make my own character.\n");
    }

    public static String newCharacterPrompt() { //BEGIN newCharacterPrompt

        String userInput = "";
        newGamePlayerCharacterList();
        String confirmationInput = "";

        while (true) {
            String newCharacterPrompt = input.nextLine().toLowerCase();
            switch (newCharacterPrompt) { //BEGIN SWITCH
                case "1":
                case "astarion":
                    System.out.println("You chose Astarion, is this correct? 'Y' or 'N': \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if (confirmationInput.startsWith("Y")) {
                        return userInput = "astarion";
                    } else {
                        newCharacterPrompt();
                    }
                    break;
                case "2":
                case "lae'zel":
                    System.out.println("You chose Lae'zel, is this correct? 'Y' or 'N': \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if (confirmationInput.startsWith("Y")) {
                        return userInput = "lae'zel";
                    } else {
                        newCharacterPrompt();
                    }
                    break;
                case "3":
                case "gale":
                    System.out.println("You chose Gale, is this correct? 'Y' or 'N': \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if (confirmationInput.startsWith("Y")) {
                        return userInput = "gale";
                    } else {
                        newCharacterPrompt();
                    }
                    break;
                case "4":
                case "shadowheart":
                    System.out.println("You chose Shadowheart, is this correct? 'Y' or 'N': \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if (confirmationInput.startsWith("Y")) {
                        return userInput = "shadowheart";
                    } else {
                        newCharacterPrompt();
                    }
                    break;
                case "5":
                case "wyll":
                    System.out.println("You chose Wyll, is this correct? 'Y' or 'N': \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if (confirmationInput.startsWith("Y")) {
                        return userInput = "wyll";
                    } else {
                        newCharacterPrompt();
                    }
                    break;
                case "6":
                case "karlach":
                    System.out.println("You chose Karlach, is this correct? 'Y' or 'N': \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if (confirmationInput.startsWith("Y")) {
                        return userInput = "karlach";
                    } else {
                        newCharacterPrompt();
                    }
                    break;
                case "7":
                case "the dark urge":
                    System.out.println("You chose The Dark Urge, is this correct? 'Y' or 'N': \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if (confirmationInput.startsWith("Y")) {
                        return userInput = "the dark urge";
                    } else {
                        newCharacterPrompt();
                    }
                    break;
                case "8":
                case "own":
                case "custom":
                    System.out.println("You want to make your own character, is this correct? 'Y' or 'N': \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if (confirmationInput.startsWith("Y")) {
                        PlayerCharacter.createPlayerCharacter();
                        return userInput = "custom";
                    } else {
                        newCharacterPrompt();
                    }
                    break;
                default:
                     System.out.println("Invalid choice. Please select a valid option.\n");
                        continue;
                    } //END SWITCH
                    break;
            } //END WHILE
            return userInput;
        }
    }
