package HOT.Map;

class Solution {
    public int orangesRotting(int[][] grid) {
        int fc = 0; //fresh_count
        
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) fc++;
            }
        }
        for(int k = 0; k < fc; k++){
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == k + 2){
                        if(i > 0){
                            if(grid[i - 1][j] == 1) grid[i - 1][j] = k + 3;
                        }if(i < m - 1){
                            if(grid[i + 1][j] == 1) grid[i + 1][j] = k + 3;
                        }if(j > 0){
                            if(grid[i][j - 1] == 1) grid[i][j - 1] = k + 3;
                        }if(j < n - 1){
                            if(grid[i][j + 1] == 1) grid[i][j + 1] = k + 3;
                        }
                    }
                }
            }
        }
        int maxTime = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1) return -1;
                maxTime = Math.max(maxTime, grid[i][j]);
            }
        }
        return maxTime > 0 ? maxTime - 2 : 0;
    }
}