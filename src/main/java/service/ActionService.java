package service;

import Entity.Action;
import org.springframework.stereotype.Service;
import repository.ActionRepository;

@Service
public class ActionService {

    private final ActionRepository repository;

    public ActionService(ActionRepository repository) {
        this.repository = repository;
    }

    public Action update(Action action){
        return repository.save(action);
    }

    public Action add(Action action){
        return  repository.save(action);
    }

    public void delete(Action action){
        repository.delete(action);
    }
}
