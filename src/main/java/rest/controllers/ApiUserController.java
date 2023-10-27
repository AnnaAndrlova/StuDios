package rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import rest.models.User;
import rest.repo.UserRepo;
import java.util.List;

public class ApiUserController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value = "/")
    public String getPage(){
        return "Welcome";
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/saveuser")
    public String saveUsers(@RequestBody User user){
        userRepo.save(user);
        return "Saved Successfully";
    }

    @PostMapping(value = "/updateuser/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setUserName(user.getUserName());
        updatedUser.setUserPass(user.getUserPass());

        userRepo.save(updatedUser);
        return "Updated Successfully";
    }

    @PostMapping(value = "/deleteuser/{id}")
    public String deleteUser(@PathVariable long id){
        userRepo.deleteById(id);
        return "Deleted Successfully";
    }

}
