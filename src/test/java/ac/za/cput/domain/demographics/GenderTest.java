package ac.za.cput.domain.demographics;

import ac.za.cput.factory.demographics.GenderFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenderTest {

    Gender gender;
    @Before
    public void setUp() throws Exception {
        gender = GenderFactory.getGender("Male");
    }

    @Test
    public void getId() {
        assertNotNull(gender.getId());
    }

    @Test
    public void getName() {
        assertEquals("Male", gender.getName());
    }
}