public class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for (int i=0; i<grid.length; i++)
            for (int j=0; j<grid[i].length; j++)
                islands += sink(grid, i, j);
        return islands;
    }
    int sink(char[][] grid, int i, int j) {
        if (i < 0 || i == grid.length || j < 0 || j == grid[i].length || grid[i][j] != '1')
            return 0;
        grid[i][j] = '2';
        for (int k=0; k<4; k++)
            sink(grid, i+d[k], j+d[k+1]);
        return 1;
    }
    int[] d = {0, 1, 0, -1, 0};
}

// Leetcode 
public class Solution {
    public int numIslands(char[][] grid) {
        
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    travels(grid,i,j);
                    res++;
                }
            }
        }
        return res;
    }

    private void travels(char[][] grid, int i,int j){

        int[] d = {0, 1, 0, -1, 0};

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != '1') return;

        grid[i][j] = 'v';

        for(int k =0;k<4;k++){
            travels(grid,i+d[k],j+d[k+1]);
        }

    }

}



