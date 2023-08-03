/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 */

class Solution {
    public List<String> letterCombinations(String digits) {
        return generateCombinations(digits, 0);
    }

    private List<String> generateCombinations(String digits, int ind){
        if(ind >= digits.length()) return new ArrayList<String>();
        List<String> ret = new ArrayList<String>();
        List<String> nextLevel = generateCombinations(digits, ind+1);
        List<String> charsAtDig = getCharsAtDigit(digits.charAt(ind));
        for(String elem1: charsAtDig){
            if(nextLevel.size() == 0){
                ret.add(elem1);
            }
            for(String elem: nextLevel){
                ret.add(elem1+elem);
            }
        }

        return ret;
    }

    private List<String> getCharsAtDigit(char dig){
        List<String> ret = new ArrayList<String>();

        switch(dig){
            case '1':
                break;
            case '2':
                ret.add("a");ret.add("b");ret.add("c");
                break;
            case '3':
                ret.add("d");ret.add("e");ret.add("f");
                break;
            case '4':
                ret.add("g");ret.add("h");ret.add("i");
                break;
            case '5':
                ret.add("j");ret.add("k");ret.add("l");
                break;
            case '6':
                ret.add("m");ret.add("n");ret.add("o");
                break;
            case '7':
                ret.add("p");ret.add("q");ret.add("r");ret.add("s");
                break;
            case '8':
                ret.add("t");ret.add("u");ret.add("v");
                break;
            case '9':
                ret.add("w");ret.add("x");ret.add("y");ret.add("z");
                break;
        }

        return ret;
    }
}