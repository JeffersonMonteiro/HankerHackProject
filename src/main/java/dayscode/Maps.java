package dayscode;

import java.util.HashMap;
import java.util.Scanner;

class Maps{

    public static void main(String []argh){
        HashMap<String, String> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++){
            String name = in.next();
            int phone = in.nextInt();
            // Write code here
            map.put(name, String.valueOf(phone));

        }
        while(in.hasNext()){
            String s = in.next();
            // Write code here

            if(map.containsKey(s)){
                System.out.println(s+"="+map.get(s));
            }else{
                System.out.println("Not found");
            }
        }
        in.close();
    }
}