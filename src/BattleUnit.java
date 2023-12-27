import java.util.*;
import java.util.stream.Collectors;

public class BattleUnit {
    private static Scanner input = new Scanner(System.in);
    private boolean isDead = false;
    private BattleUnit character;
    private String characterName;
    private ValidCharacterRaces characterRace;
    private ValidCharacterSubraces characterSubrace;
    private ValidCharacterClasses characterClass;
    private Map<CharacterAttributes, Integer> characterAttributes = new HashMap<>();
    private Map<ValidCharacterRaces, List<ValidCharacterSubraces>> subracesMap = new EnumMap<>(ValidCharacterRaces.class);
    private ValidCharacterBackgrounds characterBackground;
    private String characterConditions;
    private String characterResistances;
    private String characterItems;
    private String[] characterInventory;
    private int characterGold = 0;
    private int characterBaseHitPoints = 0;
    private int characterWeight = 0;
    private int characterArmorClass = 0;
    private int characterCarryingCapacity = 40;
    private double characterExperiencePoints = 0;
    private int characterCampSupplies = 0;

    public enum ValidCharacterRaces {
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
        ValidCharacterRaces(String displayRace) {
            this.displayRace = displayRace;
        }
    }
    public enum ValidCharacterSubraces {
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
        WHITE_DRAGONBORN("White Dragonborn");

        private final String displaySubrace;

        ValidCharacterSubraces(String displaySubraces) {
            this.displaySubrace = displaySubraces; }
    }
    private void initializeSubracesMap() {

        subracesMap.put(ValidCharacterRaces.ELF, Arrays.asList(ValidCharacterSubraces.HIGH_ELF,
                ValidCharacterSubraces.WOOD_ELF));

        subracesMap.put(ValidCharacterRaces.TIEFLING, Arrays.asList(ValidCharacterSubraces.ASMODEUS,
                ValidCharacterSubraces.MEPHISTOPHELES, ValidCharacterSubraces.ZARIEL));

        subracesMap.put(ValidCharacterRaces.DROW, Arrays.asList(ValidCharacterSubraces.LOLTH_SWORN,
                ValidCharacterSubraces.SELDARINE));

        subracesMap.put(ValidCharacterRaces.DWARF, Arrays.asList(ValidCharacterSubraces.GOLD_DWARF,
                ValidCharacterSubraces.SHIELD_DWARF, ValidCharacterSubraces.DUERGAR));

        subracesMap.put(ValidCharacterRaces.HALF_ELF, Arrays.asList(ValidCharacterSubraces.HIGH_HALF_ELF,
                ValidCharacterSubraces.WOOD_HALF_ELF, ValidCharacterSubraces.DROW_HALF_ELF));

        subracesMap.put(ValidCharacterRaces.HALFLING, Arrays.asList(ValidCharacterSubraces.LIGHTFOOT_HALFLING,
                ValidCharacterSubraces.STRONGHEART_HALFLING));

        subracesMap.put(ValidCharacterRaces.GNOME, Arrays.asList(ValidCharacterSubraces.ROCK_GNOME,
                ValidCharacterSubraces.FOREST_GNOME, ValidCharacterSubraces.DEEP_GNOME));

        subracesMap.put(ValidCharacterRaces.DRAGONBORN, Arrays.asList(ValidCharacterSubraces.BLACK_DRAGONBORN,
                ValidCharacterSubraces.BLUE_DRAGONBORN, ValidCharacterSubraces.BRONZE_DRAGONBORN,
                ValidCharacterSubraces.COPPER_DRAGONBORN, ValidCharacterSubraces.GOLD_DRAGONBORN,
                ValidCharacterSubraces.GREEN_DRAGONBORN, ValidCharacterSubraces.RED_DRAGONBORN,
                ValidCharacterSubraces.SILVER_DRAGONBORN, ValidCharacterSubraces.WHITE_DRAGONBORN));
    }
    public enum ValidCharacterClasses {
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

        ValidCharacterClasses(String displayClass) {
            this.displayClass = displayClass;
        }
    }
    public enum ValidCharacterBackgrounds {
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

        ValidCharacterBackgrounds(String displayBackground) {
            this.displayBackground = displayBackground;
        }
    }
    public enum CharacterAttributes {
        STRENGTH("Strength"),
        DEXTERITY("Dexterity"),
        CONSTITUTION("Constitution"),
        INTELLIGENCE("Intelligence"),
        WISDOM("Wisdom"),
        CHARISMA("Charisma");
        private final String displayCharacterAttributes;

