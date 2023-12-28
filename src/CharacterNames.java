import java.util.Scanner;

public class CharacterNames {
    private static String characterName;
    private static final Scanner input = new Scanner(System.in);

    public static String getCharacterName() {
        setCharacterName();
        return characterName;
    }
    private static void setCharacterName() {
        boolean isValid;
        do {
            System.out.println("Enter your name (alphabetic characters, max length 28): \n");
            characterName = input.nextLine().stripLeading().stripTrailing();
            isValid = characterName.matches("[a-zA-Z',-]+(?:\\s[a-zA-Z',-]+)*") && characterName.length() <= 28;

            if (!isValid) {
                System.out.println("Invalid name. Please enter a valid name. ");
            }
        } while (!isValid);
    }
}
