import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'getPasswordStrength' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY passwords
     *  2. STRING_ARRAY common_words
     */
    private static String weak = "weak";
    private static String strong = "strong";
    public static List<String> getPasswordStrength(List<String> pw, List<String> cw) {
        // Write your code here
        int n = pw.size();
        List<String> ans = new ArrayList<String>();
        Set<String> cwSet = new HashSet<String>();
        for(String s: cw){
            cwSet.add(s);
        }
        for(int i = 0; i < n; i++){
            String wd = pw.get(i);
            boolean status = (wd.length() > 5);
            boolean allNumeric = true;
            boolean allUpper = true;
            boolean allLower = true;
            for(int j = 0; j < wd.length() && status; j++){
                if(wd.charAt(j) - '0' < 0 || wd.charAt(j) - '0' > 9 ) allNumeric = false;
                if(wd.charAt(j) < 'a' || wd.charAt(j) > 'z') allLower = false;
                if(wd.charAt(j) < 'A' || wd.charAt(j) > 'Z') allUpper = false;
                for(int k = j + 1; k <= wd.length() && status; k++){
                    String temp = wd.substring(j, k);
                    if(cwSet.contains(temp)){
                        status = false;
                    }
                }
            }

            if(status && !allNumeric && !allUpper && !allLower) ans.add(strong);
            else ans.add(weak);
        }

        return ans;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int passwordsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> passwords = IntStream.range(0, passwordsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        int common_wordsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> common_words = IntStream.range(0, common_wordsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        List<String> result = Result.getPasswordStrength(passwords, common_words);

        bufferedWriter.write(
                result.stream()
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
