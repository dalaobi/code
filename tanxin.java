import java.util.Arrays;
import java.util.Comparator;

public class tanxin{
/**
 * 局部最优解： 优先满足 贪婪度最低的孩子的要求
 * ! to review match匹配思路！   孩子-饼干匹配： while{if() }  区别 while{while{} }
 * 遍历饼干， 找孩子、
 * @param g 孩子需求大小
 * @param s 饼干大小
 * @return 可以满足孩子数量
 */    
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index1 = 0, index2 =0;
        while(index1 <g.length && index2 < s.length){
            if(g[index1]<=s[index2]){
                index1++;
            }
            index2++;
        }
        return index1;
    }
/** 435. Non-overlapping Intervals (Medium)
 * 
 */
    public int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.end));
    }
/**605 can place flowers
 * 实现
 *  */
    public boolean canPlaceFlowers(int[] flowerbed, int n){
        
    }
}