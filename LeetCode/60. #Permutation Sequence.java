public class Solution {  
    public String getPermutation(int n, int k) {  
        int i = 0, j = 0;  
        boolean[] isUsed = new boolean[n];  //isUsed[i]�洢���ǵ�i + 1�����Ƿ�ʹ��  
        
        int[] data = new int[n];  //data[i]�洢���� i! �Ľ��, ����forѭ�����г�ʼ��  
        data[0] = 1;  
        for (i = 1; i < n; i++)  
            data[i] = data[i - 1] * i;  
       
        --k;  //����--k��ԭ������Ϊ��ʵ���� rank = (k - 1) / data[i]��Ϊ�˼�������������ô�Ͷ�k�Լ�  
        StringBuffer result = new StringBuffer();  
        while (--i >= 0) {  
            int rank = k / data[i];  //rank��ʾ������Ҫ��Ѱ���ǵ� rank + 1�����  
            for (j = 0; j <= rank; j++)  
                if (isUsed[j]) rank++;  //�����j + 1������ʹ���ˣ���ôrank�Լ�  
            isUsed[rank] = true;  //���� j = temp + 1����ʹ���ˣ���ôisUsed[temp]�ͱ���Ϊtrue  
            result.append(j);
            k = k % data[i];  
        }  
        return result.toString();  
    }  
}  