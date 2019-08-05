package ac.za.cput.service.impl;

import ac.za.cput.domain.user.EmployeeGender;
import ac.za.cput.domain.user.EmployeeRace;
import ac.za.cput.repository.EmployeeRaceRepository;
import ac.za.cput.repository.impl.EmployeeRaceRepositoryImpl;
import ac.za.cput.service.EmployeeRaceService;

import java.util.List;

public class EmployeeRaceServiceImpl implements EmployeeRaceService {
    private static EmployeeRaceService service;
    private EmployeeRaceRepository repository;

    public static EmployeeRaceService getService()
    {
        if(service == null) service = new EmployeeRaceServiceImpl();
        return service;
    }
    private EmployeeRaceServiceImpl()
    {
        if(repository==null) repository = EmployeeRaceRepositoryImpl.getRepository();
    }

    @Override
    public EmployeeRace create(EmployeeRace employee) {
        return this.repository.create(employee);
    }

    @Override
    public EmployeeRace read(String s) {
        return this.repository.read(s);
    }

    @Override
    public EmployeeRace update(EmployeeRace employee) {
        return this.repository.update(employee);
    }

    @Override
    public boolean delete(EmployeeRace employee) {
        return this.repository.delete(employee);
    }

    @Override
    public List<EmployeeRace> readEr(String s) {
        return this.repository.readEr(s);
    }

}
