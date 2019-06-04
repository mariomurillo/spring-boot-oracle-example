package guru.springframework.controllers;

import guru.springframework.commands.AnimalDto;
import guru.springframework.domain.Animal;
import guru.springframework.services.AnimalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class AnimalsController {

    @Autowired
    private AnimalsService service;

    @RequestMapping("/animals")
    public String redirToList(){

        return "redirect:/animal/list";
    }

    @RequestMapping({"/animal/list", "/animal"})
    public String listAnimals(Model model){
        model.addAttribute("animals", service.listAll());
        return "animal/list";
    }

    @RequestMapping("/animal/new")
    public String newAnimal(Model model){
        model.addAttribute("animalForm", new AnimalDto());
        return "animal/animalform";
    }

    @RequestMapping(value = "/animal", method = RequestMethod.POST)
    public String saveOrUpdateAnimal(@Valid AnimalDto animalForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "animal/animalform";
        }

        Animal savedAnimal = service.saveOrUpdateAnimalForm(animalForm);

        return "redirect:/animal/show/" + savedAnimal.getId();
    }

    @RequestMapping("/animal/show/{id}")
    public String getAnimal(@PathVariable String id, Model model){
        model.addAttribute("animal", service.getById(Long.valueOf(id)));
        return "animal/show";
    }
}
