import java.util.*;

public class CharacterRaceMap {
    public static final Map<CharacterRace.CharacterRacesEnum, List<CharacterSubrace.CharacterSubracesEnum>> subracesMap = new EnumMap<>(CharacterRace.CharacterRacesEnum.class);

    static {
        initializeSubracesMap();
    }

    public static void initializeSubracesMap() {

        subracesMap.put(CharacterRace.CharacterRacesEnum.ELF, Arrays.asList(CharacterSubrace.CharacterSubracesEnum.HIGH_ELF,
                CharacterSubrace.CharacterSubracesEnum.WOOD_ELF, CharacterSubrace.CharacterSubracesEnum.DARK_ELF));

//        subracesMap.put(CharacterRace.CharacterRacesEnum.TIEFLING, Arrays.asList(CharacterSubrace.CharacterSubracesEnum.ASMODEUS,
//                CharacterSubrace.CharacterSubracesEnum.MEPHISTOPHELES, CharacterSubrace.CharacterSubracesEnum.ZARIEL));

//        subracesMap.put(CharacterRace.CharacterRacesEnum.DROW, Arrays.asList(CharacterSubrace.CharacterSubracesEnum.LOLTH_SWORN,
//                CharacterSubrace.CharacterSubracesEnum.SELDARINE));

        subracesMap.put(CharacterRace.CharacterRacesEnum.DWARF, Arrays.asList(CharacterSubrace.CharacterSubracesEnum.GOLD_DWARF,
                CharacterSubrace.CharacterSubracesEnum.SHIELD_DWARF, CharacterSubrace.CharacterSubracesEnum.DUERGAR));

        subracesMap.put(CharacterRace.CharacterRacesEnum.HALF_ELF, Arrays.asList(CharacterSubrace.CharacterSubracesEnum.HIGH_HALF_ELF,
                CharacterSubrace.CharacterSubracesEnum.WOOD_HALF_ELF, CharacterSubrace.CharacterSubracesEnum.DARK_HALF_ELF));

        subracesMap.put(CharacterRace.CharacterRacesEnum.HALFLING, Arrays.asList(CharacterSubrace.CharacterSubracesEnum.LIGHTFOOT_HALFLING,
                CharacterSubrace.CharacterSubracesEnum.STRONGHEART_HALFLING));

        subracesMap.put(CharacterRace.CharacterRacesEnum.GNOME, Arrays.asList(CharacterSubrace.CharacterSubracesEnum.ROCK_GNOME,
                CharacterSubrace.CharacterSubracesEnum.FOREST_GNOME, CharacterSubrace.CharacterSubracesEnum.DEEP_GNOME));

//        subracesMap.put(CharacterRace.CharacterRacesEnum.DRAGONBORN, Arrays.asList(CharacterSubrace.CharacterSubracesEnum.BLACK_DRAGONBORN,
//                CharacterSubrace.CharacterSubracesEnum.BLUE_DRAGONBORN, CharacterSubrace.CharacterSubracesEnum.BRONZE_DRAGONBORN,
//                CharacterSubrace.CharacterSubracesEnum.COPPER_DRAGONBORN, CharacterSubrace.CharacterSubracesEnum.GOLD_DRAGONBORN,
//                CharacterSubrace.CharacterSubracesEnum.GREEN_DRAGONBORN, CharacterSubrace.CharacterSubracesEnum.RED_DRAGONBORN,
//                CharacterSubrace.CharacterSubracesEnum.SILVER_DRAGONBORN, CharacterSubrace.CharacterSubracesEnum.WHITE_DRAGONBORN));

        subracesMap.put(CharacterRace.CharacterRacesEnum.HUMAN, List.of(CharacterSubrace.CharacterSubracesEnum.NONE));
//        subracesMap.put(CharacterRace.CharacterRacesEnum.GITHYANKI, List.of(CharacterSubrace.CharacterSubracesEnum.NONE));
        subracesMap.put(CharacterRace.CharacterRacesEnum.HALF_ORC, List.of(CharacterSubrace.CharacterSubracesEnum.NONE));

    }
    public void addSubraces(CharacterRace.CharacterRacesEnum race, List<CharacterSubrace.CharacterSubracesEnum> subraces) {
        if (!Arrays.asList(CharacterRace.CharacterRacesEnum.values()).contains(race)) {
            throw new IllegalArgumentException("Invalid race: " + race);
        }
        subracesMap.put(race, subraces);
    }
public static List<CharacterSubrace.CharacterSubracesEnum> getSubraces(CharacterRace.CharacterRacesEnum characterRace) {
    return subracesMap.get(characterRace);
}
public static Map<CharacterRace.CharacterRacesEnum, List<CharacterSubrace.CharacterSubracesEnum>> getAllSubracesMap() {
        return Collections.unmodifiableMap(subracesMap);
}
}