public class Solution {
    public boolean isMatch(String s, String p){
		boolean[][] cache = new boolean[s.length()+1][p.length()+1];
		cache[0][0] = true;
		for(int j = 1; j <= p.length(); ++j){
			cache[0][j] = cache[0][j-1] && p.charAt(j-1) == '*';
			for(int i = 1; i <= s.length(); ++i){
				if(p.charAt(j-1) == '*')
					cache[i][j] = cache[i-1][j-1] || cache[i-1][j] || cache[i][j-1];
				else if(p.charAt(j-1) == '?' || p.charAt(j-1) == s.charAt(i-1))
					cache[i][j] = cache[i-1][j-1];
			}
		}
		return cache[s.length()][p.length()];
	}
}