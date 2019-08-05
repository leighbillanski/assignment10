package ac.za.cput.service.impl;

import ac.za.cput.domain.Employee;
import ac.za.cput.domain.demographics.Gender;
import ac.za.cput.domain.demographics.Race;
import ac.za.cput.factory.EmployeeFactory;
import ac.za.cput.factory.demographics.GenderFactory;
import ac.za.cput.factory.demographics.RaceFactory;
import ac.za.cput.service.EmployeeService;
import ac.za.cput.service.GenderService;
import ac.za.cput.service.RaceService;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class FullEmployeeServiceTest {
    EmployeeService service;
    GenderService genderService;
    RaceService raceService;

    @Before
    public void setUp() throws Exception {
        service = EmployeeServiceImpl.getService();
        genderService = GenderServiceImpl.getService();
        raceService = RaceServiceImpl.getService();
    }

    @Test
    public void createDb() {
        for(int i=0; i<10; i++)
        {
            String gStr = "", rStr="";
            if(i % 2 == 0)
            {
                gStr = "Male";
                rStr = "White";
            } else {
                gStr = "Female";
                rStr = "African";
            }
            Gender g = GenderFactory.getGender(gStr);
            Race r = RaceFactory.getRace(rStr);
            Employee emp = EmployeeFactory.getEmployee("Test"+i, "Name"+i);
            g = GenderServiceImpl.getService().create(g);
            r = RaceServiceImpl.getService().create(r);

            HashMap<String, Object> hm = this.service.create(emp, r , g);
            //hm.get("Empoyee");
            //hm.get("Race");
            //hm.get("Gender");
            assertNotNull(hm);
        }
    }

    @Test
    public void getRace() {
        createDb();

        Employee emp1 = EmployeeFactory.getEmployee("Test4", "Name4");
        emp1 = EmployeeServiceImpl.getService().create(emp1);

        Race r = this.service.getRace(emp1);
        System.out.println(r.getId());
        System.out.println(r.getName());

        assertNotNull(r);
    }

    @Test
    public void getGender() {
        createDb();

        Employee emp1 = EmployeeFactory.getEmployee("Test4", "Name4");
        emp1 = EmployeeServiceImpl.getService().create(emp1);

        Gender g = this.service.getGender(emp1);
        System.out.println(g.getId());
        System.out.println(g.getName());

        assertNotNull(g);
    }

    @Test
    public void getEmployeesFromGender(){
        createDb();
        Gender g = GenderFactory.getGender("Male");
        g = GenderServiceImpl.getService().create(g);

        List<Employee> el = genderService.getEmployees(g);
        for(Employee emp : el) System.out.println(emp.getFirstName());

        assertNotNull(el);
    }

    @Test
    public void getEmployeesFromRace(){
        createDb();
        Race r = RaceFactory.getRace("African");
        r = RaceServiceImpl.getService().create(r);

        List<Employee> el = raceService.getEmployees(r);
        for(Employee emp : el) System.out.println(emp.getFirstName());

        assertNotNull(el);
    }
}