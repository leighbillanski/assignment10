package ac.za.cput.factory.user;

import ac.za.cput.domain.Employee;
import ac.za.cput.domain.demographics.Race;
import ac.za.cput.domain.user.EmployeeRace;
import ac.za.cput.factory.EmployeeFactory;
import ac.za.cput.factory.demographics.RaceFactory;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeRaceFactoryTest {
    Employee emp;
    Race race;

    @Before
    public void setUp() throws Exception {
        emp = EmployeeFactory.getEmployee("Test", "Name");
        race = RaceFactory.getRace("African");
    }

    @Test
    public void getEmployeeRace() {
        EmployeeRace test = EmployeeRaceFactory.getEmployeeRace(emp.getEmpId(), race.getId());
        assertEquals(emp.getEmpId(), test.getEmpId());
        assertEquals(race.getId(), test.getRaceId());
    }
}