package it.corso.repository;

import it.corso.model.Address;
import it.corso.model.Contact;

import java.util.List;

public interface ContactRepository extends Repository {
    void registraContatto(Contact contact, Address address);
    List<Contact> elencoContatti();
}
