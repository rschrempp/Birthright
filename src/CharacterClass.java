import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class CharacterClass {
    private CharacterClassesEnum characterClass;
    private final Scanner input = new Scanner(System.in);

    public CharacterClass(CharacterClassesEnum characterClass) {this.characterClass = characterClass; }
    public CharacterClass() {

    }
    public enum CharacterClassesEnum {
        BARBARIAN("Barbarian"),
        BARD("Bard"),
        PRIEST("Priest"),
        DRUID("Druid"),
        KNIGHT("Knight"),
        MONK("Monk"),
        PALADIN("Paladin"),
        HUNTER("Hunter"),
        ROGUE("Rogue"),
        SORCERER("Sorcerer"),
        WARLOCK("Warlock"),
        WIZARD("Wizard");

        private final String displayClassEnum;
        CharacterClassesEnum(String displayClass) {
            this.displayClassEnum = displayClass;
        }
        public String getDisplayClass() { return displayClassEnum; }
    }
    public CharacterClassesEnum getCharacterClass() { return characterClass; }
    public void setCharacterClass(CharacterClassesEnum charClass) { this.characterClass = charClass; }
    public void setCharacterClass() {
        characterClass = null;
        do {
            System.out.println("Choose your class: \n");
            for (CharacterClass.CharacterClassesEnum charClass : CharacterClass.CharacterClassesEnum.values()) {
                System.out.println(charClass.ordinal() + 1 + ".) " + charClass.displayClassEnum);
            }
            String userInput = input.nextLine().trim();
            if (userInput.matches("\\d+")) {
                int userChoice = Integer.parseInt(userInput);
                if (userChoice >= 1 && userChoice <= CharacterClass.CharacterClassesEnum.values().length) {
                    characterClass = (CharacterClass.CharacterClassesEnum.values()[userChoice - 1]);
                    return; //until input validation added
                } else {
                    System.out.println("Invalid choice. Please enter a valid number. \n");
                    continue;
                }
            } else {
                try {
                    characterClass = CharacterClass.CharacterClassesEnum.valueOf(userInput.toUpperCase().replace("-", "_").replace(" ", "_"));
                    return; //until input validation added
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid class. Please enter a valid class. \n");
//                    continue;
                }
            }
        } while (true);
    }
    public static CharacterClass fromEnum(CharacterClass.CharacterClassesEnum characterClassesEnum) {
        return switch (characterClassesEnum) {
            case BARBARIAN, BARD, PRIEST,
                    DRUID, KNIGHT, MONK,
                    PALADIN, HUNTER, ROGUE,
                    SORCERER, WARLOCK, WIZARD -> {
                CharacterClass charClass = new CharacterClass();
                charClass.setCharacterClass(characterClassesEnum);
            yield charClass;
        }
            default -> throw new IllegalArgumentException("Unsupported CharacterClassesEnum: " + characterClassesEnum);
        };
    }
}
