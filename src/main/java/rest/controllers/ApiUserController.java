package rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rest.models.Task;
import rest.models.User;
import rest.repo.UserRepo;
import java.util.List;

@RestController
public class ApiUserController {

    @Autowired
    private UserRepo userRepo;


    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable long id) {
        return userRepo.findById(id).get();
    }

    @PostMapping(value = "/saveUser")
    public String saveUsers(@RequestBody User user){
        userRepo.save(user);
        return "Saved Successfully";
    }

    @PostMapping(value = "/updateUser/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setUserName(user.getUserName());
        updatedUser.setUserPass(user.getUserPass());
        updatedUser.setFirstName(user.getFirstName());
        userRepo.save(updatedUser);
        return "Updated Successfully";
    }

    @PostMapping(value = "/deleteUser/{id}")
    public String deleteUser(@PathVariable long id){
        userRepo.deleteById(id);
        return "Deleted Successfully";
    }

}
