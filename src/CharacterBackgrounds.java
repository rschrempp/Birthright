import java.util.Scanner;
public class CharacterBackgrounds {
    private static CharacterBackgroundsEnum characterBackground;
    private static final Scanner input = new Scanner(System.in);
    public enum CharacterBackgroundsEnum {
        ACOLYTE("Acolyte"),
        CHARLATAN("Charlatan"),
        CRIMINAL("Criminal"),
        ENTERTAINER("Entertainer"),
        FOLK_HERO("Folk Hero"),
        GUILD_ARTISAN("Guild Artisan"),
        NOBLE("Noble"),
        OUTLANDER("Outlander"),
        SAGE("Sage"),
        SOLDIER("Soldier"),
        URCHIN("Urchin");

        private final String displayBackground;

        CharacterBackgroundsEnum(String displayBackground) {
            this.displayBackground = displayBackground;
        }
        public String getDisplayBackground() {
            return displayBackground;
        }
    }
    public static CharacterBackgroundsEnum getCharacterBackground() {
        setCharacterBackground();
        return characterBackground;
    }
    private static void setCharacterBackground() {
        do {
            System.out.println("Choose your background: \n");
            for (CharacterBackgroundsEnum background : CharacterBackgroundsEnum.values()) {
                System.out.println(background.ordinal() + 1 + ".) " + background.displayBackground);
            }
            String userInput = input.nextLine().trim();
            if (userInput.matches("\\d+")) {
                int userChoice = Integer.parseInt(userInput);
                if (userChoice >= 1 && userChoice <= CharacterBackgroundsEnum.values().length) {
                    characterBackground = CharacterBackgroundsEnum.values()[userChoice - 1];
                } else {
                    System.out.println("Invalid choice. Please enter a valid number. \n");
                    continue;
                }
            } else {
                try {
                    characterBackground = CharacterBackgroundsEnum.valueOf(userInput.toUpperCase().replace("-", "_").replace(" ", "_"));
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid background. Please enter a valid background. \n");
                    continue;
                }
            }
            if (characterBackground != null) {
                System.out.println("You selected " + characterBackground.displayBackground + ", is that correct? 'Y'/[Enter] or 'N': \n");

                String confirmationInput = input.nextLine().toUpperCase();
                if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                    return;
                } else {
                    characterBackground = null;
                }
            }
        } while (true);
    }
}
