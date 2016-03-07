public class LetterCombinations{
    private void recursiveDFS(String digits,String[] map,int index,char[] buffer,List<String> ret){
    	if(index == digits.length()){
    		ret.add(new String(buffer));
    		return;
    	}
    	
    	char digChar = digits.charAt(index);
    	int dig = digChar-'0';
    	
    	for(int i=0; i<map[dig].length(); ++i){
    		buffer[index] = map[dig].charAt(i);
    		recursiveDFS(digits,map,index+1,buffer,ret);
    	}
    }
	

	public List<String> letterCombinations(String digits) {
		List<String> ret = new ArrayList<String>();
		String[] map = new String[10];
		char[] buffer = new char[digits.length()];
		
		map[0] = map[1] = "";
		map[2] = "abc";
		map[3] = "def";
		map[4] = "ghi";
		map[5] = "jkl";
		map[6] = "mno";
		map[7] = "pqrs";
		map[8] = "tuv";
		map[9] = "wxyz";
		
		if("".equals(digits)) return ret;
		recursiveDFS(digits,map,0,buffer,ret);
		return ret;
    }
	
	
	
	public static void main(String[] args){
		List<String> l = new LetterCombinations().letterCombinations("23");
		Iterator<String> i = l.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
}
