package com.example.praktika3.controller;

import com.example.praktika3.entity.PeopleEntity;
import com.example.praktika3.repository.PeopleRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
public class PeopleController {

    private final PeopleRepository peopleRepository;



    @PostMapping("/addPeople")
    public  String newPeople(@RequestBody PeopleEntity people){
        if (people == null) {
            return "Ошибка: Невозможно добавить пустого человека";
        }
        peopleRepository.save(people);
        return "Новый человек добавлен";
    }

    @GetMapping("/people/{id}")
    public String getPeopleById(@PathVariable int id) {
        Optional<PeopleEntity> people = peopleRepository.findById(id);
        if (people.isEmpty()) {
            return "Человек с таким ID не найден";
        }
        return "Человек найден: " + people.get();
    }

    @GetMapping("/people")
    public String getPeopleByGender(@RequestParam String g) {
        List<PeopleEntity> peopleList = peopleRepository.findByGender(g);
        if (peopleList.isEmpty()) {
            return "Не найдено людей с таким полом";
        }

        StringBuilder result = new StringBuilder();
        result.append("Найдено людей с полом ").append(g).append(":\n");

        for (PeopleEntity person : peopleList) {
            result.append(String.format(
                    "\nID: %d\nИмя: %s\nФамилия: %s\nВозраст: %d\nПол: %s\nEmail: %s\nТелефон: %s\n",
                    person.getId(),
                    person.getFirstName(),
                    person.getLastName(),
                    person.getAge(),
                    person.getGender(),
                    person.getEmail(),
                    person.getPhone()));
        }

        return result.toString();
    }


    @GetMapping("/ageGreaterThan")
    public String getPeopleByAgeGreaterThan(@RequestParam int age) {
        List<PeopleEntity> peopleList = peopleRepository.findByAgeGreaterThan(age);
        if (peopleList.isEmpty()) {
            return "Не найдено людей старше " + age + " лет";
        }

        StringBuilder result = new StringBuilder();
        result.append("Найдено людей старше ").append(age).append(" лет:\n");

        for (PeopleEntity person : peopleList) {
            result.append(String.format(
                    "\nID: %d\nИмя: %s\nФамилия: %s\nВозраст: %d\nПол: %s\nEmail: %s\nТелефон: %s\n",
                    person.getId(),
                    person.getFirstName(),
                    person.getLastName(),
                    person.getAge(),
                    person.getGender(),
                    person.getEmail(),
                    person.getPhone()));
        }

        return result.toString();
    }

    @DeleteMapping("/people/{id}")
    public String deletePeopleById(@PathVariable int id){
        PeopleEntity people = peopleRepository.findById(id).orElse(null);
        if(people == null){
            return "Такого человека нету";
        }
        peopleRepository.deleteById(id);
        return "Человек удалён";
    }
}
