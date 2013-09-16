package jp.ddo.chiroru.javaee.sample.common.validation.validator;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

public class Employee {
    private String firstName;
    private String lastName;
    private List<String> emailAddresses;

    @NotNull
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    @ValidCollection(elementType=String.class, constraints={Email.class})
    public List<String> getEmailAddresses() { return emailAddresses; }
    public void setEmailAddresses(List<String> emailAddresses) { this.emailAddresses = emailAddresses; }

}
