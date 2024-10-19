package com.asiri.tms.service;

import com.asiri.tms.to.TaskTo;

import java.util.List;

public interface TaskService {

    TaskTo createTask(TaskTo taskTo);

    void updateTask(TaskTo taskTo);

    void deleteTask(int taskId);

    List<TaskTo> getAllTasks();
}
