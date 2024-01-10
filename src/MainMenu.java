    import java.util.Scanner;
    public class MainMenu {
        private static Scanner input = new Scanner(System.in);
        public static void mainMenuOptions() {
            displayMainMenu();
            getUserChoice();
        }

        public enum MainMenuOptions {
            CONTINUE_GAME("Continue"),
            NEW_GAME("New Game"),
            LOAD_GAME("Load Game"),
            QUIT_GAME("Quit Game");

            private final String displayOptions;

            MainMenuOptions(String displayOptions) {
                this.displayOptions = displayOptions;
            }

            public String getDisplayOptions() {
                return displayOptions;
            }
        }

        public static void displayMainMenu() {
            System.out.println("Welcome to Birthright. Please select one of the following options to continue: ");
            for (MainMenuOptions option : MainMenuOptions.values()) {
                System.out.println(option.ordinal() + 1 + ".) " + option.displayOptions);
            }
        }

        public static void getUserChoice() {
            do {
                String userChoice = input.nextLine().trim();

                if (userChoice.matches("\\d")) {
                    int integerChoice = Integer.parseInt(userChoice);
                    if (integerChoice >= 1 && integerChoice <= MainMenuOptions.values().length) {
                        choiceFromEnum(MainMenuOptions.values()[integerChoice - 1]); //until input validation added
                        return;
                    } else {
                        System.out.println("Invalid choice. Please enter a valid number. \n");
                    }
                } else {
                    try {
                        MainMenuOptions selectedOption = MainMenuOptions.valueOf(userChoice.toUpperCase().replace("-", "_").replace(" ", "_"));
                         choiceFromEnum(selectedOption);
                         return;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid choice. Please enter a valid choice. \n");
                    }
                }
            } while (true);
        }
        public static void choiceFromEnum(MainMenuOptions userChoice) {
            switch (userChoice) {
                case CONTINUE_GAME:
                    System.out.println("This is a placeholder statement. Continuing game...");
                    return;
                case NEW_GAME:
                    NewGame.newGameStart();
                case LOAD_GAME:
                    System.out.println("This is a placeholder statement. Loading game...");
                    return;
                case QUIT_GAME:
                    System.out.println("This is a placeholder statement. Quitting game...");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }