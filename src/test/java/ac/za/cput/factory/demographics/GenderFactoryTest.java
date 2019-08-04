package ac.za.cput.factory.demographics;

import ac.za.cput.domain.demographics.Gender;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GenderFactoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getGender() {
        Gender test= GenderFactory.getGender("Male");
        assertEquals("Male", test.getName());
    }
}