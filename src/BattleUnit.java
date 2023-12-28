import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map.Entry;

public class BattleUnit {
    private static Scanner input = new Scanner(System.in);
    private String characterName;
    private CharacterRacesAndSubraces.CharacterRacesEnum characterRace;
    private CharacterRacesAndSubraces.CharacterSubracesEnum characterSubrace;
    private CharacterClasses.CharacterClassesEnum characterClass;
    private CharacterBackgrounds.CharacterBackgroundsEnum characterBackground;
    private Map<CharacterAttributes.CharacterAttributesEnum, Integer> characterAttributes;

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }
    public void setCharacterRace(CharacterRacesAndSubraces.CharacterRacesEnum characterRace) {
        this.characterRace = characterRace;
    }
    public void setCharacterSubrace(CharacterRacesAndSubraces.CharacterSubracesEnum characterSubrace) {
        this.characterSubrace = characterSubrace;
    }
    public void setCharacterClass(CharacterClasses.CharacterClassesEnum characterClass) {
        this.characterClass = characterClass;
    }
    public void setCharacterBackground(CharacterBackgrounds.CharacterBackgroundsEnum characterBackground) {
        this.characterBackground = characterBackground;
    }
    public void setCharacterAttributes(Map<CharacterAttributes.CharacterAttributesEnum, Integer> characterAttributes) {
        this.characterAttributes = characterAttributes;
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

    public BattleUnit createCharacter() {
        BattleUnit character = new BattleUnit();
try {
    character.setCharacterName(CharacterNames.getCharacterName());
    character.setCharacterRace(CharacterRacesAndSubraces.getCharacterRace());
    character.setCharacterSubrace(CharacterRacesAndSubraces.getCharacterSubrace());
    character.setCharacterClass(CharacterClasses.getCharacterClass());
    character.setCharacterBackground(CharacterBackgrounds.getCharacterBackground());
    character.setCharacterAttributes(CharacterAttributes.getCharacterAttributes());
    displayCharacterInfo(character);
} catch (IllegalArgumentException e) {
    System.out.println("Error... character creation failed.");
}
        return character;
    }

    public void displayCharacterInfo(BattleUnit character) {
        System.out.println("Character information for " + CharacterNames.getCharacterName() + ": \n");
        System.out.println("Race: " + CharacterRacesAndSubraces.getCharacterRace());
        System.out.println("Subrace: " + CharacterRacesAndSubraces.getCharacterSubrace());
        System.out.println("Class: " + CharacterClasses.getCharacterClass());
        System.out.println("Background: " + CharacterBackgrounds.getCharacterBackground());
        System.out.println("Attributes: " + CharacterAttributes.getCharacterAttributes());
        }
    }