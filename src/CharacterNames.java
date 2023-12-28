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
            System.out.println("Enter your name (alphabetic characters, max length 24): \n");
            characterName = input.nextLine();
            isValid = characterName.matches("[a-zA-Z\\s']+") && characterName.length() <= 24;

            if (!isValid) {
                System.out.println("Invalid name. Please enter a valid name. ");
            }
        } while (!isValid);
    }
}
