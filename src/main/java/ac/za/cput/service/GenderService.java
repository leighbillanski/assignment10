package ac.za.cput.service;

import ac.za.cput.domain.demographics.Gender;

import java.util.List;

public interface GenderService extends IService<Gender, String> {
    List getEmployees(Gender gender);
}
