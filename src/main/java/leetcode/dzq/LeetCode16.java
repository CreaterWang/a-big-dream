package leetcode.dzq;

import java.util.Arrays;

/**
 * @Description: 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 *  
 *
 * 示例：
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 *
 * 提示：
 *
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode16
 * @Author: dongzeqi
 * @Date: 2020/7/13 20:59
 * @Version: 1.0
 */
public class LeetCode16 {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,8,2,1,-4};
        int target = 1;
        System.out.println(threeSumClosest(nums,target));
    }
    public static int threeSumClosest(int[] nums, int target) {
        if (nums.length<3){
            return 0;
        }
        Arrays.sort(nums);
        int num = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left<right){
                int sum = nums[i]+nums[left]+nums[right];

                if (sum == target){
                    return target;
                }
                if (sum > target){
                    if (num > sum-target){
                        result = sum;
                        num = sum-target;
                    }
                    right--;
                }
                if (sum < target){
                    if (num > target-sum){
                        result = sum;
                        num = target-sum;
                    }
                    left++;
                }
            }
        }
        return result;
    }
}
