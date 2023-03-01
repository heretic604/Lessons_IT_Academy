package lesson10.shop;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.UUID;

public class Product {

    private final UUID id;
    private final String name;
    private final GregorianCalendar date;

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd MMM yyyy");
        return String.format("""
                %s %s %s
                """, id, name, df.format(date.getTime()));
    }

    public Product(String name, GregorianCalendar date) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

}
