import java.util.Random;
public class DnDCharacter {
    int strength = ability();
    int dexterity = ability();
    int constitution = ability();
    int intelligence = ability();
    int wisdom = ability();
    int charisma = ability();

    int modifier(double n) {
        return (int) Math.floor((n - 10) / 2);
    }
    int ability() {
        Random rand = new Random();
        int min = 7, s = 0;
        for (int i = 0; i < 4; i++) {
            int curr = 1 + rand.nextInt(6);
            if (curr < min) min = curr;
            s += curr;
        }
        return s - min;
    }
    int getStrength() { return strength; }
    int getDexterity() { return dexterity; }
    int getConstitution() { return constitution; }
    int getIntelligence() { return intelligence; }
    int getWisdom() { return wisdom; }
    int getCharisma() { return charisma; }
    int getHitpoints() { return 10 + modifier(getConstitution()); }
}