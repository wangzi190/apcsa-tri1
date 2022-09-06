// imports allow you to use code already written by others.  It is good to explore and learn libraries.  The names around the dots often give you a hint to the originator of the code.
import java.util.Scanner; //library for user input
import java.lang.Math; //library for random numbers


public class Menu {
    // Instance Variables
    public final String DEFAULT = "\u001B[0m";  // Default Terminal Color
    public final String[][] COLORS = { // 2D Array of ANSI Terminal Colors
        {"Default",DEFAULT},
        {"Red", "\u001B[31m"}, 
        {"Green", "\u001B[32m"}, 
        {"Yellow", "\u001B[33m"}, 
        {"Blue", "\u001B[34m"}, 
        {"Purple", "\u001B[35m"}, 
        {"Cyan", "\u001B[36m"}, 
        {"White", "\u001B[37m"}, 
    };
    // 2D column location for data
    public final int NAME = 0;
    public final int ANSI = 1;  // ANSI is the "standard" for terminal codes

    // Constructor on this Object takes control of menu events and actions
    public Menu() {
        Scanner sc = new Scanner(System.in);  // using Java Scanner Object
        
        this.print();  // print Menu
        boolean quit = false;
        while (!quit) {
            try {  // scan for Input
                int choice = sc.nextInt();  // using method from Java Scanner Object
                System.out.print("" + choice + ": ");
                quit = this.action(choice);  // take action
            } catch (Exception e) {
                sc.nextLine(); // error: clear buffer
                System.out.println(e + ": Not a number, try again.");
            }
        }
        sc.close();
    }

    // Print the menu options to Terminal
    private void print() {
        //System.out.println commands below is used to present a Menu to the user. 
        System.out.println("-------------------------\n");
        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Say Hello");
        System.out.println("2 - Output colors");
        System.out.println("3 - Loading in color");
        System.out.println("0 - Quit");
        System.out.println("-------------------------\n");
    }

    // Private method to perform action and return true if action is to quit/exit
    private boolean action(int selection) {
        boolean quit = false;

        switch (selection) {  // Switch or Switch/Case is Control Flow statement and is used to evaluate the user selection
            case 0:  
                System.out.print("Goodbye, World!");
                quit = true;
                break;
            case 1:
                System.out.print("Hello, World!");
                break;
            case 2:
                for(int i = 0; i < COLORS.length; i++)  // loop through COLORS array
                    System.out.print(COLORS[i][ANSI] + COLORS[i][NAME]);
                break;
            case 3:
                System.out.print("Loading...");
                for (int i = 0; i < 20; i++) {  // fixed length loading bar
                    int random = (int) (Math.random() * COLORS.length);  // random logic
                    try {
                        Thread.sleep(100);  // delay for loading
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    System.out.print(COLORS[random][ANSI] + "#");
                }
                break;
                    
            default:
                //Prints error message from console
                System.out.print("Unexpected choice, try again.");
        }
        System.out.println(DEFAULT);  // make sure to reset color and provide new line
        return quit;
    }

    // Static driver/tester method
    static public void main(String[] args)  {  
        new Menu(); // starting Menu object
    }

}
Menu.main(null);