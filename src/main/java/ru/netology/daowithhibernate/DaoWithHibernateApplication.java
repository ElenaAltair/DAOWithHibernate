package ru.netology.daowithhibernate;

import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.netology.daowithhibernate.entity.Contact;
import ru.netology.daowithhibernate.entity.Persons;
import ru.netology.daowithhibernate.repositories.ORMRepository;

import java.util.logging.Logger;

@SpringBootApplication
public class DaoWithHibernateApplication implements CommandLineRunner {

    private Logger log = Logger.getLogger(DaoWithHibernateApplication.class.getName());

    private final ORMRepository repository;

    public DaoWithHibernateApplication(ORMRepository repository) {
        this.repository = repository;
    }

    public static void main(String[] args) throws Exception {
        //отключаем банер spring boot, если не хотим видеть его лого в консоли
        SpringApplication app = new SpringApplication(DaoWithHibernateApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        // тест

        Persons person1 = Persons.builder()
                .contact(Contact.builder()
                        .name("Olga")
                        .surname("Orlova")
                        .age(30)
                        .build())
                .phoneNumber("8(911)555-77-77")
                .cityOfLiving("Sankt-Peterburg")
                .build();

        Persons saved1 = repository.save(person1);
        log.info(String.valueOf(saved1));

        repository.delete(saved1);

    }
}
