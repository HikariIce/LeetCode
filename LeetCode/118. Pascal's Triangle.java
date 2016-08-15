public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for(int j = 1; j < i; j++){
                temp.add(res.get(i-1).get(j-1) + res.get(i-1).get(j));
            }
            if(i != 0){
                temp.add(1);
            }
            res.add(temp);
        }
        return res;
    }
}