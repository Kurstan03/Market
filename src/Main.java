import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person person = new Person("Kurstan", "2222 1111",178030);
        List<Market> markets = new LinkedList<>();
        markets.add(new Market("Narodnyi", 200, Products.values()));
        markets.add(new Market("Frunze", 250, Products.values()));
        while (true){
            System.out.println("""
                    ~~~~~~~~~~~~~~~~~~~~
                    1.My info
                    2.Markets""");
            int num = new Scanner(System.in).nextInt();
            switch (num){
                case 1:
                    System.out.println(person);
                    break;
                case 2:
                        for (int i = 0; i < markets.size(); i++) {
                            System.out.println(markets.get(i).getName());
                        }
                        System.out.println("Write market name:");
                        String name = scanner.nextLine();
                        for (Market market : markets) {
                            if (name.equals(market.getName())) {
                                method(market, person);
                            }
                        }
                    break;

            }
        }


    }

    public static void method(Market market, Person person) {
        BuyAbleImpl buyAbleImpl = new BuyAbleImpl();
        while (true) {
            System.out.println("""
                    ~~~~~~~~~~~~~~~~~~~~~ 
                       Commands
                    1.All products
                    2.Discount products
                    3.Buy products
                    4.Market account
                    5.Back""");

            String number = new Scanner(System.in).nextLine();
            switch (number) {
                case "1":
                    buyAbleImpl.getAllProducts(market);
                    break;
                case "2":
                    buyAbleImpl.getDiscountProducts(market);
                    break;
                case "3":
                    System.out.println(buyAbleImpl.getCheck(market, person));
                    break;
                case "4":
                    System.out.println("Market:  " + market.getName());
                    System.out.println("Account:  " + market.getAccount());
            }
            if (number.equals("5")) {
                break;
            }
        }
    }
}