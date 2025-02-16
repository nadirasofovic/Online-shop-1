import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void inventoryTest() {
        Inventory inventory =new Inventory("Bananas", 200);
        assertNotEquals("150", inventory.getQuantity());
    }

}