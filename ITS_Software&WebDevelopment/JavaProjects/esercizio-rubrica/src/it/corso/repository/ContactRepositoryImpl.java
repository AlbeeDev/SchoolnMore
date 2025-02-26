package it.corso.repository;

import it.corso.model.Address;
import it.corso.model.Contact;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository {
    @Override
    public void registraContatto(Contact contact, Address address) {
        String sql1 = "INSERT INTO addresses (street, civic, cap, town, province) values (?, ?, ?, ?, ?)";
        int id_address = 0;
        try (Connection connection = getConnection()) {
            try (PreparedStatement statement = connection.prepareStatement(sql1, PreparedStatement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, address.getStreet());
                statement.setString(2, address.getCivic());
                statement.setString(3, address.getCap());
                statement.setString(4, address.getTown());
                statement.setString(5, address.getProvince());

                int res = statement.executeUpdate();

                if (res > 0) {
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        id_address = generatedKeys.getInt(1);
                    }
                } else {
                    System.out.println("Insert failed, no rows affected.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            String sql2 = "INSERT INTO contacts (name, lastname, photo, phone, mail, address_id) VALUES(?,?,?,?,?,?)";
            try (PreparedStatement statement = connection.prepareStatement(sql2)) {
                statement.setString(1, contact.getName());
                statement.setString(2, contact.getLastName());
                statement.setString(3, contact.getPhoto());
                statement.setString(4, contact.getPhone());
                statement.setString(5, contact.getMail());
                statement.setInt(6, id_address);
                statement.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }



    }

    @Override
    public List<Contact> elencoContatti() {
        String sql = "SELECT * FROM contacts c join addresses a on a.id = c.address_id";
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            List<Contact> contacts = new ArrayList<>();
            while (resultSet.next()) {
                Address address = new Address();
                address.setStreet(resultSet.getString("street"));
                address.setCivic(resultSet.getString("civic"));
                address.setCap(resultSet.getString("cap"));
                address.setTown(resultSet.getString("town"));
                address.setProvince(resultSet.getString("province"));
                Contact contact = new Contact();
                contact.setName(resultSet.getString("name"));
                contact.setLastName(resultSet.getString("lastname"));
                contact.setPhoto(resultSet.getString("photo"));
                contact.setPhone(resultSet.getString("phone"));
                contact.setMail(resultSet.getString("mail"));
                contact.setAddress(address);
                contacts.add(contact);
            }
            return contacts;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
