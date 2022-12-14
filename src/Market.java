import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Market {
    private String name;
    private int account;
    private Products[] products;

    public Market(String name, int account, Products[] products) {
        this.name = name;
        this.account = account;
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public Products[] getProducts() {
        return products;
    }

    public void setProducts(Products[] products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Market{" +
                "name='" + name + '\'' +
                ", account=" + account +
                ", products=" + Arrays.toString(products) +
                '}';
    }
}
