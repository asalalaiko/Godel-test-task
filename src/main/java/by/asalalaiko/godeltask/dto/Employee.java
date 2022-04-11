package by.asalalaiko.godeltask.dto;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    private Long employeeId;
    private String firstName;
    private Gender gender;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
