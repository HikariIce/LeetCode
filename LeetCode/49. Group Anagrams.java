public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0)  
	           return null;  
		
		HashMap<String, List<String>> map = new HashMap<>();
		Arrays.sort(strs);
		for (String s : strs){
			String skey = sortedStr(s);
			if(map.containsKey(skey)){
	               map.get(skey).add(s);
	           }else{
	               map.put(skey,new ArrayList<String>());
	               map.get(skey).add(s);
	        }
		}
		
		return 	new ArrayList<List<String>>(map.values());
    }
    
    public String sortedStr(String str){
		char[] c = str.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
}