import java.awt.geom.NoninvertibleTransformException;
import java.util.*;

public class CharacterRacesAndSubraces {
    private static Map<CharacterRacesEnum, List<CharacterSubracesEnum>> subracesMap = new EnumMap<>(CharacterRacesEnum.class);
    private static CharacterRacesEnum characterRace;
    private static CharacterSubracesEnum characterSubrace;
    private static final Scanner input = new Scanner(System.in);

    public enum CharacterRacesEnum {
        ELF("Elf"),
        TIEFLING("Tiefling"),
        DROW("Drow"),
        HUMAN("Human"),
        GITHYANKI("Githyanki"),
        DWARF("Dwarf"),
        HALF_ELF("Half-Elf"),
        HALFLING("Halfling"),
        GNOME("Gnome"),
        DRAGONBORN("Dragonborn"),
        HALF_ORC("Half-Orc");

        private final String displayRace;

        CharacterRacesEnum(String displayRace) {
            this.displayRace = displayRace;
        }

        public String getDisplayRace() {
            return displayRace;
        }
    }


    public enum CharacterSubracesEnum {
        HIGH_ELF("High Elf"),
        WOOD_ELF("Wood Elf"),
        ASMODEUS("Asmodeus"),
        MEPHISTOPHELES("Mephistopheles"),
        ZARIEL("Zariel"),
        LOLTH_SWORN("Lolth-Sworn"),
        SELDARINE("Seldarine"),
        GOLD_DWARF("Gold Dwarf"),
        SHIELD_DWARF("Shield Dwarf"),
        DUERGAR("Duergar"),
        HIGH_HALF_ELF("High Half-Elf"),
        WOOD_HALF_ELF("Wood Half-Elf"),
        DROW_HALF_ELF("Drow Half-Elf"),
        LIGHTFOOT_HALFLING("Lightfoot Halfling"),
        STRONGHEART_HALFLING("Strongheart Halfling"),
        ROCK_GNOME("Rock Gnome"),
        FOREST_GNOME("Forest Gnome"),
        DEEP_GNOME("Deep Gnome"),
        BLACK_DRAGONBORN("Black Dragonborn"),
        BLUE_DRAGONBORN("Blue Dragonborn"),
        BRONZE_DRAGONBORN("Bronze Dragonborn"),
        COPPER_DRAGONBORN("Copper Dragonborn"),
        GOLD_DRAGONBORN("Gold Dragonborn"),
        GREEN_DRAGONBORN("Green Dragonborn"),
        RED_DRAGONBORN("Red Dragonborn"),
        SILVER_DRAGONBORN("Silver Dragonborn"),
        WHITE_DRAGONBORN("White Dragonborn"),
        NONE("None");

        private final String displaySubrace;

        CharacterSubracesEnum(String displaySubraces) {
            this.displaySubrace = displaySubraces;
        }

        public String getDisplaySubrace() {
            return displaySubrace;
        }
    }

    private static void initializeSubracesMap() {

        subracesMap.put(CharacterRacesEnum.ELF, Arrays.asList(CharacterSubracesEnum.HIGH_ELF,
                CharacterSubracesEnum.WOOD_ELF));

        subracesMap.put(CharacterRacesEnum.TIEFLING, Arrays.asList(CharacterSubracesEnum.ASMODEUS,
                CharacterSubracesEnum.MEPHISTOPHELES, CharacterSubracesEnum.ZARIEL));

        subracesMap.put(CharacterRacesEnum.DROW, Arrays.asList(CharacterSubracesEnum.LOLTH_SWORN,
                CharacterSubracesEnum.SELDARINE));

        subracesMap.put(CharacterRacesEnum.DWARF, Arrays.asList(CharacterSubracesEnum.GOLD_DWARF,
                CharacterSubracesEnum.SHIELD_DWARF, CharacterSubracesEnum.DUERGAR));

        subracesMap.put(CharacterRacesEnum.HALF_ELF, Arrays.asList(CharacterSubracesEnum.HIGH_HALF_ELF,
                CharacterSubracesEnum.WOOD_HALF_ELF, CharacterSubracesEnum.DROW_HALF_ELF));

        subracesMap.put(CharacterRacesEnum.HALFLING, Arrays.asList(CharacterSubracesEnum.LIGHTFOOT_HALFLING,
                CharacterSubracesEnum.STRONGHEART_HALFLING));

        subracesMap.put(CharacterRacesEnum.GNOME, Arrays.asList(CharacterSubracesEnum.ROCK_GNOME,
                CharacterSubracesEnum.FOREST_GNOME, CharacterSubracesEnum.DEEP_GNOME));

        subracesMap.put(CharacterRacesEnum.DRAGONBORN, Arrays.asList(CharacterSubracesEnum.BLACK_DRAGONBORN,
                CharacterSubracesEnum.BLUE_DRAGONBORN, CharacterSubracesEnum.BRONZE_DRAGONBORN,
                CharacterSubracesEnum.COPPER_DRAGONBORN, CharacterSubracesEnum.GOLD_DRAGONBORN,
                CharacterSubracesEnum.GREEN_DRAGONBORN, CharacterSubracesEnum.RED_DRAGONBORN,
                CharacterSubracesEnum.SILVER_DRAGONBORN, CharacterSubracesEnum.WHITE_DRAGONBORN));

        subracesMap.put(CharacterRacesEnum.HUMAN, List.of(CharacterSubracesEnum.NONE));
        subracesMap.put(CharacterRacesEnum.GITHYANKI, List.of(CharacterSubracesEnum.NONE));
        subracesMap.put(CharacterRacesEnum.HALF_ORC, List.of(CharacterSubracesEnum.NONE));

    }

