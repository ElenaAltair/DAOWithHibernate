package ru.netology.daowithhibernate;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DaoWithHibernateApplication { // implements CommandLineRunner

    //@PersistenceContext
    //private EntityManager entityManager;

    public static void main(String[] args) throws Exception {

        //SpringApplication.run(DaoWithHibernateApplication.class, args);

        //отключаем банер spring boot, если не хотим видеть его лого в консоли
        SpringApplication app = new SpringApplication(DaoWithHibernateApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

	/*
	@Override
	@Transactional
	public void run(String... args) throws Exception {

		var person1 = Persons.builder()
				.contact(Contact.builder()
						.name("Oleg")
						.surname("Sidorov")
						.age(18)
						.build())
				.phone_number("8(911)777-77-77")
				.city_of_living("Moscow")
				.build();

		entityManager.persist(person1);

		var person2 = Persons.builder()
				.contact(Contact.builder()
						.name("Max")
						.surname("Petrov")
						.age(20)
						.build())
				.phone_number("8(911)555-55-55")
				.city_of_living("Sankt-Peterburg")
				.build();

		entityManager.persist(person2);

		var person3 = Persons.builder()
				.contact(Contact.builder()
						.name("Elena")
						.surname("Petrova")
						.age(25)
						.build())
				.phone_number("8(911)999-99-99")
				.city_of_living("Sankt-Peterburg")
				.build();

		entityManager.persist(person3);

		var person4 = Persons.builder()
				.contact(Contact.builder()
						.name("Ivan")
						.surname("Ivanov")
						.age(25)
						.build())
				.phone_number("8(911)888-88-88")
				.city_of_living("Minsk")
				.build();

		entityManager.persist(person4);

		var person5 = Persons.builder()
				.contact(Contact.builder()
						.name("Petr")
						.surname("Usupov")
						.age(12)
						.build())
				.phone_number("8(911)111-11-11")
				.city_of_living("Moscow")
				.build();

		entityManager.persist(person5);

	}
	*/

}
