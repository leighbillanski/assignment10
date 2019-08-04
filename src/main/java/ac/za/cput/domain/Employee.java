package ac.za.cput.domain;

public class Employee {
    private String empId, firstName, lastName;

    private Employee() {}

    private Employee(Builder builder)
    {
        this.empId = builder.empId;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public String getEmpId() {
        return empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static class Builder {
        private String empId, firstName, lastName;

        public Builder empId(String empId)
        {
            this.empId = empId;
            return this;
        }

        public Builder firstName(String firstName)
        {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName)
        {
            this.lastName = lastName;
            return this;
        }

        public Builder copy(Employee emp)
        {
            this.empId = emp.empId;
            this.firstName = emp.firstName;
            this.lastName = emp.lastName;
            return this;
        }

        public Employee build()
        {
            return new Employee(this);
        }
    }
}
