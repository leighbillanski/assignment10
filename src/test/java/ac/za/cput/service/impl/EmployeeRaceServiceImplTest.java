package ac.za.cput.service.impl;

import ac.za.cput.domain.Employee;
import ac.za.cput.domain.demographics.Race;
import ac.za.cput.domain.user.EmployeeRace;
import ac.za.cput.factory.EmployeeFactory;
import ac.za.cput.factory.demographics.RaceFactory;
import ac.za.cput.factory.user.EmployeeRaceFactory;
import ac.za.cput.service.EmployeeRaceService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeRaceServiceImplTest {

    private EmployeeRaceService service;
    Employee emp;
    Race race;
    EmployeeRace er;

    @Before
    public void setUp() throws Exception {
        service = EmployeeRaceServiceImpl.getService();
        emp = EmployeeFactory.getEmployee("Test", "Name");
        race = RaceFactory.getRace("African");
        er = EmployeeRaceFactory.getEmployeeRace(emp.getEmpId(), race.getId());
    }

    @Test
    public void create() {
        EmployeeRace test = service.create(er);
        assertEquals(er.getEmpId(), test.getEmpId());
        assertEquals(er.getRaceId(), test.getRaceId());
    }

    @Test
    public void update() {
        create();
        EmployeeRace t = er;
        Race fr = RaceFactory.getRace("Female");
        t.setRaceId(fr.getId());

        EmployeeRace upd = this.service.update(t);

        assertEquals(fr.getId(), upd.getRaceId());
        assertEquals(emp.getEmpId(), upd.getEmpId());
    }

    @Test
    public void read() {
        create();
        assertSame(er, this.service.read(emp.getEmpId()));
    }

    @Test
    public void delete() {
        create();
        boolean res = this.service.delete(er);
        assertTrue(res);
        assertNull(this.service.read(emp.getEmpId()));
    }
}