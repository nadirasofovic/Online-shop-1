import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    public void itemTest() {
        Item item = new Item("T-Shirt", 19.99f,100,"clothing");
        assertNotEquals("Laptop",item.getName());
    }
}