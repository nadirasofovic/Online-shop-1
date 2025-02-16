public class Category implements Comparable<Category> {
    private String name;
    private Integer quantity;

    public Category(String name,Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int compareTo(Category o) {
        return o.quantity.compareTo(this.quantity);
    }
}
