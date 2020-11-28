package com.app;

import java.util.Arrays;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

import com.app.entities.ContactsMasterEntity;
import com.app.repo.IContactsMasterRepository;

@SpringBootApplication
public class SpringBootDataJpaApplication {

	@Autowired
	private Environment env;

	@Autowired
	private IContactsMasterRepository contactsMasterRepository;

	private static final Logger log = LoggerFactory.getLogger(SpringBootDataJpaApplication.class);

	public static void main(String[] args) {
		// SpringApplication.run(SpringBootDataJpaApplication.class, args);
		new SpringApplicationBuilder(SpringBootDataJpaApplication.class).profiles("uat", "dev").run(args);
	}

	@Bean
	@Profile(value = "dev")
	public CommandLineRunner commandLineRunner1() {
		return args -> {
			Optional<ContactsMasterEntity> optionalContact = contactsMasterRepository.findById(8);
			if (optionalContact.isPresent()) {
				log.info("Contact found {}", optionalContact.get());
				ContactsMasterEntity contact = optionalContact.get();
				contact.setContactName("Prashant Paunikar");
				ContactsMasterEntity saveContactEntity = contactsMasterRepository.save(contact);
				log.info("Contact Updated Successfully With Entity {}", saveContactEntity);
			} else {
				log.info("Contact Not Found With Given Id");
			}
		};
	}

	@Bean
	@Profile(value = { "uat", "prod" })
	public CommandLineRunner commandLineRunner2() {
		return args -> {
			Arrays.stream(env.getActiveProfiles()).forEach(activeProfile -> log.info(activeProfile));
		};
	}

}
