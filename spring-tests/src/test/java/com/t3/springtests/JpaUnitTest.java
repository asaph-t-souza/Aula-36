package com.t3.springtests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.t3.springtests.entity.Task;
import com.t3.springtests.repository.TaskRepository;

@DataJpaTest
public class JpaUnitTest {

    @Autowired
    private TaskRepository taskRepository;

    @Test
	void contextLoads() {
        assertThat(taskRepository).isNotNull();
    }

    @Test
    void shouldStoreTask(){
        Task task = taskRepository.save(new Task("Quarto", "Arrumar os quartos", false));
        
        assertThat(task).hasFieldOrProperty("id");
        assertThat(task).hasFieldOrPropertyWithValue("name", "Quarto");
        assertThat(task).hasFieldOrPropertyWithValue("description", "Arrumar os quartos");
        assertThat(task).hasFieldOrPropertyWithValue("isDone", false);
    }

    @Test
    void testFindByName(){
        taskRepository.save(new Task("Quarto", "Arrumar os quartos", false));

        assertThat(taskRepository.findByName("Quarto").get()).isNotNull();
    }
    
}
