class Solution {

    public int first(int nums[],int target){
        int i=0;
        int j=nums.length-1;
        int first=-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(nums[mid]==target){
              first=mid;
              j=mid-1;
            }

           else if(nums[mid]>target){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return first;
    }

    public int last(int nums[],int target){
        int i=0;
        int j=nums.length-1;
        int first=-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(nums[mid]==target){
            first=mid;
              i=mid+1;
            }
           else if(nums[mid]>target){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return first;
    }
    public int[] searchRange(int[] nums, int target) {
        int result[]={-1,-1};
        result[0]=first(nums,target);
         result[1]=last(nums,target);
         return result;
    }
}
