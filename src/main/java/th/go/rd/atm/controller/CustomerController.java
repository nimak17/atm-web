package th.go.rd.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class CustomerController {

    private ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("/customer")
    //@RequestMapping("/customer") //URL
    public String getCustomerPage(Model model) {
//        ArrayList<Customer> customers = new ArrayList<>();
//        customers.add(new Customer(1, "Peter", "1234"));
//        customers.add(new Customer(2, "Nancy", "2345"));
//        customers.add(new Customer(3, "Rick", "3456"));
        model.addAttribute("allCustomers", customers);
        return "customer"; // customer.html
    }

    @PostMapping("customer")
    public String registerCustomer(@ModelAttribute Customer customer, Model model) { //@ModelAttribute <- หมายถึงรับมาจากหน้าบ้าน
        customers.add(customer);
        model.addAttribute("allCustomers", customers);
        return "redirect:customer"; //redirect <- รีเซ็ตค่าใน form ก่อนส่งค่าไป
    }


}
