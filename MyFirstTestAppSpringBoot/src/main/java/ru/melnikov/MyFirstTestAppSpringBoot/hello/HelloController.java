package ru.melnikov.MyFirstTestAppSpringBoot.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class HelloController {
    private ArrayList<String> arrayList = new ArrayList<>();// Статическая переменная для хранения списка
    private HashMap<Integer, String> hashMap = new HashMap<>();//Статическая переменная для хранения ключ-значение

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name",
            defaultValue = "World") String name){
        return String.format("Hello %s!", name);
    }

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam String s){
        arrayList.add(s);
        return "Текущее состояние списка: " + arrayList.toString();
    }

    @GetMapping("/show-array")
    public String showArrayList(){
        if (arrayList.isEmpty()) {
            return "Список пуст.";
        } else {
            return "Текущий список: " + arrayList.toString();
        }
    }

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam String s){
        int i = hashMap.size() + 1;
        hashMap.put(i, s);
        return "Текущее состояние hashMap: " + hashMap.toString();
    }

    @GetMapping("/show-map")
    public String showHashMap(){
        if (hashMap.isEmpty()) {
            return "Список пуст.";
        } else {
            return "Текущий список: " + hashMap.toString();
        }
    }

    @GetMapping("/show-all-lenght")
    public String showAllLenght(){
        if (hashMap.isEmpty() || arrayList.isEmpty()) {
            return "Список(ки) пуст(ы).";
        } else {
            return "Количество эл-ов ArrayLis: " + arrayList.size() +
                   "; Количество эл-ов HashMap: " + hashMap.size() + ";";
        }
    }
}
