package consol;


import java.util.Scanner;

public class Console {
    private static String bound = "\n________________________________________________";
    public static int askCustomer() {
        Scanner scan1 = new Scanner(System.in);
        int var1 = 0;
        System.out.println("What information you want find: \n1. Courses.\n2. Lectures. "
                    + "\n3. Lectors.\n6. Finish.");
        try{
            var1 = scan1.nextInt();
        }catch(Exception e){
            System.err.println("Incorrect information! Try again.");
            System.out.println(bound);
            scan1 = new Scanner(System.in);
        }
        return var1;
    }
}
