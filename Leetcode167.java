//双指针

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length-1;
        while(l<r){
            int sum = numbers[l] + numbers[r];
            if(sum == target){
                return new int[]{l+1,r+1};
            }else if( sum<target){
                l++;
            }else{
                r--;
            }
        }
       return new int[]{-1,-1};    
    }
}


//hashMap

class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int[] ans = new int[2];
        Map<Integer,Integer> map = new HashMap<>();

        

        for(int index =0;index<numbers.length;index++){

            if(map.containsKey(numbers[index])){
                ans[0] = map.get(numbers[index])+1;
                ans[1] = index+1;
            }else{
                map.put(target - numbers[index],index);
            }

        }

        return ans;
       
    }
}
