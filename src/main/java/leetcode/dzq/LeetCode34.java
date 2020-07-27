package leetcode.dzq;

import java.util.Arrays;

/**
 * @Description: 在排序数组中查找元素的第一个和最后一个位置
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode34
 * @Author: dongzeqi
 * @Date: 2020/7/27 21:59
 * @Version: 1.0
 */
public class LeetCode34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 10;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }
    public static int[] searchRange(int[] nums, int target) {
        int left = search(nums,target);
        int right = search(nums,target+1)-1;
        if(left==nums.length || nums[left]!=target){//这表明数组中不存在target
            return new int[]{-1,-1};
        }
        return new int[]{left,right}; //否则数组中存在target，则b-1是最后一个target的元素索引
    }
    //该二分查找nums中第一个>=t的元素位置
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while(left<right){
            int index = (left+right)/2;
            if(nums[index]<target)
                left = index+1;
            else{
                right = index;
            }
        }
        return left;
    }

    public static int[] searchRange1(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        while (left<=right){
            int index = (left+right)/2;
            if (nums[index] == target){
                //找到目标数
                left = right = index;
                while (right < nums.length-1 && nums[right+1] == target){
                    right++;
                }
                while (left > 0 && nums[left-1] == target){
                    left--;
                }
                return new int[]{left,right};
            }else if (nums[index] > target){
                right = index-1;
            }else {
                left = index+1;
            }
        }
        return new int[]{-1,-1};
    }
}
