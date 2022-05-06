package by.asalalaiko.godeltask.controller;

import by.asalalaiko.godeltask.dto.Employee;
import by.asalalaiko.godeltask.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/save")
    public String add(@Valid Employee employee) {

        employeeService.saveEmployee(employee);

        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(value="id") Long id){
        if (id==null)  return "redirect:/";
        employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }



    @GetMapping("/edit")
    public String getToEdit (@RequestParam(value="id") Long id, Model model){
        model.addAttribute("title", "Main page");
        model.addAttribute("employee", employeeService.findEmployeeById(id));
        model.addAttribute("employees", employeeService.findAllEmployees());
        return "index";
    }




}
