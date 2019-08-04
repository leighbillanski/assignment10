package ac.za.cput.factory.user;

import ac.za.cput.domain.Employee;
import ac.za.cput.domain.demographics.Gender;
import ac.za.cput.domain.user.EmployeeGender;
import ac.za.cput.factory.EmployeeFactory;
import ac.za.cput.factory.demographics.GenderFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeGenderFactoryTest {

    Employee emp;
    Gender gen;
    @Before
    public void setUp() throws Exception {
        emp = EmployeeFactory.getEmployee("Test", "Name");
        gen = GenderFactory.getGender("Male");
    }

    @Test
    public void getEmployeeGender() {
        EmployeeGender test = EmployeeGenderFactory.getEmployeeGender(emp.getEmpId(), gen.getId());

        assertEquals(emp.getEmpId(), test.getEmpId());
        assertEquals(gen.getId(), test.getGenderId());
    }
}