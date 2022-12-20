package com.klozevitz.sportwithme2_0.model.dto;

import com.klozevitz.sportwithme2_0.model.entities.City;
import com.klozevitz.sportwithme2_0.model.entities.Role;
import com.klozevitz.sportwithme2_0.model.entities.User;

import java.util.HashSet;
import java.util.Set;

public class UserDTO {
    private String username;
    private String phone;
    private String name;
    private Integer age;
    private Integer events_organized;
    private Integer strikes_amount;
    private City city;
    private Set<String> roles = new HashSet<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public UserDTO(User user) {
        this.username = user.getUsername();
        this.phone = user.getPhone();
        this.name = user.getName();
        this.age = user.getAge();
        this.events_organized = user.getEvents_organized();
        this.strikes_amount = user.getStrikes_amount();
        this.city = user.getCity();
        for (Role role: user.getRoles())
            this.roles.add(role.getName());
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
                ", roles=" + roles +
                '}';
    }
}
