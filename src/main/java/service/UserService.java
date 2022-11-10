package service;

import Entity.User;
import org.springframework.stereotype.Service;
import repository.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User update(User user){
        return repository.save(user);
    }

    public User add(User user){
        return  repository.save(user);
    }

    public void delete(User user){
        repository.delete(user);
    }
}
