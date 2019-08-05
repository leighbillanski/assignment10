package ac.za.cput.service;

import ac.za.cput.domain.user.EmployeeGender;
import ac.za.cput.domain.user.EmployeeRace;

import java.util.List;

public interface EmployeeRaceService extends IService<EmployeeRace, String> {
    List<EmployeeRace> readEr(String s);

}
