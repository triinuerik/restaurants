package com.triinu.restoran;

import com.triinu.restoran.entity.RestoRating;
import com.triinu.restoran.entity.Restoran;
import com.triinu.restoran.repository.RatingRepository;
import com.triinu.restoran.repository.RestoranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class RestoranController {

    @Autowired
    private RestoranRepository restoranRepository;
    @Autowired
    private RatingRepository ratingRepository;

    @RequestMapping("/greeting")
    @ResponseBody//Basically tells to not look for the jsp page, but to show the function's return value
    public String greeting() {
        return "nice";
    }

    @RequestMapping(value="/create/{name}", method= RequestMethod.GET)
    @ResponseBody
    public String createRestoran(@PathVariable String name) {
        Restoran restoran = new Restoran();
        restoran.setName(name);
        restoran.setAddress("10");
        restoran = restoranRepository.save(restoran);
        return String.valueOf(restoran.getId());
    }

    @RequestMapping(value={"/"})
    public String listRestaurants(Map<String, Object> model) {
        List<Restoran> restaurants = restoranRepository.findAll();
        model.put("restaurants", restaurants);
        return "restaurants";
    }

    @GetMapping(value = "/showRestoForm")
    public String showRestoForm(Model model) {
        model.addAttribute("restoran", new Restoran());
        return "resto_form";
    }

    @PostMapping(value = "/processRestoForm")
    public String processRestoForm(@ModelAttribute(value="restoran") Restoran restoran) {
        restoran = restoranRepository.save(restoran);
        return "redirect:/";
    }

    @GetMapping(value = "/showRatingForm")
    public String showRatingForm(Model model) {
        model.addAttribute("restoRating", new RestoRating());
        return "resto_form";
    }


    @GetMapping(value = "/showRatingForm/{id}")
    public String showRatingFormWithId(@PathVariable(value="id") Long id, Model model) {
        RestoRating restoRating = new RestoRating();
        Restoran restoran = restoranRepository.findOne(id);
        restoRating.setRestoran(restoran);
        model.addAttribute("restoRating", restoRating);
        List<RestoRating> restoRatings = ratingRepository.findByRestaurantId(id);
        model.addAttribute("restoRatings", restoRatings);
        return "rating_form";
    }

    @PostMapping(value = "/processRatingForm/{id}")
    public String processRatingForm(@ModelAttribute(value="restoRating") RestoRating restoRating, @PathVariable(value="id") Long id) {
        restoRating.setRestoran(restoranRepository.findOne(id));
        restoRating = ratingRepository.save(restoRating);
        return "redirect:/";
    }

    /*@RequestMapping(value={"/showRatingForm/{id}"})
    public String listRestoRatings(Map<String, Object> model) {
        List<RestoRating> restoRatings = ratingRepository.findAll();
        model.put("restoRatings", restoRatings);
        return "rating_form";
    }*/
}
