package cz.upce.fei.zzapr.w04.codingbat;

public class TripleUp {
    public static void main(String[] args) {
        int[] nums1 = {1, 4, 5, 6, 2};
        int[] nums2 = {1, 2, 3};
        int[] nums3 = {1, 2, 4};

        System.out.println("tripleUp([1, 4, 5, 6, 2]) → " + tripleUp(nums1));
        System.out.println("tripleUp([1, 2, 3]) → " + tripleUp(nums2));
        System.out.println("tripleUp([1, 2, 4]) → " + tripleUp(nums3));
    }

    public static boolean tripleUp(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2]) {
                return true;
            }
        }
        return false;
    }
}
