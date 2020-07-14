package leetcode.wyj;

import java.util.Arrays;

public class LeetCode16 {
    public static void main(String[] args) {
        int[] nums = {1,1,-1,-1,3};

        System.out.println(threeSumClosest(nums, -1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int resultX = Integer.MAX_VALUE;
        int result = 0;


        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[start] + nums[end] + nums[i];
                int abs = Math.abs(target - sum);

                if (abs < resultX) {
                    resultX = abs;
                    result = sum;
                }

                if (target < sum) {
                    end--;
                } else if (target > sum) {
                    start++;
                } else {
                    return result;
                }

            }
        }
        return result;
    }
}
