package ac.za.cput.factory;

import ac.za.cput.domain.Employee;
import ac.za.cput.util.uuid;

public class EmployeeFactory {
    public static Employee getEmployee(String firstName, String lastName)
    {
        return new Employee.Builder().empId(uuid.getUUID()).firstName(firstName).lastName(lastName).build();
    }
}
