public class Solution {
    public int minDistance(String word1, String word2) {
        
        int[][] distance = new int[word1.length() + 1][word2.length() + 1]; //表示从第1个字单词的第0位至第i位形成的子串和第2个单词的第0位至第j位形成的子串的编辑距离
        
        for(int i = 0; i <= word1.length(); ++i) distance[i][0] = i;
        for(int i = 0; i <= word2.length(); ++i) distance[0][i] = i;
        
        for(int i = 1; i <= word1.length(); ++i){
            for(int j = 1; j <= word2.length(); ++j){
                int replace = 0;
                if(word1.charAt(i-1) == word2.charAt(j-1))  //下标对应关系为i,j分别对应word1,word2的第i,j个字符,即i-1,j-1位置的字符
                    replace = distance[i-1][j-1];
                else
                    replace = distance[i-1][j-1] + 1;
                int minInsertDelete = Math.min(distance[i-1][j], distance[i][j-1]) + 1;
                distance[i][j] = Math.min(replace, minInsertDelete);
            }
        }
        
        return distance[word1.length()][word2.length()];
    }
}