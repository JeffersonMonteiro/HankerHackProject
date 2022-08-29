package dayscode.exceptions.stringtointeger;

import java.io.*;

import static java.util.stream.Collectors.joining;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String S = bufferedReader.readLine();

        try{
            System.out.println(Integer.parseInt(S));
        }catch(NumberFormatException e){
            System.out.println("Bad String");
            throw new NumberFormatException("Bad String");
        }



        bufferedReader.close();
    }
}
