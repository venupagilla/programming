class uniquePathsWithObstacles {
    static int helper(int m, int n, int x, int y, int[][] ob,int[][] dp) {
        if (x >= m || y >= n) return 0;
        
        if (ob[x][y] == 1) return 0;
        
        if (x == m - 1 && y == n - 1) return 1;
        if(dp[x][y]!=-1) return dp[x][y];
        
        int right = helper(m, n, x, y + 1, ob,dp);
        int bottom = helper(m, n, x + 1, y, ob,dp);
        
        dp[x][y]=right+bottom;
        return right + bottom;
    }
    
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return helper(m, n, 0, 0, obstacleGrid,dp);
    }
}