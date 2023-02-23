package lesson9.beer.shop;

import lesson9.exceptions.OutOfStorageException;

public class Shop {

    public void completeOrder() {

        boolean validOrder = true;
        Guest guest = new Guest();
        Storage storage = new Storage();

        try {
            storage.checkStorage();

        } catch (OutOfStorageException e) {
            System.out.println(e.getMessage());
            validOrder = false;
        }

        System.out.printf("""
                Order Info:
                Guest: %s %s
                Valid registration: %s
                Ordered: %s bottles
                Valid order: %s
                """, guest.getEmail(), guest.getAge(), guest.isSuccessRegistration(), storage.getOrder(), validOrder);
    }

}
