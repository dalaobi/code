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
/**
 * 347.top k frequent elements
 * 
 */
    public List<Integer> topKFrequent(int[] nums, int k){
        
    }
}