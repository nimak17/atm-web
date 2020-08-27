package th.go.rd.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import th.go.rd.atm.model.Customer;
import th.go.rd.atm.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //private ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping
    //@RequestMapping("/customer") //URL
    public String getCustomerPage(Model model) {
//        ArrayList<Customer> customers = new ArrayList<>();
//        customers.add(new Customer(1, "Peter", "1234"));
//        customers.add(new Customer(2, "Nancy", "2345"));
//        customers.add(new Customer(3, "Rick", "3456"));
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "customer"; // customer.html
    }

    @PostMapping
    public String registerCustomer(@ModelAttribute Customer customer, Model model) {
        customerService.createCustomer(customer);
        model.addAttribute("allCustomers", customerService.getCustomers());
        return "redirect:customer";
    }
}
