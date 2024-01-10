import java.util.*;

public class CharacterAttributes {
    private LinkedHashMap<CharacterAttributesEnum, Integer> attributesMap = initializeAttributesMap();
    private static final Scanner input = new Scanner(System.in);

    public CharacterAttributes(CharacterAttributesEnum... attributes) {this.attributesMap = initializeAttributesMap(); }
    public CharacterAttributes() {

}
public enum CharacterAttributesEnum {
    STRENGTH("Strength"),
    DEXTERITY("Dexterity"),
    CONSTITUTION("Constitution"),
    INTELLIGENCE("Intelligence"),
    WISDOM("Wisdom"),
    CHARISMA("Charisma");

    private final String displayAttributeEnum;
    CharacterAttributesEnum(String displayAttribute) {displayAttributeEnum = displayAttribute; }
    public String getDisplayAttribute() { return displayAttributeEnum; }
}

    private LinkedHashMap<CharacterAttributesEnum, Integer> initializeAttributesMap() {
        LinkedHashMap<CharacterAttributesEnum, Integer> attributesMap = new LinkedHashMap<>();
        for (CharacterAttributesEnum attribute : CharacterAttributesEnum.values()) {
            attributesMap.put(attribute, 8);
        }
        return attributesMap;
    }

    public Map<CharacterAttributesEnum, Integer> getCharacterAttributes() {
        return attributesMap;
    }

    public void setOriginCharacterAttributes(Map<CharacterAttributesEnum, Integer> attributesValues) {
        attributesMap.putAll(attributesValues);
    }
    public void setCharacterAttributes() {
        int maxTotalAttributePoints = 27;

        do {
            System.out.println("Character Attributes: ");
            System.out.println(" ");
            System.out.println("Remaining points: " + maxTotalAttributePoints);
            System.out.println(" ");
            printChosenAttributes();
            System.out.println("Choose an attribute to increase or decrease (minimum 8, maximum 17): \n");
            System.out.println("\nEnter attribute to change (or 'done' to finish): \n");
            String userInput = input.nextLine().trim();

            if (userInput.equalsIgnoreCase("done")) {
                break;
            }

            try {
                if (attributesMap.containsKey(CharacterAttributesEnum.valueOf(userInput.toUpperCase()))) {
                    int currentAttributePoints = attributesMap.get(CharacterAttributesEnum.valueOf(userInput.toUpperCase()));
                    System.out.println("Enter points to add (positive) or subtract (negative) to " + userInput + ": ");
                    int attributePointsToAddOrSubtract = Integer.parseInt(input.nextLine());
                    int newAttributePoints = currentAttributePoints + attributePointsToAddOrSubtract;

                    if (newAttributePoints >= 8 && newAttributePoints <= 17 && maxTotalAttributePoints - attributePointsToAddOrSubtract >= 0) {
                        attributesMap.put(CharacterAttributesEnum.valueOf(userInput.toUpperCase()), newAttributePoints);
                        maxTotalAttributePoints -= attributePointsToAddOrSubtract;
                    } else {
                        System.out.println("Invalid input. Attributes must stay between 8 and 17, and check remaining points. ");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid attribute and points. ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid attribute and points.");
            }
        } while (maxTotalAttributePoints != 0);
    }

    private void printChosenAttributes() {
        for (CharacterAttributesEnum attribute : CharacterAttributesEnum.values()) {
            String attributeDisplayName = attribute.getDisplayAttribute();
            System.out.println(attributeDisplayName + ": " + attributesMap.get(attribute));
        }
        System.out.println();
    }
}
