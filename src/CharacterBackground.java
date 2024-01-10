import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CharacterBackground {
    private CharacterBackgroundsEnum characterBackground;
    private final Scanner input = new Scanner(System.in);

    public CharacterBackground(CharacterBackgroundsEnum characterBackground) {this.characterBackground = characterBackground; }
public CharacterBackground() {

}
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
        private final String displayBackgroundEnum;

        CharacterBackgroundsEnum(String displayBackground) { this.displayBackgroundEnum = displayBackground; }
        public String getDisplayBackground() { return displayBackgroundEnum; }
    }

    public CharacterBackgroundsEnum getCharacterBackground() { return characterBackground; }

    public void setCharacterBackground(CharacterBackgroundsEnum background) {this.characterBackground = background; }

    public void setCharacterBackground() {
        characterBackground = null;
        do {
            System.out.println("Choose your background: \n");
            for (CharacterBackground.CharacterBackgroundsEnum background : CharacterBackground.CharacterBackgroundsEnum.values()) {
                System.out.println(background.ordinal() + 1 + ".) " + background.displayBackgroundEnum);
            }
            String userInput = input.nextLine().trim();
            if (userInput.matches("\\d+")) {
                int userChoice = Integer.parseInt(userInput);
                if (userChoice >= 1 && userChoice <= CharacterBackground.CharacterBackgroundsEnum.values().length) {
                    characterBackground = (CharacterBackground.CharacterBackgroundsEnum.values()[userChoice - 1]);
                    return; //until input validation added
                } else {
                    System.out.println("Invalid choice. Please enter a valid number. \n");
                    continue;
                }
            } else {
                try {
                    characterBackground = (CharacterBackground.CharacterBackgroundsEnum.valueOf(userInput.toUpperCase().replace("-", "_").replace(" ", "_")));
                    return; //until input validation added
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid class. Please enter a valid class. \n");
//                    continue;
                }
            }
        } while (true);
    }
    public static CharacterBackground fromEnum(CharacterBackground.CharacterBackgroundsEnum characterBackgroundsEnum) {
        return switch (characterBackgroundsEnum) {
            case ACOLYTE, CHARLATAN, CRIMINAL,
             ENTERTAINER, FOLK_HERO, GUILD_ARTISAN,
             NOBLE, OUTLANDER, SAGE,
             SOLDIER, URCHIN -> {
                CharacterBackground background = new CharacterBackground();
                background.setCharacterBackground(characterBackgroundsEnum);
                yield background;
            }
            default -> throw new IllegalArgumentException("Unsupported CharacterBackgroundsEnum: " + characterBackgroundsEnum);
        };
    }
}
