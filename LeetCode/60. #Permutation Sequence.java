public class Solution {  
    public String getPermutation(int n, int k) {  
        int i = 0, j = 0;  
        boolean[] isUsed = new boolean[n];  //isUsed[i]存储的是第i + 1个数是否被使用  
        
        int[] data = new int[n];  //data[i]存储的是 i! 的结果, 并用for循环进行初始化  
        data[0] = 1;  
        for (i = 1; i < n; i++)  
            data[i] = data[i - 1] * i;  
       
        --k;  //进行--k的原因是因为，实际上 rank = (k - 1) / data[i]，为了减少运算量，那么就对k自减  
        StringBuffer result = new StringBuffer();  
        while (--i >= 0) {  
            int rank = k / data[i];  //rank表示下面需要搜寻的是第 rank + 1大的数  
            for (j = 0; j <= rank; j++)  
                if (isUsed[j]) rank++;  //如果第j + 1个数被使用了，那么rank自加  
            isUsed[rank] = true;  //由于 j = temp + 1，被使用了，那么isUsed[temp]就被置为true  
            result.append(j);
            k = k % data[i];  
        }  
        return result.toString();  
    }  
}  