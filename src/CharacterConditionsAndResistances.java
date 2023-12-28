
public class CharacterConditionsAndResistances {
    private String characterConditions;
    private String characterResistances;

    public String getCharacterConditions() {
        setCharacterConditions();
        return characterConditions;
    }
    private boolean setCharacterConditions() {

        boolean characterBlinded = false;
        boolean characterCharmed = false;
        boolean characterCursed = false;
        boolean characterDiseased = false;
        boolean characterFrightened = false;
        boolean characterIncapacitated = false;
        boolean characterMaimed = false;
        boolean characterPoisoned = false;
        boolean characterPolymorphed = false;
        boolean characterProne = false;
        boolean characterUnconscious = false;

        return false;
    }
    public String getCharacterResistances() {
        setCharacterResistances();
        return characterResistances;
    }
    private void setCharacterResistances() {
        // int = 5 immune, 4 = 50% resist, 3 = 25% resist, 2 = normal, 1 = 25% vulnerable, 0 = 50% vulnerable

        int characterBludgeoningResistance = 2;
        int characterPiercingResistance = 2;
        int characterSlashingResistance = 2;
        int characterFireResistance = 2;
        int characterColdResistance = 2;
        int characterLightningResistance = 2;
        int characterThunderResistance = 2;
        int characterAcidResistance = 2;
        int characterPoisonResistance = 2;
        int characterRadiantResistance = 2;
        int characterNecroticResistance = 2;
        int characterForceResistance = 2;
        int characterPsychicResistance = 2;

    }

}
