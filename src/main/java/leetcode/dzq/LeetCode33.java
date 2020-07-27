package leetcode.dzq;

/**
 * @Description: 搜索旋转排序数组
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 *
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 *
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 *
 * 你可以假设数组中不存在重复的元素。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 示例 1:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 *
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode33
 * @Author: dongzeqi
 * @Date: 2020/7/24 22:42
 * @Version: 1.0
 */
public class LeetCode33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));
    }
    /**
     * @Description 二分查找法 增加判断(主要是判断数据所在区间 其它跟二分查找法类似)
     * @Author dongzeqi
     * @Date 2020/7/27 21:56
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int index = (left+right)/2;
            if (nums[index] == target){//寻找到元素
                return index;
            }else if (nums[index] >= nums[left]){//前面有序
                if (nums[left] <= target && nums[index] >target){//判断区间
                    right = index-1;
                }else {
                    left = index+1;
                }
            }else{//后面有序
                if (nums[right] >= target && nums[index] < target){//判断区间
                    left = index +1;
                }else {
                    right = index-1;
                }
            }
        }
        return -1;
    }

    public static int search1(int[] nums, int target) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target){
                return i;
            }
        }
        return index;
    }
}
