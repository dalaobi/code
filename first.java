import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
/**双指针
 * 协同
 */
class first{
   
    private final static  HashSet<Char> vowels = new HashSet<>(Arrays.asList('a','e','i','o','u'));    
/** 345, reverseVowels
 *  char[] result= new char[string.length()]
 *  return new String (result)
 * 
 */
    public static reverseVowels(String s){
        int i =0;
        int j = s.length();
        char[] result  = new char[s.length()];
        while(i<=j){
            char chari = s.charAt(i);
            char charj = s.charAt(j);
            
            if(!vowels.contains(chari)){
                result[i++] = chari; 
            }
            else if(!vowels.contains(charj)){
                result[j--] = charj;
            }
            else {
                result[i++] = charj;
                result[j--] = chari;
            }
        }
        return new String (result);
    }
/**680 valid palindrome
 * 可以删除一个字符， 判断是否构成回文字符串
 *
 */
    public boolean validPalindrome(String s){
        int i = 0, j = s.length();
        while(i<j){
            if(s.charAt(i) != s.charAt(j)){
                // 不满足时，去掉左/右所指的一个点后，判断是否回文。
                return isPalindrom(s, i+1, j) || isPalindrom(s, i, j-1);
            }
            // 满足回文条件，左右指针继续遍历。
            i++;
            j--;
        }
        return true;
    }
    private boolean isPalindrom(String s, int start, int end){
        while(start< end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
        }
        return true;
    }
/**88 merge sorted array
 * 合并有序数组,从nunms1 中取m,从nums2 中取n个，合并到nums1数组中
 * 因为是合并到 nums1 上， 所以从前往后合并到nums1上会覆盖掉
 * 不同if 的顺序，逻辑结构
 */
    public void merge(int[] nums1, int m, int[] nums2, int n){  
        int index1 = m-1, index2 = n-1;
        int merge_index = m+n-1;
        while(index1 >=0 || index2>=0){
            if(nums1[m-1] < nums2[n-1]){
                if(index1<0){
                    nums1[merge_index--] = nums2[index2];
                }
                else if(index2<0){
                    nums1[merge_index--] = nums1[index1--];
                }
                else if(nums1[index1]<nums2[index2]){
                    nums1[merge_index--] = nums2[index2--];
                }
                else if(nums1[index1]>nums2[index2]){
                    nums1[merge_index--] = nums1[index1--];
                }

            }
        }

    }
/**141 linked list cycle
 * 循环条件 需要考虑l2.next.next
 * null.next 报错
 *  */    
    public boolean hasCycle(ListNode head){
        ListNode l1 = head, l2 = head.next;
        if(head == null) return false;
        while(l1 != null && l2 != null && l2.next != null){
            if(l1 == l2) {
                return true;
            }
            l1 = l1.next;
            l2 = l2.next.next;
        }
        return false;
    }
/**to review
 * 524. Longest Word in Dictionary through Deleting  
 * 删除s中一些字符，使之可以构成d中的一个字符串，找出能构成的最长字符串
 * compareTo  返回相对字典序、
 * string while 遍历 i=0 到i <s.length(), 因为i到最后字符时还继续。length= 最后一个字符index+1
 */
public Strict findLongestWord(String s, List<String> d){
    String current_longest_string = "";
    for(String word : d){
        //若当前最长字符匹配的长度最大/字典序最大，直接跳过当前的 isvalid 比较
        if(current_longest_string.length()> word.length() || 
            (current_longest_string.length() == word.length() && current_longest_string.compareTo(word) <0)){
                continue;
            }
        // 比较s和word是否匹配上
        if(isValid(s,word)){
            current_longest_string = word;
        }
    }
    return current_longest_string;
}
private isValid(String s, String word){
    int i =0,j = 0;

    while(i<s.length() && j<word.length()){
        if(s.charAt(i) == word.charAt(j)){
            j++;
        }
        i++;
    }
    return j == word.length();
}
}
