public class Inventory {
    private String name;
    private Integer quantity;

    public Inventory(String name,Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public void change (Integer i) {
        quantity-=i;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
