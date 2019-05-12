package pl.edu.wszib.project.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.project.dao.SelectedColorDao;
import pl.edu.wszib.project.domain.SelectedColor;

@Controller
public class DataController {

    @Value("${app.header.data}")
    private String title;

    @Autowired
    SelectedColorDao selectedColorDao;

    @GetMapping("/data")
    public String dataPage (Model model){
        Iterable<SelectedColor> selectedColors = selectedColorDao.findAll();

        model.addAttribute("title", title);
        model.addAttribute("selectedColors", selectedColors);
        return "data";
    }
}
