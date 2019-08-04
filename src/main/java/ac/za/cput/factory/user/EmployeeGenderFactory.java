package ac.za.cput.factory.user;

import ac.za.cput.domain.user.EmployeeGender;

public class EmployeeGenderFactory {
    public static EmployeeGender getEmployeeGender(String empId, String genderId)
    {
        return new EmployeeGender(genderId, empId);
    }
}
