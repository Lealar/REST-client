package com.epam.rd.izh;



import com.epam.rd.izh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Communication {

    private final String URL = "http://localhost:8080/api/users";

    @Autowired
    private RestTemplate restTemplate;

    public List<User> getAllUser(){

        ResponseEntity<List<User>> responseEntity =
                restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                });

        List<User> allUsers = responseEntity.getBody();
        return allUsers;

    }
    public User getUser(int id){
        User user = restTemplate.getForObject(URL + "/" + id, User.class);
        return user;
    }

    public void saveUser(User user){
        int id = user.getId();
        if (id == 0){
            ResponseEntity<String> responseEntity =
                    restTemplate.postForEntity(URL, user, String.class);
            System.out.println("New User was added to db");
            System.out.println(responseEntity.getBody());
        } else {
            restTemplate.put(URL, user);
            System.out.println("User with id= " + id + " was updated");
        }

    }
    public void deleteUser(int id){
        restTemplate.delete(URL + "/" + id);
        System.out.println("User with id= " + id + " was deleted from db");
    }
}
