/**
 * You are given an array of strings products and a string searchWord.
 *
 * Design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
 *
 * Return a list of lists of the suggested products after each character of searchWord is typed.
 *
 *
 *
 * Example 1:
 *
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [["mobile","moneypot","monitor"],["mobile","moneypot","monitor"],["mouse","mousepad"],["mouse","mousepad"],["mouse","mousepad"]]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"].
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"].
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"].
 * Example 2:
 *
 * Input: products = ["havana"], searchWord = "havana"
 * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * Explanation: The only word "havana" will be always suggested while typing the search word.
 *
 *
 * Constraints:
 *
 * 1 <= products.length <= 1000
 * 1 <= products[i].length <= 3000
 * 1 <= sum(products[i].length) <= 2 * 104
 * All the strings of products are unique.
 * products[i] consists of lowercase English letters.
 * 1 <= searchWord.length <= 1000
 * searchWord consists of lowercase English letters.
 */

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
     * Complete the 'getProductSuggestions' function below.
     *
     * The function is expected to return a 2D_STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY products
     *  2. STRING search
     */

    public static List<List<String>> getProductSuggestions(List<String> pd, String search) {
        // Write your code here
        Collections.sort(pd);
        // System.out.println(pd);
        List<List<String>> ans = new ArrayList();
        int st = 0, n = search.length(), m = pd.size();
        String searchStr = String.valueOf(search.charAt(0));
        for(int i = 0;i < n; i++){
            List<String> temp = new ArrayList();
            if(i > 0) searchStr += search.charAt(i);

            st = searchStart(pd, searchStr, st, m - 1);
            for(int k = st; k < st + 3 && k < pd.size(); k++){
                if(match(pd.get(k), searchStr) == 0)
                    temp.add(pd.get(k));
            }
            ans.add(temp);
        }
        return ans;
    }

    private static int searchStart(List<String> pd, String searchStr, int st, int en){
        if(st > en) return st;

        int mid = (st + en) / 2;

        int matchVal = match(pd.get(mid), searchStr);
        // System.out.println(st + " " + en + " " + searchStr + " " + matchVal);
        if(matchVal < 0) return searchStart(pd, searchStr, mid + 1, en);
        else return searchStart(pd, searchStr, st, mid - 1);


    }

    private static int match(String a, String b){
        int n = a.length(), m = b.length(), i = 0;
        while(i < m){
            if(i >= n) return -1;
            int temp = a.charAt(i) - b.charAt(i);
            if(temp == 0) i++;
            else return temp;
        }
        return 0;

    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int productsCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> products = IntStream.range(0, productsCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(toList());

        String search = bufferedReader.readLine();

        List<List<String>> result = Result.getProductSuggestions(products, search);

        result.stream()
                .map(
                        r -> r.stream()
                                .collect(joining(" "))
                )
                .map(r -> r + "\n")
                .collect(toList())
                .forEach(e -> {
                    try {
                        bufferedWriter.write(e);
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
