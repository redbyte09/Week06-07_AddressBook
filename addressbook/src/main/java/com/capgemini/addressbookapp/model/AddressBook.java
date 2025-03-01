package com.capgemini.addressbookapp.model;

import com.capgemini.addressbookapp.dto.AddressBookDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ADDRESSBOOK")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phoneNumber;
    private String email;
    private String address;

    // Constructor to initialize from DTO
    public AddressBook(AddressBookDTO dto) {
        this.name = dto.getName();
        this.phoneNumber = dto.getPhoneNumber();
        this.email = dto.getEmail();
        this.address = dto.getAddress();
    }
}