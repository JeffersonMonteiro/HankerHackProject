package dayscode;

import java.util.Scanner;

public class ReviewDay6 {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        //System.out.print("Please enter the number of strings you want to enter: ");
        //takes an integer input
        String[] string = new String[sc.nextInt()];

        //consuming the <enter> from input above
        sc.nextLine();
        for (int i = 0; i < string.length; i++) {
            string[i] = sc.nextLine();
        }

        for (int j = 0; j< string.length; j++ ){
            StringBuilder evenElements = new StringBuilder();
            StringBuilder oddElements = new StringBuilder();
            char[] myElement = string[j].toCharArray();
            for (int h = 0; h< myElement.length; h++){
                if(h ==0 || h%2==0){
                    evenElements.append(myElement[h]);
                }else{
                    oddElements.append(myElement[h]);
                }
            }
            System.out.println(evenElements+" "+oddElements);
        }
    }
}
