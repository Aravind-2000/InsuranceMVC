package com.example.insurancemvc.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clientId;

    private String surName;
    private String givenName;
    private String salutation;
    private String gender;
    private String maritalStatus;


    private Long addressId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId", updatable = false, insertable = false)
    private Address address;


    private String email;
    private String mobileNumber;
    private String postalCode;
    private String country;
    private String nationality;
    private String nameFormat;
    private Boolean companyDoctor;

    private String birthDate;
    private String birthPlace;
    private String language;
    private String category;
    private String occupation;


    private Long bankId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "bankId", updatable = false, insertable = false)
    private Bank bank;




//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientID")
//    private List<Proof> proofList = new ArrayList<>();

    private int validFlag;

    @CreationTimestamp
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private LocalDateTime modifiedDate;
}
