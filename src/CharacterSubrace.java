import java.util.*;

public class CharacterSubrace {
    private CharacterSubracesEnum characterSubrace;
    private final Scanner input = new Scanner(System.in);
    private final EnumMap<CharacterRace.CharacterRacesEnum, List<CharacterSubrace.CharacterSubracesEnum>> subracesMap = new EnumMap<>(CharacterRace.CharacterRacesEnum.class);
    public CharacterSubrace(CharacterSubracesEnum characterRace) {
        this.characterSubrace = characterRace;
    }
    public CharacterSubrace() {

    }
    public enum CharacterSubracesEnum {
        HIGH_ELF("High Elf"),
        WOOD_ELF("Wood Elf"),
        DARK_ELF("Dark Elf"),
//        ASMODEUS("Asmodeus"),
//        MEPHISTOPHELES("Mephistopheles"),
//        ZARIEL("Zariel"),
//        LOLTH_SWORN("Lolth-Sworn"),
//        SELDARINE("Seldarine"),
        GOLD_DWARF("Gold Dwarf"),
        SHIELD_DWARF("Shield Dwarf"),
        DUERGAR("Duergar"),
        HIGH_HALF_ELF("High Half-Elf"),
        WOOD_HALF_ELF("Wood Half-Elf"),
        DARK_HALF_ELF("Dark Half-Elf"),
//        DROW_HALF_ELF("Drow Half-Elf"),
        LIGHTFOOT_HALFLING("Lightfoot Halfling"),
        STRONGHEART_HALFLING("Strongheart Halfling"),
        ROCK_GNOME("Rock Gnome"),
        FOREST_GNOME("Forest Gnome"),
        DEEP_GNOME("Deep Gnome"),
//        BLACK_DRAGONBORN("Black Dragonborn"),
//        BLUE_DRAGONBORN("Blue Dragonborn"),
//        BRONZE_DRAGONBORN("Bronze Dragonborn"),
//        COPPER_DRAGONBORN("Copper Dragonborn"),
//        GOLD_DRAGONBORN("Gold Dragonborn"),
//        GREEN_DRAGONBORN("Green Dragonborn"),
//        RED_DRAGONBORN("Red Dragonborn"),
//        SILVER_DRAGONBORN("Silver Dragonborn"),
//        WHITE_DRAGONBORN("White Dragonborn"),
        NONE("None");

        private final String displaySubraceEnum;

        CharacterSubracesEnum(String displaySubrace) { displaySubraceEnum = displaySubrace; }
        public String getDisplaySubrace() { return displaySubraceEnum; }
    }

    public CharacterSubracesEnum getCharacterSubrace() {
        return characterSubrace;
    }
    public void setCharacterSubrace(CharacterSubracesEnum subrace) { this.characterSubrace = subrace; }

    public void setCharacterSubrace(CharacterRace.CharacterRacesEnum characterRace) {
        characterSubrace = null;
        CharacterRaceMap.initializeSubracesMap();

        if (CharacterRaceMap.getSubraces(characterRace).contains(CharacterSubracesEnum.NONE)) {
            characterSubrace = (CharacterSubracesEnum.NONE);
            return;
        }
        do
        {
                System.out.println("Choose your subrace: \n");
                List<CharacterSubracesEnum> subraces = CharacterRaceMap.getSubraces(characterRace);
                if (!subraces.isEmpty()) {
                    for (int i = 0; i < subraces.size(); i++) {
                        System.out.println((i + 1) + ".) " + subraces.get(i).displaySubraceEnum);
                    }
                    String userInput = input.nextLine().trim();
                    if (userInput.matches("\\d+")) {
                        int userChoice = Integer.parseInt(userInput);
                        if (userChoice >= 1 && userChoice <= subraces.size()) {
                            characterSubrace = (subraces.get(userChoice - 1));
                        } else {
                            System.out.println("Invalid choice. Please enter a valid number. \n");
//                            continue;
                        }
                    } else {
                        try {
                            characterSubrace = (CharacterSubracesEnum.valueOf(userInput.toUpperCase().replace("-", "_").replace(" ", "_")));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid subrace. Please enter a valid subrace. \n");
//                            continue;
                        }
                    }
                    if (characterSubrace != null) {
                        System.out.println("You chose " + characterSubrace.getDisplaySubrace() + ", is that correct? 'Y'/[Enter] or 'N': \n");
                        String confirmationInput = input.nextLine().toUpperCase();
                        if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                            return;
                        }
                    }
                }
        } while (true);
    }
//    public static CharacterSubrace fromEnum(CharacterSubracesEnum characterSubracesEnum) {
//        return new CharacterSubrace(characterSubracesEnum);
//    }
        public static CharacterSubrace fromEnum(CharacterSubrace.CharacterSubracesEnum characterSubracesEnum) {
        return switch (characterSubracesEnum) {
            case HIGH_ELF, WOOD_ELF, DARK_ELF,
                    GOLD_DWARF, SHIELD_DWARF, DUERGAR,
                    HIGH_HALF_ELF, WOOD_HALF_ELF, DARK_HALF_ELF,
                    LIGHTFOOT_HALFLING, STRONGHEART_HALFLING,
                    ROCK_GNOME, FOREST_GNOME, DEEP_GNOME,
                    NONE -> {
                CharacterSubrace subrace = new CharacterSubrace();
                subrace.setCharacterSubrace(characterSubracesEnum);
                yield subrace;
            }
            default -> throw new IllegalArgumentException("Unsupported CharacterRacesEnum: " + characterSubracesEnum);
        };
    }
    public void closeScanner() {
        input.close();
    }
}
