class Sort012 {
    public void sort012(int[] arr) {
        // code here
        int low=0,mid=0,high=arr.length-1,temp=-1;
        while(mid<=high){
            if(arr[mid]==0){
                temp=arr[mid];
                arr[mid]=arr[low];
                arr[low]=temp;
                low++;
                mid++;
            }else if(arr[mid]==1){
                mid++;
            }else{
                temp=arr[mid];
                arr[mid]=arr[high];
                arr[high]=temp;
                high--;
            }
        }
    }
}