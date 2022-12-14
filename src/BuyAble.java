public interface BuyAble {

    void getAllProducts(Market market);

    void getDiscountProducts(Market market);

    StringBuilder getCheck(Market market, Person person);
}
