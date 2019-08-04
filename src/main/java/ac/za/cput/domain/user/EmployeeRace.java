package ac.za.cput.domain.user;

public class EmployeeRace {
    private String raceId, empId;

    public EmployeeRace(String raceId, String empId) {
        this.raceId = raceId;
        this.empId = empId;
    }

    public String getRaceId() {
        return raceId;
    }

    public void setRaceId(String raceId) {
        this.raceId = raceId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }
}
