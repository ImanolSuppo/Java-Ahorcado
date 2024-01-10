package ar.edu.utn.frc.tup.lciii;

import java.util.Scanner;

/**
 * Hello Strings 3!
 *
 */
public class App 
{

    /**
     * This is the main program
     * 
     */
    public static void main( String[] args )
    {
        Scanner sc=new Scanner(System.in);
        String a =sc.next();
        String b =sc.next();
        System.out.print((sumTheLenghts(a, b))+System.lineSeparator());
        System.out.print((isLexicographically(a, b) ? "Yes" : "No")+System.lineSeparator());
        System.out.print(capitalizeFirstLetter(a, b)+System.lineSeparator());

    }

    private static String capitalizeFirstLetter(String a, String b) {
        a = a.substring(0, 1).toUpperCase() + a.substring(1);
        b = b.substring(0, 1).toUpperCase() + b.substring(1);
        return a + " " + b;
    }

    private static boolean isLexicographically(String a, String b) {
        if (a.compareTo(b)<0)
            return false;
        return  true;
    }

    private static int sumTheLenghts(String a, String b) {
        return a.length()+b.length();
    }
}
