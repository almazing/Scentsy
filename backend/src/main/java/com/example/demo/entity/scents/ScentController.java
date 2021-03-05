package com.example.demo.entity.scents;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "/api")
public class ScentController {

    @Autowired
    private ScentRepository ScentRepository;

    @GetMapping(path = "/scents")
    public @ResponseBody Iterable<Scent> getAllScents() {
        return ScentRepository.findAll();
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody Scent getScent(@PathVariable(value = "id") Integer id) {
        Optional<Scent> Scent = ScentRepository.findById(id);
        return Scent.get();
    }

    @PostMapping(path = "/scents")
    public @ResponseBody String createScent(@RequestBody Scent Scent) {
        ScentRepository.save(Scent);
        return "Saved";
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody String updateScent(@PathVariable(value = "id") Integer id, @RequestBody Scent ScentDetails) {

        Optional<Scent> optionalScent = ScentRepository.findById(id);
        Scent Scent = optionalScent.get();

        Scent.setScentName(ScentDetails.getScentName());
        Scent.setScentDescription(ScentDetails.getScentDescription());
        Scent.setScentCategory(ScentDetails.getScentCategory());
        

        ScentRepository.save(ScentDetails);
        return "Updated";
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody String deleteScent(@PathVariable(value = "id") Integer id) {
        ScentRepository.deleteById(id);
        return "Deleted";
    }
}