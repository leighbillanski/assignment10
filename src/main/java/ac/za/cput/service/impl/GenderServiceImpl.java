package ac.za.cput.service.impl;

import ac.za.cput.domain.Employee;
import ac.za.cput.domain.demographics.Gender;
import ac.za.cput.domain.user.EmployeeGender;
import ac.za.cput.factory.user.EmployeeGenderFactory;
import ac.za.cput.repository.GenderRepository;
import ac.za.cput.repository.impl.GenderRepositoryImpl;
import ac.za.cput.service.GenderService;

import java.util.ArrayList;
import java.util.List;

public class GenderServiceImpl implements GenderService {
    private static GenderService service;
    private GenderRepository repository;

    public static GenderService getService()
    {
        if(service == null) service = new GenderServiceImpl();
        return service;
    }
    private GenderServiceImpl()
    {
        if(repository==null) repository = GenderRepositoryImpl.getRepository();
    }
    @Override
    public Gender create(Gender gender) {
        return this.repository.create(gender);
    }

    @Override
    public Gender read(String s) {
        return this.repository.read(s);
    }

    @Override
    public Gender update(Gender gender) {
        return this.repository.update(gender);
    }

    @Override
    public boolean delete(Gender gender) {
        return this.repository.delete(gender);
    }

    @Override
    public List getEmployees(Gender gender) {
        gender = GenderServiceImpl.getService().create(gender);
        List<EmployeeGender> egL = EmployeeGenderServiceImpl.getService().readEg(gender.getId());
        List<Employee> empL = new ArrayList<>();
        for(EmployeeGender eg : egL)
        {
            empL.add(EmployeeServiceImpl.getService().read(eg.getEmpId()));
        }
        return empL;
    }
}
