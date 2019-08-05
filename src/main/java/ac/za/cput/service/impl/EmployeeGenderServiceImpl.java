package ac.za.cput.service.impl;

import ac.za.cput.domain.user.EmployeeGender;
import ac.za.cput.repository.EmployeeGenderRepository;
import ac.za.cput.repository.impl.EmployeeGenderRepositoryImpl;
import ac.za.cput.service.EmployeeGenderService;

import java.util.List;

public class EmployeeGenderServiceImpl implements EmployeeGenderService {
    private static EmployeeGenderService service;
    private EmployeeGenderRepository repository;
    private String s;

    public static EmployeeGenderService getService()
    {
        if(service == null) service = new EmployeeGenderServiceImpl();
        return service;
    }
    private EmployeeGenderServiceImpl()
    {
        if(repository==null) repository = EmployeeGenderRepositoryImpl.getRepository();
    }

    @Override
    public EmployeeGender create(EmployeeGender employee) {
        return this.repository.create(employee);
    }

    @Override
    public EmployeeGender read(String s) {
        return this.repository.read(s);
    }

    @Override
    public EmployeeGender update(EmployeeGender employee) {
        return this.repository.update(employee);
    }

    @Override
    public boolean delete(EmployeeGender employee) {
        return this.repository.delete(employee);
    }

    @Override
    public List<EmployeeGender> readEg(String s) {
        return this.repository.readEg(s);
    }
}
