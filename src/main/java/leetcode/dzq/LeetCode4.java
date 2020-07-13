package leetcode.dzq;

/**
 * @Description: 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。
 *
 * 请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m+n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1,3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1,2]
 * nums2 = [3,4]
 *
 * 则中位数是 (2+3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @ProjectName: a-big-dream
 * @Package: leetcode.dzq
 * @ClassName: LeetCode4
 * @Author: dongzeqi
 * @Date: 2020/7/6 21:25
 * @Version: 1.0
 */
public class LeetCode4 {

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {-1,5};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if (len1>len2){
            return findMedianSortedArrays(nums2,nums1);
        }
        int left = 0;
        int right = len1;
        int middle = (len1+len2+1)/2;
        while (left < right){
            int i = (left+right+1)/2;
            int j = middle-i;
            if (nums1[i-1]>nums2[j]){
                right = j-1;
            }else{
                left = i;
            }
        }
        right = middle-left;
        int num1Max = left==0?Integer.MIN_VALUE:nums1[left-1];
        int num2Max = right==0?Integer.MIN_VALUE:nums2[right-1];
        int num1Min = left==len1?Integer.MAX_VALUE:nums1[left];
        int num2Min = right==len2?Integer.MAX_VALUE:nums2[right];
        if ((len1+len2)%2==1){
            return Math.max(num1Max,num2Max);
        }else {
            return (double)(Math.max(num1Max,num2Max)+Math.min(num1Min,num2Min))/2.0;
        }
    }
    /**
     * @Description 求两个数组的中位数
     * @Author dongzeqi
     * @Date 2020/7/6 21:26
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays2(nums2,nums1);//保持数组1长度短 ,来确定遍历一定可以达到目的
        }
        int left = 0;
        int right = nums1.length;
        int k = (nums1.length+nums2.length+1)/2;//k为中心点如果为奇数能保证左侧元素多一个
        while (left < right){
            int a = (left+right+1)/2;
            int b = k-a;
            if (nums1[a-1]>nums2[b]){//判断nums1的左侧最大值跟nums2的右侧最小值比较锁定下次折半范围   跟a的定义相呼应 int a = (left+right+1)/2;   a为折半的中心点 保持总数为奇数时左侧多一个的原则
                right = a-1;//下次查询范围left->a-1
            }else {
                left = a;//下次查询范围a->right
            }
        }
        right = k-left;
        int nums1Max = left==0?Integer.MIN_VALUE:nums1[left-1];//获取数组一的左侧最大值
        int nums1Min = left==nums1.length?Integer.MAX_VALUE:nums1[left];//获取数组一的右侧最小值
        int nums2Max = right==0?Integer.MIN_VALUE:nums2[right-1];//获取数组二的左侧最大值
        int nums2Min = right==nums2.length?Integer.MAX_VALUE:nums2[right];//获取数组二的右侧最小值
        if ((nums1.length+nums2.length)%2 == 1){
            return Math.max(nums1Max,nums2Max);//总数为奇数时
        }else{
            return (double)(Math.max(nums1Max,nums2Max)+Math.min(nums1Min,nums2Min))/2.0;
        }
    }

    /**
     * @Description 求两个数组的中位数
     * @Author dongzeqi
     * @Date 2020/7/6 21:26
     */
    public static double findMedianSortedArrays1(int[] nums1,int[] nums2) {
        int length = nums1.length+nums2.length;
        int n1 = 0;
        int n2 = 0;
        int r = length/2;
        int ml = 0;
        int mr = 0;
        for (int i = 0; i < length; i++) {
            if (n2==nums2.length || (n1 < nums1.length && nums1[n1] <= nums2[n2])) {
                if (i==r) {
                    mr = nums1[n1];
                    break;
                }
                ml = nums1[n1];
                n1++;
            } else {
                if (i==r) {
                    mr = nums2[n2];
                    break;
                }
                ml = nums2[n2];
                n2++;
            }
        }
        if (length % 2==0) {
            return (double) (ml+mr)/2;
        } else {
            return mr;
        }
    }
}
