public class Solution {
    public static List<List<Integer>> combine(int n, int m) {
		List<List<Integer>> res = new ArrayList<>();
		
		List<Integer> ele = new ArrayList<>();
		
		combine(n, m, 0, 1, res, ele);
		
		return res;
		
    }
	
	private static void combine(int n, int m, int level, int idx, List<List<Integer>> res,List<Integer> ele){
		if (level == m){
			res.add(new ArrayList<>(ele));
			return;
		} 
		
		for (int i = idx; i <= n; i++){
			ele.add(i);
			combine(n, m, level + 1, i + 1, res,ele);
			ele.remove(new Integer(i));
		}
	}
}