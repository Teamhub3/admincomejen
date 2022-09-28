package com.teamhub.admincomejen.controllers.frontend;

import com.teamhub.admincomejen.entities.Employee;
import com.teamhub.admincomejen.entities.Enterprise;
import com.teamhub.admincomejen.entities.EnumRoleName;
import com.teamhub.admincomejen.entities.Transaction;
import com.teamhub.admincomejen.services.EmployeeService;
import com.teamhub.admincomejen.services.EnterpriseService;
import com.teamhub.admincomejen.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FrontEndController {
    @Autowired
    private EnterpriseService enterpriseService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("formUser", new Employee());
        return "login";
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("formEmployee", new Employee());
        model.addAttribute("listEnterprises", this.enterpriseService.getEnterprises());
        return "register";
    }

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("formUser") Employee employee){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String getHome(Model model, Authentication auth) throws Exception {
        if (this.employeeService.getEmployeeByEmail(auth.getName()).getRoles().get(0) == EnumRoleName.ROLE_ADMIN) {
            model.addAttribute("enterprises", this.enterpriseService.getEnterprises());
            return "home-admin";
        }
        else {
            Enterprise enterprise = this.employeeService.getEmployeeByEmail(auth.getName()).getEnterprise();
            String redirectDir = "redirect:/enterprises/front/enterprise/"+enterprise.getId().toString();
            return redirectDir;
        }

    }

    @DeleteMapping("/enterprises/front/delete/{id}")
    public String deleteEnterprise(@PathVariable Long id){
        this.enterpriseService.deleteEnterprise(id);
        return "redirect:/home";
    }

    @GetMapping("/enterprises/front/add/enterprise")
    public String getAddEnterprise(Model model){
        model.addAttribute("formEnterprise", new Enterprise());
        return "add-enterprise";
    }
    @GetMapping("/enterprises/front/add/transaction/{id}")
    public String getAddTransaction(Model model, @PathVariable Long id){
        try {
            model.addAttribute("formTransaction",new Transaction());
            model.addAttribute("enterprise", this.enterpriseService.getEnterprise(id));
            return "add-transaction";

        }catch (Exception e){
            String redirectDir = "redirect:/enterprises/front/transactions/"+id.toString();
            return  redirectDir;
        }
    }
    @GetMapping("/enterprises/front/add/employee/{id}")
    public String getAddEmployee(Model model, @PathVariable Long id){
        try {
            model.addAttribute("formEmployee", new Employee());
            model.addAttribute("enterprise", this.enterpriseService.getEnterprise(id));
            model.addAttribute("listRoles", EnumRoleName.values());
            return "add-employee";
        }catch (Exception e){
            String redirectDir = "redirect: /enterprises/front/employees/" + id.toString();
            return redirectDir;
        }

    }

    @PostMapping("/enterprises/save")
    public String postEnterprise(@ModelAttribute("formEnterprise") Enterprise enterprise){
        enterprise.setId(this.enterpriseService.getUltimoId() + 1);
        enterprise.setCreatedAt(LocalDate.now());
        enterprise.setUpdatedAt(LocalDate.now());
        this.enterpriseService.postEnterprise(enterprise);
        return "redirect:/home";
    }

    @PostMapping("/transaction/save/{id}")
    public String postTransaction(@ModelAttribute("formTransaction") Transaction transaction, @PathVariable Long id,Authentication auth) throws Exception {
        transaction.setId(this.transactionService.getUltimoId() + 1);
        transaction.setEnterprise(this.enterpriseService.getEnterprise(id));
        transaction.setUpdatedAt(LocalDate.now());
        transaction.setCreatedAt(LocalDate.now());
        transaction.setEmployee(this.employeeService.getEmployeeByEmail(auth.getName()));
        this.transactionService.postTransaction(transaction);
        String redirectDir = "redirect:/enterprises/front/transactions/"+id.toString();
        return  redirectDir;
    }

    @PostMapping("/employee/save/{id}")
    public String postEmployee(@ModelAttribute("formEmployee") Employee employee, @PathVariable Long id) throws Exception {
        employee.setId(this.employeeService.getUltimoId() + 1);
        System.out.println(employee.getId());
        employee.setEnterprise(this.enterpriseService.getEnterprise(id));
        System.out.println(employee.getEnterprise().getId());
        employee.setCreatedAt(LocalDate.now());
        employee.setUpdateAt(LocalDate.now());
        this.employeeService.postEmployee(employee);
        String redirectDir = "redirect:/enterprises/front/employees/"+id.toString();
        return redirectDir;
    }
    @PostMapping("/employee/save")
    public String postEmployeeRegister(@ModelAttribute("formEmployee") Employee employee, Model model) throws Exception {
        employee.setId(this.employeeService.getUltimoId() + 1);
        System.out.println(employee.getId());
        employee.setCreatedAt(LocalDate.now());
        employee.setUpdateAt(LocalDate.now());
        List<EnumRoleName> roles = new ArrayList<>();
        roles.add(EnumRoleName.ROLE_ADMIN);
        employee.setRoles(roles);
        this.employeeService.postEmployee(employee);
        return "successful-registration";
    }
    @GetMapping("/enterprises/front/enterprise/{id}")
    public String getManageEnterprise(Model model, @PathVariable Long id, Authentication auth){
        try {
            model.addAttribute("enterprise", this.enterpriseService.getEnterprise(id));
            model.addAttribute("employee", this.employeeService.getEmployeeByEmail(auth.getName()));
            return "manage-enterprise";

        }catch (Exception e){
            return "/login";
        }
    }
    @GetMapping("/enterprises/front/transactions/{id}")
    public String getTransactions(Model model, @PathVariable Long id){
        try {
            model.addAttribute("listTransaction", this.transactionService.getTransactionByEnterpriseId(id));
            model.addAttribute("enterprise", this.enterpriseService.getEnterprise(id));
            return "manage-transactions";

        }catch (Exception e){
            return "redirect: /home";
        }
    }

    @GetMapping("/enterprises/front/employees/{id}")
    public String getEmployees(Model model, @PathVariable Long id) throws Exception {
        model.addAttribute("listEmployees", this.employeeService.getEmployeeByEnterpriseId(id));
        model.addAttribute("enterprise", this.enterpriseService.getEnterprise(id));
        return "manage-employees";
    }







}
