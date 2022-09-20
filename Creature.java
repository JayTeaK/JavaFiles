public abstract class Creature {
    protected char creatureChar;
    abstract public int move(String str);
    abstract public int breed();
    abstract public char getChar();
    public int numZeroGet(String str) {
        int zeroCount = 0;
        for (int i = 0; i < 4; i++) {
            if (str.charAt(i) == '0') {
                zeroCount++;
            }
        }
        return zeroCount;
    }
}