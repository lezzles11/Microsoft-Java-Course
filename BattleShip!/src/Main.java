import java.util.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lesleycheung
 */

public class Main {
    public static int rows = 10;
    public static int columns = 10;
    public static int printPlayerShips;
    public static int printComputerShips;
    public static String[][] bigMap = new String[rows][columns];
    public static int[][] missedGuesses = new int[rows][columns];
    
    public static void main(String[] args) {
        System.out.println("**** Welcome to Lesley's Battleship game! ****");
        System.out.println("Right now, the sea is empty\n");
        map();
        playersShips();
        computersShips();
        do {
            fight();
        } while (Main.printPlayerShips != 0 && Main.printComputerShips != 0);
        gameOver();
    }
    
    public static void map() {
        //Creating map - 
        System.out.print("  ");
        for (int i = 0; i < columns; i++) 
            System.out.print(i);
        System.out.println();
        // Looping over to make multi-dimensional array
        for (int i = 0; i < bigMap.length; i++) {
            for (int j = 0; j < bigMap.length; j++) {
                
                bigMap[i][j] = " ";
                if (j == 0)
                    // when j = 0 - insert | (beginning)
                    System.out.print(i + "|" + bigMap[i][j]);
                    // the ending | and the number 
                else if (j == bigMap[i].length - 1) 
                    System.out.print(bigMap[i][j] + "|" + i);
                else    
                    System.out.print(bigMap[i][j]);
            }
            System.out.println();
        }
        
        System.out.print("  ");
        for (int i = 0; i < columns; i++) 
            System.out.print(i);
        System.out.println();
    }
    
    
    
    public static void playersShips() {
        Scanner reader = new Scanner(System.in);
        System.out.println("\nLet's start! ");
        Main.printPlayerShips = 5; 
        for (int i = 1; i <= Main.printPlayerShips;) {
            System.out.println("Enter X coordinate for your " + i + " ship: ");
            int x = Integer.parseInt(reader.nextLine());
            System.out.println("Enter Y coordinate for your " + i + " ship: ");
            int y = Integer.parseInt(reader.nextLine());
            if ((x >= 0 && x < rows) && (y >= 0 && y < columns) && (bigMap[x][y] == " ")) {
                bigMap[x][y] = "@";
                i++;
            } 
            else if ((x >= 0 && x < rows) && (y >= 0 && y < columns) && bigMap[x][y] == "@")
                System.out.println("You can't place two or more ships in the same location");
            else if ((x < 0 || x >= rows) || (y < 0 || y >= columns))
                System.out.println("You can't place ships outside the " + rows + "by " + columns + "grid");
        }
        printMap();
    }
    
    public static void computersShips() {
        System.out.println("\nComputer's Turn... MUAHAHAHA");
        Main.printComputerShips = 5; 
        for (int i = 1; i <= Main.printComputerShips; ) {
            int x = (int)(Math.random() * 10);
            int y = (int)(Math.random() * 10);
            
            if ((x < rows && x >= 0) && (y >= 0 && y < columns) && (bigMap[x][y] == " ")){
                bigMap[x][y] = "x";
                System.out.println(i + ". ship deployed!");
                i++;
            } 
        }
        printMap();
    }
    
    public static void fight() {
        playerTurn();
        computerTurn();
        printMap();
        System.out.println();
        System.out.println("Your ships: " + Main.printPlayerShips + " | Computer ships: " + Main.printComputerShips);
        System.out.println();
    }
    
    public static void playerTurn() {
        System.out.println("Let's go.");
        int x = -1, y = -1; 
        do { 
            Scanner reader = new Scanner(System.in);
            System.out.println("Enter X coordinate: ");
            x = Integer.parseInt(reader.nextLine());
            System.out.println("Enter Y coordinate: ");
            y = Integer.parseInt(reader.nextLine());
            
            if ((x >= 0 && x < rows) && (y >= 0 && y < columns)) {
                if (bigMap[x][y] == "x") {
                    System.out.println("Nice job!!!");
                    bigMap[x][y] = "!";
                    --Main.printComputerShips; 
                } else if (bigMap[x][y] == "@") {
                    System.out.println("Oh no... you killed your own...");
                    bigMap[x][y] = "x";
                    --Main.printPlayerShips; 
                    ++Main.printComputerShips; 
                } else if (bigMap[x][y] == " ") {
                    System.out.println("Missed.");
                    bigMap[x][y] = "-";
                }    
            } else if ((x < 0 || x >= rows) || (y < 0 || y >= columns))
                System.out.println("You can't place ships outside the " + rows + " or " + columns);
        
        } while ((x < 0 || x >= rows) || (y < 0 || y >= columns));
        }
    
    public static void computerTurn() {
        System.out.println("\n The Computer's Turn!");
        int x = -1, y = -1; 
        do {
            x = (int)(Math.random() * 10);
            y = (int)(Math.random() * 10);
            if ((x >= 0 && x < rows) && (y >= 0 && y < columns)) {
                if (bigMap[x][y] == "@") {
                    System.out.println("They got one of your ships!!");
                    bigMap[x][y] = "x"; 
                    --Main.printPlayerShips; 
                    ++Main.printComputerShips; 
                } else if (bigMap[x][y] == "x") {
                    System.out.println("The computer killed one of its own ships. lol.");
                } else if (bigMap[x][y] == " ") {
                    System.out.println("You're still safe! They missed!");
                    if (missedGuesses[x][y] != 1)
                        missedGuesses[x][y] = 1; 
                }
            }
        } while ((x < 0 || x >= rows) || (y < 0 || y >= columns)); 
    }
    
    public static void gameOver() {
        System.out.println("Your ships: " + Main.printPlayerShips + " | Computer ships: " + Main.printComputerShips);
        if (Main.printPlayerShips > 0 && Main.printComputerShips <= 0)
            System.out.println("You won, like I knew you would!");
        else 
            System.out.println("Well... not a win this time. Better luck next time!");
    }
    public static void printMap() {
        System.out.println();
        System.out.print("  ");
        for (int i = 0; i < columns; i++)
            System.out.print(i);
        for (int x = 0; x < bigMap.length; x++) {
            System.out.print(x + "|");
            for (int y = 0; y < bigMap[x].length; y++) {
                System.out.print(bigMap[x][y]);
            }
            System.out.println("|" + x);
        }
        System.out.print("  ");
        for (int i = 0; i < columns; i++)
            System.out.print(i);
    }

    
    
}

