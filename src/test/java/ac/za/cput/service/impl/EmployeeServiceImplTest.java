package ac.za.cput.service.impl;

import ac.za.cput.domain.Employee;
import ac.za.cput.factory.EmployeeFactory;
import ac.za.cput.service.EmployeeService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeServiceImplTest {

    private EmployeeService service;
    private Employee emp;
    @Before
    public void setUp() throws Exception {
        service = EmployeeServiceImpl.getService();
        emp = EmployeeFactory.getEmployee("Test", "Name");
    }

    @Test
    public void create() {
        Employee test = service.create(emp);
        assertSame(this.emp, test);
    }

    @Test
    public void update() {
        this.create();
        Employee e = new Employee.Builder().copy(this.emp).firstName("UpdTest").build();
        Employee upd = this.service.update(e);
        assertSame(e.getFirstName(), upd.getFirstName());
    }

    @Test
    public void read() {
        this.create();
        Employee r = service.read(emp.getEmpId());
        assertSame(this.emp, r);
    }

    @Test
    public void delete() {
        create();
        Employee e = this.service.read(emp.getEmpId());
        boolean result = this.service.delete(e);
        assertTrue(result);
        assertNull(this.service.read(emp.getEmpId()));
    }
}