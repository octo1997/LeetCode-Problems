/**
 * Implement the next permutation, which rearranges numbers into the numerically next greater permutation of numbers for a given array A of size N.
 *
 * If such arrangement is not possible, it must be rearranged as the lowest possible order, i.e., sorted in ascending order.
 *
 * NOTE:
 *
 * The replacement must be in-place, do not allocate extra memory.
 * DO NOT USE LIBRARY FUNCTION FOR NEXT PERMUTATION. Use of Library functions will disqualify your submission retroactively and will give you penalty points.
 *
 *
 * Problem Constraints
 * 1 <= N <= 5 * 105
 *
 * 1 <= A[i] <= 109
 *
 *
 *
 * Input Format
 * The first and the only argument of input has an array of integers, A.
 *
 *
 *
 * Output Format
 * Return an array of integers, representing the next permutation of the given array.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3]
 * Input 2:
 *
 *  A = [3, 2, 1]
 *
 *
 * Example Output
 * Output 1:
 *
 *  [1, 3, 2]
 * Output 2:
 *
 *  [1, 2, 3]
 */

public class Solution {
    public int[] nextPermutation(int[] A) {
        int n = A.length;
        for(int i = n - 2; i >= 0; i--){
            if(A[i] < A[i + 1]) {
                swapWithNextElem(A, i);
                Arrays.sort(A, i + 1, n);
                return A;
            }
        }

        Arrays.sort(A);
        return A;


    }

    private void swapWithNextElem(int[] A, int elemIdx){
        int idx = elemIdx + 1;
        for(int i = elemIdx + 1; i < A.length; i++){
            if(A[elemIdx] < A[i] && A[idx] > A[i])
                idx = i;
        }
        int temp = A[idx];
        A[idx] = A[elemIdx];
        A[elemIdx] = temp;
    }
}