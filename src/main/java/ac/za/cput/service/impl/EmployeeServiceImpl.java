package ac.za.cput.service.impl;

import ac.za.cput.domain.Employee;
import ac.za.cput.domain.demographics.Gender;
import ac.za.cput.domain.demographics.Race;
import ac.za.cput.domain.user.EmployeeGender;
import ac.za.cput.domain.user.EmployeeRace;
import ac.za.cput.factory.user.EmployeeGenderFactory;
import ac.za.cput.factory.user.EmployeeRaceFactory;
import ac.za.cput.repository.EmployeeRepository;
import ac.za.cput.repository.impl.EmployeeRepositoryImpl;
import ac.za.cput.service.EmployeeService;

import java.util.HashMap;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private static EmployeeService service;
    private EmployeeRepository repository;

    public static EmployeeService getService()
    {
        if(service == null) service = new EmployeeServiceImpl();
        return service;
    }
    private EmployeeServiceImpl()
    {
        if(repository==null) repository = EmployeeRepositoryImpl.getRepository();
    }

    @Override
    public Employee create(Employee employee) {
        return this.repository.create(employee);
    }

    @Override
    public Employee read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Employee update(Employee employee) {
        return this.repository.update(employee);
    }

    @Override
    public boolean delete(Employee employee) {
        return this.repository.delete(employee);
    }


    @Override
    public HashMap<String, Object> create(Employee emp, Race race, Gender gender) {
        Race r = RaceServiceImpl.getService().create(race);
        Gender g = GenderServiceImpl.getService().create(gender);
        Employee e = this.create(emp);

        EmployeeRace er = EmployeeRaceFactory.getEmployeeRace(e.getEmpId(), r.getId());
        EmployeeGender eg = EmployeeGenderFactory.getEmployeeGender(e.getEmpId(), g.getId());
        EmployeeGender egg = EmployeeGenderServiceImpl.getService().create(eg);
        EmployeeRace err = EmployeeRaceServiceImpl.getService().create(er);

        HashMap<String, Object> hm = new HashMap<>();

        hm.put("Employee", e);
        hm.put("Race", r);
        hm.put("Gender",g);

        return hm;
    }

    @Override
    public Race getRace(Employee emp) {
        EmployeeRace er = EmployeeRaceServiceImpl.getService().read(emp.getEmpId());
        return RaceServiceImpl.getService().read(er.getRaceId());
    }

    @Override
    public Gender getGender(Employee emp) {
        EmployeeGender eg = EmployeeGenderServiceImpl.getService().read(emp.getEmpId());
        return GenderServiceImpl.getService().read(eg.getGenderId());
    }


}
