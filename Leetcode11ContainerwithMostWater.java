class Solution {
    public int maxArea(int[] height) {

        int l = 0;
        int r = height.length-1;
        int res = Integer.MIN_VALUE;

        while(l<r){

            int cur = (r-l) * (Math.min(height[l],height[r]));

            res = Math.max(res,cur);

            if(height[r]>height[l]){
                l++;
            }else{
                r--;
            }
        }
     
        return res;
    }
}