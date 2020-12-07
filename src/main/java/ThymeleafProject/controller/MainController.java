package ThymeleafProject.controller;


import ThymeleafProject.model.Car;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;


@Controller
public class MainController {
    private static List<Car> cars = new ArrayList<Car>();
    static {
        cars.add(new Car(0, "Clio", "Renault", "Rouge"));
        cars.add(new Car(1, "Megane", "Renault", "Jaune"));
        cars.add(new Car(2, "308", "Peugeot", "Anthracite"));
    }

    @Value("${welcome.message}")
    private String message;

    @RequestMapping(value= {"/"}, method = RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("message", message);
        model.addAttribute("cars", cars);
        return "index";
    }
    @RequestMapping(value={"/{id}"}, method = RequestMethod.GET)
    public String details(Model model, @PathVariable("id") int id) {
        model.addAttribute("details", cars.get(id));
        return "details";
    }
}
