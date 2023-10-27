package rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.models.Project;
import rest.repo.ProjectRepo;

import java.util.List;

public class ApiProjectController {

    private ProjectRepo projectRepo;

    @GetMapping(value = "/projects")
    public List<Project> getProjects() {
        return projectRepo.findAll();
    }

    @PostMapping(value = "/saveProject")
    public void saveProject(@RequestBody Project project) {
        projectRepo.save(project);
    }
    @PutMapping(value = "/updateProject/{id}")
    public void updateProject(@PathVariable long id, @RequestBody Project project){
        Project updatedProject = projectRepo.findById(id).get();
    }

}




