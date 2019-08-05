package ac.za.cput.repository;

import ac.za.cput.domain.user.EmployeeGender;

import java.util.List;

public interface EmployeeGenderRepository extends iRepository<EmployeeGender, String> {
    List<EmployeeGender> readEg(String s);
}
