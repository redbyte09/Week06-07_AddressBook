package com.capgemini.addressbookapp.service;

import com.capgemini.addressbookapp.dto.AddressBookDTO;
import com.capgemini.addressbookapp.model.AddressBook;
import com.capgemini.addressbookapp.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository repository;

    public AddressBook saveEntry(AddressBookDTO dto) {
        AddressBook entry = new AddressBook(dto); // Convert DTO to Model
        return repository.save(entry);
    }

    public List<AddressBook> getAllEntries() {
        return repository.findAll();
    }

    public Optional<AddressBook> getEntryById(Long id) {
        return repository.findById(id);
    }

    public AddressBook updateEntry(Long id, AddressBookDTO newEntry) {
        return repository.findById(id)
                .map(entry -> {
                    entry.setName(newEntry.getName());
                    entry.setPhoneNumber(newEntry.getPhoneNumber());
                    entry.setEmail(newEntry.getEmail());
                    entry.setAddress(newEntry.getAddress());
                    return repository.save(entry);
                })
                .orElseThrow(() -> new RuntimeException("Entry not found with id: " + id));
    }

    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }
}