class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int index1= m-1;
        int index2= n-1;
        int tLen = m+n-1;

        while(index1>=0 && index2 >=0){

            nums1[tLen--] = nums1[index1] > nums2[index2]? nums1[index1--] : nums2[index2--];

        }

//nums2 如果遍历完，那么最后的值一定是-1，那么 index2+1 就是0， 从index2 中的0到0，什么都不用复制
        System.arraycopy(nums2,0,nums1,0,index2+1);     
    }
}