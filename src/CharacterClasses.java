import java.util.Scanner;
public class CharacterClasses {
    private static CharacterClassesEnum characterClass;
    private static final Scanner input = new Scanner(System.in);

    public enum CharacterClassesEnum {
        BARBARIAN("Barbarian"),
        BARD("Bard"),
        CLERIC("Cleric"),
        DRUID("Druid"),
        FIGHTER("Fighter"),
        MONK("Monk"),
        PALADIN("Paladin"),
        RANGER("Ranger"),
        ROGUE("Rogue"),
        SORCERER("Sorcerer"),
        WARLOCK("Warlock"),
        WIZARD("Wizard");

        private final String displayClass;

        CharacterClassesEnum(String displayClass) {
            this.displayClass = displayClass;
        }
        public String getDisplayClass() {
            return displayClass;
        }
    }
    public static CharacterClassesEnum getCharacterClass() {
        setCharacterClass();
        return characterClass;
    }
    private static void setCharacterClass() {
        do {
            System.out.println("Choose your class: \n");
            for (CharacterClassesEnum validClass : CharacterClassesEnum.values()) {
                System.out.println(validClass.ordinal() + 1 + ".) " + validClass.displayClass);
            }
            String userInput = input.nextLine().trim();
            if (userInput.matches("\\d+")) {
                int userChoice = Integer.parseInt(userInput);
                if (userChoice >= 1 && userChoice <= CharacterClassesEnum.values().length) {
                    characterClass = CharacterClassesEnum.values()[userChoice - 1];
                } else {
                    System.out.println("Invalid choice. Please enter a valid number. \n");
                    continue;
                }
            } else {
                try {
                    characterClass = CharacterClassesEnum.valueOf(userInput.toUpperCase().replace("-", "_").replace(" ", "_"));
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid class. Please enter a valid class. \n");
                    continue;
                }
            }
            if (characterClass != null) {
                System.out.println("You chose " + characterClass.displayClass + ", is that correct? 'Y'/[Enter] or 'N': \n");

                String confirmationInput = input.nextLine().toUpperCase();
                if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                    return;
                } else {
                    characterClass = null;
                }
            }
        } while (true);
    }
}
