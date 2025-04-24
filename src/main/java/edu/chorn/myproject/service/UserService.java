package edu.chorn.myproject.service;

/*
    @author chorn
    @project myproject
    @class UserService
    @version 1.0.0
    @since 08.04.2025 - 17.36
*/

import edu.chorn.myproject.model.User;
import edu.chorn.myproject.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private List<User> userList = new ArrayList<>();
    {
        userList.add(new User("name1", "000001", "description1"));
        userList.add(new User("name2", "000002", "description2"));
        userList.add(new User("name3", "000003", "description3"));
    }

    @PostConstruct
    public void init() {
        userRepository.deleteAll();
        userRepository.saveAll(userList);
    }

    //  CRUD   - create read update delete

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        return userRepository.save(user);
    }

    public void delById(String id) {
        userRepository.deleteById(id);
    }
}
