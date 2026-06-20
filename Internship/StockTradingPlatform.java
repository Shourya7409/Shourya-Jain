import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double balance = 10000.0;

        HashMap<String, Stock> market = new HashMap<>();
        market.put("TCS", new Stock("TCS", 3500));
        market.put("INFY", new Stock("INFY", 1500));
        market.put("WIPRO", new Stock("WIPRO", 500));

        HashMap<String, Integer> portfolio = new HashMap<>();

        while (true) {

            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("Balance: ₹" + balance);

            System.out.println("\n1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Stocks:");
                    for (Stock stock : market.values()) {
                        System.out.println(stock.name + " - ₹" + stock.price);
                    }
                    break;

                case 2:
                    System.out.print("Enter Stock Name: ");
                    String buyStock = sc.next().toUpperCase();

                    if (!market.containsKey(buyStock)) {
                        System.out.println("Stock not found!");
                        break;
                    }

                    System.out.print("Enter Quantity: ");
                    int buyQty = sc.nextInt();

                    double cost = market.get(buyStock).price * buyQty;

                    if (cost > balance) {
                        System.out.println("Insufficient Balance!");
                    } else {
                        balance -= cost;

                        portfolio.put(
                                buyStock,
                                portfolio.getOrDefault(buyStock, 0) + buyQty);

                        System.out.println("Purchase Successful!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Stock Name: ");
                    String sellStock = sc.next().toUpperCase();

                    if (!portfolio.containsKey(sellStock)
                            || portfolio.get(sellStock) == 0) {

                        System.out.println("You don't own this stock!");
                        break;
                    }

                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();

                    if (sellQty > portfolio.get(sellStock)) {
                        System.out.println("Not enough shares!");
                    } else {

                        double amount =
                                market.get(sellStock).price * sellQty;

                        balance += amount;

                        portfolio.put(
                                sellStock,
                                portfolio.get(sellStock) - sellQty);

                        System.out.println("Stock Sold Successfully!");
                    }
                    break;

                case 4:
                    System.out.println("\n===== PORTFOLIO =====");

                    if (portfolio.isEmpty()) {
                        System.out.println("No stocks purchased.");
                    } else {
                        for (Map.Entry<String, Integer> entry :
                                portfolio.entrySet()) {

                            System.out.println(
                                    entry.getKey() +
                                    " : " +
                                    entry.getValue() +
                                    " shares");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}