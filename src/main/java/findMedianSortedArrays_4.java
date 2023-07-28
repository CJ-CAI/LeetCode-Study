import java.util.Arrays;

public class findMedianSortedArrays_4 {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        int sum = nums2.length + nums1.length;
        int i = 0, j = 0;
        int a=0,b=0;
        for (int l = 0; l < sum/2+1; l++) {
            b=a;
            if (i<nums1.length && (j >= nums2.length || nums1[i] < nums2[j]) ) {
                a=nums1[i];
                i++;

            } else {
                a=nums2[j];
                j++;
            }
        }
        if(sum%2==0)
            System.out.println(a+" "+b+" "+(a+b)/2.0);
        else
            System.out.println(a);
    }
}
