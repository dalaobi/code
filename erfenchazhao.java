public class erfenchazhao {
/**1)基础二分
 * 2）变种二分
 * h赋值、循环条件
 */
    public int basicBinarysearch(int[] nums, int target){
        int l = 0, h =nums.length;
        int m = low +(h-l) /2;
        while(l<=h){
            if(nums[m] == target){return m;}
            else if(nums[m] > target){h = m-1;}
            else if(nums[m] < target){l = m+1;}
        }
        return -1;

    }
    //变种：取可重复数组最左侧的target位置
    //画图体会终止条件 l<h、 target 和 真实要得到的real_target 相对位置 
    public int BianarySearch(int[] nums, int target){
        int l= 0, h = nums.length;
        int m = low + (h-l) / 2;
        while(l<h){
            if(nums[m] >= target){h = m;}
            else if(nums[m] <target){l =m +1;}
        }

    }
    public char nextGreatestLetter(char[] letters, char target) {
        
    }
    
}