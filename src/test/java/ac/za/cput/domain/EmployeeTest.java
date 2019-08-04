package ac.za.cput.domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {
    Employee emp;
    @Before
    public void setUp() throws Exception {
        emp = new Employee.Builder().firstName("TestName").lastName("SecName").empId("123456").build();
    }

    @Test
    public void getEmpId() {
        assertEquals("123456", emp.getEmpId());
        assertNotNull(emp.getEmpId());
    }

    @Test
    public void getFirstName() {
        assertEquals("TestName", emp.getFirstName());
    }

    @Test
    public void getLastName() {
        assertNotNull(emp.getLastName());
    }
}