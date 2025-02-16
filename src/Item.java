public class Item implements Comparable<Item>{
    private String name;
    private Float price;
    private Integer quantity;
    private String category;

    public Item(String name,Float price,Integer quantity,String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public Float getPrice() {
        return price;
    }

    @Override
    public int compareTo(Item o) {
        return o.quantity.compareTo(this.quantity);
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", category='" + category + '\'' +
                '}';
    }
}
