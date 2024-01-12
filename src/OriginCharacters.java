import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OriginCharacters {
    public static Humanoid originCharacters;
    public static Humanoid savaric;
    public static Humanoid baldwin;
    public static Humanoid ysoria;
    public static Humanoid aurelia;
    public static Humanoid otto;
    public static Humanoid chloe;
    public static Humanoid theOutcast;
    public static Humanoid custom;
    
    static List<CharacterAttributes.CharacterAttributesEnum> originCharacterAttributes = Arrays.asList(
            CharacterAttributes.CharacterAttributesEnum.STRENGTH,
            CharacterAttributes.CharacterAttributesEnum.DEXTERITY,
            CharacterAttributes.CharacterAttributesEnum.CONSTITUTION,
            CharacterAttributes.CharacterAttributesEnum.INTELLIGENCE,
            CharacterAttributes.CharacterAttributesEnum.WISDOM,
            CharacterAttributes.CharacterAttributesEnum.CHARISMA);

    public static Humanoid createSavaric() {
        Humanoid savaric = new Humanoid(
        new CharacterName("Savaric"),
            CharacterRace.CharacterRacesEnum.HUMAN,
            CharacterSubrace.CharacterSubracesEnum.NONE,
            CharacterClass.CharacterClassesEnum.BARBARIAN,
            CharacterBackground.CharacterBackgroundsEnum.CRIMINAL,
            originCharacterAttributes);

    Map<CharacterAttributes.CharacterAttributesEnum, Integer> attributesValues = new HashMap<>();
    attributesValues.put(CharacterAttributes.CharacterAttributesEnum.STRENGTH, 17);
    attributesValues.put(CharacterAttributes.CharacterAttributesEnum.DEXTERITY, 15);
    attributesValues.put(CharacterAttributes.CharacterAttributesEnum.CONSTITUTION, 15);
    attributesValues.put(CharacterAttributes.CharacterAttributesEnum.INTELLIGENCE, 10);
    attributesValues.put(CharacterAttributes.CharacterAttributesEnum.WISDOM, 10);
    attributesValues.put(CharacterAttributes.CharacterAttributesEnum.CHARISMA, 9);

        savaric.getCharacterAttributes().setOriginCharacterAttributes(attributesValues);

        OriginCharacters.savaric = savaric;

        return savaric;
    }
    public static Humanoid createBaldwin() {
        Humanoid baldwin = new Humanoid(
        new CharacterName("Baldwin"),
                CharacterRace.CharacterRacesEnum.DWARF,
                CharacterSubrace.CharacterSubracesEnum.SHIELD_DWARF,
                CharacterClass.CharacterClassesEnum.PALADIN,
                CharacterBackground.CharacterBackgroundsEnum.FOLK_HERO,
                originCharacterAttributes);

        Map<CharacterAttributes.CharacterAttributesEnum, Integer> attributesValues = new HashMap<>();
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.STRENGTH, 15);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.DEXTERITY, 10);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.CONSTITUTION, 15);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.INTELLIGENCE, 10);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.WISDOM, 15);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.CHARISMA, 10);

        baldwin.getCharacterAttributes().setOriginCharacterAttributes(attributesValues);

        OriginCharacters.baldwin = baldwin;

        return baldwin;
    }
    public static Humanoid createYsoria() {
        Humanoid ysoria = new Humanoid(
                new CharacterName("Ysoria"),
                CharacterRace.CharacterRacesEnum.ELF,
                CharacterSubrace.CharacterSubracesEnum.DARK_ELF,
                CharacterClass.CharacterClassesEnum.WARLOCK,
                CharacterBackground.CharacterBackgroundsEnum.CHARLATAN,
                originCharacterAttributes);

        Map<CharacterAttributes.CharacterAttributesEnum, Integer> attributesValues = new HashMap<>();
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.STRENGTH, 9);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.DEXTERITY, 13);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.CONSTITUTION, 15);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.INTELLIGENCE, 11);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.WISDOM, 10);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.CHARISMA, 17);

        ysoria.getCharacterAttributes().setOriginCharacterAttributes(attributesValues);

        OriginCharacters.ysoria = ysoria;

        return ysoria;
    }
    public static Humanoid createAurelia() {
        Humanoid aurelia = new Humanoid(
                new CharacterName("Aurelia"),
                CharacterRace.CharacterRacesEnum.GNOME,
                CharacterSubrace.CharacterSubracesEnum.ROCK_GNOME,
                CharacterClass.CharacterClassesEnum.ROGUE,
                CharacterBackground.CharacterBackgroundsEnum.URCHIN,
                originCharacterAttributes);

        Map<CharacterAttributes.CharacterAttributesEnum, Integer> attributesValues = new HashMap<>();
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.STRENGTH, 11);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.DEXTERITY, 17);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.CONSTITUTION, 15);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.INTELLIGENCE, 11);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.WISDOM, 10);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.CHARISMA, 11);

        aurelia.getCharacterAttributes().setOriginCharacterAttributes(attributesValues);

        OriginCharacters.aurelia = aurelia;

        return aurelia;
    }
    public static Humanoid createOtto() {
        Humanoid otto = new Humanoid(
                new CharacterName("Otto"),
                CharacterRace.CharacterRacesEnum.HALF_ELF,
                CharacterSubrace.CharacterSubracesEnum.HIGH_HALF_ELF,
                CharacterClass.CharacterClassesEnum.BARD,
                CharacterBackground.CharacterBackgroundsEnum.ENTERTAINER,
                originCharacterAttributes);

        Map<CharacterAttributes.CharacterAttributesEnum, Integer> attributesValues = new HashMap<>();
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.STRENGTH, 10);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.DEXTERITY, 15);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.CONSTITUTION, 15);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.INTELLIGENCE, 11);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.WISDOM, 10);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.CHARISMA, 14);

        otto.getCharacterAttributes().setOriginCharacterAttributes(attributesValues);

        OriginCharacters.otto = otto;

        return otto;
    }
    public static Humanoid createChloe() {
        Humanoid chloe = new Humanoid(
                new CharacterName("Chloe"),
                CharacterRace.CharacterRacesEnum.ELF,
                CharacterSubrace.CharacterSubracesEnum.WOOD_ELF,
                CharacterClass.CharacterClassesEnum.DRUID,
                CharacterBackground.CharacterBackgroundsEnum.OUTLANDER,
                originCharacterAttributes);

        Map<CharacterAttributes.CharacterAttributesEnum, Integer> attributesValues = new HashMap<>();
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.STRENGTH, 9);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.DEXTERITY, 13);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.CONSTITUTION, 15);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.INTELLIGENCE, 11);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.WISDOM, 17);
        attributesValues.put(CharacterAttributes.CharacterAttributesEnum.CHARISMA, 10);

        chloe.getCharacterAttributes().setOriginCharacterAttributes(attributesValues);

        OriginCharacters.chloe = chloe;

        return chloe;
    }
}
