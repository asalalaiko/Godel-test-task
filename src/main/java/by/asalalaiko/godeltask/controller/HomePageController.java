package by.asalalaiko.godeltask.controller;

import by.asalalaiko.godeltask.dto.Employee;
import by.asalalaiko.godeltask.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class HomePageController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/")
    public String Home (Model model){
        model.addAttribute("title", "Main page");
        model.addAttribute("employee", new Employee());
        model.addAttribute("employees", employeeService.findAllEmployees());
        return "index";
    }

    @PostMapping("/")
    public String addCity(@Valid Employee employee) {

        employeeService.createEmployee(employee);

        return "redirect:/";
    }

//    @GetMapping("/admin/city/delete")
//    public String deleteCity(@RequestParam(value="id") Long id){
//        if (id==null)
//            throw new CityNotFoundException();
//        cityService.deleteById(id);
//        return "redirect:/admin/city";
//    }
//
//
//
//    @GetMapping("/admin/city/edit")
//    public String getCityToEdit (@RequestParam(value="id") Long id, Model model){
//        model.addAttribute("title", "Admin - Cities list");
//        model.addAttribute("city", cityService.getCityById(id));
//        model.addAttribute("cities", cityService.getCities());
//        return "/admin/city";
//    }




}
