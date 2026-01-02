import java.util.HashMap;
import java.util.Map;
class NRepeatedElementinSize2NArray {
    public int repeatedNTimes(int[] nums) {
        Map<Integer,Integer> counts=new HashMap<>();
        int n=nums.length;
        int reqCount=n/2;
        for(int i=0;i<n;i++){
            int val=nums[i];
            int curcount=counts.getOrDefault(val,0)+1;
            if(curcount==reqCount){
                return val;
            }
            counts.put(val,curcount);
        }
        return -1;
    }
}