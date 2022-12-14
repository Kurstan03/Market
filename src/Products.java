public enum Products {
    Сгущенка(45),
    Молоко(102),
    Творог(57,12),
    хлеб(15,10),
    Йогурт(20),
    Пепси(88, 7),
    Чай (140),
    Puc(343);



    private int price;
    private int discount;

    Products(int price) {
        this.price = price;
    }

    Products(int price, int discount) {
        this.price = price;
        this.discount = discount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return  "        " + price + "        " + discount;
    }
}
