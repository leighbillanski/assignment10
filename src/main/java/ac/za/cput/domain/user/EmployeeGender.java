package ac.za.cput.domain.user;

public class EmployeeGender {
    private String genderId, empId;

    public EmployeeGender(String genderId, String empId) {
        this.genderId = genderId;
        this.empId = empId;
    }

    public String getGenderId() {
        return genderId;
    }

    public void setGenderId(String genderId) {
        this.genderId = genderId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}
