import java.util.Scanner;

public class CharacterName {
    private String characterName;
    private final Scanner input = new Scanner(System.in);

    public CharacterName(String characterName) {
        this.characterName = characterName;
    }

    public CharacterName() {

    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName() {
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

