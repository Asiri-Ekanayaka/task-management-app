package com.asiri.tms.service.impl;

import com.asiri.tms.entity.Task;
import com.asiri.tms.entity.User;
import com.asiri.tms.repository.TaskRepository;
import com.asiri.tms.service.TaskService;
import com.asiri.tms.service.exception.ServiceException;
import com.asiri.tms.to.TaskTo;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final ModelMapper mapper;

    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    @Override
    public TaskTo createTask(TaskTo taskTo) {
        Task taskEntity = mapper.map(taskTo, Task.class);
        taskEntity.setUser(new User(SecurityContextHolder.getContext().getAuthentication().getName()));
        taskEntity = taskRepository.save(taskEntity);
        return mapper.map(taskEntity, TaskTo.class);
    }

    @Override
    public void updateTask(TaskTo taskTo) {
        Task taskEntity = taskRepository.findTaskByIdAndUser(taskTo.getId(), new User(SecurityContextHolder.getContext().getAuthentication().getName()))
                .orElseThrow(() -> new ServiceException(ServiceException.Type.NOT_FOUND, "Task does not exist"));
        taskEntity.setDescription(taskTo.getDescription());
        taskEntity.setCompleted(taskTo.getCompleted());
        taskRepository.save(taskEntity);
    }

    @Override
    public void deleteTask(int taskId) {
        Task taskEntity = taskRepository.findTaskByIdAndUser(taskId, new User(SecurityContextHolder.getContext().getAuthentication().getName()))
                .orElseThrow(() -> new ServiceException(ServiceException.Type.NOT_FOUND, "Task does not exist"));
        taskRepository.delete(taskEntity);
    }

    @Override
    public List<TaskTo> getAllTasks() {
        return taskRepository.findAllTasksByUser(new User(SecurityContextHolder.getContext().getAuthentication().getName()))
                .map(task -> mapper.map(task, TaskTo.class)).collect(Collectors.toList());
    }
}
