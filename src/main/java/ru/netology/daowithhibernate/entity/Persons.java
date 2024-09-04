package ru.netology.daowithhibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Persons {

    //name, surname, age, phone_number, city_of_living;
    //первичным ключом будет сочетание name, surname, age.
    @EmbeddedId
    private Contact contact;

    @Column(nullable = false)
    private String phone_number;

    @Column(nullable = false)
    private String city_of_living;

}

