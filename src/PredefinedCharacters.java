import java.util.Arrays;
import java.util.List;

public class PredefinedCharacters {
    private final List<CharacterAttributes.CharacterAttributesEnum> attributes = null;
    public Humanoid predefinedCharacters;


    static List<CharacterAttributes.CharacterAttributesEnum> savaricAttributes = Arrays.asList(CharacterAttributes.CharacterAttributesEnum.STRENGTH,
            CharacterAttributes.CharacterAttributesEnum.DEXTERITY, CharacterAttributes.CharacterAttributesEnum.CONSTITUTION,
            CharacterAttributes.CharacterAttributesEnum.INTELLIGENCE, CharacterAttributes.CharacterAttributesEnum.WISDOM, CharacterAttributes.CharacterAttributesEnum.CHARISMA);
    static Humanoid savaric = new Humanoid(new CharacterName("Savaric"), CharacterRace.CharacterRacesEnum.HUMAN, CharacterSubrace.CharacterSubracesEnum.NONE,
            CharacterClass.CharacterClassesEnum.BARBARIAN, CharacterBackground.CharacterBackgroundsEnum.CRIMINAL, savaricAttributes);

    public static Humanoid createSavaric() {
        new Humanoid(new CharacterName("Savaric"), CharacterRace.CharacterRacesEnum.HUMAN, CharacterSubrace.CharacterSubracesEnum.NONE,
                CharacterClass.CharacterClassesEnum.BARBARIAN, CharacterBackground.CharacterBackgroundsEnum.CRIMINAL, savaricAttributes);

        return savaric;
    }
}
