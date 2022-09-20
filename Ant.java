public class Ant extends Creature {
    Ant(char _antChar) {
        creatureChar = _antChar;
    }
    
    public int move(String str) {
        return 1;
    }
    public int breed() {
        System.out.print("Breed");
        return 1;
    }
    public char getChar() {
        return creatureChar;
    }
}
