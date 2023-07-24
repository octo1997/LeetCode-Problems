
public class Solution {
    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        Map<Integer, Integer> storer = new HashMap<Integer, Integer>();
        for(int a: A){
            storer.put(a, storer.getOrDefault(a, 0) + 1);
        }
        
        for(int b : B){
            if(storer.containsKey(b) && storer.get(b) > 0){
                ans.add(b);
                storer.put(b, storer.get(b) - 1);
            }
        }
        
        return ans;
    }
}