package guru.springframework.converters;

import guru.springframework.commands.AnimalDto;
import guru.springframework.domain.Animal;
import org.springframework.stereotype.Component;

@Component
public class AnimalConverter {

    public Animal dtoToEntity(AnimalDto dto) {

        Animal animal = new Animal();
        animal.setName(dto.getName());

        return animal;
    }
}
