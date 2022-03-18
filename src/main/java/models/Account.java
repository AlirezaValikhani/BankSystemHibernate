package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Account extends BaseModel {
    private Double balance;
    private String accountNumber;
    @ManyToOne
    private Customer customer;
    @OneToOne(mappedBy = "account")
    private CreditCard creditCard;
}
