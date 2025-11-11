package com.cineman.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tblCustomers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 100)
    private String fullName;

    private LocalDate dateOfBirth;

    @Column(length = 255)
    private String address;

    @Column(length = 15)
    private String phoneNumber;

    @Column(length = 100)
    private String email;

    private Integer loyaltyPoints = 0;

    @Column(length = 20)
    private String membershipCardID;

    @OneToOne
    @JoinColumn(name = "accountID")
    private Account account;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getLoyaltyPoints() { return loyaltyPoints; }
    public void setLoyaltyPoints(Integer loyaltyPoints) { this.loyaltyPoints = loyaltyPoints; }

    public String getMembershipCardID() { return membershipCardID; }
    public void setMembershipCardID(String membershipCardID) { this.membershipCardID = membershipCardID; }

    public Account getAccount() { return account; }
    public void setAccount(Account account) { this.account = account; }
}
