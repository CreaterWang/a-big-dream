package leetcode.dzq;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例：
 *
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode1
 * @Author: dongzeqi
 * @Date: 2020/7/9 22:32
 * @Version: 1.0
 */
public class LeetCode11 {

    public static void main(String[] args) {
        int[] nums = {1,8,6,2,5,4,8,3,7};
        try {
            System.out.println(maxArea(nums));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * @Description 两数之和hash
     * @Author dongzeqi
     * @Date 2020/7/5 20:19
     */
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;
        if (height.length>1){
            while (left < right){
                if (height[left] < height[right]){
                    maxArea = Math.max(maxArea,(height[left]*(right-left)));
                    left++;
                }else{
                    maxArea = Math.max(maxArea,(height[right]*(right-left)));
                    right--;
                }

            }
        }
        return maxArea;
    }
}
