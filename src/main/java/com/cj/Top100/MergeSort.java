import java.util.Arrays;

public class MergeSort {
    public static void divide(int[] arr,int left,int right,int mid){
        if(mid!=0){
            divide(arr,left,left+mid,mid/2);
            divide(arr,left+mid,right,mid/2);
            merge(arr,left,right,mid);
        }
    }
    public static void merge(int[] arr,int left,int right,int mid){
        int i=left,j=left+mid,index=0;
        int[] temp=new int[right-left];

        while (i<(left+mid)&&j<right){
            if(arr[i]<arr[j]){
                temp[index++]=arr[i++];
            }
            else {
                temp[index++]=arr[j++];
            }
        }

        while (i<left+mid){
            temp[index++]=arr[i++];
        }

        while (j<right){
            temp[index++]=arr[j++];
        }

        for (int s = 0; s < temp.length; s++) {
            arr[left++]=temp[s];
        }

    }
    public static void sort(int[] arr){
        if(arr.length==0) {
            return;
        }
        int mid=arr.length/2;
        divide(arr,0,arr.length-1,mid);
    }

    public static void main(String[] args) {
        int[] test = {2, 3, 1, 4,5,3,4,7};
        sort(test);
        System.out.println(Arrays.toString(test));
    }
}
