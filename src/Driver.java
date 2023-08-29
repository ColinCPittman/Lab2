import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        int choice;
        Scanner sc = new Scanner(System.in);
        StockItem milk = new StockItem("1 Gallon of Milk", 3.60f, 15);
        StockItem bread = new StockItem("1 Loaf of Bread", 1.98f, 30);
        do {
            System.out.print(mainMenu);
            choice = getMenuChoice(fromOne, toSeven, exitValue, "Choice: ");
            switch (choice) {
                case sold_one_milk:
                    milk.lowerQty(1);
                    break;
                case sold_one_bread:
                    bread.lowerQty(1);
                    break;
                case change_price_of_milk:
                    System.out.println("New price of milk: ");
                    milk.setPrice(sc.nextFloat());
                    break;
                case change_price_of_bread:
                    System.out.println("New price of bread: ");
                    bread.setPrice(sc.nextFloat());
                    break;
                case add_milk_to_inventory:
                    System.out.println("Enter qty of milk to add to inventory: ");
                    milk.raiseQty(sc.nextInt());
                    break;
                case add_bread_to_inventory:
                    System.out.println("Enter qty of bread to add to inventory: ");
                    bread.raiseQty(sc.nextInt());
                    break;
                case see_inventory:
                    System.out.println("Milk: " + milk + "\nBread: " + bread);
                    break;
                default:
                    break;
            }
        } while (choice != exitValue);

    }

    static final int sold_one_milk = 1;
    static final int sold_one_bread = 2;
    static final int change_price_of_milk = 3;
    static final int change_price_of_bread = 4;
    static final int add_milk_to_inventory = 5;
    static final int add_bread_to_inventory = 6;
    static final int see_inventory = 7;
    static final int exitValue = 8;
    static final int fromOne = 1;
    static final int toSeven = 7;

    public static int getMenuChoice(int lowValue, int highValue, int exitValue, String choicePrompt) {
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

    public static String mainMenu = """
                            
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