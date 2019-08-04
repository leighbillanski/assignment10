package ac.za.cput.domain.user;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeGenderTest {

    EmployeeGender test;
    @Before
    public void setUp() throws Exception {
        test = new EmployeeGender("12345", "54321");
    }

    @Test
    public void getGenderId() {
        assertNotNull(test.getGenderId());
    }

    @Test
    public void setGenderId() {
        test.setGenderId("222");
        assertEquals("222", test.getGenderId());
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