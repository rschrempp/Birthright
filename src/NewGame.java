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
        CUSTOM("Custom");

        private final String displayCharacters;

        NewGameCharacterList(String displayCharacters) {
            this.displayCharacters = displayCharacters;
        }

        public String getDisplayCharacters() {
            return displayCharacters;
        }
    }
    public static void newGameStart() {
        newGameIntroduction();
        getUserChoice();
    }

    private static void newGameIntroduction() {
        System.out.println("Welcome, adventurer... to Birthright. \nThe essence of Humanity lives in ambiguity. Decide your fate and create your legacy. ");
        System.out.println("Please choose one of the Origin characters below. Or, create your own. \n");
        for (NewGameCharacterList character : NewGameCharacterList.values()) {
            System.out.println(character.ordinal() + 1 + ".) " + character.displayCharacters);
        }
    }

    public static void getUserChoice() {
        do {
            String userChoice = input.nextLine().trim();

            if (userChoice.matches("\\d")) {
                int integerChoice = Integer.parseInt(userChoice);
                if (integerChoice >= 1 && integerChoice <= NewGameCharacterList.values().length) {
                    choiceFromEnum(NewGameCharacterList.values()[integerChoice - 1]); //until input validation added
                    return;
                } else {
                    System.out.println("Invalid choice. Please enter a valid number. \n");
                }
            } else {
                try {
                    NewGameCharacterList selectedOption = NewGameCharacterList.valueOf(userChoice.toUpperCase().replace("-", "_").replace(" ", "_"));
                    choiceFromEnum(selectedOption);
                    return;
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid choice. Please enter a valid choice. \n");
                }
            }
        } while (true);
    }

    public static void choiceFromEnum(NewGameCharacterList userChoice) {
        switch (userChoice) {
            case SAVARIC:
                System.out.println("Savaric is a brutal savage, known only by their savagery and taste for profit...\n" +
                        "A former mercenary, Savaric's only concern is their own benefit. " +
                        "Savaric prefers to handle situations directly, and has little patience for diplomacy.\n");
                OriginCharacters.createSavaric();
                OriginCharacters.savaric.displayCharacterInfo();
                return;
            case BALDWIN:
                System.out.println("Baldwin is a Paladin, known by the peasantry in the slums of Isgard.\nBaldwin is also a humble blacksmith, providing his community with armor and weapons to fight against the Abyss. \n");
                OriginCharacters.createBaldwin();
                OriginCharacters.baldwin.displayCharacterInfo();
                return;
            case YSORIA:
                System.out.println("Ysoria is a deceitful witch that specializes in manipulation.\nShe finds pleasure in trickery, deceit, and surprise. Her home is well-kept, serviced by her thralls that fell for her false promises. \n");
                OriginCharacters.createYsoria();
                OriginCharacters.ysoria.displayCharacterInfo();
                return;
            case AURELIA:
                System.out.println("Aurelia is a poor thief accustomed to survival by any means necessary... \nShe often retells stories of her youth, where pickpocketing and stealing food meant another day of life for herself. \n");
                OriginCharacters.createAurelia();
                OriginCharacters.aurelia.displayCharacterInfo();
                return;
            case OTTO:
                System.out.println("Otto is the titular Bard of the Seventh Kingdom. \nOtto favors diplomacy, a good wine, and entertainment than violence. When possible, Otto will make friends in unexpected places. \n");
                OriginCharacters.createOtto();
                OriginCharacters.otto.displayCharacterInfo();
                return;
            case CHLOE:
                System.out.println("Chloe is a noble Druid obsessed with solving the riddle of civilization.\nIf we were all meant to be, surely this world would have the means to support us? While curious, Chloe is hesitant to commit to anything that might yield bad fruit. \n");
                OriginCharacters.createChloe();
                OriginCharacters.chloe.displayCharacterInfo();
                return;
            case THE_OUTCAST:
                System.out.println("The fringe of society is where you call home. You, among your caste, are the last to find relief. \n");
                Humanoid theOutcast = new Humanoid();
                theOutcast.createCharacter();
                theOutcast.displayCharacterInfo();
                return;
            case CUSTOM:
                System.out.println("This is a placeholder statement. Custom chosen...");
                Humanoid baba = new Humanoid();
                baba.createCharacter();
                baba.displayCharacterInfo();
                return;
            default:
                System.out.println("Invalid option");
        }
    }
}
