package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class CreditCard extends BaseModel{
    private String cardNumber;
    private String cvv2;
    private String secondPassword;
    private String password;
    @OneToOne
    private Account account;
}
