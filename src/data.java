// able to hold four types of data
public class data {
    // constants works as type tag
    public static final int INT = 1;
    public static final int SHORT = 2;
    public static final int FLOAT = 3;
    public static final int CHAR = 4;

    public int typeTag; // indicate which kind of data is hold as above
    private int intData;
    private short shortData;
    private float floatData;
    private char charData;

    public data(int input) {
        typeTag = INT;
        intData = input;
    }

    public data(short input) {
        typeTag = SHORT;
        shortData = input;
    }

    public data(float input) {
        typeTag = FLOAT;
        floatData = input;
    }

    public data(char input) {
        typeTag = CHAR;
        charData = input;
    }

    public int getInt() {
        if(typeTag != INT) {
            System.out.println("Type Mismatch!!");
        }
        return intData;
    }

    public short getShort() {
        if(typeTag != SHORT) {
            System.out.println("Type Mismatch!!");
        }
        return shortData;
    }

    public float getFloat() {
        if(typeTag != FLOAT) {
            System.out.println("Type Mismatch!!");
        }
        return floatData;
    }

    public char getChar() {
        if(typeTag != CHAR) {
            System.out.println("Type Mismatch!!");
        }
        return charData;
    }
}
