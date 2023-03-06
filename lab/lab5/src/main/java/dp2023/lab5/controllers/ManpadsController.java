package dp2023.lab5.controllers;


import dp2023.lab5.models.Manpads;
import dp2023.lab5.services.ManpadsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@Controller
public class ManpadsController {

    @Autowired
    private ManpadsService manpadsService;

    @GetMapping("/")
    public String home(Model model) {
        List<Manpads> manpadsList = manpadsService.getAllManpads();
        model.addAttribute("manpadsList", manpadsList);
        return "index";
    }

    @GetMapping("/add")
    public String addManpadsForm(Model model) {
        model.addAttribute("manpads", new Manpads());
        return "add_manpads";
    }

    @PostMapping("/add")
    public String addManpads(@ModelAttribute("manpads") @Valid Manpads manpads, BindingResult result) {
        if (result.hasErrors()) {
            return "add_manpads";
        }
        manpadsService.saveOrUpdateManpads(manpads);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String editManpadsForm(@PathVariable("id") int id, Model model) {
        Manpads manpads = manpadsService.getManpadsById(id);
        if (manpads != null) {
            model.addAttribute("manpads", manpads);
            return "edit_manpads";
        } else {
            return "redirect:/";
        }
    }

    @PostMapping("/edit/{id}")
    public String editManpads(@PathVariable("id") int id, @ModelAttribute("manpads") @Valid Manpads manpads,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "edit_manpads";
        }
        manpads.setId(id);
        manpadsService.saveOrUpdateManpads(manpads);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteManpads(@PathVariable("id") int id) {
        manpadsService.deleteManpads(id);
        return "redirect:/";
    }

}