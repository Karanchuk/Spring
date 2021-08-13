package lesson1;

public class Product {
    private static int counter = 0;
    private int id, cost;
    private String title;

    public Product(String title, int cost) {
        id = ++counter;
        this.cost = cost;
        this.title = title;
    }

    @Override
    public String toString() {
        return new StringBuilder(title + " costs " + cost).toString();
    }
}
