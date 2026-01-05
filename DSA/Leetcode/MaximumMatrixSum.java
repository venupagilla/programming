class  MaximumMatrixSum{
    public long maxMatrixSum(int[][] matrix) {
        int n=matrix.length;
        int negativecount=0;
        long sum=0;
        int smallestvalue=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                int val=matrix[i][j];
                sum+=Math.abs(val);
                if(val<0){
                    negativecount++;
                }
                smallestvalue=Math.min(smallestvalue,Math.abs(val));
            }
        }
        if(negativecount%2==0){
            return sum;
        }else{
            return sum-2L*smallestvalue;
        }
    }
}
