import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryTest {

    @Test
    public void categoryTest() {
        Category category = new Category("clothing", 100);
        assertEquals("beauty products", category.getName());

    }
}