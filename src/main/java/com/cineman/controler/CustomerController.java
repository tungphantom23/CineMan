package com.cineman.controler;

import com.cineman.dao.AccountDAO;
import com.cineman.dao.CustomerDAO;
import com.cineman.model.Account;
import com.cineman.model.AccountType;
import com.cineman.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CustomerController {
    private final AccountDAO accountRepository;
    private final CustomerDAO customerRepository;

    public CustomerController(AccountDAO accountRepository, CustomerDAO customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @GetMapping("/register")
    public String registerForm() { return "register"; }

    @PostMapping("/register")
    public String register(Account account, Customer customer, Model model) {
        // assign customer account type
        AccountType t = new AccountType();
        t.setId(3); // assumes data.sql created CUSTOMER as id=3
        account.setAccountType(t);
        Account saved = accountRepository.save(account);
        customer.setAccount(saved);
        customerRepository.save(customer);
        model.addAttribute("message", "Đăng ký thành công. Vui lòng đăng nhập.");
        return "login";
    }
}
