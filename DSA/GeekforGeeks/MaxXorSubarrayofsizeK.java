public class MaxXorSubarrayofsizeK {
    public int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int cur=0;
        for(int i=0;i<k;i++){
            cur=cur^arr[i];
        }
        int max=cur;
        for(int i=1;i<arr.length-k+1;i++){
            cur=cur^arr[i-1];
            cur=cur^arr[i+k-1];
            if(cur>max){
                max=cur;
            }
        }
        return max;
    }
}
