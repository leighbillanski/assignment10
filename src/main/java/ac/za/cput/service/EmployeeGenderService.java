package ac.za.cput.service;

import ac.za.cput.domain.demographics.Gender;
import ac.za.cput.domain.user.EmployeeGender;

import java.util.List;

public interface EmployeeGenderService extends IService<EmployeeGender, String> {
    List<EmployeeGender> readEg(String s);
}
