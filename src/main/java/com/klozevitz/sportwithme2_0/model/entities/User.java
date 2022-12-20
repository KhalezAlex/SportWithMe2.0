package com.klozevitz.sportwithme2_0.model.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "events_organized")
    private Integer events_organized;
    @Column(name = "strikes_amount")
    private Integer strikes_amount;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    @ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public User() {
    }

    public User(Long id, String username, String password, String phone, String name,
                Integer age, Integer events_organized,
                Integer strikes_amount, City city, Set<Role> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.name = name;
        this.age = age;
        this.events_organized = events_organized;
        this.strikes_amount = strikes_amount;
        this.city = city;
        this.roles = roles;
    }

    public User(String username, String password, Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.events_organized = 0;
        this.strikes_amount = 0;
        this.roles = roles;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.events_organized = 0;
        this.strikes_amount = 0;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getEvents_organized() {
        return events_organized;
    }

    public void setEvents_organized(Integer events_organized) {
        this.events_organized = events_organized;
    }

    public Integer getStrikes_amount() {
        return strikes_amount;
    }

    public void setStrikes_amount(Integer strikes_amount) {
        this.strikes_amount = strikes_amount;
    }

    @Override
    public String toString() {
        return "{" +
                "username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", date_of_birth=" + age +
                ", events_organized=" + events_organized +
                ", strikes_amount=" + strikes_amount +
                ", city=" + city +
//                ", roles=" + roles +
                '}';
    }
}
