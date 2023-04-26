class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

       int row = matrix.length;
       int col = matrix[0].length;

       int upbase = 0;
       int downbase =  row-1;
       int rightbase = col-1;
       int leftbase = 0;
        
        List<Integer> res = new ArrayList<>();

        while(res.size()<row*col){
            
            //横向先开
            if(upbase<=downbase){
                //这里是等号，不是<
                for(int i=leftbase;i<=rightbase;i++){
                    res.add(matrix[upbase][i]);
                }
                upbase++;
            };
            //右边那一行开始
            if(leftbase<=rightbase){
                for(int j=upbase;j<=downbase;j++){
                    res.add(matrix[j][rightbase]);
                }
                rightbase--;
            }
            //底层哪一行
            if(upbase<=downbase){

                for(int i = rightbase;i>=leftbase;i--){
                    res.add(matrix[downbase][i]);
                }
                downbase--;
            };
            //左边的哪一行
            if(leftbase<=rightbase){
                for(int j= downbase;j>=upbase;j--){
                    res.add(matrix[j][leftbase]);
                    //这边横坐标，纵坐标这块自己搞反了，还是要想清楚
                }
                leftbase++;
            }
        }
       
        return res;
    }
}