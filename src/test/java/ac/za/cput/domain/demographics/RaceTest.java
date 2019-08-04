package ac.za.cput.domain.demographics;

import ac.za.cput.factory.demographics.RaceFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceTest {

    Race race;
    @Before
    public void setUp() throws Exception {
        race = RaceFactory.getRace("Male");
    }

    @Test
    public void getId() {
        assertNotNull(race.getId());
    }

    @Test
    public void getName() {
        assertEquals("Male", race.getName());
    }
}