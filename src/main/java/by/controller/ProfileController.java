package by.controller;


import by.entity.User;
import by.manager.UserManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;

@Slf4j
@Controller
@RequestMapping("/profile")
public class ProfileController {



    @Autowired
    private UserManager userManager;


    @GetMapping
    public String getStorage(Principal principal, ModelMap map,
        @RequestParam(value = "error", required = false) String error) {
        User user = userManager.findByLogin(principal.getName());
        map.put("user", user);
        return "profile";
    }

//    @PostMapping("/discard")
//    public String discardStorageProduct(@ModelAttribute StorageDTO storageDTO, BindingResult bindingResult,
//                                        RedirectAttributes redirectAttributes, Principal principal) {
//        Storage storage = storageManager.getById(storageDTO.getStorageId());
//        discardValidator.validate(storageDTO, bindingResult);
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
//            return "redirect:/storage";
//        }
//        storageManager.discardProduct(storageDTO);
//        log.info("Пользователь " + userManager.findByLogin(principal.getName()).getLogin() + " списал товар '" +
//                storage.getProduct().getName() + "' в размере "
//                + storageDTO.getQuantity());
//        return "redirect:/storage";
//    }
//
//    @GetMapping("/deleteDiscarded")
//    public String deleteDiscardedProduct(@RequestParam("id") int id) {
//        discardedProductManager.delete(discardedProductManager.getById(id));
//        return "redirect:/storage";
//    }
//
//    @GetMapping("/generateReport")
//    public String generateReport(RedirectAttributes redirectAttributes) {
//        try {
//            storageManager.writeToExcelSheet();
//            redirectAttributes.addFlashAttribute("success","Отчет сгенерирован");
//        }catch (Exception e) {
//            redirectAttributes.addFlashAttribute("failure", e.getMessage());
//        }
//        return "redirect:/storage";
//    }
//
//    @PostMapping("/return")
//    public String returnDiscarded(@ModelAttribute StorageDTO storageDTO, BindingResult bindingResult,
//                                  Principal principal, RedirectAttributes redirectAttributes) {
//        DiscardedProduct discardedProduct = discardedProductManager.getById(storageDTO.getStorageId());
//        returnValidator.validate(storageDTO, bindingResult);
//        if (bindingResult.hasErrors()) {
//            redirectAttributes.addFlashAttribute("errors",bindingResult.getAllErrors());
//            return "redirect:/storage";
//        }
//        storageManager.returnProduct(storageDTO);
//        log.info("Пользователь " + userManager.findByLogin(principal.getName()).getLogin() + " вернул списанный товар '" +
//                discardedProduct.getProduct().getName() + "' на склад в размере "
//                + storageDTO.getQuantity() + "шт.");
//        return "redirect:/storage";
//    }
}

