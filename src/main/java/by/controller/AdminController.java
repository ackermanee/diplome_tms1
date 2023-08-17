package by.controller;

import by.entity.User;
import by.manager.AdminManager;
import by.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserManager userManager;

    @Autowired
    private AdminManager adminManager;

    @GetMapping
    public String getUserList(Principal principal, ModelMap map) {
        User user = userManager.findByLogin(principal.getName());
        map.put("user",user);
        map.put("logs", adminManager.getUsersLog());
        map.put("users", userManager.getUsers());
        return "adminPanel";
    }
//    @GetMapping("/admin")
//    public String getUserList(ModelMap map, Principal principal) {
//        return "admin";
//    }
//    @GetMapping
//    public String getUserList(Principal principal, ModelMap map) {
//        User user = userManager.findByRole("ADMIN");
//        map.put("admin",user);
////        map.put("logs", adminManager.getUsersLog());
////        map.put("users", userManager.getUsers());
//        return "/admin";
//    }


//    @GetMapping("/admin")
//    public String getUserList(ModelMap map, Principal principal) {
//        User user = userManager.findByRole(principal.getName());
//        if (user.getRole()=="ADMIN"){
//            map.put("user",user);
//
//            return "admin";
//
//        }
//        else {
//            return "admin";
//        }
//
//    }

//
//    @GetMapping("/access")
//    public String approveUser(@RequestParam("id") int userId,@RequestParam boolean status) {
//        User user = userManager.getById(userId);
//        if (status) {
////            user.setApproved(true);
//            userManager.editUser(user);
//            log.info("Пользователь " + user.getLogin() + " был подтвержден в системе");
//        }else {
////            user.setApproved(false);
//            userManager.editUser(user);
//            log.info("Пользователю " + user.getLogin() + " был запрещен доступ к системе");
//        }
//        return "redirect:/admin";
//    }
//
//    @GetMapping("/delete")
//    public String deleteUser(@RequestParam("id") int userId) {
//        User user = userManager.getById(userId);
//        userManager.delete(user);
//        log.info("Пользователь " + user.getLogin() + " был удален из системы");
//        return "redirect:/admin";
//    }
}

