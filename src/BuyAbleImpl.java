import java.time.LocalDate;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BuyAbleImpl implements BuyAble{
    @Override
    public void getAllProducts(Market market) {


        for (Products product : market.getProducts()) {
            System.out.println("___________________________________________________________");
            System.out.printf("""
                    Product name: %s  |  price: %s  |  discount: %d
                    """,product.name(), product.getPrice(), product.getDiscount());

            System.out.println("___________________________________________________________");
        }
    }

    @Override
    public void getDiscountProducts(Market market) {

        for (Products product : market.getProducts()) {
            if(product.getDiscount() != 0){
                System.out.println("___________________________________________________________");
                System.out.printf("""
                    Product name: %s  |  price: %s  |  discount: %d
                    """,product.name(), product.getPrice(), product.getDiscount());

                System.out.println("___________________________________________________________");
            }
        }
    }

    @Override
    public StringBuilder getCheck(Market market, Person person) {
        StringBuilder check = new StringBuilder("                   #########check#########\n");
        check.append("\nMarket: " + market.getName());
        check.append("\nPerson: " + person.getName());
        check.append("\nDate: " + LocalDate.now()).append("    " + LocalTime.now().getHour() +":" + LocalTime.now().getMinute());
        System.out.println("Write product name: ");
        int counter = 0;
        int counterDis = 0;
        String name = new Scanner(System.in).nextLine();
        for (Products product : market.getProducts()) {
            if (product.name().trim().toLowerCase().equals(name.toLowerCase().trim())) {
                System.out.println("Amount: ");
                int amount = new Scanner(System.in).nextInt();
                int summa = product.getPrice() * amount;
                check.append("\n\nName: " + product.name()).append(" | prise: " +
                        product.getPrice()).append(" | amount: " + amount).append(" | discount: " +
                        product.getDiscount()).append("% | summa: " + summa);
                counter += summa;
                counterDis += product.getDiscount();
                while (true) {
                    System.out.println("Anything else needed (yes/no)?");
                    String yesOrNo = new Scanner(System.in).nextLine();
                    if (yesOrNo.equals("yes")) {
                        System.out.println("Write product name: ");
                        String newName = new Scanner(System.in).nextLine();
                        for (Products product1 : market.getProducts()) {
                            if (product1.name().trim().toLowerCase().equals(newName.toLowerCase().trim())) {
                                System.out.println("Amount: ");
                                int amount1 = new Scanner(System.in).nextInt();
                                int summa1 = (product1.getPrice() * amount1);

                                check.append("\nName: " + product1.name()).append(" | prise: " +
                                        product1.getPrice()).append(" | amount: " + amount1).append(" | discount: " +
                                        product1.getDiscount()).append("% | summa: " + summa1);
                                counter += summa1;
                                counterDis += product.getDiscount();
                            }
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        check.append("\n\nTotal without discount:     " + counter);
        int totalDis = ((counter * counterDis) / 100);
        check.append("\n\nTotal discount:     " + totalDis);
        check.append("\n\nTOTAL:    " + (counter - totalDis) + " coм");
        market.setAccount(market.getAccount() + (counter - totalDis));
        person.setAccount(person.getAccount() - (counter - totalDis));
        return check.append("\n\nThank you for your purchase");
    }
}
