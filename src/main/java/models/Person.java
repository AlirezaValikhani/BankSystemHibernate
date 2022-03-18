package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@MappedSuperclass
public abstract class Person extends BaseModel {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String nationalCode;
    private String phoneNumber;
    private Long employeeId;
}
