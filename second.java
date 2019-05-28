import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**排序
 * 包含快排、堆排序、桶排序、国企颜色排序
 */
class second{
    /**215. Kth Largest Element in an Array (Medium)
    * method 1: 堆排序
    *同类型kth largeest element,即堆顶元素 / top k largest element
    * topk max 选择最小堆（末尾淘汰制）
    * todo： 堆排的具体内部实现， 初始小顶堆to大顶堆
    *  */    
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue <Integer>pq = new PriorityQueue<>(); 
        for(int num: nums){
            pq.add(num);
            //维护大小为k
            if(pq.size() >k){
                pq.poll();
            }
        }
        return pq.peek();
    }
    /**to review 
     * method2
     * todo:list.length,  string.length(), 集合中元素个数size()
     * 快排: https://www.cnblogs.com/MOBIN/p/4681369.html
     * 找到kth， 在遍历一次，找到所有大于k的元素
     * step1: partition/swap
     * step2: find all larger than kth element
     */
    public int findKthLargest2(int[] nums, int k){
        //找到第k大的元素k=length-k  ,与之对应k=k 是第k小的，从0开始算
        k = nums.length-k;
        int i =0, j = nums.length -1;
        while(i<j){ 
        int ordered_index = partition(nums, i, j);
        if (ordered_index == k)  break;  
        else if (ordered_index > k)   j=k-1;
        else if (ordered_index < k)   i=k+1;
        }
        return nums[k];
    }
    /** to review partition 
     * nums ,from i to j
     * partition 思路： 拆和补的过程，边拆边补
     * 首先拆掉首个点， 作为pivot， 然后左右依次遍历。
     * 
     *  */ 
    private int partition(int[] nums, int i, int j) {
        int index1 = i, index2 = j;
        
        int pivot = nums[i];
        //pivot 取得左一(拆)，所以从右边开始
        while(index1 < index2){
            // !双重while循环，index2发生变化，所以都需对index2 判断范围
            //找到第一个需要交换的index2 的位置：拆, 然后补到左边
            while (index1< index2 && nums[index2] >= pivot){
                index2--;
            }
            swap(a, index1, index2);
            while (index1< index2 && nums[index1] <= pivot){
                index1++;
            }
            swap(a, index1, index2);
        }
        nums[index2] = pivot;
        // return nums[index2]; 
        return index2;
    }
    private void swap(int[] a, int i ,int j) {
        int temp;
        temp = a[i];
        a[i] = a[j];
        a[j] = temp; 
    }
/**to review
 * 347.top k frequent elements
 * g
 */
    public List<Integer> topKFrequent(int[] nums, int k){
        //step1: hashmap ,统计出不同的频率
        HashMap <> hm = new HashMap<>();
        for(int num : nums){
           hm.put(num, hm.getOrDefault(num, 0)+1) ;
        }
        //step2: bucket[[],[] ]， 根据频率桶排序（下标即是频率）
        // hm.keyset() , hm.get(key)
        List<Integer> [] buckets = new ArrayList [nums.length+1];
        for(int key : hm.keyset()){
            int frequency = hm.get(key);
            if(buckets[frequency] == null) buckets[frequency] = new ArrayList();
            else buckets[frequency].add(key);
        }
        //step3: find top k
        //todo:  List<Integer> [] buckets = new ArrayList [nums.length+1];
        //todo: list.size() ???? if list[i] = null
        // addAll, 传入是一个list，将list所有元素加入当前 list中 
        //sublist(int fromindex, int endindex), 返回一个子数组， 原数组和子数组的操作互相影响
        List<Integer>  topK = new ArrayList<>();
        for(i = buckets.length; i>=0 && topK.size() <k; i--){
            //! 防止 bucketes[i]长度不够报错, buckets[i]长度超过k 溢出
            if(buckets[i].size() == 0){
                continue;
            }
            else if(buckets[i].size() < (k- topK.size())){
                topK.addAll(buckets[i]);
            }
            else{
                topK.addAll(buckets[i].subList(0, k-topK.size()));
            }

        }
        return topK;
    }
/**Sort Characters By Frequency 
 * i: string.toCharArray()
 * 
 */
    public String frequencySort(String s) {
        HashMap <> numFrequency = new HashMap<>();
        for(char i : s.toCharArray()){
            numFrequency.put(i, numFrequency.getOrDefault(i, 0)+1);
        }
        List<>[] frequencyBucket = new ArrayList[s.length()+1];
        for(char key: numFrequency.keySet()) {
            int frequency = frequencyBucket.get(key);
            if(frequencyBucket[frequency] == null){
                frequencyBucket[frequency] = new ArrayList<>();
            }
            frequencyBucket[frequency].add(key);
        } 
        StringBuilder str = new StringBuilder();
        for(int i = frequencyBucket.length; i>=0 ;i--){
            if(frequencyBucket[i] == 0) continue;
            for(char c: frequencyBucket[i]){
                //!  for (int j = 0; j < i; j++)  j从0开始到i（频率），来保证 字符出现几次就append几次
                for(int j =0; j<i; j++){
                str.append(c);
            }
            }
        }
        return str.toString();
    }
    /** 75. Sort Colors (Medium)
     * 0/1/2 归并排序， 思路类似快排
     * !! swap(nums, ++zero, one++)   one++ 画图分析，若(nums, ++zero, one)，则是zero在移动， 直到swap 过来1， 否则one 不动。
     * !应该为zero，和one 相邻， 同步移动。  设计实例， 画图分析
     * 
     * @param nums
     */
    public void sortColors(int[] nums) {
        int zero = -1,one = 0, two = nums.length;
        // one 作为当前遍历指针。
        while(one < two){
            if(nums[one] == 0){swap(nums, ++zero, one++);}
            else if(nums[one] == 2){swap(nums, --two, one);}
            else one++;
        }
    } 



    
    public static void main(String[] args) {
        List<>[] frequencyBucket = new ArrayList[10];
        
    }
}