package com.BookMyShowBackend.BookMyShow.Controllers;

import com.BookMyShowBackend.BookMyShow.Dtos.UserRequestDto;
import com.BookMyShowBackend.BookMyShow.Models.UserEntity;
import com.BookMyShowBackend.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @PostMapping("/add")
    public String addUser(@RequestBody()UserRequestDto userRequestDto) throws Exception {
        try {
            userService.createUser(userRequestDto);
        }
        catch (Exception e){
            return e.toString();
        }
        return "successfully added";
    }

    @GetMapping("/findbyname")
    public List<UserEntity> findUsersByName(@RequestParam("name")String name){
        return userService.findUserByName(name);
    }
}
