import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }

    public String getHamletData(){
        return hamletData;
    }

    public String changeHamletToLeon(String input) {
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(input);
        input = matcher.replaceAll("Leon");
        pattern = Pattern.compile("HAMLET");
        matcher = pattern.matcher(input);
        input = matcher.replaceAll("LEON");
        return input;
    }

    public String changeHoratioToTariq(String input) {
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(input);
        input = matcher.replaceAll("Tariq");
        pattern = Pattern.compile("HORATIO");
        matcher = pattern.matcher(input);
        input = matcher.replaceAll("TARIQ");
        return input;
    }

    public int findHamlet(String input) {
        int count = 0;
        Pattern pattern = Pattern.compile("Hamlet");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            count++;
        }
        pattern = Pattern.compile("HAMLET");
        matcher = pattern.matcher(input);
        while(matcher.find()){
            count++;
        }
        return count;
    }

    public int findHoratio(String input) {
        int count = 0;
        Pattern pattern = Pattern.compile("Horatio");
        Matcher matcher = pattern.matcher(input);
        while(matcher.find()){
            count++;
        }
        pattern = Pattern.compile("HORATIO");
        matcher = pattern.matcher(input);
        while(matcher.find()){
            count++;
        }
        return count;
    }
}
