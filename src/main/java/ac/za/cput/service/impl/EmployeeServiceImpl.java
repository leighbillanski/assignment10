package ac.za.cput.service.impl;

import ac.za.cput.domain.Employee;
import ac.za.cput.repository.EmployeeRepository;
import ac.za.cput.repository.impl.EmployeeRepositoryImpl;
import ac.za.cput.service.EmployeeService;

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
}
