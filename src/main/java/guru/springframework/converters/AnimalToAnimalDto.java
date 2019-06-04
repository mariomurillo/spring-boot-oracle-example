package guru.springframework.converters;

import guru.springframework.commands.AnimalDto;
import guru.springframework.domain.Animal;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AnimalToAnimalDto implements Converter<Animal, AnimalDto> {

    @Override
    public AnimalDto convert(Animal animal) {

        AnimalDto dto = new AnimalDto();
        dto.setId(animal.getId());
        dto.setName(animal.getName());

        return dto;
    }
}
