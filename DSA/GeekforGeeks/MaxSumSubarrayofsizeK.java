public class MaxSumSubarrayofsizeK {
    public int maxSubarraySum(int[] arr, int k) {
        // Code here
        int max=0;
        int cur=0;
        for(int i=0;i<k;i++){
            cur+=arr[i];
        }
        if(cur>max){
            max=cur;
        }
        for(int i=1;i<=arr.length-k;i++){
            cur-=arr[i-1];
            cur+=arr[i+k-1];
            if(cur>max){
                max=cur;
            }
        }
        return max;
    }
}
