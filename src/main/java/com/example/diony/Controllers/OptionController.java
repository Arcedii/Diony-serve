package com.example.diony.Controllers;

import com.example.diony.entity.Option;
import com.example.diony.services.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/options")
public class OptionController {

    @Autowired
    private OptionService
            optionService;

    @GetMapping
    public List<Option> getAllOptions() {
        return optionService.getAllOptions();
    }

    @PostMapping
    public Option addOption(@RequestBody Option option) {
        return optionService.addOption(option);
    }

    @DeleteMapping("/{id}")
    public void deleteOption(@PathVariable Long id) {
        optionService.deleteOption(id);
    }
}
