import java.util.HashMap;
import java.util.Map;

public class hashmap{
    public static void main(String args[]){
        Map<String, Integer> hello=new HashMap<>();
        hello.put("a",10);
        hello.put("b",5);
        for(String keyname:hello.keySet()){
            System.out.println(keyname+" : "+hello.get(keyname));
        }

    }
}
