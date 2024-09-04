package ru.netology.daowithhibernate.repositories;

import org.springframework.stereotype.Repository;
import ru.netology.daowithhibernate.entity.Persons;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ORMRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Persons> getPersonsByCity(String city) {

        List<Persons> persons = entityManager.createQuery("SELECT p FROM Persons p WHERE p.city_of_living = :city", Persons.class)
                .setParameter("city", city)
                .getResultList();
        return persons;
    }

}
