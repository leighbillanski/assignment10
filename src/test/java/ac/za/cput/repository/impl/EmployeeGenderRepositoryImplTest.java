package ac.za.cput.repository.impl;

import ac.za.cput.domain.Employee;
import ac.za.cput.domain.demographics.Gender;
import ac.za.cput.domain.user.EmployeeGender;
import ac.za.cput.factory.EmployeeFactory;
import ac.za.cput.factory.demographics.GenderFactory;
import ac.za.cput.factory.user.EmployeeGenderFactory;
import ac.za.cput.repository.EmployeeGenderRepository;
import ac.za.cput.service.impl.GenderServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeeGenderRepositoryImplTest {

    Employee emp;
    Gender gender;
    EmployeeGender er;
    EmployeeGenderRepository repository;
    @Before
    public void setUp() throws Exception {
        emp = EmployeeFactory.getEmployee("Test", "Name");
        gender = GenderFactory.getGender("Male");
        gender = GenderServiceImpl.getService().create(gender);
        er = EmployeeGenderFactory.getEmployeeGender(emp.getEmpId(), gender.getId());

        repository = EmployeeGenderRepositoryImpl.getRepository();
    }

    @Test
    public void create() {
        EmployeeGender test = repository.create(er);
        assertEquals(er.getEmpId(), test.getEmpId());
        assertEquals(er.getGenderId(), test.getGenderId());
    }

    @Test
    public void update() {
        create();
        EmployeeGender t = er;
        Gender fr = GenderFactory.getGender("Female");
        t.setGenderId(fr.getId());

        EmployeeGender upd = this.repository.update(t);

        assertEquals(fr.getId(), upd.getGenderId());
        assertEquals(emp.getEmpId(), upd.getEmpId());
    }

    @Test
    public void read() {
        create();
        assertSame(er, this.repository.read(emp.getEmpId()));
    }

    @Test
    public void delete() {
        create();
        boolean res = this.repository.delete(er);
        assertTrue(res);
        assertNull(this.repository.read(emp.getEmpId()));
    }

    @Test
    public void readEg() {
        create();
        Employee emp;
        Gender gender;
        EmployeeGender er;
        emp = EmployeeFactory.getEmployee("Test2", "Name2");
        gender = GenderFactory.getGender("Male");
        gender = GenderServiceImpl.getService().create(gender);

        er = EmployeeGenderFactory.getEmployeeGender(emp.getEmpId(), gender.getId());
        EmployeeGender test = repository.create(er);

        List<EmployeeGender> egL = this.repository.readEg(gender.getId());
        assertNotNull(egL);

    }
}