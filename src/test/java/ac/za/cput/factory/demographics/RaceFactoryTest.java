package ac.za.cput.factory.demographics;

import ac.za.cput.domain.demographics.Race;
import ac.za.cput.repository.RaceRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceFactoryTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void getRace() {
        Race test = RaceFactory.getRace("African");
        assertEquals("African", test.getName());
    }
}