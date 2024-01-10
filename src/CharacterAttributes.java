import java.util.*;

public class CharacterAttributes {
    private CharacterAttributesEnum characterAttributes;
    private final List<CharacterAttributesEnum> attributes;
    private static final Map<CharacterAttributesEnum, Integer> attributesMap = initializeAttributesMap();
    private static final Scanner input = new Scanner(System.in);

    public CharacterAttributes(CharacterAttributesEnum... characterAttributes) {this.attributes = Arrays.asList(attributes); }
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

    private static Map<CharacterAttributesEnum, Integer> initializeAttributesMap() {
        Map<CharacterAttributesEnum, Integer> attributesMap = new HashMap<>();
        for (CharacterAttributesEnum attribute : CharacterAttributesEnum.values()) {
            attributesMap.put(attribute, 8);
        }
        return attributesMap;
    }

    public CharacterAttributesEnum getCharacterAttributes() {
        return characterAttributes;
    }

    public void setCharacterAttributes() {
        CharacterAttributesEnum finalAttributeSelection = null;
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

            if (userInput.equalsIgnoreCase("done") && maxTotalAttributePoints == 0) {
                break;
            }

            try {
                if (attributesMap.containsKey(CharacterAttributesEnum.valueOf(userInput.toUpperCase()))) {
                    finalAttributeSelection = CharacterAttributesEnum.valueOf(userInput.toUpperCase());
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
        characterAttributes = finalAttributeSelection;
    }

    private static void printChosenAttributes() {
        for (CharacterAttributesEnum attribute : CharacterAttributesEnum.values()) {
            System.out.println(attribute + ": " + attributesMap.get(attribute));
        }
        System.out.println();
    }
}
