package service;

import Entity.Recipe;
import org.springframework.stereotype.Service;
import repository.RecipeRepository;

@Service
public class RecipeService {
    private final RecipeRepository repository;

    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public Recipe update(Recipe recipe){
        return repository.save(recipe);
    }

    public Recipe add(Recipe recipe){
        return  repository.save(recipe);
    }

    public void delete(Recipe recipe){
        repository.delete(recipe);
    }
}
