/**
 * Problem Description
 *
 * We have a list of lexicographically sorted strings A. We also have a string B. We need the first and last indexes of strings from A which are having their prefix as B. A can contain duplicate strings.
 *
 * Return [-1, -1] if no such prefix exists.
 *
 *
 *
 * Problem Constraints
 *
 * 1 <= |A| <= 105
 *
 * 1 <= ∑|A[i]| <= 106
 *
 * 1 <= |B| <= 105
 *
 *
 *
 * Input Format
 *
 * The first line contains an array of strings A.
 *
 * The second line contains the required prefix B.
 *
 *
 *
 * Output Format
 *
 * Return a vector containing first and last indexes and [-1, -1] in case no such prefix exists. Consider 0-based indexing.
 *
 *
 *
 * Example Input
 *
 * Input 1:
 *
 *   A = [a, aa, aab, b, bb, bba, bbb]
 *  B = bb
 * Input 2:
 *
 *  A = [a, b]
 *  B = c
 *
 *
 * Example Output
 *
 * Output 1:
 *
 *  [4, 6]
 * Output 2:
 *
 *  [-1, -1]
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  bb occurs as prefix in bb,bba and bb.
 * Explanation 2:
 *
 *  c is not present as prefix.
 */

public class Solution {
    public int[] solve(String[] A, String B) {

        return findPrefix(A, B, 0, A.length - 1);


    }

    private int[] findPrefix(String[] A, String B, int st, int en){
        if(st > en) return new int[]{-1, -1};

        int mid = (st + en) / 2;
        int cmp = compare(A[mid], B);
        if(cmp < 0) return findPrefix(A, B, mid + 1, en);
        else if(cmp > 0) return findPrefix(A, B, st, mid - 1);
        else{
            return new int[]{searchLeft(A, B, 0, mid - 1), searchRight(A, B, mid + 1, A.length - 1)};
        }


    }

    private int searchLeft(String[] A, String B, int st, int en){
        if(st > en) return st;
        int mid = (st + en) / 2;
        if(compare(A[mid], B) == 0) return searchLeft(A, B, st, mid - 1);
        return searchLeft(A, B, mid + 1, en);
    }

    private int searchRight(String[] A, String B, int st, int en){
        if(st > en) return en;
        int mid = (st + en) / 2;
        if(compare(A[mid], B) == 0) return searchRight(A, B, mid + 1, en);
        return searchRight(A, B, st, mid - 1);
    }


    private int compare(String a, String b){
        int i = 0;
        while(i < a.length() && i < b.length()){
            if(a.charAt(i) < b.charAt(i)) return -1;
            else if(a.charAt(i) > b.charAt(i)) return 1;
            i++;
        }
        return 0;
    }
}
