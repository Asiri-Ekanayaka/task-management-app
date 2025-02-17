package com.asiri.tms.repository;

import com.asiri.tms.entity.Task;
import com.asiri.tms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.stream.Stream;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    Optional<Task> findTaskByIdAndUser(Integer id, User user);

    Stream<Task> findAllTasksByUser(User user);

}
