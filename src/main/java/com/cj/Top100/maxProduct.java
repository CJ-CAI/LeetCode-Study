public class maxProduct {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,0,-1};
        boolean flag=false;
        int cache=1,sum=1,Max=Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
           sum*=nums[i];
           Max=Math.max(Max,sum);
           if(sum<0){
               if(flag==false){
                   cache=sum;
                   sum=1;
                   flag=true;
               }
               else {
                   sum=cache*sum;
                   flag=false;
                   Max=Math.max(Max,sum);
               }
           }
           else if (sum==0) {
               flag=false;
               sum=1;
           }
        }

        flag=false;
        cache=sum=1;
        for (int i = nums.length-1; i >=0; i--) {
            sum*=nums[i];
            Max=Math.max(Max,sum);
            if(sum<0){
                if(flag==false){
                    cache=sum;
                    sum=1;
                    flag=true;
                }
                else {
                    sum=cache*sum;
                    flag=false;
                    Max=Math.max(Max,sum);
                }
            }
            else if (sum==0) {
                flag=false;
                sum=1;
            }
        }
        System.out.println(Max);
    }
}
