    import java.util.Scanner;
    public class MainMenu { //BEGIN MainMenu
    static Scanner input = new Scanner(System.in);
    public static void introductoryMessage() { //BEGIN introductoryMessage()
    System.out.println("\nWelcome to Chronicles of Faerûn! Please select one of the following options to continue.\n");
    System.out.println("1. Continue\n" + "2. New Game\n" + "3. Load Game\n" + "4. Quit\n");
    } //END introductoryMessage()
    public static String mainMenuOptions() { //BEGIN mainMenuOptions
    String userInput = "";
    while (true) {
    introductoryMessage();
    String mainMenuOptions = input.nextLine().toLowerCase();
    switch (mainMenuOptions) { //BEGIN SWITCH
        case "1":
        case "continue":
        case "continue game":
            System.out.println("Launching game...\n");
        userInput = "continue";
            break;
        case "2":
        case "new":
        case "new game":
        System.out.println("Starting a new game...\n");
        userInput = "new game";
        NewGame.newGameIntroduction();
        NewGame.newCharacterPrompt();
            break;
        case "3":
        case "load":
        case "load game":
            System.out.println("Loading game...\n");
        userInput = "load game";
            break;
        case "4":
        case "quit":
        case "quit game":
            System.out.println("Quitting game...\n");
        userInput = "quit game";
            break;
        default:
    System.out.println("Invalid choice. Please select a valid option.");
        continue;
    } //END SWITCH
    break; //Exits loop if valid choice is made.
    } //END WHILE
    return userInput;
    } //END mainMenuOptions()
    } //END MainMenu




