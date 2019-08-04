package ac.za.cput.factory.user;

import ac.za.cput.domain.user.EmployeeRace;

public class EmployeeRaceFactory {
    public static EmployeeRace getEmployeeRace(String empId, String raceId)
    {
        return new EmployeeRace(raceId, empId);
    }
}
