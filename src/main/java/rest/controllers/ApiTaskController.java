package rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.models.Project;
import rest.models.Task;
import rest.models.User;
import rest.repo.TaskRepo;

import java.util.List;

@RestController
public class ApiTaskController {

    @Autowired
    private TaskRepo taskRepo;

    @GetMapping(value = "/tasks")
    public List<Task> getTasks(){
        return taskRepo.findAll();
    }

    @PostMapping(value = "/saveTask")
    public String saveTask(@RequestBody Task task){
        taskRepo.save(task);
        return "Saved Successfully";
    }

    @PutMapping(value = "/updateTask/{id}")
    public String updateTask(@PathVariable long id, @RequestBody Task task){
        Task updatedTask = taskRepo.findById(id).get();
        updatedTask.setCategory(task.getCategory());
        updatedTask.setDescription(task.getDescription());
        updatedTask.setDeadline(task.getDeadline());
        //updatedTask.setStatus(task.getStatus());
        //updatedTask.setPriority(task.getPriority());

        taskRepo.save(updatedTask);
        return "Updated Successfully";
    }
    @GetMapping(value = "/task/{id}")
    public Task getTask(@PathVariable long id) {
        return taskRepo.findById(id).get();
    }

    @DeleteMapping(value = "/deleteTask/{id}")
    public String deleteTask(@PathVariable long id){
        taskRepo.deleteById(id);
        return "Deleted Successfully";
    }

}