        CharacterAttributes(String displayCharacterAttributes) {
            this.displayCharacterAttributes = displayCharacterAttributes;
        }
    }
    private void initializeAttributes(Map<CharacterAttributes, Integer> characterAttributes) {
        for (CharacterAttributes attribute : CharacterAttributes.values()) {
            characterAttributes.put(attribute, 8);
        }
    }

    private String setCharacterName() {
        boolean isValid;
        do {
            System.out.println("Enter your name (alphabetic characters, max length 24): \n");
            characterName = input.nextLine();
            isValid = characterName.matches("[a-zA-Z\\s']+") && characterName.length() <= 24;

            if (!isValid) {
                System.out.println("Invalid name. Please enter a valid name. ");
            }
        } while (!isValid);
        return characterName;
    }
    private void setCharacterRace() {
        do {
            System.out.println("Choose your race: \n");
            for (ValidCharacterRaces race : ValidCharacterRaces.values()) {
                System.out.println(race.ordinal() + 1 + ".) " + race.displayRace);
            }
            String userInput = input.nextLine().trim();
            if (userInput.matches("\\d+")) {
                int userChoice = Integer.parseInt(userInput);
                if (userChoice >= 1 && userChoice <= ValidCharacterRaces.values().length) {
                    characterRace = ValidCharacterRaces.values()[userChoice - 1];
                } else {
                    System.out.println("Invalid choice. Please enter a valid number. \n");
                    continue;
                }
            } else {
                try {
                    characterRace = ValidCharacterRaces.valueOf(userInput.toUpperCase().replace("-", "_").replace(" ", "_"));
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid race. Please enter a valid race. \n");
                    continue;
                }
            }
            if (characterRace != null) {
                System.out.println("You chose " + characterRace.displayRace + ", is that correct? 'Y'/[Enter] or 'N': \n");

                String confirmationInput = input.nextLine().toUpperCase();
                if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                    System.out.println("Character name is: " + characterName);
                    System.out.println("this.Character name is: " + this.characterName);
                    System.out.println("Character race is: " + characterRace);
                    System.out.println("this.Character race is: " + this.characterRace);
                    System.out.println("Character subrace is: " + characterSubrace);
                    System.out.println("this.Character subrace is: " + this.characterSubrace);
                    System.out.println("Character class is: " + characterClass);
                    System.out.println("this.Character class is: " + this.characterClass);
                    System.out.println("Character background is: " + characterBackground);
                    System.out.println("this.Character background is: " + this.characterBackground);
                    return;
                } else {
                    continue;
                }
            }
        } while (true);
    }

    private void setCharacterSubrace(ValidCharacterRaces characterRace) {
        initializeSubracesMap();

        do {
            if (subracesMap.containsKey(this.characterRace)) {
                System.out.println("Choose your subrace: \n");
                List<ValidCharacterSubraces> subraces = subracesMap.get(this.characterRace);
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
                            characterSubrace = ValidCharacterSubraces.valueOf(userInput.toUpperCase().replace("-", "_").replace(" ", "_"));
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid subrace. Please enter a valid subrace. \n");
                            continue;
                        }
                    }
                    if (characterSubrace != null) {
                        System.out.println("You chose " + characterSubrace.displaySubrace + ", is that correct? 'Y'/[Enter] or 'N': \n");

                        String confirmationInput = input.nextLine().toUpperCase();
                        if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                            System.out.println("Character name is: " + characterName);
                            System.out.println("this.Character name is: " + this.characterName);
                            System.out.println("Character race is: " + characterRace);
                            System.out.println("this.Character race is: " + this.characterRace);
                            System.out.println("Character subrace is: " + characterSubrace);
                            System.out.println("this.Character subrace is: " + this.characterSubrace);
                            System.out.println("Character class is: " + characterClass);
                            System.out.println("this.Character class is: " + this.characterClass);
                            System.out.println("Character background is: " + characterBackground);
                            System.out.println("this.Character background is: " + this.characterBackground);
                            return;
                        }
                    } else {
                        characterSubrace = null;
                    }
                }
            } else {
                break;
            }
        } while (true);
    }
    private void setCharacterClass() {
        do {
            System.out.println("Choose your class: \n");
            for (ValidCharacterClasses validClass : ValidCharacterClasses.values()) {
                System.out.println(validClass.ordinal() + 1 + ".) " + validClass.displayClass);
            }
            String userInput = input.nextLine().trim();
            if (userInput.matches("\\d+")) {
                int userChoice = Integer.parseInt(userInput);
                if (userChoice >= 1 && userChoice <= ValidCharacterClasses.values().length) {
                    characterClass = ValidCharacterClasses.values()[userChoice - 1];
                } else {
                    System.out.println("Invalid choice. Please enter a valid number. \n");
                    continue;
                }
            } else {
                try {
                    characterClass = ValidCharacterClasses.valueOf(userInput.toUpperCase().replace("-", "_").replace(" ", "_"));
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid class. Please enter a valid class. \n");
                    continue;
                }
            }
            if (characterClass != null) {
                System.out.println("You chose " + characterClass.displayClass + ", is that correct? 'Y'/[Enter] or 'N': \n");

                String confirmationInput = input.nextLine().toUpperCase();
                if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                    System.out.println("Character name is: " + characterName);
                    System.out.println("this.Character name is: " + this.characterName);
                    System.out.println("Character race is: " + characterRace);
                    System.out.println("this.Character race is: " + this.characterRace);
                    System.out.println("Character subrace is: " + characterSubrace);
                    System.out.println("this.Character subrace is: " + this.characterSubrace);
                    System.out.println("Character class is: " + characterClass);
                    System.out.println("this.Character class is: " + this.characterClass);
                    System.out.println("Character background is: " + characterBackground);
                    System.out.println("this.Character background is: " + this.characterBackground);
                    return;
                } else {
                    characterClass = null;
                }
            }
        } while (true);
    }

    private void setCharacterBackground() {
        do {
            System.out.println("Choose your background: \n");
            for (ValidCharacterBackgrounds background : ValidCharacterBackgrounds.values()) {
                System.out.println(background.ordinal() + 1 + ".) " + background.displayBackground);
            }
            String userInput = input.nextLine().trim();
            if (userInput.matches("\\d+")) {
                int userChoice = Integer.parseInt(userInput);
                if (userChoice >= 1 && userChoice <= ValidCharacterBackgrounds.values().length) {
                    characterBackground = ValidCharacterBackgrounds.values()[userChoice - 1];
                } else {
                    System.out.println("Invalid choice. Please enter a valid number. \n");
                    continue;
                }
            } else {
                try {
                    characterBackground = ValidCharacterBackgrounds.valueOf(userInput.toUpperCase().replace("-", "_").replace(" ", "_"));
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid background. Please enter a valid background. \n");
                    continue;
                }
            }
            if (characterBackground != null) {
                System.out.println("You selected " + characterBackground.displayBackground + ", is that correct? 'Y'/[Enter] or 'N': \n");

                String confirmationInput = input.nextLine().toUpperCase();
                if ((confirmationInput.startsWith("Y") || confirmationInput.isEmpty())) {
                    System.out.println("Character name is: " + characterName);
                    System.out.println("this.Character name is: " + this.characterName);
                    System.out.println("Character race is: " + characterRace);
                    System.out.println("this.Character race is: " + this.characterRace);
                    System.out.println("Character subrace is: " + characterSubrace);
                    System.out.println("this.Character subrace is: " + this.characterSubrace);
                    System.out.println("Character class is: " + characterClass);
                    System.out.println("this.Character class is: " + this.characterClass);
                    System.out.println("Character background is: " + characterBackground);
                    System.out.println("this.Character background is: " + this.characterBackground);
                    return;
                } else {
                    characterBackground = null;
                }
            }
        } while (true);
    }
    private void setCharacterAttributes(Scanner input, Map<CharacterAttributes, Integer> characterAttributes) {
        initializeAttributes(characterAttributes);
        int maxTotalAttributePoints = 27;

        do  {
            System.out.println("Character Attributes: ");
            System.out.println(" ");
            System.out.println("Remaining points: " + maxTotalAttributePoints);
            System.out.println(" ");
            printChosenAttributes(characterAttributes);
            System.out.println("Choose an attribute to increase or decrease (minimum 8, maximum 17): \n");
            System.out.println("\nEnter attribute to change (or 'done' to finish): \n");
            String userInput = input.nextLine().toUpperCase();

            if (userInput.equalsIgnoreCase("done")) {
                System.out.println("Final attributes: \n");
                printChosenAttributes(characterAttributes);
                break;
            }

            try {
                do {
                    CharacterAttributes chosenAttribute = CharacterAttributes.valueOf(userInput);
                    System.out.println("Enter points to add (positive) or subtract (negative) to " +
                            chosenAttribute.displayCharacterAttributes + ": ");
                    int attributePointsToAddOrSubtract = Integer.parseInt(input.nextLine());
                    if (characterAttributes.containsKey(chosenAttribute)) {
                        int currentAttributePoints = characterAttributes.get(chosenAttribute);
                        int newAttributePoints = currentAttributePoints + attributePointsToAddOrSubtract;

                        if (newAttributePoints >= 8 && newAttributePoints <= 17 && maxTotalAttributePoints - attributePointsToAddOrSubtract >= 0) {
                            characterAttributes.put(chosenAttribute, newAttributePoints);
                            maxTotalAttributePoints -= attributePointsToAddOrSubtract;
                        } else {
                            System.out.println("Invalid input. Attributes must stay between 8 and 17, and check remaining points. \n");
                        }
                    }
                } while (false);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Please enter a valid attribute and points. \n");
                System.out.println(" ");
            }
        } while (maxTotalAttributePoints >= 0);
    }

    private static void printChosenAttributes(Map<CharacterAttributes, Integer> attributePoints) {
        for (CharacterAttributes attribute : CharacterAttributes.values()) {
            System.out.println(attribute.displayCharacterAttributes + ": " + attributePoints.get(attribute));
        }
        System.out.println();
    }
    private boolean setCharacterConditions() {

        boolean characterBlinded = false;
        boolean characterCharmed = false;
        boolean characterCursed = false;
        boolean characterDiseased = false;
        boolean characterFrightened = false;
        boolean characterIncapacitated = false;
        boolean characterMaimed = false;
        boolean characterPoisoned = false;
        boolean characterPolymorphed = false;
        boolean characterProne = false;
        boolean characterUnconscious = false;

        boolean characterConditions = characterBlinded || characterCharmed || characterCursed || characterDiseased ||
                characterFrightened || characterIncapacitated || characterMaimed || characterPoisoned ||
                characterPolymorphed || characterProne || characterUnconscious;

        return characterConditions;
    }

    private void setCharacterResistances(String characterResistances) {
        // int = 5 immune, 4 = 50% resist, 3 = 25% resist, 2 = normal, 1 = 25% vulnerable, 0 = 50% vulnerable

        int characterBludgeoningResistance = 2;
        int characterPiercingResistance = 2;
        int characterSlashingResistance = 2;
        int characterFireResistance = 2;
        int characterColdResistance = 2;
        int characterLightningResistance = 2;
        int characterThunderResistance = 2;
        int characterAcidResistance = 2;
        int characterPoisonResistance = 2;
        int characterRadiantResistance = 2;
        int characterNecroticResistance = 2;
        int characterForceResistance = 2;
        int characterPsychicResistance = 2;

    }

    private void addItemToInventory(String item) {
        if (characterInventory == null) {
            characterInventory = new String[]{item};
        } else {
            characterInventory = Arrays.copyOf(characterInventory, characterInventory.length + 1);
            characterInventory[characterInventory.length - 1] = item;
        }
    }

    public void setCharacterBaseHitPoints(int characterBaseHitPoints) {
        this.characterBaseHitPoints = characterBaseHitPoints;
    }

    public void setCharacterCampSupplies(int characterCampSupplies) {
        this.characterCampSupplies = characterCampSupplies;
    }

    public void setCharacterGold(int characterGold) {
        this.characterGold = characterGold;
    }

    public void setCharacterWeight(int characterWeight) {
        this.characterWeight = characterWeight;
    }

    public void setCharacterArmorClass(int characterArmorClass) {
        this.characterArmorClass = characterArmorClass;
    }

    public void setCharacterCarryingCapacity(int characterCarryingCapacity) {
        this.characterCarryingCapacity = characterCarryingCapacity;
    }

    public void setCharacterExperiencePoints(int CharacterExperiencePoints) {
        this.characterExperiencePoints = characterExperiencePoints;
    }

    public BattleUnit createCharacter() {
        BattleUnit character = new BattleUnit();
try {
    character.setCharacterName();
    character.setCharacterRace();
    character.setCharacterSubrace(characterRace);
    character.setCharacterClass();
    character.setCharacterBackground();
    character.setCharacterAttributes(input, characterAttributes);
    displayCharacterInfo();

} catch (IllegalArgumentException e) {
    System.out.println("Error... character creation failed.");
}
        return character;
    }

    public void displayCharacterInfo() {
        System.out.println("Character information for " + characterName + ": \n");
        System.out.println("Race: \n" + characterRace.displayRace);
        System.out.println("Subrace: \n" + characterSubrace.displaySubrace);
        System.out.println("Class: \n" + characterClass.displayClass);
        System.out.println("Background: \n" + characterBackground.displayBackground);
        System.out.println("Attributes: \n"); for (Map.Entry<CharacterAttributes, Integer> entry : characterAttributes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("Base hit points: \n" + characterBaseHitPoints);
        }
    }