import java.util.*;
import java.util.stream.Collectors;

public class BattleUnit {
    private static Scanner input = new Scanner(System.in);
    private boolean isDead = false;
    private BattleUnit character;
    private String characterName;
    private String characterRace;
    private String characterSubrace;
    private String characterClass;
    private Map<CharacterAttributes, Integer> characterAttributes = new HashMap<>();
    private Map<ValidCharacterRaces, List<ValidCharacterSubraces>> subracesMap = new HashMap<>();
    private String characterBackground;
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

        private final String displayRaceName;

        ValidCharacterRaces(String displayRaceName) {
            this.displayRaceName = displayRaceName;
        }
    }
    public enum ValidCharacterSubraces {
        HIGH_ELF("High-Elf"),
        WOOD_ELF("Wood-Elf"),
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

        private final String displaySubraceName;

        ValidCharacterSubraces(String displaySubraceName) {
            this.displaySubraceName = displaySubraceName; }
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

        private final String displayClassName;

        ValidCharacterClasses(String displayClassName) {
            this.displayClassName = displayClassName;
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

        private final String displayBackgroundName;

        ValidCharacterBackgrounds(String displayBackgroundName) {
            this.displayBackgroundName = displayBackgroundName;
        }
    }
    public enum CharacterAttributes {
        STRENGTH("Strength"),
        DEXTERITY("Dexterity"),
        CONSTITUTION("Constitution"),
        INTELLIGENCE("Intelligence"),
        WISDOM("Wisdom"),
        CHARISMA("Charisma");
        private final String displayAttributes;

        CharacterAttributes(String displayAttributes) {
            this.displayAttributes = displayAttributes;
        }
    }
    private String setCharacterName() {
        String characterName;
        boolean isValid;
        do {
            System.out.println("Enter your name (alphabetic characters, max length 24): \n");
            characterName = input.nextLine();
            isValid = characterName.matches("[a-zA-Z\\s']+") && characterName.length() <= 24;

            if (!isValid) {
                System.out.println("Invalid name. Please enter a valid name.\n");
            }
        } while (!isValid);
        return characterName;
    }
    private ValidCharacterRaces setCharacterRace() {
        String userInput = input.nextLine();
        ValidCharacterRaces characterRace = null;

        System.out.println("Choose your race: ");
        for (ValidCharacterRaces race : ValidCharacterRaces.values()) {
            System.out.println(race.ordinal() + 1 + ".) " + race.displayRaceName);
        }
        if (userInput.matches("\\d+")) {
            int userChoice = Integer.parseInt(userInput);
            if (userChoice >= 1 && userChoice <= ValidCharacterRaces.values().length) {
                characterRace = ValidCharacterRaces.values()[userChoice - 1];
            }
        } else {
            try {
                characterRace = ValidCharacterRaces.valueOf(userInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid race. Please enter a valid race.");
                setCharacterRace();
            }
        }
        if (characterRace != null) {
            System.out.println("You selected: " + characterRace + ", is that correct? \n");
            String confirmationInput = input.nextLine().toUpperCase();
            if (confirmationInput.startsWith("N")) {
                setCharacterRace();
            }
        }
        return characterRace;
    }

private void initializeSubracesMap() {
        subracesMap.put(ValidCharacterRaces.ELF, Arrays.asList(ValidCharacterSubraces.HIGH_ELF,
                ValidCharacterSubraces.WOOD_ELF));

        subracesMap.put(ValidCharacterRaces.TIEFLING, Arrays.asList(ValidCharacterSubraces.ASMODEUS,
                ValidCharacterSubraces.MEPHISTOPHELES,ValidCharacterSubraces.ZARIEL));

        subracesMap.put(ValidCharacterRaces.DROW, Arrays.asList(ValidCharacterSubraces.LOLTH_SWORN,
                ValidCharacterSubraces.SELDARINE));

        subracesMap.put(ValidCharacterRaces.DWARF, Arrays.asList(ValidCharacterSubraces.GOLD_DWARF, ValidCharacterSubraces.SHIELD_DWARF, ValidCharacterSubraces.DUERGAR));

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
private String setCharacterSubrace(ValidCharacterRaces characterRace) {

    if (subracesMap.containsKey(characterRace)) {
        List<ValidCharacterSubraces> subraces = subracesMap.get(characterRace);
        displaySubraces(subraces);
        int userInput = getUserInput(subraces.size());
        characterSubrace = subraces.get(userInput - 1).displaySubraceName;
    } else {
        System.out.println("Invalid character race. Please enter a valid race.");
        setCharacterSubrace(characterRace);
    } return characterSubrace;
}
    private void displaySubraces (List < ValidCharacterSubraces > subraces) {
        for (int i = 0; i < subraces.size(); i++) {
            System.out.println((i + 1) + ".) " + subraces.get(i).displaySubraceName);
        }
    }
    private int getUserInput (int max){
        int userInput;
        do {
            System.out.println("Enter your choice: ");
            userInput = input.nextInt();
            input.nextLine();
        } while (userInput < 1 || userInput > max);
        return userInput;
    }

    private ValidCharacterClasses setCharacterClass() {
        String userInput = input.nextLine();
        ValidCharacterClasses characterClass = null;

        System.out.println("Choose your class: ");
        for (ValidCharacterClasses validClass : ValidCharacterClasses.values()) {
            System.out.println(validClass.ordinal() + 1 + ".) " + validClass.displayClassName);
        }
        if (userInput.matches("\\d+")) {
            int userChoice = Integer.parseInt(userInput);
            if (userChoice >= 1 && userChoice <= ValidCharacterClasses.values().length) {
                characterClass = ValidCharacterClasses.values()[userChoice - 1];
            }
        } else {
            try {
                characterClass = ValidCharacterClasses.valueOf(userInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid class. Please enter a valid class.");
                setCharacterClass();
            }
        }
        if (characterClass != null) {
            System.out.println("You selected: " + characterClass + ", is that correct? \n");
            String confirmationInput = input.nextLine().toUpperCase();
            if (confirmationInput.startsWith("N")) {
                setCharacterClass();
            }
        }
        return characterClass;
    }
    private ValidCharacterBackgrounds setCharacterBackground() {
        String userInput = input.nextLine();
        ValidCharacterBackgrounds characterBackground = null;

        System.out.println("Choose your background: ");
        for (ValidCharacterBackgrounds background : ValidCharacterBackgrounds.values()) {
            System.out.println(background.ordinal() + 1 + ".) " + background.displayBackgroundName);
        }
        if (userInput.matches("\\d+")) {
            int userChoice = Integer.parseInt(userInput);
            if (userChoice >= 1 && userChoice <= ValidCharacterBackgrounds.values().length) {
                characterBackground = ValidCharacterBackgrounds.values()[userChoice - 1];
            }
        } else {
            try {
                characterBackground = ValidCharacterBackgrounds.valueOf(userInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid background. Please enter a valid background.");
                setCharacterBackground();
            }
        }
        if (characterBackground != null) {
            System.out.println("You selected: " + characterBackground + ", is that correct? \n");
            String confirmationInput = input.nextLine().toUpperCase();
            if (confirmationInput.startsWith("N")) {
                setCharacterBackground();
            }
        }
        return characterBackground;
    }
    private Map<CharacterAttributes, Integer> setCharacterAttributes(Scanner input, Map<CharacterAttributes, Integer> characterAttributes) {

        initializeAttributes(characterAttributes);

        int totalAttributePoints = 27;

        while (totalAttributePoints > 0) {
            displayAttributePoints(characterAttributes, totalAttributePoints);

            CharacterAttributes chosenAttribute = getChosenAttribute(input);

            if (chosenAttribute == null) {
                break;
            }

            handleAttributeAllocation(input, characterAttributes, totalAttributePoints, chosenAttribute);
        }
        displayFinalAttributeAllocation(characterAttributes);
        return characterAttributes;
    }

    private void initializeAttributes(Map<CharacterAttributes, Integer> characterAttributes) {
        for (CharacterAttributes attribute : CharacterAttributes.values()) {
            characterAttributes.put(attribute, 8);
        }
    }

    private void displayAttributePoints(Map<CharacterAttributes, Integer> characterAttributes, int totalAttributePoints) {
        System.out.println("Remaining points: " + totalAttributePoints);
        System.out.println("Available attributes: " + Arrays.stream(CharacterAttributes.values())
                .map(attribute -> attribute.displayAttributes).collect(Collectors.toList()));
        System.out.println("Enter attribute to increase (or 'done' to finish): ");
    }

    private CharacterAttributes getChosenAttribute(Scanner input) {
        System.out.println("Enter attribute to increase (or 'done' to finish): ");
        String userInput = input.nextLine();

        if (userInput.equalsIgnoreCase("done")) {
            return null;
        }

        try {
            return CharacterAttributes.valueOf(userInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid attribute. Please enter a valid attribute. ");
            return getChosenAttribute(input);
        }
    }

    private void handleAttributeAllocation(Scanner input, Map<CharacterAttributes, Integer> characterAttributes,
        int totalAttributePoints, CharacterAttributes chosenAttribute) {
        if (characterAttributes.containsKey(chosenAttribute)) {
            System.out.println("Enter points to allocate (between 1 and 7): ");
            int pointsToAdd = Integer.parseInt(input.nextLine());

            if (isValidPointAllocation(pointsToAdd, totalAttributePoints)) {
                updateAttributeValues(characterAttributes, chosenAttribute, pointsToAdd);
                totalAttributePoints -= pointsToAdd;
            } else {
                System.out.println("Invalid input. Please enter a valid number of points. ");
            }
        } else {
            System.out.println("Invalid attribute. Please enter a valid attribute. ");
        }
    }

    private boolean isValidPointAllocation(int pointsToAdd, int totalAttributePoints) {
        return pointsToAdd >= 1 && pointsToAdd <= 7 && totalAttributePoints - pointsToAdd >= 0;
    }

    private void updateAttributeValues(Map<CharacterAttributes, Integer> characterAttributes,
                                       CharacterAttributes chosenAttribute, int pointsToAdd) {
        int currentValue = characterAttributes.get(chosenAttribute);
        int newValue = Math.min(currentValue + pointsToAdd, 15);
        characterAttributes.put(chosenAttribute, newValue);
    }

    private void displayFinalAttributeAllocation(Map<CharacterAttributes, Integer> characterAttributes) {
        System.out.println("\nFinal attribute allocation: ");
        for (Map.Entry<CharacterAttributes, Integer> entry : characterAttributes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private void setCharacterConditions(String characterConditions) {

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

        this.characterConditions = characterConditions;
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

        this.characterResistances = characterResistances;
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
        Scanner input = new Scanner(System.in);
        BattleUnit character = new BattleUnit();
try {
    character.setCharacterName();
    character.setCharacterRace();
    character.setCharacterSubrace(ValidCharacterRaces.valueOf(characterRace));
    character.setCharacterClass();
    character.setCharacterBackground();
    character.setCharacterAttributes(input, characterAttributes);

} catch (IllegalArgumentException e) {
    System.out.println("Error... character creation failed.");
}
        return character;
    }

    public void displayCharacterInfo() {
        System.out.println("Character information for " + characterName + ":\n");
        System.out.println("Race: \n" + characterRace);
        System.out.println("Subrace: \n" + characterSubrace);
        System.out.println("Class: \n" + characterClass);
        System.out.println("Background: \n" + characterBackground);
        System.out.println("Attributes: \n" + characterAttributes);
        System.out.println("Base hit points: \n" + characterBaseHitPoints);
        for (Map.Entry<CharacterAttributes, Integer> entry : characterAttributes.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}