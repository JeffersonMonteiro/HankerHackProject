package dayscode;

import java.util.Scanner;

public class ClassVsInstance {
    private int age;
    private StringBuilder message;
    private int initialAge;

    public ClassVsInstance(int initialAge) {
        message = new StringBuilder();
        // Add some more code to run some checks on initialAge
        if(initialAge <0){
            this.age = 0;
            message.append("Age is not valid, setting age to 0.\n");
        }else{
            this.age = initialAge;
            this.initialAge = initialAge;
        }
    }

    public void amIOld() {
        // Write code determining if this person's age is old and print the correct statement:
        if(age < 13){
            message.append("You are young.\n");
        }else if(age >=13 && age <18){
            message.append("You are a teenager.\n");
        }else{
            message.append("You are old.\n");
        }

        if(age > initialAge){
            System.out.println(message.toString().substring(0,message.length()-1));
        }
     }

    public void yearPasses() {
       this.age++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int age = sc.nextInt();
            ClassVsInstance p = new ClassVsInstance(age);
            p.amIOld();
            for (int j = 0; j < 3; j++) {
                p.yearPasses();
            }
            p.amIOld();
            System.out.println();
        }
        sc.close();
    }
}