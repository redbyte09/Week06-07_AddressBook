package com.capgemini.addressbookapp.dto;

import jakarta.validation.constraints.NotEmpty;

public class AddressBookDTO {

    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotEmpty(message = "Phone number cannot be empty")
    private String phoneNumber;

    private String email;
    private String address;

    // Constructors
    public AddressBookDTO() {}

    public AddressBookDTO(String name, String phoneNumber, String email, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}