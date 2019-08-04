package ac.za.cput.domain.user;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeRaceTest {

    EmployeeRace test;
    @Before
    public void setUp() throws Exception {
        test = new EmployeeRace("12345", "54321");
    }

    @Test
    public void getRaceId() {
        assertNotNull(test.getRaceId());
    }

    @Test
    public void setRaceId() {
        test.setRaceId("222");
        assertEquals("222", test.getRaceId());
    }

    @Test
    public void getEmpId() {
        assertNotNull(test.getEmpId());
    }

    @Test
    public void setEmpId() {
        test.setEmpId("333");
        assertEquals("333", test.getEmpId());
    }
}