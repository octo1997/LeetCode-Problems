/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
 * Output: 20
 * Explanation:
 *
 * We can connect the points as shown above to get the minimum cost of 20.
 * Notice that there is a unique path between every pair of points.
 * Example 2:
 *
 * Input: points = [[3,12],[-2,5],[-4,1]]
 * Output: 18
 *
 *
 * Constraints:
 *
 * 1 <= points.length <= 1000
 * -106 <= xi, yi <= 106
 * All pairs (xi, yi) are distinct.
 */
class Solution {

    class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int dist;

        Edge(int a, int b, int[][] points){
            src = a;
            dest = b;

            dist = getDist(a, b, points);
        }
        @Override
        public int compareTo(Edge a){
            return dist < a.dist ? -1 : (dist == a.dist ? 0 : 1);
        }

        @Override
        public String toString(){
            return "{" + src + " " + dest + " " + dist + "}";
        }


    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        parent = new int[n];
        List<Edge> edgeList = new ArrayList<Edge>();

        for(int i = 0; i < n; i++){
            parent[i] = i;
            for(int j = 0; j < i; j++){
                edgeList.add(new Edge(i, j, points));
            }
        }
        Collections.sort(edgeList);
        int ans = 0, cnt = 0;
        for(int i = 0; i < edgeList.size() && cnt < n; i++){
            int src = edgeList.get(i).src;
            int dest = edgeList.get(i).dest;
            if(!checkCircularTree(src, dest)){
                ans += edgeList.get(i).dist;
            }
        }

        return ans;

    }
    private int[] parent;
    private boolean checkCircularTree(int st, int en){
        int root1 = find(st);
        int root2 = find(en);

        if(root1 == root2) return true;

        union(root1, root2);
        return false;
    }

    public int find(int a){
        if(parent[a] == a) return a;
        return find(parent[a]);
    }

    public void union(int a, int b){
        if(a > b) parent[b] = a;
        else parent[a] = b;
    }



    private int getDist(int i, int j, int[][] points){
        int[] a = points[i];
        int[] b = points[j];
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}