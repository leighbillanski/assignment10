package ac.za.cput.repository.impl;

import ac.za.cput.domain.Employee;
import ac.za.cput.domain.demographics.Race;
import ac.za.cput.domain.user.EmployeeRace;
import ac.za.cput.factory.EmployeeFactory;
import ac.za.cput.factory.demographics.RaceFactory;
import ac.za.cput.factory.user.EmployeeRaceFactory;
import ac.za.cput.repository.EmployeeRaceRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeRaceRepositoryImplTest {
    Employee emp;
    Race race;
    EmployeeRace er;
    EmployeeRaceRepository repository;
    @Before
    public void setUp() throws Exception {
        emp = EmployeeFactory.getEmployee("Test", "Name");
        race = RaceFactory.getRace("African");
        er = EmployeeRaceFactory.getEmployeeRace(emp.getEmpId(), race.getId());

        repository = EmployeeRaceRepositoryImpl.getRepository();
    }

    @Test
    public void create() {
        EmployeeRace test = repository.create(er);
        assertEquals(er.getEmpId(), test.getEmpId());
        assertEquals(er.getRaceId(), test.getRaceId());
    }

    @Test
    public void update() {
        create();
        EmployeeRace t = er;
        Race fr = RaceFactory.getRace("White");
        t.setRaceId(fr.getId());

        EmployeeRace upd = this.repository.update(t);

        assertEquals(fr.getId(), upd.getRaceId());
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
}