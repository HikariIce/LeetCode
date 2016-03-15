public class KMP{
    private int[] getNext(String s){
    	int len = s.length();
    	int[] next = new int[len];
    	
    	int i = 0,j = -1;
    	next[0]= -1;	  
    	
    	while(i<len-1){
    		if(j==-1 || s.charAt(i)==s.charAt(j)){
    			++i;
    			++j;
    			next[i] = j;
    		}
    		else
    			j = next[j];
    	}
    	
    	return next;
    }
	
    /**
     * find the index of first pattern
     * @param original
     * @param pattern
     * @return
     */
	public int KMPsearch(String original,String pattern){
		if(original.equals("")||pattern.equals("")){
	        if(original.equals("")&&pattern.equals("")) return 0;
	        else if(pattern.equals("")) return 0;
	        else return -1;
	    }
	    
		int[] next = getNext(pattern);
		int orglen = original.length(),patlen = pattern.length();	
		
		int i = 0,j = 0;
		while(i<orglen && j<patlen){
			if(j==-1 || original.charAt(i)==pattern.charAt(j)){
				++i;
				++j;
			}
			else
				j = next[j];
		}
		
		if(j==patlen) return i-patlen;
		else return -1;
	}
	
	public static void main(String[] args){
		String s = "babcbabcabcaabcabcabcacabc";
		String p = "abcabcacab";
		int[] next = new KMP().getNext(p);
		for(int i = 0;i<p.length();++i){
			System.out.print(next[i]+" ");
		}
		System.out.println();
		
		int idx = new KMP().KMPsearch(s,p);
		System.out.println(idx);
		for (int i = idx;i<idx+p.length();++i){
			System.out.print(s.charAt(i));
		}
	}
}



