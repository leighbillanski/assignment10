package ac.za.cput.repository.impl;

import ac.za.cput.domain.Employee;
import ac.za.cput.factory.EmployeeFactory;
import ac.za.cput.repository.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeRepositoryImplTest {

    private EmployeeRepository repository;
    private Employee emp;
    @Before
    public void setUp() throws Exception {
        repository = EmployeeRepositoryImpl.getRepository();
        emp = EmployeeFactory.getEmployee("Test", "Name");
    }

    @Test
    public void create() {
        Employee test = repository.create(emp);
        assertSame(this.emp, test);
    }

    @Test
    public void update() {
        this.create();
        Employee e = new Employee.Builder().copy(this.emp).firstName("UpdTest").build();
        Employee upd = this.repository.update(e);
        assertSame(e.getFirstName(), upd.getFirstName());
    }

    @Test
    public void read() {
        this.create();
        Employee r = repository.read(emp.getEmpId());
        assertSame(this.emp, r);
    }

    @Test
    public void delete() {
        create();
        Employee e = this.repository.read(emp.getEmpId());
        boolean result = this.repository.delete(e);
        assertTrue(result);
        assertNull(this.repository.read(emp.getEmpId()));
    }
}