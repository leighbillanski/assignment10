package ac.za.cput.repository.impl;

import ac.za.cput.domain.user.EmployeeGender;
import ac.za.cput.repository.EmployeeGenderRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EmployeeGenderRepositoryImpl implements EmployeeGenderRepository {
    private static EmployeeGenderRepository repository;
    private HashSet<EmployeeGender> db;
    public static EmployeeGenderRepository getRepository()
    {
        if(repository == null) repository = new EmployeeGenderRepositoryImpl();
        return repository;
    }
    private EmployeeGenderRepositoryImpl()
    {
        if(this.db==null) this.db = new HashSet<>();
    }
    @Override
    public EmployeeGender create(EmployeeGender employeeGender) {
        EmployeeGender find = this.read(employeeGender.getEmpId());
        if(find == null)
        {
            this.db.add(employeeGender);
            return employeeGender;
        }
        return find;
    }

    @Override
    public EmployeeGender update(EmployeeGender employeeGender) {
        if(this.delete(employeeGender) != false)
        {
            this.db.add(employeeGender);
            return employeeGender;
        }
        return null;
    }

    @Override
    public EmployeeGender read(String s) {
        return this.db.stream().filter(er -> er.getEmpId().trim().toLowerCase().equals(s.toLowerCase())).findAny().orElse(null);
    }

    @Override
    public boolean delete(EmployeeGender employeeGender) {
        EmployeeGender find = this.read(employeeGender.getEmpId());

        if(find != null)
        {
            this.db.remove(find);
            return true;
        }
        return false;
    }

    @Override
    public List<EmployeeGender> readEg(String s) {
        List<EmployeeGender> egL= new ArrayList<>();
        for(EmployeeGender eg : this.db)
        {
            if(eg.getGenderId().equals(s)) egL.add(eg);
        }
        return egL;
    }
}
