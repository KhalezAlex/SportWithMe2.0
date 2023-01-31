package com.klozevitz.sportwithme2_0.model.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "address")
    private String address;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "team")
    private Integer team;

    @Column(name = "need")
    private Integer need;

    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name ="activity_id")
    private Activity activity;

    @ManyToOne
    @JoinColumn(name = "daddy_id")
    private User daddy;

    @ManyToMany(mappedBy = "memberOfEvents", fetch = FetchType.LAZY)
    private Set<User> members;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public Event(Long id, String address, LocalDate date, Integer team, Integer need, String comment, Activity activity, User daddy, Set<User> members, City city) {
        this.id = id;
        this.address = address;
        this.date = date;
        this.team = team;
        this.need = need;
        this.comment = comment;
        this.activity = activity;
        this.daddy = daddy;
        this.members = members;
        this.city = city;
    }

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getTeam() {
        return team;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }

    public Integer getNeed() {
        return need;
    }

    public void setNeed(Integer need) {
        this.need = need;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public User getDaddy() {
        return daddy;
    }

    public void setDaddy(User daddy) {
        this.daddy = daddy;
    }

    public Set<User> getMembers() {
        return members;
    }

    public void setMembers(Set<User> member) {
        this.members = member;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}