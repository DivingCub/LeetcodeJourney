class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(target - nums[0],0);
        for(int i=1;i<nums.length;i++){
            
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }else{
                map.put(target - nums[i],i);
            }
        }
        return null;
    }
}