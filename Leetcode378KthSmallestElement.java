class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((x1,x2)->{
            return x2-x1;
        });

        int row = matrix.length;
        int col = matrix[0].length;

        for(int i=0; i<row;i++){
            for(int j=0; j<col;j++){

               if(pq.size()<k){

                   pq.offer(matrix[i][j]);

               }else{
                   
                   if(matrix[i][j] < pq.peek()){

                    pq.offer(matrix[i][j]);
                    pq.poll();

                   }

               }

            }
        }

        return pq.peek();

    }
}