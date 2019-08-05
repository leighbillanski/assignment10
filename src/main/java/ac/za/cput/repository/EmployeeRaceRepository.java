package ac.za.cput.repository;

import ac.za.cput.domain.user.EmployeeRace;

import java.util.List;

public interface EmployeeRaceRepository extends iRepository<EmployeeRace, String> {
    List<EmployeeRace> readEr(String s);
}
