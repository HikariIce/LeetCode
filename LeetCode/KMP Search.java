public class KMP{
    private int[] getNext(String s){
    	int len = s.length();
    	int[] next = new int[len+1];
    	String ss = "^"+s;    //Let subscript of s start at 1
    	
    	int i = 1,j = 0;
    	next[0]=next[1]=0;	  //Let subscript of next start at 1,too
    	
    	while(i<len){
    		if(j==0 || ss.charAt(i)==ss.charAt(j)){
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
		String org = "^"+original;
		String pat = "^"+pattern;
		int[] next = getNext(pattern);
		int orglen = original.length(),patlen = pattern.length();	
		
		int i = 1,j = 1;
		while(i<=orglen && j<=patlen){
			if(j==0 || org.charAt(i)==pat.charAt(j)){
				++i;
				++j;
			}
			else
				j = next[j];
		}
		
		if(j>patlen) return i-patlen-1;
		else return -1;
	}
	
	public static void main(String[] args){
		String s = "babcbabcabcaabcabcabcacabc";
		String p = "abcabcacab";
		int[] next = new KMP().getNext(p);
		for(int i = 1;i<=p.length();++i){
			System.out.print(next[i]+" ");
		}
		System.out.println();
		
		int idx = new KMP().KMPsearch(s,p);
		for (int i = idx;i<idx+p.length();++i){
			System.out.print(s.charAt(i));
		}
	}
}
