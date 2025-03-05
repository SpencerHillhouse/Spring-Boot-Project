package com.springbootproject.SpringBootProject.Model;


import jakarta.persistence.*;

@Entity
@Table
public class CustomerModel {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long id;
    private String username;
    private String password;
    private boolean available;

    public CustomerModel() {

    }

    public CustomerModel(Long id, String username, String password, boolean available) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.available = available;
    }

    public CustomerModel(String username, String password, boolean available) {
        this.username = username;
        this.password = password;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username=" + username +
                ", password=" + password +
                ", available=" + available +
                ")";
    }
}