    public static CharacterRacesEnum getCharacterRace() {
        setCharacterRace();
        return characterRace;
    }

    private static void setCharacterRace() {
        do {
            System.out.println("Choose your race: \n");
            for (CharacterRacesEnum race : CharacterRacesEnum.values()) {
                System.out.println(race.ordinal() + 1 + ".) " + race.displayRace);
            }
            String userInput = input.nextLine().trim();
            if (userInput.matches("\\d+")) {
                int userChoice = Integer.parseInt(userInput);
                if (userChoice >= 1 && userChoice <= CharacterRacesEnum.values().length) {
                    characterRace = CharacterRacesEnum.values()[userChoice - 1];
                } else {
                    System.out.println("Invalid choice. Please enter a valid number. \n");
                    continue;
                }
            } else {
                try {
                    characterRace = CharacterRacesEnum.valueOf(userInput.toUpperCase().replace("-", "_").replace(" ", "_"));
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid race. Please enter a valid race. \n");
                    continue;
                }
            }
            if (characterRace != null) {
                System.out.println("You chose " + characterRace.displayRace + ", is that correct? 'Y'/[Enter] or 'N': \n");

                String confirmationInput = input.nextLine().toUpperCase();
                if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                    return;
                }
            }
        } while (true);
    }

    public static CharacterSubracesEnum getCharacterSubrace() {
        setCharacterSubrace(characterRace);
        return characterSubrace;
    }

    private static void setCharacterSubrace(CharacterRacesEnum characterRace) {
        initializeSubracesMap();

        do {
            if (subracesMap.containsKey(characterRace) && (subracesMap.get(characterRace).contains(CharacterSubracesEnum.NONE))) {
                characterSubrace = CharacterSubracesEnum.NONE;
                return;
            }
            else if (subracesMap.containsKey(characterRace)) {
                System.out.println("Choose your subrace: \n");
                List<CharacterSubracesEnum> subraces = subracesMap.get(characterRace);
                if (!subraces.isEmpty()) {
                    for (int i = 0; i < subraces.size(); i++) {
                        System.out.println((i + 1) + ".) " + subraces.get(i).displaySubrace);
                    }
                    String userInput = input.nextLine().trim();
                    if (userInput.matches("\\d+")) {
                        int userChoice = Integer.parseInt(userInput);
                        if (userChoice >= 1 && userChoice <= subraces.size()) {
                            characterSubrace = subraces.get(userChoice - 1);
                        } else {
                            System.out.println("Invalid choice. Please enter a valid number. \n");
                            continue;
                        }
                    } else {
                        try {
                            characterSubrace = CharacterSubracesEnum.valueOf(userInput.toUpperCase().replace("-", "_").replace(" ", "_"));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid subrace. Please enter a valid subrace. \n");
                            continue;
                        }
                    }
                    if (characterSubrace != null) {
                        System.out.println("You chose " + characterSubrace.displaySubrace + ", is that correct? 'Y'/[Enter] or 'N': \n");
                        String confirmationInput = input.nextLine().toUpperCase();
                        if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                            return;
                        }
                    }
                }
            }
        } while (true);
    }
}