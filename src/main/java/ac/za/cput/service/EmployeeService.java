package ac.za.cput.service;

import ac.za.cput.domain.Employee;
import ac.za.cput.domain.demographics.Gender;
import ac.za.cput.domain.demographics.Race;

import java.util.HashMap;
import java.util.List;

public interface EmployeeService extends IService<Employee, String> {
    HashMap create(Employee emp, Race r, Gender g);
    Race getRace(Employee emp);
    Gender getGender(Employee emp);
}
