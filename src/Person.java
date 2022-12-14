import java.math.BigDecimal;

public class Person {
    private String name;
    private String cardNumber;
    private int account;

    public Person(String name, String cardNumber, int account) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return  "name: " + name +
                "\ncardNumber: " + cardNumber +
                "\naccount: " + account;
    }
}
