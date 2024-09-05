package ru.netology.daowithhibernate.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.netology.daowithhibernate.entity.Persons;

import java.util.List;
import java.util.Optional;

@Repository
public interface ORMRepository extends JpaRepository<Persons, Long> {

    // создайте метод, который будет принимать название города (city) и
    // возвращать Entity из базы данных, которые соответствуют этому city
    List<Persons> findAllByCityOfLivingLike(String cityOfLiving);

    // или через query
    @Query("select p from Persons p where p.cityOfLiving like ?1")
    List<Persons> getPersonsByCity(String cityOfLiving);


    // создайте метод, который будет принимать возраст (age) и возвращать Entity из базы данных,
    // которые меньше переданного age и отсортированы по возрастанию
    List<Persons> findByContact_AgeLessThanOrderByContact_AgeAsc(int age);

    // или через query
    @Query("select p from Persons p where p.contact.age < ?1 order by p.contact.age")
    List<Persons> findAgeLess(int age);


    // создайте метод, который будет принимать имя и фамилию (name и surname) и
    // возвращать Entity из базы данных,
    // которые соответствуют сочетанию name и surname и являются Optional.
    Optional<Persons> findAllByContact_NameAndContact_Surname(String name, String surname);

    // или через query
    @Query("select p from Persons p where p.contact.name = ?1 and p.contact.surname = ?2")
    Optional<Persons> findByName(String name, String surname);

    /*
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public List<Persons> getPersonsByCity(String city) {

        List<Persons> persons = entityManager.createQuery("SELECT p FROM Persons p WHERE p.city_of_living = :city", Persons.class)
                .setParameter("city", city)
                .getResultList();
        return persons;
    }
    */
}
