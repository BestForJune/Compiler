//import javafx.css.Match;

import java.io.*;
import java.util.*;
// import java.util.Arrays;
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
                    if(dataType.equals("short")) {
                        bc.pushs((short) 0);
                    }
                    if(dataType.equals("int")) {
                        bc.pushi(0);
                    }
                    if(dataType.equals("float")) {
                        bc.pushf(0);
                    }
                    // System.out.println(symbol);
                    // System.out.println(dataType);
                    continue;
                }
                if(line.matches("lab [A-Za-z]+")){
                    Pattern pattern = Pattern.compile("lab ([A-Za-z]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("lab Error!");
                    }
                    String label = matcher.group(1);
                    continue;
                }
                if(line.matches("subr[A-Za-z 0-9]+")) { //unfinished
                    Pattern pattern = Pattern.compile("subr ([0-9]+) ([A-Za-z]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("subr Error!");
                    }
                    int cnt = Integer.parseInt(matcher.group(1));
                    String flabel = matcher.group(2);
                    // System.out.println(cnt);
                    // System.out.println(flabel);
                    continue;
                }
                if (line.matches("retr .*?")){
                    Pattern pattern = Pattern.compile("retr ([A-Za-z]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("retr Error!");
                    }
                    String var = matcher.group(1);
                    continue;
                }
                if (line.matches("ret")){
                    continue;
                }
                if (line.matches("printv .*?")){
                    Pattern pattern = Pattern.compile("printv ([a-zA-Z]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("printv Error!");
                    }
                    String var = matcher.group(1);
                    // System.out.println(var);
                    continue;
                }
                if (line.matches("print.*?")){
                    Pattern pattern = Pattern.compile("print([a-z]+) ([A-Za-z]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("print Error!");
                    }
                    String type = matcher.group(1);
                    String literal = matcher.group(2);
                    continue;
                }
                if (line.matches("jmp .*?")){
                    Pattern pattern = Pattern.compile("jmp ([a-zA-Z0-9]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("jmp Error!");
                    }
                    String label = matcher.group(1);
                    continue;
                }
                if (line.matches("jmpc .*?")){
                    Pattern pattern = Pattern.compile("jmpc ([a-zA-Z0-9]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("jmpc Error!");
                    }
                    String label = matcher.group(1);
                    continue;
                }
                if (line.matches("cmpe")){
                    continue;
                }
                if (line.matches("cmplt")){
                    continue;
                }
                if (line.matches("call .*?")){ 
                    String[] allinfor = line.split(" ");
                    List<String> vara = new ArrayList<String>();
                    int cnt = Integer.parseInt(allinfor[1]);
                    for (int i = 2; i < allinfor.length - 1; i++)
                        vara.add(allinfor[i]);
                    String flabel = allinfor[allinfor.length - 1];
                    continue;
                }
                if (line.matches("callr .*?")){
                    String[] allinfor = line.split(" ");
                    List<String> vara = new ArrayList<String>();
                    int cnt = Integer.parseInt(allinfor[1]);
                    for (int i = 2; i < allinfor.length - 1; i++)
                        vara.add(allinfor[i]);
                    String flabel = allinfor[allinfor.length - 1];
                    continue;
                }
                if (line.matches("push[a-z] .*?")){
                   Pattern pattern = Pattern.compile("push([a-z]) ([a-zA-Z0-9]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("push Error!");
                    }
                    String type = matcher.group(1);
                    String val = matcher.group(2);
                    continue;
                }
                if (line.matches("popm .*?")){
                    Pattern pattern = Pattern.compile("popm ([0-9]+)");
                     Matcher matcher = pattern.matcher(line);
                     if(!matcher.find()) {
                         System.out.println("popm Error!");
                     }
                     int val = Integer.parseInt(matcher.group(1));
                     continue;
                 }
                if (line.matches("popv .*?")){
                    Pattern pattern = Pattern.compile("popv ([a-zA-Z0-9]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("popv Error!");
                    }
                    String var = matcher.group(1);//variable
                    continue;
                 }
                 if (line.matches("peek .*?")){
                    Pattern pattern = Pattern.compile("peek ([a-zA-Z0-9]+) ([-0-9]+)");
                     Matcher matcher = pattern.matcher(line);
                     if(!matcher.find()) {
                         System.out.println("popv Error!");
                     }
                     String var = matcher.group(1);//variable
                     int val = Integer.parseInt(matcher.group(2));
                     continue;
                 }
                if (line.matches("poke .*?")){
                    Pattern pattern = Pattern.compile("poke ([-0-9]+) ([a-zA-Z0-9]+)");
                     Matcher matcher = pattern.matcher(line);
                     if(!matcher.find()) {
                         System.out.println("popv Error!");
                     }
                     String var = matcher.group(2);//variable
                     int val = Integer.parseInt(matcher.group(1));
                     continue;
                 }
                 if (line.matches("swp")){
                     continue;
                 }
                 if (line.matches("add")){
                    continue;
                }
                if (line.matches("sub")){
                    continue;
                }
                if (line.matches("mul")){
                    continue;
                }
                if (line.matches("div")){
                    continue;
                }
            }
        }
        catch (IOException e) {
            System.out.println("File not found!!!");
        }
        output.close();
    }
}
