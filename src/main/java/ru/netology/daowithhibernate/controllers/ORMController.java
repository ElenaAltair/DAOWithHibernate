package ru.netology.daowithhibernate.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daowithhibernate.entity.Persons;
import ru.netology.daowithhibernate.repositories.ORMRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ORMController {

    private final ORMRepository ormRepository;

    public ORMController(ORMRepository ormRepository) {
        this.ormRepository = ormRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getProduct(String city) {
        return ormRepository.findAllByCityOfLivingLike(city);
    }

    @GetMapping("/persons/by-city_query")
    public List<Persons> getProductQuery(String city) {
        return ormRepository.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Persons> getAgeLess(int age) {
        return ormRepository.findByContact_AgeLessThanOrderByContact_AgeAsc(age);
    }

    @GetMapping("/persons/by-age_query")
    public List<Persons> getAgeLessQuery(int age) {
        return ormRepository.findAgeLess(age);
    }

    @GetMapping("/persons/by-name")
    public Optional<Persons> getAgeLess(String name, String surname) {
        return ormRepository.findAllByContact_NameAndContact_Surname(name, surname); // http://localhost:8080/persons/by-name?name=Max&surname=Petrov
    }

    @GetMapping("/persons/by-name_query")
    public Optional<Persons> getAgeLessQuery(String name, String surname) {
        return ormRepository.findByName(name, surname); // http://localhost:8080/persons/by-name_query?name=Max&surname=Petrov
    }

}
