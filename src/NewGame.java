import java.util.Arrays;
import java.util.Scanner;

public class NewGame {
    private static Scanner input = new Scanner(System.in);

    public enum NewGameCharacterList {
        SAVARIC("Savaric"),
        BALDWIN("Baldwin"),
        YSORIA("Ysoria"),
        AURELIA("Aurelia"),
        OTTO("Otto"),
        CHLOE("Chloe"),
        THE_OUTCAST("The Outcast"),
        CUSTOM("Custom"),
        NONE("None");

        private final String formatCharacterName;

        NewGameCharacterList(String formatCharacterName) {
            this.formatCharacterName = formatCharacterName;
        }

        public String getDisplayCharacters() {
            return formatCharacterName;
        }
    }

    public static void newGameStart() {
        newGameIntroduction();
        characterSelectionMenu();
        getUserChoice();
    }

    private static void newGameIntroduction() {
        System.out.println("Welcome, adventurer... to Birthright. \nThe essence of Humanity lives in ambiguity. Decide your fate and create your legacy. ");
    }
    private static void characterSelectionMenu() {
        System.out.println("Please choose one of the Origin characters below. Or, create your own. \n");
        for (int i = 0; i < NewGameCharacterList.values().length - 1; i++) {
        NewGameCharacterList characters = NewGameCharacterList.values()[i];
            System.out.println(characters.ordinal() + 1 + ".) " + characters.formatCharacterName);
        }
    }

    public static void getUserChoice() {
        do {
            String userChoice = input.nextLine().trim();

            if (userChoice.matches("\\d")) {
                int integerChoice = Integer.parseInt(userChoice);
                if (integerChoice >= 1 && integerChoice <= NewGameCharacterList.values().length) {
                    characterSelectionSwitch(NewGameCharacterList.values()[integerChoice - 1]); //until input validation added
                    return;
                } else {
                    System.out.println("Invalid choice. Please enter a valid number. \n");
                }
            } else {
                try {
                    NewGameCharacterList selectedOption = NewGameCharacterList.valueOf(userChoice.toUpperCase().replace("-", "_").replace(" ", "_"));
                    characterSelectionSwitch(selectedOption);
                    return;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid choice. Please enter a valid choice. \n");
                }
            }
        } while (true);
    }

    public static Humanoid characterSelectionSwitch(NewGameCharacterList character) {
        String confirmationInput;
        do {
            switch (character) {
                case SAVARIC:
                    System.out.println("""
                            Savaric is a ruthless killer, concerned about one thing -- winning.
                            A former mercenary, Savaric has little concern for those less fortunate. They can be found around groups of suspicion and have connections to criminal networks, such as slaving and thievery.
                            Savaric prefers to handle situations directly, and prefers intimidation to diplomacy.
                            He can become consumed in a frenzy if a situation becomes dire.
                            """);
                    System.out.println("You chose Savaric, is that correct? 'Y'/[Enter] or 'N': \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                        OriginCharacters.savaric.displayCharacterInfo();
                        return OriginCharacters.savaric;
                    }
                    else character = NewGameCharacterList.NONE;
                    break;
                case BALDWIN:
                    System.out.println("Baldwin is a Paladin, known by the peasantry in the slums of Isgard.\nBaldwin is also a humble blacksmith, providing his community with armor and weapons to fight against the Abyss. \n");
                    System.out.println("You chose Baldwin, is that correct? 'Y'/[Enter] or 'N': \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                        OriginCharacters.createBaldwin();
                        OriginCharacters.baldwin.displayCharacterInfo();
                        return OriginCharacters.baldwin;
                    }
                    else character = NewGameCharacterList.NONE;
                    break;
                case YSORIA:
                    System.out.println("Ysoria is a deceitful witch that specializes in manipulation.\nShe finds pleasure in trickery, deceit, and surprise. Her home is well-kept, serviced by her thralls that fell for her false promises. \n");
                    System.out.println("You chose Ysoria, is that correct? 'Y'/[Enter] or 'N': \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                        OriginCharacters.createYsoria();
                        OriginCharacters.ysoria.displayCharacterInfo();
                        return OriginCharacters.ysoria;
                    }
                    else character = NewGameCharacterList.NONE;
                    break;
                case AURELIA:
                    System.out.println("Aurelia is a poor thief accustomed to survival by any means necessary... \nShe often retells stories of her youth, where pickpocketing and stealing food meant another day of life for herself. \n");
                    System.out.println("You chose Aurelia, is that correct? 'Y'/[Enter] or 'N': \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                        OriginCharacters.createAurelia();
                        OriginCharacters.aurelia.displayCharacterInfo();
                        return OriginCharacters.aurelia;
                    }
                    else character = NewGameCharacterList.NONE;
                    break;
                case OTTO:
                    System.out.println("Otto is the titular Bard of the Seventh Kingdom. \nOtto favors diplomacy, a good wine, and entertainment than violence. When possible, Otto will make friends in unexpected places. \n");
                    System.out.println("You chose Otto, is that correct? 'Y'/[Enter] or 'N': \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                        OriginCharacters.createOtto();
                        OriginCharacters.otto.displayCharacterInfo();
                        return OriginCharacters.otto;
                    }
                    else character = NewGameCharacterList.NONE;
                    break;
                case CHLOE:
                    System.out.println("Chloe is a noble Druid obsessed with solving the riddle of civilization.\nIf we were all meant to be, surely this world would have the means to support us? While curious, Chloe is hesitant to commit to anything that might yield bad fruit. \n");
                    System.out.println("You chose Chloe, is that correct? 'Y'/[Enter] or 'N': \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                        OriginCharacters.createChloe();
                        OriginCharacters.chloe.displayCharacterInfo();
                        return OriginCharacters.chloe;
                    }
                    else character = NewGameCharacterList.NONE;
                    break;
                case THE_OUTCAST:
                    System.out.println("The fringe of society is where you call home. You, among your caste, are the last to find relief. \n");
                    System.out.println("You chose The Outcast, is that correct? 'Y'/[Enter] or 'N': \n");
                    confirmationInput = input.nextLine().toUpperCase();
                    if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                        Humanoid theOutcast = new Humanoid();
                        theOutcast.createCharacter();
                        theOutcast.displayCharacterInfo();
                        return OriginCharacters.theOutcast;
                    }
                    else character = NewGameCharacterList.NONE;
                    break;
                case CUSTOM:
                    System.out.println("Creating character... \n");
                        Humanoid custom = new Humanoid();
                        custom.createCharacter();
                        custom.displayCharacterInfo();
                        return OriginCharacters.custom;
                default:
                    characterSelectionMenu();
                    getUserChoice();
            }
        } while (true);
    }
}

