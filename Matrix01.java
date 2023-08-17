/***
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: [[0,0,0],[0,1,0],[0,0,0]]
 * Example 2:
 *
 *
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]]
 * Output: [[0,0,0],[0,1,0],[1,2,1]]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * mat[i][j] is either 0 or 1.
 * There is at least one 0 in mat.
 */

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        for(int i =0 ; i < m; i++){
            for(int j = 0; j < n; j++) {
                if(mat[i][j] != 0) ans[i][j] = m * n + 1;
            }
        }
        bfs(ans, mat);

        
        return ans;
    }

    private void bfs(int[][] ans, int[][] mat){
        int m = mat.length, n = mat[0].length;
        int maxval = m * n;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(mat[i][j] != 0){
                    ans[i][j] = Math.min(ans[i][j], Math.min(
                        i > 0 ? 1 + ans[i - 1][j] : maxval,
                        j > 0 ? 1 + ans[i][j - 1] : maxval
                    ));
                }
            }
        }

        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(mat[i][j] != 0){
                    ans[i][j] = Math.min(ans[i][j], Math.min(
                        i < m - 1 ? 1 + ans[i + 1][j] : maxval,
                        j < n - 1 ? 1 + ans[i][j + 1] : maxval
                    ));
                }
            }
        }
    }
    
}