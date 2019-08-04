package ac.za.cput.repository.impl;

import ac.za.cput.domain.Employee;
import ac.za.cput.repository.EmployeeRepository;

import java.util.HashSet;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private static EmployeeRepository repository;
    private HashSet<Employee> db;

    private EmployeeRepositoryImpl() {
        db = new HashSet<>();
    }

    public static EmployeeRepository getRepository()
    {
        if(repository == null) repository = new EmployeeRepositoryImpl();
        return repository;
    }

    @Override
    public Employee create(Employee employee) {
        db.add(employee);
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee emp = this.read(employee.getEmpId());
        if(emp != null && this.delete(emp))
        {
            return this.create(employee);
        }
        return null;

    }

    @Override
    public Employee read(final String s) {
        Employee emp = db.stream().filter(e -> e.getEmpId().toLowerCase().equals(s)).findAny().orElse(null);
        return emp;
    }

    @Override
    public boolean delete(Employee employee) {
        Employee emp  = this.read(employee.getEmpId());
        if(emp != null)
        {
            this.db.remove(emp);
            return true;
        } else
            return false;
    }
}
