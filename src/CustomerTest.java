import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    public void CustomerTest() {
        Customer customer = new Customer("Alice Smith", "alice@example.com");
        assertEquals("Alice Smith", customer.getName());
    }

}