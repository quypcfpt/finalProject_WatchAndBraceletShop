package com.spring2019.controllerImpl;

import com.spring2019.entity.ProductCategory;
import com.spring2019.model.ProductCategoryModel;
import com.spring2019.service.ProductCategoryService;
import com.spring2019.serviceImpl.ProductCategoryServiceImpl;
import com.spring2019.transformer.ProductCategoryTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ViewController {
@Autowired
    ProductCategoryTransformer cateTranform;

@Autowired
ProductCategoryService categoryService;
    /**
     * Login Page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/login", "/"})
    public String toLogin(Model model) {
        return "login";
    }

    /**
     * Home Product Page
     *
     * @param model
     * @return
     */
    @RequestMapping("/home")
    public String toHome(Model model) {
        //Excute anything here
        return "product/home";
    }

    /**
     * Home Product Page
     *
     * @param model
     * @return
     */
    @RequestMapping("/watch")
    public String toWatch(Model model) {
        //Excute anything here
        return "product/watch";
    //Admin
    @RequestMapping("/admin/product_category")
    public  String adminProductCategory(){
        //Excute anything here
        return "admin/category";
    }

    @PostMapping("/admin/product_category/save")
    public String postsSave(@ModelAttribute("form") ProductCategoryModel model, RedirectAttributes ra) {
        //TODO validation
        ProductCategory entity = new ProductCategory();
        entity = cateTranform.modelToEntity(model);
        entity.setActive(true);
        entity.setStatus(1);
        categoryService.save(entity);
        ra.addFlashAttribute("msg", "Created!");
        return "redirect:/admin/product_category";
    }
    @RequestMapping("/admin/label")
    public  String adminProductLabel(){
        //Excute anything here
        return "admin/label";
    }
}
