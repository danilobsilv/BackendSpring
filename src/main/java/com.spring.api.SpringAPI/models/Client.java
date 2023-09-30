package com.spring.api.SpringAPI.models;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

// I can use lombok instead of doing boilerplate codes
// import lombok.data;

@Entity  // to indicate that it is an entity and is being mapped to the database
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int age;

    @Column()
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;

    public Long getId() {
        return Id;
    }

    public void setId(long id) {
        this.Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        email = newEmail;
    }

    public int getAge() {
        return age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return Objects.equals(Id, client.Id);
    }


    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
