package ru.netology.daowithhibernate.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daowithhibernate.entity.Persons;
import ru.netology.daowithhibernate.repositories.ORMRepository;

import java.util.List;

@RestController
public class ORMController {
    private ORMRepository ormRepository;

    public ORMController(ORMRepository ormRepository) {
        this.ormRepository = ormRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getProduct(String city) {
        return ormRepository.getPersonsByCity(city);
    }

}
