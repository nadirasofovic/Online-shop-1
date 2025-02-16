import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseTest {

    @Test
    public void purchaseTest() {
        Purchase purchase = new Purchase("Charlie Williams", "The Great Gatsby", 1);
        assertNotEquals("Couch", purchase.getItemName());
    }
}