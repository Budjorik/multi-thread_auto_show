public class Main {
    public static void main(String[] args) throws InterruptedException {
        int numberOfDeals = 10;
        Autoshow autoshow = new Autoshow(numberOfDeals, numberOfDeals);

        for (int i = 0 ; i < numberOfDeals ; i++) {
            startSales(autoshow);
            new Thread(null, autoshow::receiveCar, "Производитель").start();
        }

    }

    public static void startSales(Autoshow autoshow) {
        for (int i = 0 ; i < autoshow.getCustomers().size() ; i++) {
            final int num = i;
            String nameOfCustomer = "Покупатель " + i;
            new Thread(null, () -> autoshow.sellCar(autoshow.getCustomers().get(num)), nameOfCustomer).start();
        }
    }

}