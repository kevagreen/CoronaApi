package com.tts.coronatracking.controller;

import com.tts.coronatracking.services.CoronaData;
import com.tts.coronatracking.stats.StateStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class MainController {
    @Autowired
   CoronaData coronaData;

    @GetMapping(path = "/")
    public String stats(Model model){
        model.addAttribute("StateStats", coronaData.getStatList());
        return "stats";
    }
}
