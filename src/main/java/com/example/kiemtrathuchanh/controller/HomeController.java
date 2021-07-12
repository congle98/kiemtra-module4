package com.example.kiemtrathuchanh.controller;

import com.example.kiemtrathuchanh.model.City;
import com.example.kiemtrathuchanh.model.Country;
import com.example.kiemtrathuchanh.service.CityService;
import com.example.kiemtrathuchanh.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private CityService cityService;

    @Autowired
    private CountryService countryService;



    @ModelAttribute("countries")
    public List<Country> listCountry(){
        return (List<Country>) countryService.findAll();
    }
    @GetMapping("")
    public ModelAndView listCity(){
        List<City> cities = (List<City>) cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("cities",cities);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("city",new City());
        return modelAndView;
    }
    @PostMapping("/create")
    public String save(@Valid @ModelAttribute ("city") City city, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "/create";
        }
        cityService.save(city);
        return "redirect:/home";
    }
    @GetMapping("/{id}/delete")
    public String deleteCity(@PathVariable Long id){
        cityService.delete(id);
        return "redirect:/home";
    }
    @GetMapping("/{id}/view")
    public ModelAndView viewCity(@PathVariable Long id){
        Optional<City> city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("city",city.get());
        return modelAndView;
    }
    @GetMapping("/{id}/edit")
    public ModelAndView editFormCity(@PathVariable Long id){
        Optional<City> city = cityService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("city",city.get());
        return modelAndView;
    }
    @PostMapping("/edit")
    public String editCity(@Valid @ModelAttribute City city, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            return "edit";
        }
        cityService.save(city);
        return "redirect:/home";
    }
}
