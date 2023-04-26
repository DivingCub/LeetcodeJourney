class Solution {
    public int findKthPositive(int[] arr, int k) {

        int l  = 0;
        int  r = arr.length-1;


        while(l<=r){

            int mid= l+ (r-l)/2;

            if(arr[mid] - mid -1 <k){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        //结束的时候，l会是 r+1  arr[r] + k - (arr[r]-r-1);
        return  l + k;
        
        
    }
}