package ac.za.cput.repository.impl;

import ac.za.cput.domain.user.EmployeeRace;
import ac.za.cput.repository.EmployeeRaceRepository;

import java.util.HashSet;

public class EmployeeRaceRepositoryImpl implements EmployeeRaceRepository {
    private static EmployeeRaceRepository repository;
    private HashSet<EmployeeRace> db;
    public static EmployeeRaceRepository getRepository()
    {
        if(repository == null) repository = new EmployeeRaceRepositoryImpl();
        return repository;
    }
    private EmployeeRaceRepositoryImpl()
    {
        if(this.db==null) this.db = new HashSet<>();
    }
    @Override
    public EmployeeRace create(EmployeeRace employeeRace) {
        EmployeeRace find = this.read(employeeRace.getEmpId());
        if(find == null)
        {
            this.db.add(employeeRace);
            return employeeRace;
        }
        return find;
    }

    @Override
    public EmployeeRace update(EmployeeRace employeeRace) {
        if(this.delete(employeeRace) != false)
        {
            this.db.add(employeeRace);
            return employeeRace;
        }
        return null;
    }

    @Override
    public EmployeeRace read(String s) {
        return this.db.stream().filter(er -> er.getEmpId().trim().toLowerCase().equals(s.toLowerCase())).findAny().orElse(null);
    }

    @Override
    public boolean delete(EmployeeRace employeeRace) {
        EmployeeRace find = this.read(employeeRace.getEmpId());

        if(find != null)
        {
            this.db.remove(find);
            return true;
        }
        return false;
    }
}
