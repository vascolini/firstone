package cz.upce.fei.zzapr.w04.codingbat;


public class No14 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {2, 3, 4};

        System.out.println("no14([1, 2, 3]) → " + no14(nums1));
        System.out.println("no14([1, 2, 3, 4]) → " + no14(nums2));
        System.out.println("no14([2, 3, 4]) → " + no14(nums3));
    }

    public static boolean no14(int[] nums) {
        boolean contains1 = false;
        boolean contains4 = false;

        for (int num : nums) {
            if (num == 1) {
                contains1 = true;
            } else if (num == 4) {
                contains4 = true;
            }
        }

        return !contains1 || !contains4;
    }
}
