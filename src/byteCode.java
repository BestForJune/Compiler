import javax.xml.crypto.Data;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Stack;

public class byteCode {
    private DataOutputStream output;
    private int stackPointer; //points to last item pushed in
    private int programCounter; //points to last byte written
    private Stack<Integer> frameStack; //points to first item in the frame
    public byteCode(DataOutputStream out) {
        stackPointer = -1;
        programCounter = -1;
        output = out;
        frameStack = new Stack<Integer>();
    }

    public int getPC() { //get program counter
        return programCounter;
    }

    public int getStackPointer() {
        return stackPointer;
    }

    public int getfsp () { // get top frame stack pointer
        return frameStack.peek();
    }

    public void cmpe() throws IOException {
        output.writeByte(132);
        programCounter++;
        stackPointer--;
    }

    public void cmplt() throws IOException {
        output.writeByte(136);
        programCounter++;
        stackPointer--;
    }

    public void cmpgt() throws IOException {
        output.writeByte(140);
        programCounter++;
        stackPointer--;
    }

    public void jmp() throws IOException {
        output.writeByte(36);
        programCounter++;
        stackPointer--;
    }

    public void jmpc() throws IOException {
        output.writeByte(40);
        programCounter++;
        stackPointer -= 2;
    }

    //val is the last item pushed into stack
    public void call(int val) throws IOException {
        output.writeByte(44);
        programCounter++;
        frameStack.push(stackPointer - val - 1);
        stackPointer -= 2; //???
        // pc??
    }

    public void ret() throws IOException {
        output.writeByte(48);
        programCounter++;
        stackPointer = frameStack.pop();
        stackPointer--;
    }

    public void pushc(char data) throws IOException {
        output.writeByte(68);
        output.writeByte(data);
        programCounter += 2;
        stackPointer++;
    }

    public void pushs(short data) throws IOException {
        output.writeByte(69);
        output.writeShort(data);
        programCounter += 3;
        stackPointer++;
    }

    public void pushi(int data) throws IOException {
        output.writeByte(70);
        output.writeInt(data);
        programCounter += 5;
        stackPointer++;
    }

    public void pushf(float data) throws IOException {
        output.writeByte(71);
        output.writeFloat(data);
        programCounter += 5;
        stackPointer++;
    }

    public void pushvc() throws IOException {
        output.writeByte(72);
        programCounter++;
        //stackPointer?
    }

    public void pushvs() throws IOException {
        output.writeByte(73);
        programCounter++;
        //stackPointer?
    }

    public void pushvi() throws IOException {
        output.writeByte(74);
        programCounter++;
        //stackPointer?
    }

    public void pushvf() throws IOException {
        output.writeByte(75);
        programCounter++;
        //stackPointer?
    }

    //val is the number of items to be discarded
    public void popm(int val) throws IOException {
        output.writeByte(76);
        programCounter++;
        stackPointer -= val + 1; //including the top item number indicater
    }

    public void popv() throws IOException {
        output.writeByte(80);
        programCounter++;
        stackPointer -= 2;
    }

    //val is the number of item to be kept
    public void popa(int val) throws IOException {
        output.writeByte(77);
        programCounter++;
        stackPointer = frameStack.peek() + val - 1;
    }

    public void peekc() throws IOException {
        output.writeByte(84);
        programCounter++;
    }

    public void peeks() throws IOException {
        output.writeByte(85);
        programCounter++;
    }

    public void peeki() throws IOException {
        output.writeByte(86);
        programCounter++;
    }

    public void peekf() throws IOException {
        output.writeByte(87);
        programCounter++;
    }

    public void pokec() throws IOException {
        output.writeByte(88);
        programCounter++;
    }

    public void pokes() throws IOException {
        output.writeByte(89);
        programCounter++;
    }

    public void pokei() throws IOException {
        output.writeByte(90);
        programCounter++;
    }

    public void pokef() throws IOException {
        output.writeByte(91);
        programCounter++;
    }

    public void swp() throws IOException {
        output.writeByte(94);
        programCounter++;
    }

    public void add() throws IOException {
        output.writeByte(100);
        programCounter++;
        stackPointer--;
    }

    public void sub() throws IOException {
        output.writeByte(104);
        programCounter++;
        stackPointer--;
    }

    public void mul() throws IOException {
        output.writeByte(108);
        programCounter++;
        stackPointer--;
    }

    public void div() throws IOException {
        output.writeByte(112);
        programCounter++;
        stackPointer--;
    }

    public void printc() throws IOException {
        output.writeByte(144);
        programCounter++;
        stackPointer--;
    }

    public void prints() throws IOException {
        output.writeByte(145);
        programCounter++;
        stackPointer--;
    }

    public void printi() throws IOException {
        output.writeByte(146);
        programCounter++;
        stackPointer--;
    }

    public void printf() throws IOException {
        output.writeByte(147);
        programCounter++;
        stackPointer--;
    }

    public void halt() throws IOException {
        output.writeByte(0);
        programCounter++;
    }
}
