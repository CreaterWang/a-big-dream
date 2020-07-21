package leetcode.dzq;

import java.util.Arrays;

/**
 * @Description: 下一个排列
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须原地修改，只允许使用额外常数空间。
 *
 * 以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-permutation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode31
 * @Author: dongzeqi
 * @Date: 2020/7/21 22:37
 * @Version: 1.0
 */
public class LeetCode31 {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
    }
    /**
     * @Description 第一次遍历 从右往左 找到右侧比左侧大的值的下标i-1,  第二次遍历  从i到最右侧找到比i-1大的最后一个值 交换他俩的位置 再进行i到末尾的排序,如果没有就直接全部排序
     * @Author dongzeqi
     * @Date 2020/7/21 23:16
     */
    public static void nextPermutation(int[] nums) {
        if (nums.length>1){
            for (int i = nums.length-1; i > 0; i--) {
                if (nums[i]>nums[i-1]){
                    int j = i+1;
                    while (j < nums.length) {
                        if (nums[i-1]<nums[j]){
                            j++;
                            continue;
                        }else {
                            break;
                        }
                    }
                    each(nums,i-1,j-1);
                    Arrays.sort(nums,i,nums.length);
                    return;
                }
            }
            Arrays.sort(nums);
        }
    }

    public static void each(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return;
    }
}
