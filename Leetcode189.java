//重新复制到一个新的数组里面去的情况

class Solution {
    public void rotate(int[] nums, int k) {

        int len = nums.length;

        int[] numsCopy = new int[len];


        k = k%len;

        for(int i=0;i<len;i++){

         numsCopy[(i+k)%len] = nums[i];
        }

        for(int i=0;i<len;i++){

           nums[i] = numsCopy[i];

        }
        
    }
}

//翻转数组的方式来进行处理
class Solution {
    public void rotate(int[] nums, int k) {

        int len = nums.length;

        k = k%len;

        flipArr(nums,0,len-1);
        flipArr(nums,0,k-1);
        flipArr(nums,k,len-1);
        
       
        
    }

    private void flipArr(int[] arr,int beg ,int end){

        while(beg<end){


           int tem = arr[beg];
           arr[beg]=arr[end];
           arr[end] = tem; 

           beg++;
           end--;

        }

    }

}