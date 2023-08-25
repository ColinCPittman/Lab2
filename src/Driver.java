import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        StockItem milk = new StockItem("1 Gallon of Milk", 3.60f, 15);
        StockItem bread = new StockItem("1 Loaf of Bread", 1.98f, 30);
        do {
            System.out.print(getMainMenu());
            choice = getMenuChoice(1, 7, 8, "Choice: ");
            switch (choice) {
                case 1: //sold one milk
                    milk.lowerQty(1);
                    break;
                case 2: //sold one bread
                    bread.lowerQty(1);
                    break;
                case 3: //change price of milk
                    System.out.println("New price of milk: ");
                    milk.setPrice(sc.nextFloat());
                    break;
                case 4: //change price of bread
                    System.out.println("New price of bread: ");
                    bread.setPrice(sc.nextFloat());
                    break;
                case 5: //add milk to inventory
                    System.out.println("Enter qty of milk to add to inventory: ");
                    milk.raiseQty(sc.nextInt());
                    break;
                case 6: //add bread to inventory
                    System.out.println("Enter qty of bread to add to inventory: ");
                    bread.raiseQty(sc.nextInt());
                    break;
                case 7: //see inventory
                    System.out.println("Milk: " + milk.toString() + "\nBread: " + bread.toString());
                    break;
                default:
                    break;
            }
        } while (choice != 8);

    }

    public static int getMenuChoice(int lowValue, int highValue, int exitValue, String choicePrompt) { //method getting an int between starting and ending value (both inclusive).
        Scanner sc = new Scanner(System.in);
        boolean gotError = false;
        int y = exitValue;
        do {
            System.out.print(choicePrompt);
            gotError = false;
            try {
                y = sc.nextInt();
                sc.nextLine();
                if ((!(lowValue <= y && y <= highValue) && y != exitValue)) {
                    gotError = true;
                }
            } catch (Exception err) {
                gotError = true;
                sc.nextLine();
            }
            if (gotError) {
                System.out.println("Invalid input, please enter choice [" + exitValue + " to exit].");
            }
        } while (gotError);
        return y;
    }
    public static String getMainMenu() {
        return """
                                
                1. Sold One Milk
                2. Sold One Bread
                3. Change price of Milk
                4. Change price of Bread
                5. Add Milk to Inventory
                6. Add Bread to Inventory
                7. See Inventory
                8. Quit
                """;
    }
}