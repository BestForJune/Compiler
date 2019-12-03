//import javafx.css.Match;

import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class compiler {
    public static void main(String[] args) throws IOException {
        File inputFile = new File(args[0]);
        DataOutputStream output = new DataOutputStream(new FileOutputStream(args[1]));
        Map<String, Integer> symbolTable; // key: symbol; value: offset on the stack
        byteCode bc = new byteCode(output);
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                if(line.matches("decl[A-Za-z 0-9]+")) {
                    Pattern pattern = Pattern.compile("decl ([a-zA-Z]+) ([a-z]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("decl Error!");
                    }
                    String symbol = matcher.group(1);
                    String dataType = matcher.group(2);
//                    symbolTable.put(symbol, )
                    // if(dataType.equals("short")) {
                    //     bc.pushs((short) 0);
                    // }
                    // if(dataType.equals("int")) {
                    //     bc.pushi(0);
                    // }
                    // if(dataType.equals("float")) {
                    //     bc.pushf(0);
                    // }
                    System.out.println(symbol);
                    System.out.println(dataType);
                    continue;
                }
                if(line.matches("lab[A-Za-z]+")){
                    Pattern pattern = Pattern.compile("([A-Za-z]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("lab Error!");
                    }
                    continue;
                }
                if(line.matches("subr[A-Za-z 0-9]+")) { //unfinished
                    Pattern pattern = Pattern.compile("([0-9]+) ([A-Za-z]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("subr Error!");
                    }
                    int cnt = Integer.parseInt(matcher.group(1));
                    String flabel = matcher.group(2);
                    System.out.println(cnt);
                    System.out.println(flabel);
                    continue;
                }
                if (line.matches("ret")){
                    continue;
                }
                if (line.matches("retr var")){
                    continue;
                }
                if (line.matches("printv [a-zA-Z]+")){
                    Pattern pattern = Pattern.compile("print([a-zA-Z]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("printv Error!");
                    }
                    String var = matcher.group(1);
                    System.out.println(var);
                    continue;
                }
                if (line.matches("print([a-z]+) ([A-Za-z0-9]+)")){
                    Pattern pattern = Pattern.compile("print([a-z]+) ([A-Za-z]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("print Error!");
                    }
                    String type = matcher.group(1);
                    String literal = matcher.group(2);
                    System.out.println(type);
                    System.out.println(literal);
                    continue;
                }
                if (line.matches("jmp [a-zA-Z0-9]+")){
                    Pattern pattern = Pattern.compile("print([a-zA-Z0-9]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("jmp Error!");
                    }
                    String label = matcher.group(1);
                    System.out.println(label);
                    continue;
                }
                if (line.matches("jmpc [a-zA-Z0-9]+")){
                    Pattern pattern = Pattern.compile("print([a-zA-Z0-9]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("jmpc Error!");
                    }
                    String label = matcher.group(1);
                    System.out.println(label);
                    continue;
                }
                if (line.matches("cmpe")){
                    continue;
                }
                if (line.matches("cmplt")){
                    continue;
                }
                if (line.matches("call .*?")){ //????
                    // Pattern pattern = Pattern.compile("([0-9]+)(( [a-zA-Z0-9]+)+)");
                    // Matcher matcher = pattern.matcher(line);
                    // if(!matcher.find()) {
                    //     System.out.println("call Error!");
                    // }
                    // String var = matcher.group(1);
                    // System.out.println(var);
                    // for (int i = 1; i <= matcher.groupCount(); i++)
                    //     System.out.println(matcher.group(i));
                    String[] test = line.split(" ");
                    System.out.println(Arrays.toString(test));
                    continue;
                }
                if (line.matches("callr .*?")){ //????
                    Pattern pattern = Pattern.compile("([0-9]+) ([a-zA-Z0-9]+)+");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("callr Error!");
                    }
                    String var = matcher.group(1);
                    System.out.println(var);
                    continue;
                }
                // if (line.matches("push[a-z] [a-zA-Z0-9]+")){

                // }
            }
        }
        catch (IOException e) {
            System.out.println("File not found!!!");
        }
        output.close();
    }
}
