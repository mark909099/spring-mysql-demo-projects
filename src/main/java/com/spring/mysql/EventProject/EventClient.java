package com.spring.mysql.EventProject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="event_client")
public class EventClient {
    private Integer id;
    private String name;
    private Integer age;
    private String city;

    public EventClient(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Integer getId() { return id; }

    @Column(name="name")
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Column(name="age")
    public Integer getAge() { return age; }

    public void setAge(Integer age) { this.age = age; }

    @Column(name="city")
    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

}