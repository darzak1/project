package pl.edu.wszib.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.edu.wszib.project.dao.SelectedColorDao;
import pl.edu.wszib.project.domain.SelectedColor;

import java.util.Date;

@Controller
public class SelectedColorController {

    @Value("${app.header.select_color}")
    private String title;

    @Autowired
    SelectedColorDao selectedColorDao;

    @GetMapping({"/select", "select/{color}"})
    public String selectColorPage (@PathVariable(required = false) String color, Model model){
        if (!StringUtils.isEmpty(color)){
            selectedColorDao.save(new SelectedColor(color, new Date()));
        }

        String[][] colors = {
                {"red", "blue", "pink", "green"},
                {"black", "yelloow", "purple", "orange"},
                {"yellow", "gray", "white", "brown"},
                {"black", "green", "green", "orange"}
        };

        model.addAttribute("title", title);
        model.addAttribute("colors", colors);
        return "select";
    }

    @GetMapping("/stat")
    public String selectStatPage (){
        return "stat";
    }


}
