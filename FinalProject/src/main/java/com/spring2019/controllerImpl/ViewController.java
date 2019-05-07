package com.spring2019.controllerImpl;

import com.spring2019.entity.*;
import com.spring2019.model.*;
import com.spring2019.service.*;
import com.spring2019.serviceImpl.ProductCategoryServiceImpl;
import com.spring2019.transformer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ViewController {
    @Autowired
    ProductCategoryTransformer cateTranform;
    @Autowired
    GlassTypeTransformer glassTypeTransformer;
    @Autowired
    LabelTransformer labelTransformer;
    @Autowired
    OriginTransformer originTransformer;
    @Autowired
    WireTransformer wireTransformer;
    @Autowired
    MachineTypeTransformer machineTypeTransformer;
    @Autowired
    ProductTransformer productTransformer;

    @Autowired
    UserTransformer userTransformer;

    @Autowired
    ProductCategoryService categoryService;
    @Autowired
    GlassTypeService glassTypeService;
    @Autowired
    LabelService labelService;
    @Autowired
    OriginService originService;
    @Autowired
    WireTypeService wireTypeService;
    @Autowired
    MachineTypeService machineTypeService;
    @Autowired
    ProductService productService;

    @Autowired
    UserService userService;
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
    }

    //Admin Product Category
    @RequestMapping("/admin/product_category")
    public String adminProductCategory() {
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
        boolean check = categoryService.save(entity);
        if (check) {
            ra.addFlashAttribute("msg", "Created!");
        } else {
            ra.addFlashAttribute("msgerror", "Wire type is existed!");
        }
        return "redirect:/admin/product_category";
    }

    //Label
    @RequestMapping("/admin/label")
    public String adminProductLabel() {
        //Excute anything here
        return "admin/label";
    }

    @PostMapping("/admin/label/save")
    public String postsSaveLabel(@ModelAttribute("form") LabelModel model, RedirectAttributes ra) {
        //TODO validation
        Label entity = new Label();
        entity = labelTransformer.modelToEntity(model);
        entity.setActive(true);
        entity.setStatus(model.getStatus());
        if (entity.getStatus() == 0) {
            entity.setStatus(1);
        }
        if (entity.getImage() == null) {
            entity.setImage("data:image/png;base64,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");
        }
        boolean check = labelService.save(entity);
        if (check) {
            ra.addFlashAttribute("msg", "Created!");
        } else {
            ra.addFlashAttribute("msgerror", "Wire type is existed!");
        }
        return "redirect:/admin/label";
    }

    //glass type
    @RequestMapping("/admin/glasstype")
    public String adminProductGlassType() {
        //Excute anything here
        return "admin/glasstype";
    }

    @PostMapping("/admin/product_glass_type/save")
    public String postsSaveGlassType(@ModelAttribute("form") GlassTypeModel model, RedirectAttributes ra) {
        //TODO validation
        GlassType entity = new GlassType();
        entity = glassTypeTransformer.modelToEntity(model);
        entity.setActive(true);
        entity.setStatus(model.getStatus());
        if (entity.getStatus() == 0) {
            entity.setStatus(1);
        }
        boolean check = glassTypeService.save(entity);
        if (check) {
            ra.addFlashAttribute("msg", "Created!");
        } else {
            ra.addFlashAttribute("msgerror", "Wire type is existed!");
        }

        return "redirect:/admin/glasstype";
    }

    //origin
    @RequestMapping("/admin/origin")
    public String adminOrigin() {
        //Excute anything here
        return "admin/origin";
    }

    @PostMapping("/admin/origin/save")
    public String postsSaveOrigin(@ModelAttribute("form") OriginModel model, RedirectAttributes ra) {
        //TODO validation
        Origin entity = new Origin();
        entity = originTransformer.modelToEntity(model);
        entity.setActive(true);
        entity.setStatus(model.getStatus());
        if (entity.getStatus() == 0) {
            entity.setStatus(1);
        }
        boolean check = originService.save(entity);
        if (check) {
            ra.addFlashAttribute("msg", "Created!");
        } else {
            ra.addFlashAttribute("msgerror", "Wire type is existed!");
        }
        return "redirect:/admin/origin";
    }

    //Admin Wire Type
    @RequestMapping("/admin/wireType")
    public String adminWireType() {
        //Excute anything here
        return "admin/wiretype";
    }

    @PostMapping("/admin/wireType/save")
    public String wireTypeSave(@ModelAttribute("form") WireTypeModel model, RedirectAttributes ra) {
        //TODO validation
        WireType entity = new WireType();
        entity = wireTransformer.modelToEntity(model);
        entity.setActive(true);
        boolean result = wireTypeService.save(entity);
        if (result) {
            ra.addFlashAttribute("msg", "Created!");
        } else {
            ra.addFlashAttribute("msgerror", "Wire type is existed!");
        }
        return "redirect:/admin/wireType";
    }

    //Admin Machine Type
    @RequestMapping("/admin/machineType")
    public String adminMachineType() {
        //Excute anything here
        return "admin/machinetype";
    }

    @PostMapping("/admin/machineType/save")
    public String machineTypeSave(@ModelAttribute("form") MachineTypeModel model, RedirectAttributes ra) {
        //TODO validation
        MachineType entity = new MachineType();
        entity = machineTypeTransformer.modelToEntity(model);
        entity.setActive(true);
        boolean result = machineTypeService.save(entity);
        if (result) {
            ra.addFlashAttribute("msg", "Created!");
        } else {
            ra.addFlashAttribute("msgerror", "Machine type is existed!");
        }
        return "redirect:/admin/machineType";
    }

    //Admin Product Orders
    @RequestMapping("/admin/order")
    public String adminProductOrder() {
        //Excute anything here
        return "admin/order";
    }

    //Admin Product Order Detail
    @RequestMapping("/admin/orderdetail")
    public String adminProductOrderDetail() {
        //Excute anything here
        return "admin/orderdetail";
    }

    //Admin User
    @RequestMapping("/admin/product")
    public String adminProduct() {
        //Excute anything here
        return "admin/product";
    }

    @GetMapping("/admin/product/create")
    public String postsCreate(Model model) {
        ProductModel productModel = new ProductModel();
        model.addAttribute("form",productModel);
        model.addAttribute("categories", categoryService.getAllProductCategorysAdmin());
        model.addAttribute("wireTypes", wireTypeService.getAllWireTypesAdmin());
        model.addAttribute("galssTypes", glassTypeService.getAllGlassTypes());
        model.addAttribute("machines", machineTypeService.getAllMachineTypesAdmin());
        model.addAttribute("labels", labelService.getAllLabels());
        model.addAttribute("orgins", originService.getAllOrigin());
        return "admin/product-form";
    }

    @GetMapping("/admin/product/edit/{id}")
    public String postsEdit(Model model, @PathVariable("id") int id, RedirectAttributes ra) {
        Product found = productService.getProductById(id);
        if (found != null) {
            ProductModel productModel = new ProductModel();
            productModel = productTransformer.entityToModel(found);
            model.addAttribute("form", productModel);
            model.addAttribute("categories", categoryService.getAllProductCategorysAdmin());
            model.addAttribute("wireTypes", wireTypeService.getAllWireTypesAdmin());
            model.addAttribute("galssTypes", glassTypeService.getAllGlassTypes());
            model.addAttribute("machines", machineTypeService.getAllMachineTypesAdmin());
            model.addAttribute("labels", labelService.getAllLabels());
            model.addAttribute("orgins", originService.getAllOrigin());
            return "admin/product-form";
        }else {
            ra.addFlashAttribute("msgerror", "Product is not Existed");
            return "redirect:/admin/product";
        }
    }

    @PostMapping("/admin/product/save")
    public String productSave(@ModelAttribute("form") ProductModel model, RedirectAttributes ra) {
        //TODO validation
        Product entity = new Product();
        entity = productTransformer.modelToEntity(model);
        entity.setActive(true);
        entity.setStockAmount(entity.getStockIn() - entity.getStockOut());
        boolean result = false;
        if (entity.getStockAmount() > 0) {
            result = productService.save(entity);
        } else {
            ra.addFlashAttribute("msgerror", "Stocck IN and Stock Out is wrong!");
        }
        if (result) {
            ra.addFlashAttribute("msg", "Created!");
        } else {
            ra.addFlashAttribute("msgerror", "Product is existed!");
        }
        return "redirect:/admin/product";
    }

    //Admin Users
    @RequestMapping("/admin/user")
    public String adminUser() {
        //Excute anything here
        return "admin/user";
    }
    @GetMapping("/admin/user/create")
    public String userCreate(Model model) {
        model.addAttribute("form",new UserModel());

        return "admin/user-form";
    }

    @GetMapping("/admin/user/edit/{id}")
    public String userEdit(Model model, @PathVariable("id") int id, RedirectAttributes ra) {
        User found = userService.getUserById(id);
        if (found != null) {
            UserModel userModel = new UserModel();
            userModel = userTransformer.entityToModel(found);
            model.addAttribute("form", userModel);
            return "admin/user-form";
        }else {
            ra.addFlashAttribute("msgerror", "Product is not Existed");
            return "redirect:/admin/user";
        }
    }
    @PostMapping("/admin/user/save")
    public String userSave(@ModelAttribute("form") UserModel model, RedirectAttributes ra) {
        //TODO validation
        User entity = new User();
        entity = userTransformer.modelToEntity(model);
        boolean result = false;
        result = userService.save(entity);
        if (result) {
            ra.addFlashAttribute("msg", "Created!");
        } else {
            ra.addFlashAttribute("msgerror", "Product is existed!");
        }
        return "redirect:/admin/user";
    }

    //Dashboard
    @RequestMapping("/admin")
    public String dashboard() {
        //Excute anything here
        return "admin/dashboard";
    }
}
