package ac.za.cput.factory;

import ac.za.cput.domain.Employee;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeFactoryTest {
    private String testFname, testLname;
    @Before
    public void setUp() throws Exception {
        this.testFname = "Test";
        this.testLname = "Name";
    }

    @Test
    public void getEmployee() {
        Employee test = EmployeeFactory.getEmployee(testFname, testLname);
        assertNotNull(test.getEmpId());
        assertNotNull(test);
        assertEquals(this.testFname, test.getFirstName());
    }
}