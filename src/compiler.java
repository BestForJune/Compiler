import javafx.css.Match;

import java.io.*;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class compiler {
    public static void main(String[] args) throws IOException {
        File inputFile = new File(args[0]);
        DataOutputStream output = new DataOutputStream(new FileOutputStream(args[1]));
        Map<String, Integer> symbolTable;
        byteCode bc = new byteCode(output);
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if(line.matches("decl[A-Za-z 0-9]*")) {
                    Pattern pattern = Pattern.compile("([0-9]+)");
                    Matcher matcher = pattern.matcher(line);
                }
                if(line.matches("subr[A-Za-z 0-9]*")) {
                    Pattern pattern = Pattern.compile("([0-9]+)");
                    Matcher matcher = pattern.matcher(line);
                    if(!matcher.find()) {
                        System.out.println("subr Error!");;
                    }
                    bc.pushs((short) 1);

                    break;
                }
            }
        }
        catch (IOException e) {
            System.out.println("File not found!!!");
        }
        output.close();
    }
}
