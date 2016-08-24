public class Solution {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, hig = nums.length - 1;
        if(nums.length == 0) return;
        while(mid <= hig){
            switch(nums[mid]){
                case 0:
                    swap(nums, mid, low);
                    mid++;
                    low++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    swap(nums, mid, hig);
                    hig--;
                    break;
            }
        }
    }
    
    public void swap(int[] l, int a, int b){
        int temp = l[a];
        l[a] = l[b];
        l[b] = temp;
    }
    
}