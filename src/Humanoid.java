import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Humanoid {
    private final CharacterName characterName;
    private final CharacterRace characterRace;
    private final CharacterSubrace characterSubrace;
    private final CharacterClass characterClass;
    private final CharacterBackground characterBackground;
    private final CharacterAttributes characterAttributes;
    Map<CharacterAttributes.CharacterAttributesEnum, Integer> attributesValues = new HashMap<>();

    //MainCharacter constructor
    public Humanoid() {
        this.characterName = new CharacterName();
        this.characterRace = new CharacterRace();
        this.characterSubrace = new CharacterSubrace();
        this.characterClass = new CharacterClass();
        this.characterBackground = new CharacterBackground();
        this.characterAttributes = new CharacterAttributes();
    }

    //NPC Constructor
    public Humanoid(CharacterName characterName, CharacterRace.CharacterRacesEnum characterRace, CharacterSubrace.CharacterSubracesEnum characterSubrace,
                    CharacterClass.CharacterClassesEnum characterClass, CharacterBackground.CharacterBackgroundsEnum characterBackground, List<CharacterAttributes.CharacterAttributesEnum> characterAttributes) {
        this.characterName = characterName;
        this.characterRace = CharacterRace.fromEnum(characterRace);
        this.characterSubrace = CharacterSubrace.fromEnum(characterSubrace);
        this.characterClass = CharacterClass.fromEnum(characterClass);
        this.characterBackground = CharacterBackground.fromEnum(characterBackground);
        this.characterAttributes = new CharacterAttributes(characterAttributes.toArray(new CharacterAttributes.CharacterAttributesEnum[0]));
    }

    public CharacterName getCharacterName() {
        return characterName;
    }

    private void setCharacterName() {
        characterName.setCharacterName();
    }

    public CharacterRace getCharacterRace() {
        return characterRace;
    }

    private void setCharacterRace() {
        characterRace.setCharacterRace();
    }

    public CharacterSubrace getCharacterSubrace() {
        return characterSubrace;
    }

    private void setCharacterSubrace(CharacterRace.CharacterRacesEnum characterRace) {
        characterSubrace.setCharacterSubrace(characterRace);
    }

    public CharacterClass getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass() {
        characterClass.setCharacterClass();
    }

    public CharacterBackground getCharacterBackground() {
        return characterBackground;
    }

    public void setCharacterBackground() {
        characterBackground.setCharacterBackground();
    }

    public CharacterAttributes getCharacterAttributes() {
        return characterAttributes;
    }

    public void setOriginCharacterAttributes() {
        characterAttributes.setOriginCharacterAttributes(attributesValues);
    }

    public void setCharacterAttributes() {
        characterAttributes.setCharacterAttributes();
    }

    //    private boolean isDead;
//    private String characterItems;
//    private String[] characterInventory;
//    private int characterGold = 0;
//    private int characterBaseHitPoints = 0;
//    private int characterWeight = 0;
//    private int characterArmorClass = 0;
//    private int characterCarryingCapacity = 40;
//    private double characterExperiencePoints = 0;
//    private int characterCampSupplies = 0;
//
//    private void addItemToInventory(String item) {
//        if (characterInventory == null) {
//            characterInventory = new String[]{item};
//        } else {
//            characterInventory = Arrays.copyOf(characterInventory, characterInventory.length + 1);
//            characterInventory[characterInventory.length - 1] = item;
//        }
//    }
//
//    public void setCharacterBaseHitPoints(int characterBaseHitPoints) {
//        this.characterBaseHitPoints = characterBaseHitPoints;
//    }
//
//    public void setCharacterCampSupplies(int characterCampSupplies) {
//        this.characterCampSupplies = characterCampSupplies;
//    }
//
//    public void setCharacterGold(int characterGold) {
//        this.characterGold = characterGold;
//    }
//
//    public void setCharacterWeight(int characterWeight) {
//        this.characterWeight = characterWeight;
//    }
//
//    public void setCharacterArmorClass(int characterArmorClass) {
//        this.characterArmorClass = characterArmorClass;
//    }
//
//    public void setCharacterCarryingCapacity(int characterCarryingCapacity) {
//        this.characterCarryingCapacity = characterCarryingCapacity;
//    }
//
//    public void setCharacterExperiencePoints(int CharacterExperiencePoints) {
//        this.characterExperiencePoints = characterExperiencePoints;
//    }
    public void createCharacter() {
        try {
            setCharacterName();
            setCharacterRace();
            setCharacterSubrace(characterRace.getCharacterRace());
            setCharacterClass();
            setCharacterBackground();
            setCharacterAttributes();

        } catch (IllegalArgumentException e) {
            System.out.println("Error... character creation failed.");
        }
    }

    public void displayCharacterInfo() {
        System.out.println("Character information for " + this.characterName.getCharacterName() + ": \n");
        System.out.println("Race: " + this.characterRace.getCharacterRace().getDisplayRace());
        if (this.characterSubrace.getCharacterSubrace() != CharacterSubrace.CharacterSubracesEnum.NONE) {
            System.out.println("Subrace: " + this.characterSubrace.getCharacterSubrace().getDisplaySubrace());
        }
        System.out.println("Class: " + this.characterClass.getCharacterClass().getDisplayClass());
        System.out.println("Background: " + this.characterBackground.getCharacterBackground().getDisplayBackground());
        System.out.println("\nAttributes: ");

        Map<CharacterAttributes.CharacterAttributesEnum, Integer> attributesMap = characterAttributes.getCharacterAttributes();
        for (Map.Entry<CharacterAttributes.CharacterAttributesEnum, Integer> attribute : attributesMap.entrySet()) {
            String attributeName = attribute.getKey().getDisplayAttribute();
            int attributeValue = attribute.getValue();
            System.out.printf("%s: %d%n", attributeName, attributeValue);
        }
    }
}
