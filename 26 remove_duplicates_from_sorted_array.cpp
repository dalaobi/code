/*
Description:
remove dupicates from a sorted array, array, array
 return the length of the array
keypoint:
fast pointer(cur)/slow pointer 
理解方式： 将cur， 即快指针理解为指向 第一个不同的数字的指针。
*/
using namespace std;
#include <vector>
#include <unordered_map>
class Solution {
public:
    int removeDuplicates(vector<int> &nums) {
        if (nums.empty()) return 0;
        int pre = 0, cur = 0, n = nums.size();
        while (cur < n) {
            if (nums[pre] == nums[cur]) ++cur;   //相同， 快指针向下走
            else nums[++pre] = nums[cur++];      // 
        }
        return pre + 1;
    }
};
/* 
cpp   method
vector  动态数组
&   引用，在实参上做改变
nums.empty()
nums.size()
*/

/* 
允许出现2次， 超过2次的去除
count 还允许有几次重复的机会, count =0 时与 上一题 相同。
理解方式： 将cur， 即快指针理解为指向 （允许重复一次情况下）第一个不同的数字的指针。
*/
class Solution_dup_twice{
public:
    int removeDuplicates(vector<int> nums){
        int count =1;
        if (nums.empty()) return 0;
        int pre =0, cur =0, n = nums.size();
        while(cur<n){
            if (nums[pre] == nums[cur] && count == 0){      
                cur ++;
            }
            else
            {
                if(nums[pre] == nums[cur])
                    count --;
                else {
                    count =1;
                nums[pre++] = nums[cur++];
                }
            }
        }
    }    
};
/*
removed dumplicated num from a sorted linked list
默认 head 直接指向第一个 结点， 没有head 存放长度info 这个概念
链表操作、（遍历、删除）
*/

struct ListNode {
      int val;
      ListNode *next;
      ListNode(int x) : val(x), next(NULL) {}
};
 
class Solution_linkedlist{
public:
    ListNode *removeDuplicates(ListNode* head){
        ListNode * cur = head;
        while(cur && cur->next){
            if(cur->val == cur->next->val){
                cur->next = cur->next->next;
            }
            else cur = cur->next;
        }
        return head;
    }
};

/*
wwwwww
删除所有的重复项，重复的全部删除，一个不保留
head 结点可能会被删除，不能return head
keypoint:
前驱指针， 现指针-- 始终去指向第一个不同的结点 
*/

class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) {
        if (!head || !head->next) return head;
        ListNode *dummy = new ListNode(-1), *pre = dummy;
        dummy->next = head;
        while (pre->next) {             //每当前驱结点 向下移动， 用一个cur 结点来指向第一个 不同于前驱结点的元素  的上一个结点
        //    的 上一个结点的原因是 为了方便 = cur.next  ， 然后pre.next = cur.next
        //    如果cur 指向， 前驱的下一个结点话， 说明前驱结点链接的第一个结点就不同， 前驱结点直接向下一步。
            ListNode *cur = pre->next;
            while (cur->next && cur->next->val == cur->val) {
                cur = cur->next;
            }
            if (cur != pre->next) pre->next = cur->next;
            else pre = pre->next;
        }
        return dummy->next;
    }
};

/*
contains duplicate 
*  语言：  m.find(nums[i])   m.end
对于map， key unique， key index
map 红黑树， 有序。
unordered_map hash,  无序
m[keys] = value
此题 m【key】 = value，   value代表出现次数
find(key)      key
方法一：使用find，返回的是被查找元素的位置的迭代器，没有则返回map.end()，结尾位置的迭代器。
方法二： count（）   return 0/1
*/
class Solution_linkedlist_allduplicates{
public:
    bool containsduplicates(vector<int> &nums){
        unordered_map<int,int> m;
        for(int i=0; i< nums.size(); i++){
            if (m.find(nums[i]) != m.end ) 
                return true;
            ++m[nums[i]];
        }
        return false;
    }
};

/*
存在唯一重复的且重复俩点之间距离小于k
*/

class Solution{
public:
    bool containsNearbyDuplicates(vector<int> &nums, int k){
        unordered_map<int,int> m;
        int distance = 0;
        for(int i=0; i<nums.size(); i++){
            if(m.find(nums[i]) != m.end){
                distance = abs(i-m[nums[i]]);
                if(distance < k) return true;
                }
            m[nums[i]]=i;
        }
        return false;
    }
};

/*
 i,j , nums[i] nums[j] 的取值绝对值小于t
 i，j 绝对值小于k
 brute force 超时
 *cpp：
lower_bound     返回>=val 的最小指针
upper_bound     返回>val  的最小指针
summary： map/set 等基于红黑树， 而unordered_map/unordered_set 是基于hash。
stack/priority_queue 分别是栈和优先堆
lower_bound 方法可被map/set/vector 这样的容器使用；  栈和堆的区别比较大：遍历主要使用top()/front()/pop()等
前者：  for(auto a : x) ， iterator的遍历形式是先hasNext() ， 然后再next().
后者：  x.begin()+n

另外，解法的思路维护一个大小为k的动态窗口，在乎的是这个窗口中值得大小关系，而不是存在多少个相同的值。
*/
class Solution{
public:
    bool containsNearby(vector<int> &nums, int t, int k){
        
    }
};

