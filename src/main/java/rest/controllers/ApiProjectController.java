package rest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.models.Project;
import rest.repo.ProjectRepo;

import java.util.List;

@RestController
public class ApiProjectController {

    @Autowired
    private ProjectRepo projectRepo;


    @GetMapping(value = "/projects")
    public List<Project> getProjects() {
        return projectRepo.findAll();
    }
    @GetMapping(value = "/project/{id}")
    public Project getProjects(@PathVariable long id) {
        return projectRepo.findById(id).get();
    }

    @PostMapping(value = "/saveProject")
    public void saveProject(@RequestBody Project project) {
        projectRepo.save(project);
    }
    @PutMapping(value = "/updateProject/{id}")
    public void updateProject(@PathVariable long id, @RequestBody Project project){
        Project updatedProject = projectRepo.findById(id).get();
        updatedProject.setDeadline(project.getDeadline());
        updatedProject.setDescription(project.getDescription());
        updatedProject.setProjectName(project.getProjectName());
        updatedProject.setStatus(project.getStatus());
        updatedProject.setSubject(project.getSubject());
    }
    @DeleteMapping (value = "/delete/{id}")
    public void deleteProject(@PathVariable long id){
        Project deleteProject = projectRepo.findById(id).get();
        projectRepo.delete(deleteProject);

    }


}




