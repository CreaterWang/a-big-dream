package leetcode.wyj;

/**
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 * <p>
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 * <p>
 * 你可以假设 nums1 和 nums2 不会同时为空。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * 则中位数是 2.0
 * 示例 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * 则中位数是 (2 + 3)/2 = 2.5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode4 {

    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        findMedianSortedArrays(nums1,nums2);
    }

    //game over
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] numsLong = nums1.length > nums2.length ? nums1 : nums2;
        int[] numsShort = nums1.length > nums2.length ? nums2 : nums1;
        //找出中位数左边应该有多少数字
        int length = (nums1.length + nums2.length - 1) / 2;
        int left = 0;
        int right = numsShort.length - 1;
        int mid = 0;
        while (true) {
            mid = (left + right - 1) / 2;

            if (numsShort[mid] > numsLong[length - mid - 1]) {
                right = mid;
            }
            if (numsShort[mid + 1] < numsLong[length - mid - 2]) {
                left = mid;
            }
            if (left == right) {
                break;
            }
        }
        double result = 0.0;
        //如果是偶数
        if (length % 2 == 0) {
            int num1 = numsShort[mid] > numsLong[length - mid - 2] ? numsShort[mid] : numsLong[length - mid - 2];
            int num2 = numsShort[mid + 1] < numsLong[length - mid - 1] ? numsShort[mid + 1] : numsLong[length - mid - 1];

            result = ((double) num1 + (double) num2) / 2;
        }else{
            result = numsShort[mid + 1] < numsLong[length - mid - 1] ? numsShort[mid + 1] : numsLong[length - mid - 1];
        }
        return result;
    }

}
