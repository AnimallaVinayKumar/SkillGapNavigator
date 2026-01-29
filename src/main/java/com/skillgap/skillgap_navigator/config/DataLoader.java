package com.skillgap.skillgap_navigator.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.skillgap.skillgap_navigator.entity.*;
import com.skillgap.skillgap_navigator.repository.*;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadSkills(SkillRepository skillRepository) {
        return args -> {
            if (skillRepository.count() == 0) {
                skillRepository.save(new Skill("Java", "Programming"));
                skillRepository.save(new Skill("Spring Boot", "Backend"));
                skillRepository.save(new Skill("React", "Frontend"));
                skillRepository.save(new Skill("MySQL", "Database"));
                skillRepository.save(new Skill("Docker", "DevOps"));
                
            }
        };
    }

    @Bean
    CommandLineRunner loadResources(
            SkillRepository skillRepository,
            SkillResourceRepository resourceRepository) {

        return args -> {
            if (resourceRepository.count() > 0) return;

            skillRepository.findAll().forEach(skill -> {

                switch (skill.getName().toLowerCase()) {

                    case "java" -> {
                        save(resourceRepository, skill, ResourceType.OFFICIAL,
                                "https://docs.oracle.com/javase/tutorial/");
                        save(resourceRepository, skill, ResourceType.BEGINNER,
                                "https://www.javatpoint.com/java-tutorial");
                        save(resourceRepository, skill, ResourceType.PRACTICE,
                                "https://www.hackerrank.com/domains/java");
                    }

                    case "spring boot" -> {
                        save(resourceRepository, skill, ResourceType.OFFICIAL,
                                "https://spring.io/guides");
                        save(resourceRepository, skill, ResourceType.BEGINNER,
                                "https://www.baeldung.com/spring-boot");
                        save(resourceRepository, skill, ResourceType.PRACTICE,
                                "https://www.baeldung.com/spring-boot-rest-api");
                    }

                    case "react" -> {
                        save(resourceRepository, skill, ResourceType.OFFICIAL,
                                "https://react.dev/learn");
                        save(resourceRepository, skill, ResourceType.BEGINNER,
                                "https://www.w3schools.com/react/");
                        save(resourceRepository, skill, ResourceType.PRACTICE,
                                "https://reactjs.org/tutorial/tutorial.html");
                    }

                    case "mysql" -> {
                        save(resourceRepository, skill, ResourceType.OFFICIAL,
                                "https://dev.mysql.com/doc/");
                        save(resourceRepository, skill, ResourceType.BEGINNER,
                                "https://www.w3schools.com/mysql/");
                        save(resourceRepository, skill, ResourceType.PRACTICE,
                                "https://sqlzoo.net/");
                    }

                    case "docker" -> {
                        save(resourceRepository, skill, ResourceType.OFFICIAL,
                                "https://docs.docker.com/");
                        save(resourceRepository, skill, ResourceType.BEGINNER,
                                "https://docker-curriculum.com/");
                        save(resourceRepository, skill, ResourceType.PRACTICE,
                                "https://labs.play-with-docker.com/");
                    }

                    case "c" -> {
                        save(resourceRepository, skill, ResourceType.OFFICIAL,
                                "https://en.cppreference.com/w/c");
                        save(resourceRepository, skill, ResourceType.BEGINNER,
                                "https://www.programiz.com/c-programming");
                        save(resourceRepository, skill, ResourceType.PRACTICE,
                                "https://www.hackerrank.com/domains/c");
                    }

                }
            });
        };
    }

    private void save(SkillResourceRepository repo,
                      Skill skill,
                      ResourceType type,
                      String url) {

        SkillResource r = new SkillResource();
        r.setSkill(skill);
        r.setType(type);
        r.setUrl(url);
        repo.save(r);
    }
}
