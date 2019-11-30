import javax.xml.crypto.Data;
import java.io.DataOutputStream;
import java.io.IOException;

public class byteCode {
    DataOutputStream output;
    public byteCode(DataOutputStream out) {
        output = out;
    }

    public void cmpe() throws IOException {
        output.writeByte(132);
    }

    public void cmplt() throws IOException {
        output.writeByte(136);
    }

    public void cmpgt() throws IOException {
        output.writeByte(140);
    }

    public void jmp() throws IOException {
        output.writeByte(36);
    }

    public void jmpc() throws IOException {
        output.writeByte(40);
    }

    public void call() throws IOException {
        output.writeByte(44);
    }

    public void ret() throws IOException {
        output.writeByte(48);
    }

    public void pushc(char data) throws IOException {
        output.writeByte(68);
        output.writeByte(data);
    }

    public void pushs(short data) throws IOException {
        output.writeByte(69);
        output.writeShort(data);
    }

    public void pushi(int data) throws IOException {
        output.writeByte(70);
        output.writeInt(data);
    }

    public void pushf(float data) throws IOException {
        output.writeByte(71);
        output.writeFloat(data);
    }

    public void pushvc() throws IOException {
        output.writeByte(72);
    }

    public void pushvs() throws IOException {
        output.writeByte(73);
    }

    public void pushvi() throws IOException {
        output.writeByte(74);
    }

    public void pushvf() throws IOException {
        output.writeByte(75);
    }

    public void popm() throws IOException {
        output.writeByte(76);
    }

    public void popv() throws IOException {
        output.writeByte(80);
    }

    public void popa() throws IOException {
        output.writeByte(77);
    }

    public void peekc() throws IOException {
        output.writeByte(84);
    }

    public void peeks() throws IOException {
        output.writeByte(85);
    }

    public void peeki() throws IOException {
        output.writeByte(86);
    }

    public void peekf() throws IOException {
        output.writeByte(87);
    }

    public void pokec() throws IOException {
        output.writeByte(88);
    }

    public void pokes() throws IOException {
        output.writeByte(89);
    }

    public void pokei() throws IOException {
        output.writeByte(90);
    }

    public void pokef() throws IOException {
        output.writeByte(91);
    }

    public void swp() throws IOException {
        output.writeByte(94);
    }

    public void add() throws IOException {
        output.writeByte(100);
    }

    public void sub() throws IOException {
        output.writeByte(104);
    }

    public void mul() throws IOException {
        output.writeByte(108);
    }

    public void div() throws IOException {
        output.writeByte(112);
    }

    public void printc() throws IOException {
        output.writeByte(144);
    }

    public void prints() throws IOException {
        output.writeByte(145);
    }

    public void printi() throws IOException {
        output.writeByte(146);
    }

    public void printf() throws IOException {
        output.writeByte(147);
    }

    public void halt() throws IOException {
        output.writeByte(0);
    }
}
