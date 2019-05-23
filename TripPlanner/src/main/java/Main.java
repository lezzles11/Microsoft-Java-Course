
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    // implement your program here
    // do not put all to one method/class but rather design a proper structure to your program
        
    // Your program should use only one Scanner object, i.e., it is allowed to call 
    // new Scanner only once. If you need scanner in multiple places, you can pass it as parameter
    public static void what() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name?");
        String name = reader.nextLine(); 
        System.out.println("Nice to meet you " + name + ", where are you travelling to?");
        String destination = reader.nextLine();
        System.out.print("Great! " + destination + " sounds like a great trip");
            in.close(); 
    }

    
    public static void budget() {
        Scanner reader = new Scanner (System.in);
        System.out.print("How many days are you going to spend travelling?");
        int daysTravel = Integer.parseInt(reader.nextLine()); 
        String days = String.valueOf(daysTravel);
        int hoursTravel = daysTravel * 24;
        int minutesTravel = hoursTravel * 60; 
        String hours = String.valueOf(hoursTravel); 
        String minutes = String.valueOf(minutesTravel); 
        System.out.print("How much money, in USD, are you planning to spend on your trip?");
        int amount = Integer.parseInt(reader.nextLine());
        System.out.print("What is the three letter currency symbol for your travel destination?");
        String three = reader.nextLine(); 
        System.out.print("How many " + three + " are there in USD?");
        int usdTotal = Integer.parseInt(reader.nextLine()); 
        double inThree = usdTotal * amount; 
        double perDaySpending = inThree / daysTravel; 
        
        
        System.out.println("If you are travelling for " + days + " days that is the same as " + hours + " or " + minutes + " minutes.");
        System.out.println("If you are going to spend $" + amount + " USD that means per day you can spend up to $" + (amount/daysTravel) + " USD");
        System.out.println("Your total budget in " + three + " is " + inThree + " " + three + ", which per day is " + perDaySpending + " " + three);
        in.close(); 
    }
    
    public static void time() {
        Scanner reader = new Scanner (System.in);
        System.out.println("What is the time difference, in hours, between your home and your destination?");
        int timeDiff = Integer.parseInt(reader.next());
        int vacay = 12 + timeDiff; 
        System.out.println("That means that when it is midnight at home it will be " + vacay + ":00 in your travel destination.");
        in.close(); 
    }
    
    public static void distance() {
        Scanner reader = new Scanner (System.in);
        System.out.println("What is the square area of your destination country in km2?");
        int squareArea = Integer.parseInt(reader.nextLine());
        double miles = squareArea / 1.609; 
        System.out.println("In miles that is " + miles);
        in.close(); 

    }
    
    }

}
