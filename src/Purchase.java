public class Purchase {
    private String customer_name;
    private String item_name;
    private Integer quantity;
    public Float final_price;

    public Purchase(String customer_name,String item_name,Integer quantity) {
        this.customer_name = customer_name;
        this.item_name = item_name;
        this.quantity = quantity;
    }

    public void setFinal(Float f) {
        final_price = quantity * f;
    }

    public String getItemName() {
        return item_name;
    }

    public String getCustomerName() {
        return customer_name;
    }

    public Float getFinalPrice() {
        return final_price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "customer_name='" + customer_name + '\'' +
                ", item_name='" + item_name + '\'' +
                ", quantity=" + quantity +
                ", final_price=" + final_price +
                '}';
    }
}
