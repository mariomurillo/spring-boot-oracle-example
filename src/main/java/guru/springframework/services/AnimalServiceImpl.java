package guru.springframework.services;

import guru.springframework.commands.AnimalDto;
import guru.springframework.converters.AnimalConverter;
import guru.springframework.domain.Animal;
import guru.springframework.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalsService {

    @Autowired
    private AnimalRepository repository;
    @Autowired
    private AnimalConverter converter;

    @Override
    public List<Animal> listAll() {

        List<Animal> animals = new ArrayList<>();

        Iterable<Animal> animalsIterable = repository.findAll();

        for (Animal animal : animalsIterable) {
            animals.add(animal);
        }
        return animals;
    }

    @Override
    public Animal saveOrUpdateAnimalForm(AnimalDto dto) {

        Animal entity = converter.dtoToEntity(dto);

        Animal animalSaved = repository.save(entity);

        return animalSaved;
    }

    @Override
    public Animal getById(Long id) {
        return repository.findOne(id);
    }
}
