package it.sevenbits.homeworkBaseSpring.config;

import it.sevenbits.homeworkBaseSpring.core.repository.SimpleTaskRepository;
import it.sevenbits.homeworkBaseSpring.core.repository.ITaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
    @Bean
    public ITaskRepository itemsRepository() {
        return new SimpleTaskRepository();
    }
}


