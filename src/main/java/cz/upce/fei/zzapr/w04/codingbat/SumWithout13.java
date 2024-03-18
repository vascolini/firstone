package cz.upce.fei.zzapr.w04.codingbat;

public class SumWithout13 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {1, 1};
        int[] nums3 = {1, 2, 2, 1, 13};
        int[] nums4 = {1, 2, 2, 1, 13, 3, 4};

        System.out.println("sum13([1, 2, 2, 1]) → " + sum13(nums1));
        System.out.println("sum13([1, 1]) → " + sum13(nums2));
        System.out.println("sum13([1, 2, 2, 1, 13]) → " + sum13(nums3));
        System.out.println("sum13([1, 2, 2, 1, 13, 3, 4]) → " + sum13(nums4));
    }

    public static int sum13(int[] nums) {
        int sum = 0;
        boolean skipNext = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 13) {
                skipNext = true;
            } else if (!skipNext) {
                sum += nums[i];
            } else {
                skipNext = false;
            }
        }

        return sum;
    }
}
