import java.util.Scanner;
public class NewGame {
    private static Scanner input = new Scanner(System.in);

    private static void newGameIntroduction() {
        System.out.println("Welcome, adventurer... to the Forgotten Realms. An ancient evil has returned to Baldur's Gate, \n" +
                "intent on devouring it from the inside out. The fate of Faerûn lies in your hands. Alone, you may resist. \n" +
                "But together, you can overcome.\n");
    }
    private static void newGamePlayerCharacterList() {
        System.out.println("Please choose one of the Origin characters below. Or, create your own. \n");
        System.out.println("1.) Astarion\n" + "2.) Lae'zel\n" + "3.) Gale\n" + "4.) Shadowheart\n" + "5.) Wyll\n" +
                "6.) Karlach\n" + "7.) The Dark Urge\n" + "8.) I want to make my own character.\n");
    }
    private static String handleCharacterChoice(String characterName) {
        System.out.println("You chose " + characterName + ", is this correct? \n");
        String playerCharacterInputValidation = input.nextLine().toUpperCase();
        if (playerCharacterInputValidation.startsWith("Y") || playerCharacterInputValidation.isEmpty()) {
            return characterName;
        } else {
            return newCharacterPrompt(); // Recursive call to handle invalid input
        }
    }
    public static String newCharacterPrompt() {
        newGameIntroduction();
        newGamePlayerCharacterList();
        String confirmationInput;
        while (true) {
            String newCharacterPrompt = input.nextLine().toLowerCase();
            switch (newCharacterPrompt) {
                case "1":
                case "astarion":
                    System.out.println("Astarion was a young magistrate in Baldur's Gate, " +
                            "until one day he was assaulted and almost killed by a gang of Gurs. " +
                            "\nThe vampire lord, Cazador Szarr, who had taken interest in him, " +
                            "approached Astarion and turned him into one of his slaves – a vampire spawn. " +
                            "\nAstarion prowled the night as a vampire spawn for centuries, " +
                            "serving a sadistic master until he was snatched away. " +
                            "\nNow, he can walk in the light and has the chance at a new life, " +
                            "but how long can he keep his past buried...?\n");
                    return handleCharacterChoice("Astarion");
                case "2":
                case "lae'zel":
                    System.out.println("Lae'zel is a Githyanki Warrior from Crèche K'liir, a githyanki " +
                            "enclave on an asteroid near Selûne, the moon of Faerûn. \n" +
                            "Lae'zel is depicted as xenophobic, arrogant, and quick to anger. \n" + "Lae'zel dislikes " +
                            "acts of mercy and compassion, showing submission, or respect and diplomacy over force and domination. \n" +
                            "She is proud of her race, and frequently makes comments to the party detailing githyanki " +
                            "customs and the nature of her people. \n" +
                            "She is fiercely loyal to her queen Vlaakith.\n");
                    return handleCharacterChoice("Lae'zel");
                case "3":
                case "gale":
                    System.out.println("Gale is a magical prodigy – a wizard of great talent and incredible knowledge. \n" +
                            "Imbued with the devastating power of a Netherese orb, Gale must continually consume magical artefacts, \n" +
                            "lest he unleash that explosive force upon himself and his surroundings. \n" +
                            "Gale is an intelligent, thoughtful wizard, with a good-hearted and peaceful nature. " +
                            "He has a scholarly, slightly pompous speaking style. \n" +
                            "He speaks openly about himself when asked, describing himself as a \"wizard of some renown\" " +
                            "who enjoys good wine and ocasionally writing poetry. \n" +
                            "He frequently shares anecdotes from his youth or his career as a wizard.\n");
                    return handleCharacterChoice("Gale");
                case "4":
                case "shadowheart":
                    System.out.println("A devout follower of Shar, Shadowheart is the sole survivor of a holy mission" +
                            " undertaken on the Mistress of the Night's behest.\n" + "With raven black hair and attire, " +
                            "Shadowheart makes as strong of an impression as her personality.\n" +
                            "She dislikes those that disapprove of her worship or people pressing her for answers or details. \n" +
                            "She does not like needless cruelty or violence and can respond unfavorably to being " +
                            "too open with untrustworthy or unknown individuals. \n" +
                            "She loves animals and will always react favourably to positive interactions " +
                            "with them and negatively to cruelty towards animals. \n" +
                            "Zealously devoted, independent and headstrong, " +
                            "she prefers pragmatic solutions to issues, decisive action " +
                            "and staying uninvolved in the problems of others.\n");
                    return handleCharacterChoice("Shadowheart");
                case "5":
                case "wyll":
                    System.out.println("A valiant hero working in the frontiers of Baldur's Gate, " +
                            "Wyll fights injustice and hunts monsters wherever they may hide. \nThough bound " +
                            "in pact to an infernal fiend, he has dedicated his whole life to protecting the city " +
                            "he loves. \nWyll is heroic and kindhearted, dedicating most of his life to fighting " +
                            "on behalf of the people of the Sword Coast. \n" +
                            "He takes his duty and title seriously, and speaks boastfully of his skills " +
                            "and past as the Blade of Frontiers.\n");
                    return handleCharacterChoice("Wyll");
                case "6":
                case "karlach":
                    System.out.println("Once a soldier forced to fight in the fires of Avernus, now a woman on the brink of freedom. \n" +
                             "Karlach is an extremely passionate individual who strives to live life to the fullest. \n" +
                             "She tends to speak excitedly regarding any of life's simple pleasures, whether that" +
                             " be food, drink, friends, or intimacy. \nHer demeanor is generally joyous and very forward, " +
                             "having no fear of loudly proclaiming her love of being alive and how much she cares for those close to her. \n" +
                             "Her positive disposition and infectious energy seem to allow her to make friends easily. \n" +
                            "With a malfunctioning engine for a heart, Karlach is burning with desire to live. \n" +
                            "Will she be able to save herself, or will hell catch up with her sooner or later? \n");
                    return handleCharacterChoice("Karlach");
                case "7":
                case "the dark urge":
                    System.out.println("My rancid blood whispers to me: kill, kill, and kill again. \n" +
                            "My ruined body yearns to reap death in this world, and when this foul Urge calls, " +
                            "it possesses my whole being. \nInjured beyond repair, I know nothing besides this; \n" +
                            "I must resist this Dark Urge, lest it consume my mind. I must discover what happened to me, \n" +
                            "and who I was. Before my twitching knife-hand writes a tragedy in blood. \n");
                    System.out.println("You chose The Dark Urge, is this correct? \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if (confirmationInput.startsWith("Y") || confirmationInput.isEmpty()) {
                        BattleUnit newCharacter = new BattleUnit();
                        newCharacter.createCharacter();
                        return "The Dark Urge";
                    } else {
                        return newCharacterPrompt();
                    }
                case "8":
                case "own":
                case "custom":
                    System.out.println("You want to make your own character, is this correct? \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if (confirmationInput.startsWith("Y") || confirmationInput.isEmpty()) {
                        BattleUnit newCharacter = new BattleUnit();
                        newCharacter.createCharacter();
                        return "Custom";
                    } else {
                        return newCharacterPrompt();
                    }
                default:
                    System.out.println("Invalid choice. Please select a valid option.\n");
                    newCharacterPrompt();
            }
        }
//    public static String newCharacterPrompt() { //BEGIN newCharacterPrompt
//
//        String playerCharacter = "";
//        newGamePlayerCharacterList();
//        String playerCharacterInputValidation = "";
//
//        while (true) {
//            String newCharacterPrompt = input.nextLine().toLowerCase();
//            switch (newCharacterPrompt) { //BEGIN SWITCH
//                case "1":
//                case "astarion":
//                    System.out.println("You chose Astarion, is this correct?\n");
//                    playerCharacterInputValidation = input.nextLine().toUpperCase();
//                    if (playerCharacterInputValidation.startsWith("Y") || playerCharacterInputValidation.isEmpty()) {
//                        return playerCharacter = "astarion";
//                    } else {
//                        newCharacterPrompt();
//                    }
//                    break;
//                case "2":
//                case "lae'zel":
//                    System.out.println("You chose Lae'zel, is this correct?\n");
//                    playerCharacterInputValidation = input.nextLine().toUpperCase();
//                    if (playerCharacterInputValidation.startsWith("Y") || playerCharacterInputValidation.isEmpty()) {
//                        return playerCharacter = "lae'zel";
//                    } else {
//                        newCharacterPrompt();
//                    }
//                    break;
//                case "3":
//                case "gale":
//                    System.out.println("You chose Gale, is this correct?\n");
//                    playerCharacterInputValidation = input.nextLine().toUpperCase();
//                    if (playerCharacterInputValidation.startsWith("Y") || playerCharacterInputValidation.isEmpty()) {
//                        return playerCharacter = "gale";
//                    } else {
//                        newCharacterPrompt();
//                    }
//                    break;
//                case "4":
//                case "shadowheart":
//                    System.out.println("You chose Shadowheart, is this correct?\n");
//                    playerCharacterInputValidation = input.nextLine().toUpperCase();
//                    if (playerCharacterInputValidation.startsWith("Y") || playerCharacterInputValidation.isEmpty()) {
//                        return playerCharacter = "shadowheart";
//                    } else {
//                        newCharacterPrompt();
//                    }
//                    break;
//                case "5":
//                case "wyll":
//                    System.out.println("You chose Wyll, is this correct?\n");
//                    playerCharacterInputValidation = input.nextLine().toUpperCase();
//                    if (playerCharacterInputValidation.startsWith("Y") || playerCharacterInputValidation.isEmpty()) {
//                        return playerCharacter = "wyll";
//                    } else {
//                        newCharacterPrompt();
//                    }
//                    break;
//                case "6":
//                case "karlach":
//                    System.out.println("You chose Karlach, is this correct?\n");
//                    playerCharacterInputValidation = input.nextLine().toUpperCase();
//                    if (playerCharacterInputValidation.startsWith("Y") || playerCharacterInputValidation.isEmpty()) {
//                        return playerCharacter = "karlach";
//                    } else {
//                        newCharacterPrompt();
//                    }
//                    break;
//                case "7":
//                case "the dark urge":
//                    System.out.println("You chose The Dark Urge, is this correct?\n");
//                    playerCharacterInputValidation = input.nextLine().toUpperCase();
//                    if (playerCharacterInputValidation.startsWith("Y") || playerCharacterInputValidation.isEmpty()) {
//                        return playerCharacter = "the dark urge";
//                    } else {
//                        newCharacterPrompt();
//                    }
//                    break;
//                case "8":
//                case "own":
//                case "custom":
//                    System.out.println("You want to make your own character, is this correct?\n");
//                    playerCharacterInputValidation = input.nextLine().toUpperCase();
//                    if (playerCharacterInputValidation.startsWith("Y") || playerCharacterInputValidation.isEmpty()) {
//                        PlayerCharacter.createPlayerCharacter();
//                        return playerCharacter = "custom";
//                    } else {
//                        newCharacterPrompt();
//                    }
//                    break;
//                default:
//                     System.out.println("Invalid choice. Please select a valid option.\n");
//                        continue;
//                    } //END SWITCH
//                    break;
//            } //END WHILE
//            return playerCharacter;
        }
    }
