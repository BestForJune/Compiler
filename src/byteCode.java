import javax.xml.crypto.Data;

// import sun.awt.image.ByteBandedRaster;

import java.io.DataOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Stack;
import java.nio.ByteBuffer;

public class byteCode {
    // private DataOutputStream output;
    private int stackPointer; //points to last item pushed in
    private int programCounter; //points to last byte written
    private Stack<Integer> frameStack; //points to first item in the frame
    private ArrayList<Byte> output;
    public byteCode() {
        stackPointer = -1;
        programCounter = -1;
        output = new ArrayList<>();
        frameStack = new Stack<Integer>();
        frameStack.push(0);
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
        output.add((byte)132));
        programCounter++;
        stackPointer--;
    }

    public void cmplt() throws IOException {
        output.add((byte)136);
        programCounter++;
        stackPointer--;
    }

    public void cmpgt() throws IOException {
        output.add((byte)140);
        programCounter++;
        stackPointer--;
    }

    public void jmp() throws IOException {
        output.add((byte)36);
        programCounter++;
        stackPointer--;
    }

    public void jmpc() throws IOException {
        output.add((byte)40);
        programCounter++;
        stackPointer -= 2;
    }

    //val is the last item pushed into stack
    public void call(int val) throws IOException {
        output.add((byte)44);
        programCounter++;
        frameStack.push(stackPointer - val - 1);
        stackPointer -= 2; //???
        // pc??
    }

    public void ret() throws IOException {
        output.add((byte)48);
        programCounter++;
        stackPointer = frameStack.pop();
        stackPointer--;
    }

    public void pushc(char data) throws IOException {
        output.add((byte)68);
        output.add((byte)data);
        programCounter += 2;
        stackPointer++;
    }

    public void pushs(short data) throws IOException {
        output.add((byte)69);
        ByteBuffer buf = ByteBuffer.allocate(2);
        buf.putShort(data);
        buf.flip();
        byte[] arr = buf.array();
        for (byte each: arr){
            output.add(each);
        }
        programCounter += 3;
        stackPointer++;
    }

    public void pushi(int data) throws IOException {
        output.add((byte)70);
        ByteBuffer buf = ByteBuffer.allocate(4);
        buf.putInt(data);
        buf.flip();
        byte[] arr = buf.array();
        for (byte each: arr){
            output.add(each);
        }
        programCounter += 5;
        stackPointer++;
    }

    public void pushf(float data) throws IOException {
        output.add((byte)71);
        ByteBuffer buf = ByteBuffer.allocate(4);
        buf.putFloat(data);
        buf.flip();
        byte[] arr = buf.array();
        for (byte each: arr){
            output.add(each);
        }
        programCounter += 5;
        stackPointer++;
    }

    public void pushvc() throws IOException {
        output.add((byte)72);
        programCounter++;
        //stackPointer?
    }

    public void pushvs() throws IOException {
        output.add((byte)73);
        programCounter++;
        //stackPointer?
    }

    public void pushvi() throws IOException {
        output.add((byte)74);
        programCounter++;
        //stackPointer?
    }

    public void pushvf() throws IOException {
        output.add((byte)75);
        programCounter++;
        //stackPointer?
    }

    //val is the number of items to be discarded
    public void popm(int val) throws IOException {
        output.add((byte)76);
        programCounter++;
        stackPointer -= val + 1; //including the top item number indicater
    }

    public void popv() throws IOException {
        output.add((byte)80);
        programCounter++;
        stackPointer -= 2;
    }

    //val is the number of item to be kept
    public void popa(int val) throws IOException {
        output.add((byte)77);
        programCounter++;
        stackPointer = frameStack.peek() + val - 1;
    }

    public void peekc() throws IOException {
        output.add((byte)84);
        programCounter++;
    }

    public void peeks() throws IOException {
        output.add((byte)85);
        programCounter++;
    }

    public void peeki() throws IOException {
        output.add((byte)86);
        programCounter++;
    }

    public void peekf() throws IOException {
        output.add((byte)87);
        programCounter++;
    }

    public void pokec() throws IOException {
        output.add((byte)88);
        programCounter++;
    }

    public void pokes() throws IOException {
        output.add((byte)89);
        programCounter++;
    }

    public void pokei() throws IOException {
        output.add((byte)90);
        programCounter++;
    }

    public void pokef() throws IOException {
        output.add((byte)91);
        programCounter++;
    }

    public void swp() throws IOException {
        output.add((byte)94);
        programCounter++;
    }

    public void add((byte)) throws IOException {
        output.add((byte)100);
        programCounter++;
        stackPointer--;
    }

    public void sub() throws IOException {
        output.add((byte)104);
        programCounter++;
        stackPointer--;
    }

    public void mul() throws IOException {
        output.add((byte)108);
        programCounter++;
        stackPointer--;
    }

    public void div() throws IOException {
        output.add((byte)112);
        programCounter++;
        stackPointer--;
    }

    public void printc() throws IOException {
        output.add((byte)144);
        programCounter++;
        stackPointer--;
    }

    public void prints() throws IOException {
        output.add((byte)145);
        programCounter++;
        stackPointer--;
    }

    public void printi() throws IOException {
        output.add((byte)146);
        programCounter++;
        stackPointer--;
    }

    public void printf() throws IOException {
        output.add((byte)147);
        programCounter++;
        stackPointer--;
    }

    public void halt() throws IOException {
        output.add((byte)0);
        programCounter++;
    }
}
