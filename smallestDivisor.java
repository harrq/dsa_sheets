class Solution {

    public static int calculate(int nums[],int mid){
        int sum=0;
        for(Integer i:nums){
            sum+=(int)Math.ceil((double)i/mid);
        }
        return sum;
    }

    public static int binarySearch(int nums[],int threshold){
         int max=0;
        for(Integer k:nums){
            max=Math.max(max,k);
        }
        int ans=-1;
        int j=1;
         while(j<=max){
            int mid=j+(max-j)/2;
            int sum=calculate(nums,mid);
        if(sum<=threshold){
            ans=mid;
            max=mid-1;
        }else{
            j=mid+1;
        }
         }
         return ans;
    }


    public int smallestDivisor(int[] nums, int threshold) {
            return binarySearch(nums,threshold);
    }
}
