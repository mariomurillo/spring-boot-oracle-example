package guru.springframework.services;

import guru.springframework.commands.AnimalDto;
import guru.springframework.domain.Animal;

import java.util.List;

public interface AnimalsService {

    List<Animal> listAll();

    Animal saveOrUpdateAnimalForm(AnimalDto animalForm);

    Animal getById(Long id);
}
