package pl.edu.wszib.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.edu.wszib.project.dao.SelectedColorDao;
import pl.edu.wszib.project.domain.SelectedColor;
import pl.edu.wszib.project.helper.ColorHelper;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class statController {

    @Value("${app.header.stat}")
    private String title;

    @Autowired
    SelectedColorDao selectedColorDao;

    @GetMapping("/stat")
    public String statPage (Model model){
        Iterable<SelectedColor> selectedColors = selectedColorDao.findAll();

        //grupowanie danych:
        Collection<SelectedColor> selectedColorCollection = (Collection<SelectedColor>) selectedColors;
        Map<String, Long> dataMap = selectedColorCollection.stream().collect(Collectors.groupingBy(SelectedColor::getColor, Collectors.counting()));

        List<String> labels = ColorHelper.convertColors(dataMap.keySet());

        model.addAttribute("title", title);
        model.addAttribute("dataMap", dataMap);
        model.addAttribute("labels", labels);

        return "stat";
    }
}