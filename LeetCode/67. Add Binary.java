public class Solution {
    public String addBinary(String a, String b) {
        if(a.length() > b.length()) return addBinary(b, a);
		if(a == "") return b;
		char[] c = b.toCharArray();
		int carry = 0;
		
		for(int i = b.length()-1; i >= 0; --i){
			if(i >= b.length()-a.length()){
				int sum = a.charAt(i-b.length()+a.length())-'0' + b.charAt(i)-'0' + carry;
				if(sum == 0){
					;
				}else if(sum == 1){
					c[i] = '1';
					carry = 0;
				}else if(sum == 2){
					c[i] = '0';
					carry = 1;
				}else{
					c[i] = '1';
					carry = 1;
				}
			}else{
				int sum = b.charAt(i)-'0' + carry;
				if(sum == 0){
					break;
				}else if(sum == 1){
					c[i] = '1';
					carry = 0;
					break;
				}else{
					c[i] = '0';
					carry = 1;
				}
			}
		}
		
		if(carry == 1) return "1" + new String(c);
		return new String(c);
    }
}