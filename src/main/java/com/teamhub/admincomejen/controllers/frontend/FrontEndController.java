package com.teamhub.admincomejen.controllers.frontend;

import com.teamhub.admincomejen.entities.Employee;
import com.teamhub.admincomejen.entities.Enterprise;
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

    @PostMapping("/login")
    public String postLogin(@ModelAttribute("formUser") Employee employee,Model model){
        return "redirect:/home";
    }

    @GetMapping("/home")
    public String getHome(Model model){
        model.addAttribute("enterprises", this.enterpriseService.getEnterprises());
        return "home";
    }

    @DeleteMapping("/enterprises/front/delete/{id}")
    public String deleteEnterprise(@PathVariable Long id){
        this.enterpriseService.deleteEnterprise(id);
        return "redirect:/home";
    }

    @GetMapping("/enterprise/front/add/enterprise")
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
    @GetMapping("/enterprises/front/{id}")
    public String getManage(Model model,@PathVariable Long id) throws Exception {
        model.addAttribute("enterprise", this.enterpriseService.getEnterprise(id));
        return "manage-enterprise";
    }




}
