import java.util.*;

public class CharacterRace {
    private CharacterRacesEnum characterRace;
    private final Scanner input = new Scanner(System.in);

    public CharacterRace(CharacterRacesEnum characterRace) { this.characterRace = characterRace; }
    public CharacterRace() {

    }
    public enum CharacterRacesEnum {
        ELF("Elf"),
        //        TIEFLING("Tiefling"),
//        DROW("Drow"),
        HUMAN("Human"),
        //        GITHYANKI("Githyanki"),
        DWARF("Dwarf"),
        HALF_ELF("Half-Elf"),
        HALFLING("Halfling"),
        GNOME("Gnome"),
        HALF_ORC("Half-Orc"),
        NONE("None");

        private final String displayRaceEnum;

        CharacterRacesEnum(String displayRace) {
            this.displayRaceEnum = displayRace;
        }

        public String getDisplayRace() {
            return displayRaceEnum;
        }
    }

    public CharacterRacesEnum getCharacterRace() {
        return characterRace;
    }

    public void setCharacterRace(CharacterRacesEnum race) {
        this.characterRace = race;
    }

    public void setCharacterRace() {
        characterRace = null;
        do {
            System.out.println("Choose your race: \n");
            for (int i = 0; i < CharacterRacesEnum.values().length - 1; i++) {
                CharacterRacesEnum race = CharacterRacesEnum.values()[i];
                System.out.println(race.ordinal() + 1 + ".) " + race.displayRaceEnum);
            }
            String userInput = input.nextLine().trim();
            if (userInput.matches("\\d+")) {
                int userChoice = Integer.parseInt(userInput);
                if (userChoice >= 1 && userChoice <= CharacterRacesEnum.values().length - 1) {
                    characterRace = (CharacterRacesEnum.values()[userChoice - 1]);
                    return; //until input validation added
                } else {
                    System.out.println("Invalid choice. Please enter a valid number. \n");
                }
            } else {
                try {
                    characterRace = (CharacterRacesEnum.valueOf(userInput.toUpperCase().replace("-", "_").replace(" ", "_")));
                    return; //until input validation added
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid race. Please enter a valid race. \n");
                }
            }
        } while (true);
    }

    public static CharacterRace fromEnum(CharacterRace.CharacterRacesEnum characterRacesEnum) {
        return switch (characterRacesEnum) {
            case ELF, HUMAN, DWARF,
                    HALF_ELF, HALFLING,
                    GNOME, HALF_ORC -> {
                CharacterRace race = new CharacterRace();
                race.setCharacterRace(characterRacesEnum);
                yield race;
            }
            default -> throw new IllegalArgumentException("Unsupported CharacterRacesEnum: " + characterRacesEnum);
        };
    }
    public void closeScanner() {
        input.close();
    }
}