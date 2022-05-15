public class Main {
    public static void main(String[] args) {
        final int NUMBER_OF_DEALS = 2;
        Autoshow autoshow = new Autoshow(NUMBER_OF_DEALS, NUMBER_OF_DEALS);
        while (autoshow.getMaxNumberOfProduces() > 0 && autoshow.getMaxNumberOfSales() > 0) {
            startSales(autoshow);
            new Thread(null, autoshow::receiveCar, "Производитель").start();
        }
    }

    public static void startSales(Autoshow autoshow) {
        for (int i = 1 ; i <= autoshow.getCustomers().size() ; i++) {
            String nameOfCustomer = "Покупатель " + i;
            new Thread(null, autoshow::sellCar, nameOfCustomer).start();
        }
    }


}
