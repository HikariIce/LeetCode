public class Solution {
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        
        if(words.length == 0 || maxWidth == 0){
            res.add("");
            return res;
        }
        
        int i = 0;
        while(i < words.length){
        	int sum = words[i].length();
        	int j = i + 1;
        	
        	while(j < words.length && sum + words[j].length() + 1 <= maxWidth){
        		sum = sum + words[j].length() + 1;
        		j++;
        	}
        	
        	int extraSpace = (j - i - 1) == 0 ? (maxWidth - sum) : (maxWidth - sum + j - i - 1)/(j - i - 1);
        	StringBuffer sb = new StringBuffer();
        	
        	if(j == words.length){
        		int t = maxWidth - sum + j - i - 1;
        		while(i != j){
        			sb.append(words[i]).append(genSpace(t > 0 ? 1 : 0));
        			t--;
        			i++;
        		}
        		System.out.println(t);
        		sb.append(genSpace(t));
        		res.add(sb.toString());
        		
        		break;
        	}
			

        	int ex = 0;;
        	if((j - i -1) != 0 && ((maxWidth - sum + j - i - 1) % (j - i - 1) != 0)) {
        		sb.append(words[i]).append(genSpace(extraSpace+1));
        		ex = (maxWidth - sum + j - i - 1) % (j - i - 1) - 1;
        	}
        	else {
        		sb.append(words[i]).append(genSpace(extraSpace));
        	}
        	
        	
        	for(int k = i + 1; k < j; ++k){
        		sb.append(words[k]);
        		if(k == j-1) break;
        		else {
        			sb.append(genSpace(extraSpace + (ex > 0 ? 1 : 0)));
        			ex--;
        		}
        	}
        	
        	res.add(sb.toString());
        	i = j;
        }
        
        return res;
    }
	
	public static String genSpace(int n){
		StringBuffer sb = new StringBuffer();
		while(n-- > 0){
			sb.append(" ");
		}
		return sb.toString();
	}
}