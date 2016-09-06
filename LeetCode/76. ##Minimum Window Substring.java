public class Solution {
    public static String minWindow(String s, String t) {
        int[] needToFind = new int[256];
        int[] finded = new int[256];
        int begin = 0;
        int end = 0;
        int minBegin = 0;
        int minEnd = 0;
        int minLength = Integer.MAX_VALUE;
        int findedLength = 0;
        
        String minStr = "";
        
        for(int i = 0; i < t.length(); ++i){
        	needToFind[t.charAt(i)]++;
        }
        
        for(; end < s.length(); ++end){
        	if(needToFind[s.charAt(end)] == 0) 
        		continue;
        	finded[s.charAt(end)]++;
        	if(finded[s.charAt(end)] <= needToFind[s.charAt(end)])
        		findedLength++;
        	
        	if(findedLength >= t.length()){
        		while(needToFind[s.charAt(begin)] == 0 || finded[s.charAt(begin)] > needToFind[s.charAt(begin)]){
        			if(finded[s.charAt(begin)] > needToFind[s.charAt(begin)])
        				finded[s.charAt(begin)]--;
        			begin++;
        		}
        		
        		findedLength = end - begin + 1;
        		if(findedLength < minLength){
        			minBegin = begin;
        			minEnd = end;
        			minLength = findedLength;
        			minStr = s.substring(minBegin,minEnd + 1);
        		}
        	}
        }

		return minStr;
    }
}