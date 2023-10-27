package rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import rest.models.Task;
import rest.models.User;
import rest.repo.TaskRepo;

import java.util.List;

public class ApiTaskController {

    @Autowired
    private TaskRepo taskRepo;

    @GetMapping(value = "/tasks")
    public List<Task> getTasks(){
        return taskRepo.findAll();
    }

    @PostMapping(value = "/savetask")
    public String saveTask(@RequestBody Task task){
        taskRepo.save(task);
        return "Saved Successfully";
    }

    @PostMapping(value = "/updatetask/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task){
        Task updatedTask = taskRepo.findById(id).get();
        updatedTask.setCategory(task.getCategory());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setDeadline(task.getDeadline());
        updatedTask.setStatus(task.getStatus());
        updatedTask.setPriority(task.getPriority());

        taskRepo.save(updatedTask);
        return "Updated Successfully";
    }

    @PostMapping(value = "/deletetask/{id}")
    public String deleteTask(@PathVariable long id){
        taskRepo.deleteById(id);
        return "Deleted Successfully";
    }

}
