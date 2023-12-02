import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class PlayerCharacter {
    static Scanner input = new Scanner(System.in);

    private final String name;
    private String race;
    private String subrace;
    private String cantrips;
    private String characterClass;
    private String background;
    private Map<String, Integer> abilities;

    public PlayerCharacter(String name) {
        this.name = name;
        this.abilities = new HashMap<>();
    }

    public void setRace(String race) {
        this.race = race;
    }

    public void setSubrace(String subrace) {
        this.subrace = subrace;
    }

    public void setCantrips(String cantrips) {
        this.cantrips = cantrips;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public void displayCharacterInfo() {
        System.out.println("Character information for " + name + ":\n");
        System.out.println("Race: \n" + race);
        System.out.println("Subrace: \n" + subrace);
        System.out.println("Cantrips: \n" + cantrips);
        System.out.println("Class: \n" + characterClass);
        System.out.println("Background: \n" + background);
        System.out.println("Abilities: \n");
        for (Map.Entry<String, Integer> entry : abilities.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static PlayerCharacter createPlayerCharacter() {

        System.out.print("Enter your name: \n");
        String playerName = input.nextLine();
        PlayerCharacter player = new PlayerCharacter(playerName);
        // Set race
        player.setRace(chooseOption("Race", Race.values()));

        // Set subrace
        if (player.race != null && player.race.equals("elf")) {
            player.setSubrace(chooseOption("Subrace", Subrace.values()));
        }
        // Set cantrips
        player.setCantrips(chooseOption("Cantrips", Cantrips.values()));
        // Set class
        player.setCharacterClass(chooseOption("Class", CharacterClass.values()));
        // Set background
        player.setBackground(chooseOption("Background", Background.values()));

        return player;
    }

    private static <T extends Enum<T>> String chooseOption(String prompt, T[] options) {
        System.out.println("Select your " + prompt + ": \n");
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
        int choice;
        do {
            System.out.print("Enter the number of your choice: ");
            choice = input.nextInt();
            input.nextLine();
        } while (choice < 1 || choice > options.length);

        return options[choice - 1].name().toLowerCase();
    }

    //Enumerations for races, subraces, classes, backgrounds, and cantrips
    enum Race {ELF, TIEFLING, HUMAN, GITHYANKI, DWARF, HALFLING, GNOME, DRAGONBORN, HALF_ORC}

    enum Subrace {HIGH_ELF, WOOD_ELF, DROW}

    enum Cantrips {
        ACID_SPLASH, BONE_CHILL, FIRE_BOLT, POISON_SPRAY, RAY_OF_FROST, SHOCKING_GRASP, BLADE_WARD, FRIENDS,
        DANCING_LIGHTS, LIGHT, MAGE_HAND, MINOR_ILLUSION, TRUE_STRIKE
    }

    enum CharacterClass {BARBARIAN, BARD, CLERIC, DRUID, FIGHTER, MONK, PALADIN, RANGER, ROGUE, SORCERER, WARLOCK, WIZARD}

    enum Background {
        ACOLYTE, CHARLATAN, CRIMINAL, ENTERTAINER, FOLK_HERO, GUILD_ARTISAN, NOBLE, OUTLANDER, SAGE, SOLDIER,
        URCHIN
    }
}
//    public PlayerCharacter(String name,
//                           int strength,
//                           int dexterity,
//                           int constitution,
//                           int intelligence,
//                           int wisdom,
//                           int charisma) {
//        this.name = name;
//        this.abilities = new HashMap<>();
//        this.abilities.put("Strength", strength);
//        this.abilities.put("Dexterity", dexterity);
//        this.abilities.put("Constitution", constitution);
//        this.abilities.put("Intelligence", intelligence);
//        this.abilities.put("Wisdom", wisdom);
//        this.abilities.put("Charisma", charisma);
//    }
//
//    public void displayAbilities() {
//        System.out.println("Abilities for " + name + ":");
//        for (Map.Entry<String, Integer> entry : abilities.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue());
//        }
//    }

//    public static void customCharacterRacePrompt(){
//        System.out.println("Enter your race: \n" + "1. Elf \n" + "2. Tiefling \n" + "3. Drow \n" + "4. Human \n" +
//                "5. Githyanki \n" + "6. Dwarf \n" + "7. Halfling \n" + "8. Gnome \n" + "9. Dragonborn \n" +
//                "10. Half-Orc \n");
//    }
//    public static PlayerCharacter createPlayerCharacter() {
//        Scanner input = new Scanner(System.in);
//
//        String customCharacterRace = "";
//        String customCharacterSubRace = "";
//        String customCharacterCantrips = "";
//        String customCharacterClass = "";
//        String customCharacterBackground = "";
//
//        while (true) {
//            customCharacterRacePrompt();
//            String customCharacterInput = input.nextLine().toLowerCase();
//            switch (customCharacterInput) { //BEGIN SWITCH
//                case "1":
//                case "elf":
//                    System.out.println("You chose Elf, is this correct?");
//                    customCharacterRace = "elf";
//                    break;
//                case "2":
//                case "tiefling":
//                    System.out.println("You chose Tiefling, is this correct?");
//                    customCharacterRace = "tiefling";
//                    break;
//                case "3":
//                case "drow":
//                    System.out.println("You chose Drow, is this correct?");
//                    customCharacterRace = "drow";
//                    break;
//                case "4":
//                case "human":
//                    System.out.println("You chose Human, is this correct?");
//                    customCharacterRace = "human";
//                    break;
//                case "5":
//                case "gith":
//                case "githyanki":
//                    System.out.println("You chose Githyanki, is this correct?");
//                    customCharacterRace = "githyanki";
//                    break;
//                case "6":
//                case "dwarf":
//                    System.out.println("You chose Dwarf, is this correct?");
//                    customCharacterRace = "dwarf";
//                    break;
//                case "7":
//                case "halfling":
//                    System.out.println("You chose Halfling, is this correct?");
//                    customCharacterRace = "halfling";
//                    break;
//                case "8":
//                case "gnome":
//                    System.out.println("You chose Gnome, is this correct?");
//                    customCharacterRace = "gnome";
//                    break;
//                case "9":
//                case "dragonborn":
//                    System.out.println("You chose Dragonborn, is this correct?");
//                    customCharacterRace = "dragonborn";
//                    break;
//                case "10":
//                case "half orc":
//                case "half-orc":
//                    System.out.println("You chose Half-Orc, is this correct?");
//                    customCharacterRace = "half-orc";
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please select a valid option.\n");
//                    continue;
//            } //END SWITCH
//            break; //Exits loop if valid choice is made.
//        } //END WHILE
//        return customCharacterRace;
//    }
