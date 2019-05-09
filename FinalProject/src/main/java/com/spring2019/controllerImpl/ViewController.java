package com.spring2019.controllerImpl;

import com.spring2019.controller.ProductController;
import com.spring2019.entity.*;
import com.spring2019.model.*;
import com.spring2019.service.*;
import com.spring2019.serviceImpl.ProductCategoryServiceImpl;
import com.spring2019.transformer.*;
import org.hibernate.criterion.Order;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    OrderService orderService;

    @Autowired
    OrderDetailService orderDetailService;


    @Autowired
    ProductController productController;

    @Autowired
    ProductCategoryService productCategoryService;

    @Autowired
    ProductCategoryTransformer transformer;

    @Autowired
    OrderDetailTransformer orderDetailTransformer;

    /**
     * Login Page
     *
     * @param model
     * @return
     */
    @RequestMapping(value = {"/login", "/"})
    public String toLogin(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "login";
        }
        if (user.getRoleId() == 1) {
            return "/admin";
        } else {
            return "/home";
        }

    }

    /**
     * Home Product Page
     *
     * @param model
     * @return
     */
    @RequestMapping("/home")
    public String toHome(Model model) {
        getMenu(model);
        MultiProductModel data = new MultiProductModel();
        List<ProductModel> productList = new ArrayList<>();
        List<Product> products = productService.getAllProductsActive();
        for (Product product : products) {
            productList.add(productTransformer.entityToModel(product));
        }
        data.setListProduct(productList);
        model.addAttribute("resultProduct", data);
        return "product/home";
    }

    /**
     * Home Product Page
     *
     * @param model
     * @return
     */
    @RequestMapping("/watch/{page}")
    public String toWatch(Model model, @PathVariable("page") int page) {
        getMenu(model);
        Pageable pageable = null;
        if (page > 0) {
            pageable = PageRequest.of(page - 1, 8);
        }
        try {
            MultiProductModel data = new MultiProductModel();

            List<ProductModel> productList = new ArrayList<>();
            if (page > 0) {
                Page<Product> products = productService.getAllProductsActive(pageable);

                for (Product product : products) {
                    productList.add(productTransformer.entityToModel(product));
                }
                data.setListProduct(productList);
                data.setCurrentPage(page);
                data.setTotalPage(products.getTotalPages());
                data.setTotalRecord(products.getTotalElements());
            }
            data.setListProduct(productList);

            model.addAttribute("result", data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "product/watch";
    }

    /**
     * Home Product Page
     *
     * @param id
     * @return
     */
    @RequestMapping("/productdetail")
    public String toProductDetail(Model model, @RequestParam("proid") int id) {
        getMenu(model);
        try {
            ProductDetailModel product = productService.getProductDetail(id);
            //ProductModel productModel = productTransformer.entityToModel(product);
            model.addAttribute("prodetail", product);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "product/product-detail";
    }

    /**
     * Cart Page
     *
     * @param
     * @return
     */

    //Admin Product Category
    @RequestMapping("/admin/product_category")
    public String adminProductCategory(HttpSession session) {
        //Excute anything here
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            return "admin/category";
        }
        return "/login";

    }

    @PostMapping("/admin/product_category/save")
    public String postsSave(@ModelAttribute("form") ProductCategoryModel model, RedirectAttributes ra, HttpSession session) {
        //TODO validation
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
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
        return "/error";
    }

    //Label
    @RequestMapping("/admin/label")
    public String adminProductLabel(HttpSession session) {
        //Excute anything here
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            return "admin/label";
        }
        return "/login";
    }

    @PostMapping("/admin/label/save")
    public String postsSaveLabel(@ModelAttribute("form") LabelModel model, RedirectAttributes ra, HttpSession session) {
        //TODO validation
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
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
        return "/error";
    }

    //glass type
    @RequestMapping("/admin/glasstype")
    public String adminProductGlassType(HttpSession session) {
        //Excute anything here
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            return "admin/glasstype";
        }
        return "/login";
    }

    @PostMapping("/admin/product_glass_type/save")
    public String postsSaveGlassType(@ModelAttribute("form") GlassTypeModel model, RedirectAttributes ra, HttpSession session) {
        //TODO validation
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
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
        return "/error";
    }

    //origin
    @RequestMapping("/admin/origin")
    public String adminOrigin(HttpSession session) {
        //Excute anything here
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            return "admin/origin";
        }
        return "login";
    }

    @PostMapping("/admin/origin/save")
    public String postsSaveOrigin(@ModelAttribute("form") OriginModel model, RedirectAttributes ra, HttpSession session) {
        //TODO validation
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
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
        return "/error";
    }

    //Admin Wire Type
    @RequestMapping("/admin/wireType")
    public String adminWireType(HttpSession session) {
        //Excute anything here
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            return "admin/wiretype";
        }
        return "/login";
    }

    @PostMapping("/admin/wireType/save")
    public String wireTypeSave(@ModelAttribute("form") WireTypeModel model, RedirectAttributes ra, HttpSession session) {
        //TODO validation
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
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
        return "/error";
    }

    //Admin Machine Type
    @RequestMapping("/admin/machineType")
    public String adminMachineType(HttpSession session) {
        //Excute anything here
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            return "admin/machinetype";
        }
        return "/login";
    }

    @PostMapping("/admin/machineType/save")
    public String machineTypeSave(@ModelAttribute("form") MachineTypeModel model, RedirectAttributes ra, HttpSession session) {
        //TODO validation
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
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
        return "/error";
    }

    //Admin Product Orders
    @RequestMapping("/admin/order")
    public String adminProductOrder(HttpSession session) {
        //Excute anything here
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            return "admin/order";
        }
        return "/login";
    }

    //Admin Product Order Detail
    @RequestMapping("/admin/orderdetail")
    public String adminProductOrderDetail(HttpSession session) {
        //Excute anything here
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            return "admin/orderdetail";
        }
        return "/login";
    }

    //Admin User
    @RequestMapping("/admin/product")
    public String adminProduct(HttpSession session) {
        //Excute anything here
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            return "admin/product";
        }
        return "/login";
    }

    @GetMapping("/admin/product/create")
    public String postsCreate(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            ProductModel productModel = new ProductModel();
            model.addAttribute("form", productModel);
            model.addAttribute("categories", categoryService.getAllProductCategorysAdmin());
            model.addAttribute("wireTypes", wireTypeService.getAllWireTypesAdmin());
            model.addAttribute("galssTypes", glassTypeService.getAllGlassTypes());
            model.addAttribute("machines", machineTypeService.getAllMachineTypesAdmin());
            model.addAttribute("labels", labelService.getAllLabels());
            model.addAttribute("orgins", originService.getAllOrigin());
            return "admin/product-form";
        }
        return "/error";
    }

    @GetMapping("/admin/product/edit/{id}")
    public String postsEdit(Model model, @PathVariable("id") int id, RedirectAttributes ra, HttpSession session) {
        Product found = productService.getProductById(id);
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
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
            } else {
                ra.addFlashAttribute("msgerror", "Product is not Existed");
            }
            return "redirect:/admin/product";
        }
        return "/error";
    }

    @PostMapping("/admin/product/save")
    public String productSave(@ModelAttribute("form") ProductModel model, RedirectAttributes ra, HttpSession session) {
        //TODO validation
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
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
                ra.addFlashAttribute("msg", "Sucess!");
            } else {
                ra.addFlashAttribute("msgerror", "Product Code is existed!");
            }
            return "redirect:/admin/product";
        }
        return "/error";
    }

    //Admin Users
    @RequestMapping("/admin/user")
    public String adminUser(HttpSession session) {
        //Excute anything here
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            return "admin/user";
        }
        return "/login";
    }

    @GetMapping("/admin/user/create")
    public String userCreate(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            model.addAttribute("form", new UserModel());
            model.addAttribute("title", "Create User");
            return "admin/user-form";
        }
        return "/login";
    }

    @GetMapping("/admin/user/edit/{id}")
    public String userEdit(Model model, @PathVariable("id") int id, RedirectAttributes ra, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            User found = userService.getUserById(id);
            if (found != null) {
                UserModel userModel = new UserModel();
                userModel = userTransformer.entityToModel(found);
                model.addAttribute("form", userModel);
                return "admin/user-form";
            } else {
                ra.addFlashAttribute("msgerror", "Product is not Existed");
            }
            return "redirect:/admin/user";
        }
        return "/error";
    }

    @PostMapping("/admin/user/save")
    public String userSave(@ModelAttribute("form") UserModel model, RedirectAttributes ra, HttpSession session) {
        //TODO validation
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            User entity = new User();
            entity = userTransformer.modelToEntity(model);
            boolean result = false;
            result = userService.save(entity);
            if (result) {
                ra.addFlashAttribute("msg", "Created!");
            } else {
                ra.addFlashAttribute("msgerror", "User is existed!");
            }
            return "redirect:/admin/user";
        }
        return "/error";
    }


    // Login
    @PostMapping("/user/login")
    public String userLogin(@ModelAttribute("form") UserModel user, RedirectAttributes ra, HttpSession session) {
        User entity = new User();
        entity = userTransformer.modelToEntity(user);
        User admin = userService.getAccountByUsernameAndIsAdmin(entity.getUsername(), entity.getPassword());
        User userRole = userService.getAccountByUsernameAndIsUse(entity.getUsername(), entity.getPassword());
        if (admin != null) {
            session.setAttribute("user", admin);
            return "redirect:/admin";
        } else if (userRole != null) {
            session.setAttribute("user", userRole);
            return "redirect:/home";
        } else {
            ra.addFlashAttribute("error", "UserName and password is invalid");
        }
        session.setMaxInactiveInterval(300 * 1000);

        return "redirect:/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        //Excute anything here
        User user = (User) session.getAttribute("user");
        if (user != null)
            session.removeAttribute("user");
        System.out.println(user);
        return "redirect:/login";
    }

    //Dashboard
    @RequestMapping("/admin")
    public String dashboard(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            //Excute anything here
            model.addAttribute("title", "Dashboard");
            //Users
            List<User> users = userService.getAllByStatus(1);
            List<User> customers = userService.getAllByStatusAndRole(2, 1);
            model.addAttribute("totalUsers", users.size());
            model.addAttribute("totalcustomers", customers.size());
            model.addAttribute("totaladmin", users.size() - customers.size());
            //Products
            List<Product> products = productService.getAllProductList();
            List<Product> activeProducts = productService.getAllProductListByStatus(1);
            model.addAttribute("totalProducts", products.size());
            model.addAttribute("totalActivePro", activeProducts.size());
            model.addAttribute("totalDeactivePro", products.size() - activeProducts.size());
            //Orders
            List<Orders> orders = orderService.getAllListOrders();
            List<Orders> deliveringOrdersList = orderService.getAllListOrdersByStatus(2);
            List<Orders> paidOrdersList = orderService.getAllListOrdersByStatus(3);
            List<Orders> pendingOrdersList = orderService.getAllListOrdersByStatus(1);
            model.addAttribute("totalorders", orders.size());
            model.addAttribute("totalpending", pendingOrdersList.size());
            model.addAttribute("totalpaid", paidOrdersList.size());
            model.addAttribute("totaldelivery", deliveringOrdersList.size());
            model.addAttribute("totalcancel", orders.size() - pendingOrdersList.size() - paidOrdersList.size() - deliveringOrdersList.size());
            //Category
            model.addAttribute("totalcategories", categoryService.getAllProductCategorysAdmin().size());
            //Wire Type
            model.addAttribute("totalwiretypes", wireTypeService.getAllWireTypesAdmin().size());
            //Glass type
            model.addAttribute("totalglasstype", glassTypeService.getAllGlassTypes().size());
            //Label
            model.addAttribute("totallabels", labelService.getAllLabels().size());
            //Orgin
            model.addAttribute("totalorgin", originService.getAllOrigin().size());
            //Machine
            model.addAttribute("machine", machineTypeService.getAllMachineTypesAdmin().size());
            return "admin/dashboard";
        }
        return "/login";
    }

    private void getMenu(Model model) {
        MultiProductCategoryModel data = new MultiProductCategoryModel();
        List<ProductCategoryModel> productCategoryList = new ArrayList<>();
        List<ProductCategory> productCategories = productCategoryService.getAllProductCategorysAdmin();
        for (ProductCategory ProductCategory : productCategories) {
            productCategoryList.add(transformer.entityToModel(ProductCategory));
        }
        data.setListProductCategory(productCategoryList);
        model.addAttribute("listCates", data);

        //get label
        MultiLabelModel dataLabel = new MultiLabelModel();
        List<LabelModel> labelModelList = new ArrayList<>();
        List<Label> labelsActive = labelService.getAllLabels();
        for (Label item : labelsActive) {
            labelModelList.add(labelTransformer.entityToModel(item));
        }
        dataLabel.setListLabel(labelModelList);
        model.addAttribute("labels", dataLabel);
    }

    //Daily Report
    @GetMapping("/admin/report")
    public String report(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null)
            return "/login";
        if (user.getRoleId() == 1) {
            model.addAttribute("title", "Report");
            try {
                Date start = new Date();
                Date end = new Date();

                Date startDate = atStartOfDay(start);
                Date endDate = atEndOfDay(end);

                //Sold Product
                int soldProduct = orderDetailService.totalSoldProduct(startDate, endDate);
                model.addAttribute("soldProduct", soldProduct);

                //Sold Product
                int totalPrice = orderDetailService.totaltotalPrice(startDate, endDate);
                model.addAttribute("totalprice", soldProduct);

                //Orders
                int orders = orderService.totaltotalOrder(startDate, endDate);
                int deliveringOrdersList = orderService.totaltotalOrderByStatus(startDate, endDate, 2);
                int paidOrdersList = orderService.totaltotalOrderByStatus(startDate, endDate, 3);
                int pendingOrdersList = orderService.totaltotalOrderByStatus(startDate, endDate, 1);
                model.addAttribute("totalorders", orders);
                model.addAttribute("totalpending", pendingOrdersList);
                model.addAttribute("totalpaid", paidOrdersList);
                model.addAttribute("totaldelivery", deliveringOrdersList);
                model.addAttribute("totalcancel", orders - pendingOrdersList - paidOrdersList - deliveringOrdersList);
                List orderChart = new ArrayList();
                orderChart.add(new Object[]{"Pending", pendingOrdersList});
                orderChart.add(new Object[]{"On Delivery", deliveringOrdersList});
                orderChart.add(new Object[]{"Paid", paidOrdersList});
                orderChart.add(new Object[]{"Cancel", orders - pendingOrdersList - paidOrdersList - deliveringOrdersList});
                model.addAttribute("chart", orderChart);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return "admin/dailyreport";
        }
        return "/login";
    }

    // Register
    @RequestMapping("/register")
    public String registerPage(HttpSession session) {
        //Excute anything here
        return "/register";
    }

    @PostMapping("/user/register")
    public String userRegister(@ModelAttribute("form") UserModel user, RedirectAttributes ra) {
        User entity = new User();
        entity = userTransformer.modelToEntity(user);
        boolean result = userService.save(entity);
        if (result) {
            return "redirect:/login";
        } else {
            ra.addFlashAttribute("error", "UserName is Exist please change your username");
        }
        return "redirect:/register";
    }

    // ChangePassword
    @RequestMapping("/changepassword")
    public String changePassPage(Model model, HttpSession session) {
        //Excute anything here
        User user = (User) session.getAttribute("user");
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "/changepassword";
    }

    @PostMapping("/user/changepassword")
    public String userChangePassword(@ModelAttribute("form") UserModel user, RedirectAttributes ra, HttpSession session) {
        User entity = new User();
        User userSession = (User) session.getAttribute("user");
        user.setUsername(userSession.getUsername());
        entity = userTransformer.modelToEntity(user);
        if (user.getOldPassword().equals(userSession.getPassword())) {
            if (!user.getPassword().equals(userSession.getPassword())) {
                boolean result = userService.changePassword(entity);
                if (result) {
                    return "redirect:/admin";
                } else {
                    ra.addFlashAttribute("error", "UserName is Exist please change your username");
                }
            } else {
                ra.addFlashAttribute("error", "New Password  is the same as the old one");
            }
        } else {
            ra.addFlashAttribute("error", "Old Password  is not matched as current password");
        }
        return "redirect:/changepassword";
    }


    public static Date atStartOfDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        LocalDateTime startOfDay = localDateTime.with(LocalTime.MIN);
        return localDateTimeToDate(startOfDay);
    }

    public static Date atEndOfDay(Date date) {
        LocalDateTime localDateTime = dateToLocalDateTime(date);
        LocalDateTime endOfDay = localDateTime.with(LocalTime.MAX);
        return localDateTimeToDate(endOfDay);
    }

    private static LocalDateTime dateToLocalDateTime(Date date) {
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    private static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    @RequestMapping("/cart")
    public String toCart(Model model) {
        //Excute anything here
        getMenu(model);
        return "product/cart";
    }

    public String saveCart(List<OrderDetail> list, CartModel cart) {
        String msg = "";
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        Orders order = new Orders();
        order.setCode(UUID.randomUUID().toString());
        order.setCustomerName(cart.getName());
        order.setAddress(cart.getAddress());
        order.setStatus(1);
        order.setEmail(cart.getEmail());
        order.setPhone(cart.getPhone());
        order.setCreateDateTime(dateFormat.format(date));
        order.setNote(cart.getNote());
        Orders orders = orderService.save(order);
        if (orders != null) {
            for (OrderDetail detail : list) {
                detail.setOrderById(orders);
                orderDetailService.save(detail);
                Product updatePro = productService.getProductById(detail.getProductById().getId());
                updatePro.setStockOut(updatePro.getStockOut() + detail.getQuantity());
                updatePro.setStockAmount(updatePro.getStockIn() - updatePro.getStockOut());
                if (updatePro.getStockAmount() < 0) {
                    msg = "Sorry your order cannot complete because the good is out of stock";
                } else {
                    msg = "Your Order is Success . Please wait for 48h to delivery";
                    productService.save(updatePro);
                }
            }
        } else {
            msg = "Can not  create order . Please try again";
        }
        return msg;
    }

    public List<OrderDetail> parseJsonIntoList(String jsonObject) throws JSONException {
        List<OrderDetail> resultList = new ArrayList<>();
        JSONArray contacts = new JSONArray(jsonObject);
        for (int i = 0; i < contacts.length(); i++) {
            JSONObject cam = contacts.getJSONObject(i);
            int productId = cam.getInt("productId");
            int quantity = cam.getInt("quantity");
            String proName = cam.getString("productName");
            Product proResult = new Product();
            proResult.setId(productId);
            proResult.setName(proName.trim());
            float price = Float.parseFloat(cam.getString("price"));
            OrderDetail detail = new OrderDetail(proResult, price, quantity);
            resultList.add(detail);
        }
        return resultList;
    }

    @PostMapping("/cart/save")
    public String toCart(@ModelAttribute("form") CartModel model, RedirectAttributes ra , Model modeView) {
        //Excute anything here
        getMenu(modeView);
        String cartString = model.getCartString();
        List<OrderDetail> listresult = parseJsonIntoList(cartString);
        String msg = saveCart(listresult, model);
        ra.addFlashAttribute("msg", msg);
        modeView.addAttribute("customer",model);
        modeView.addAttribute("detail",listresult);
      
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:templates/orderconfirm.html");
            String content = new String(Files.readAllBytes(file.toPath()));
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
   return "product/orderresult";
    }

}
