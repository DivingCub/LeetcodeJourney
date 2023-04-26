class Solution {
    public int trap(int[] height) {

        int len = height.length;

        if(len<=2 || height ==null){
            return 0;
        }

        int res = 0;

        Deque<Integer> tem = new ArrayDeque<>();

        for(int i=0;i<len;i++){

            while(!tem.isEmpty()&& height[i]> height[tem.peekLast()]){
                
                int btm = tem.pollLast();

                //这里的特殊情况考虑非常重要
                if(tem.isEmpty()){
                    break;
                }                
                
               
                int l = tem.peekLast();
                int hei = (Math.min(height[i],height[l]) - height[btm]);
                int wid = i - l -1;

                res = res + hei * wid;
                
            }

            tem.addLast(i);

        }

        return res;
        
    }
}