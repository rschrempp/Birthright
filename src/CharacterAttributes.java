import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharacterAttributes {
    private static final Map<CharacterAttributes.CharacterAttributesEnum, Integer> characterAttributes = new HashMap<>();
    private static final Scanner input = new Scanner(System.in);
    public enum CharacterAttributesEnum {
        STRENGTH("Strength"),
        DEXTERITY("Dexterity"),
        CONSTITUTION("Constitution"),
        INTELLIGENCE("Intelligence"),
        WISDOM("Wisdom"),
        CHARISMA("Charisma");
        private final String displayCharacterAttributes;

        CharacterAttributesEnum(String displayCharacterAttributes) {
            this.displayCharacterAttributes = displayCharacterAttributes;
        }
        public String getDisplayCharacterAttributes() {
            return displayCharacterAttributes;
        }
    }
    private static void initializeAttributes() {
        for (CharacterAttributesEnum attribute : CharacterAttributesEnum.values()) {
            CharacterAttributes.characterAttributes.put(attribute, 8);
        }
    }
    public static Map<CharacterAttributesEnum, Integer> getCharacterAttributes() {
        setCharacterAttributes();
        return characterAttributes;
    }
    private static void setCharacterAttributes() {
        initializeAttributes();
        int maxTotalAttributePoints = 27;

        do  {
            System.out.println("Character Attributes: ");
            System.out.println(" ");
            System.out.println("Remaining points: " + maxTotalAttributePoints);
            System.out.println(" ");
            printChosenAttributes();
            System.out.println("Choose an attribute to increase or decrease (minimum 8, maximum 17): \n");
            System.out.println("\nEnter attribute to change (or 'done' to finish): \n");
            String userInput = CharacterAttributes.input.nextLine().toUpperCase().trim();

            if (userInput.equalsIgnoreCase("done")) {
                break;
            }

            try {
                do {
                    CharacterAttributesEnum chosenAttribute = CharacterAttributesEnum.valueOf(userInput);
                    System.out.println("Enter points to add (positive) or subtract (negative) to " +
                            chosenAttribute.displayCharacterAttributes + ": ");
                    int attributePointsToAddOrSubtract = Integer.parseInt(CharacterAttributes.input.nextLine());
                    if (CharacterAttributes.characterAttributes.containsKey(chosenAttribute)) {
                        int currentAttributePoints = CharacterAttributes.characterAttributes.get(chosenAttribute);
                        int newAttributePoints = currentAttributePoints + attributePointsToAddOrSubtract;

                        if (newAttributePoints >= 8 && newAttributePoints <= 17 && maxTotalAttributePoints - attributePointsToAddOrSubtract >= 0) {
                            CharacterAttributes.characterAttributes.put(chosenAttribute, newAttributePoints);
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

    private static void printChosenAttributes() {
        for (CharacterAttributesEnum attribute : CharacterAttributesEnum.values()) {
            System.out.println(attribute.displayCharacterAttributes + ": " + CharacterAttributes.characterAttributes.get(attribute));
        }
        System.out.println();
    }
}
