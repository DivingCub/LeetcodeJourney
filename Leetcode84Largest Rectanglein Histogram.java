class Solution {
    public int largestRectangleArea(int[] heights) {

        

        int len = heights.length;

        if(len==0){
            return 0;
        }

        if(len ==1){
            return heights[0];
        }

        int Area = 0;

        Deque<Integer> tem = new ArrayDeque<>();

        for(int i=0;i<len;i++){

            while(!tem.isEmpty()&& heights[i]<heights[tem.peekLast()]){

                int curHeight = heights[tem.pollLast()];

                while(!tem.isEmpty()&& curHeight==heights[tem.peekLast()]){
                    tem.pollLast();
                }

                int curLength;

                if(tem.size()==0){
                    curLength = i;
                }else{
                    curLength = i-tem.peekLast()-1;
                }

                Area = Math.max(Area, curHeight*curLength);
            }

            tem.addLast(i);
        }


        while(!tem.isEmpty()){

            int curHeight1 = heights[tem.pollLast()];
        
            while(!tem.isEmpty() && curHeight1 == heights[tem.peekLast()]){
                tem.pollLast();
            }

            int curLength1 = 0;
            if(tem.isEmpty()){
                 curLength1 = len;
            }else{
                curLength1 = len - tem.peekLast() -1;
            }

            Area = Math.max(Area,curHeight1*curLength1);

        }

        return Area;
    }
}