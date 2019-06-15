public class erfenchazhao {
/**https://blog.csdn.net/yefengzhichen/article/details/52372407
 * 1)基础二分:查找特定数
 * 2）变种二分：查找第一个大于等于, 相比基础改动俩处（因不查找特定点）：1，if 条件 num[m] == target， 2，返回值判断h是否超出范围
 * 3）变种：查找第一个大于
 * h赋值 length、length-1
 * 循环条件一般是（l<=h）, 特殊：当 h/l =m 的赋值条件时， （l<h） 防止死循环
 */
    public int basicBinarysearch(int[] nums, int target){
        int l = 0, h =nums.length;
        
        while(l<=h){
            int m = low +(h-l) /2;
            if(nums[m] == target){return m;}
            else if(nums[m] > target){h = m-1;}
            else if(nums[m] < target){l = m+1;}
        }
        return -1;

    }
    //变种：取可重复数组最左侧的target位置
    //特殊处， 画图体会终止条件 l<h(h=m 存在h永远不变的情况，若l<=h则存在死循环的情况 )、 target 和 真实要得到的real_target 相对位置 
    public int BianarySearch(int[] nums, int target){
        int l= 0, h = nums.length;
        
        while(l<h){
            int m = low + (h-l) / 2;
            if(nums[m] >= target){h = m;}
            else if(nums[m] <target){l =m +1;}
        }

    }
    // 744. 大于target的最小的
    public char nextGreatestLetter(char[] letters, char target) {
        int l=0, h = letters.length-1;
        
        while(l<=h){
            m = l +(h-l) /2;
            if(letters[m] <= target) {l = m+1;}
            else if(letters[m] > target){h = m-1;}
             
        }
        
        if (l<letters.length){return letters[l];}
        return letters[0];
    }
/**review 540. 一个有序数组只有一个数不出现俩次，找出这个数
 * 基本解法，1。hash记录次数，然后再遍历一次
 * 2. 亦或：^ 俩者同假， 异真、
 * ！！3. 本题特殊在数组已经排序，所以存在最优logn 的解法：奇偶性
 * 存在h=m， 这种不动的情况， 所以循环条件等于号去掉，防止死循环
 * 
 *  */
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h =nums.length;
        while(l < h){
            int m = l+(h-l)/2;
            if(m%2 == 1){m-=1;} // 保证m在偶数位
            if(nums[m] == nums[m+1]){l +=2;}  //画图， m偶数位（112234455），俩种情况， 偶数位在前一个位置|target（只出现一次元素）|偶数位在后一个位置
            else{h = m;}

        }
        return l;
    }
/** review 34
 * 问题：判断first_index/ last_index 是否合法性， 注释中是ac情况，
 * 现代码提示  Runtime Error
 * 
 */
    public int[] searchRange(int[] nums, int target) {
        
        int first_index = getFirst(nums, target);
        int last_index = getFirst(nums, target + 1) -1;
        if (last_index <=nums.length-1 && first_index <=nums.length-1){
            if(nums[last_index] == target && nums[first_index] == target){
            return new int [] {first_index, last_index};}
            else return new int[] {-1,1};
        }
        else {return new int [] {-1, 1};}
        /*int first = binarySearch(nums, target);
        int last = binarySearch(nums, target + 1) - 1;
        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        } else {
            return new int[]{first, last};
        }*/
    }   
    private int getFirst(int[] nums, int target){
        int l = 0, h = nums.length-1;
        while(l<h){
            int m = l +(h-l)/2;
            if (nums[m]>=target){h=m;}
            else {l = m +1;}
        }
        return l;
    }

/**
 * 
 * 
 */

}