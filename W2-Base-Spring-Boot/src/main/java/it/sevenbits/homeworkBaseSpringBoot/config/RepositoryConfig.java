package it.sevenbits.homeworkBaseSpringBoot.config;

import it.sevenbits.homeworkBaseSpringBoot.core.repository.ITaskRepository;
import it.sevenbits.homeworkBaseSpringBoot.core.repository.SimpleTaskRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ConcurrentHashMap;

/**
 * this is class for configuration ITaskRepository to choose right realization of this interface
 */
@Configuration
public class RepositoryConfig {
    /**
     * this function created the realization of ITaskRepository
     * @return : SimpleTaskRepository like ConcurrentHashMap
     */
    @Bean
    public ITaskRepository itemsRepository() {
        return new SimpleTaskRepository(new ConcurrentHashMap<>());
    }
}