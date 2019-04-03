package it.sevenbits.homeworkBaseSpringBoot.config;

import it.sevenbits.homeworkBaseSpringBoot.core.repository.ITaskRepository;
import it.sevenbits.homeworkBaseSpringBoot.core.repository.SimpleTaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class RepositoryConfig {
    @Bean
    public ITaskRepository itemsRepository() {
        return new SimpleTaskRepository(new ConcurrentHashMap<>());
    }
}