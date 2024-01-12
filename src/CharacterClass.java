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
        WIZARD("Wizard"),
        NONE("None");

        private final String displayClassEnum;
        CharacterClassesEnum(String displayClass) {
            this.displayClassEnum = displayClass;
        }
        public String getDisplayClass() { return displayClassEnum; }
    }
    public CharacterClassesEnum getCharacterClass() { return characterClass; }
    public void setCharacterClass(CharacterClassesEnum charClass) { this.characterClass = charClass; }
    public void setCharacterClass() {
        do {
            System.out.println("Choose your class: \n");
            for (int i = 0; i < CharacterClassesEnum.values().length - 1; i++) {
                CharacterClassesEnum characterClass = CharacterClassesEnum.values()[i];
                System.out.println(characterClass.ordinal() + 1 + ".) " + characterClass.displayClassEnum);
            }
            String userInput = input.nextLine().trim();
            if (userInput.matches("\\d+")) {
                int userChoice = Integer.parseInt(userInput);
                if (userChoice >= 1 && userChoice <= CharacterClass.CharacterClassesEnum.values().length - 1) {
                    characterClass = (CharacterClass.CharacterClassesEnum.values()[userChoice - 1]);
                    characterClassValidation();
                } else {
                    System.out.println("Invalid choice. Please enter a valid number. \n");
                }
            } else {
                try {
                    characterClass = CharacterClass.CharacterClassesEnum.valueOf(userInput.toUpperCase().replace("-", "_").replace(" ", "_"));
                    characterClassValidation();
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid class. Please enter a valid class. \n");
                }
            }
        } while (characterClass == CharacterClassesEnum.NONE);
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
    public void characterClassValidation() {
        if (characterClass != null) {
            System.out.println("You chose " + characterClass.displayClassEnum + ", is that correct? 'Y'/[Enter] or 'N': \n");
            String confirmationInput = input.nextLine().toUpperCase();
            if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                return;
            } else characterClass = CharacterClass.CharacterClassesEnum.NONE;
        }
    }
}
