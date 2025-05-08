package service;

import model.Animal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Zoo {
    private List<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
        animals.add(animal);
        System.out.println(animal.getName() + " has been added to the zoo.");
    }

    public void showAllAnimalActions() {
        System.out.println("\nAnimal sounds and movements:");
        for (Animal animal : animals) {
            animal.makeSound();
            animal.move();
        }
    }

    public void showAnimalCountByType() {
        Map<String, Integer> typeCount = new HashMap<>();
        for (Animal animal : animals) {
            String typeName = animal.getClass().getSimpleName();
            typeCount.put(typeName, typeCount.getOrDefault(typeName, 0) + 1);
        }

        System.out.println("\nAnimal type counts:");
        for (Map.Entry<String, Integer> entry : typeCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
