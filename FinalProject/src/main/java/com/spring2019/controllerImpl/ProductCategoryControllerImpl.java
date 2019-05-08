package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.ProductCategoryController;
import com.spring2019.entity.ProductCategory;
import com.spring2019.model.DatatableModel;
import com.spring2019.model.ProductCategoryModel;
import com.spring2019.model.MultiProductCategoryModel;
import com.spring2019.model.Response;
import com.spring2019.repository.ProductCategoryRepository;
import com.spring2019.service.ProductCategoryService;
import com.spring2019.transformer.ProductCategoryTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class ProductCategoryControllerImpl extends AbstractController implements ProductCategoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductCategoryControllerImpl.class);

    @Autowired
    ProductCategoryService service;

    @Autowired
    ProductCategoryRepository repository;

    @Autowired
    ProductCategoryTransformer transformer;


    @Override
    public String loadAllProductCategoryActive(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiProductCategoryModel> response = new Response<MultiProductCategoryModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(sortBy).ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by(sortBy).descending();
        }

        Pageable pageable = null;
        if (page > 0) {
            pageable = PageRequest.of(page - 1, size, sortable);
        }

        LOGGER.info("Start load all ProductCategory active");

        try {
            MultiProductCategoryModel data = new MultiProductCategoryModel();

            List<ProductCategoryModel> ProductCategoryModelList = new ArrayList<>();
            if (page > 0) {
                Page<ProductCategory> ProductCategorysActive = service.getAllProductCategorysActive(pageable);

                for (ProductCategory item : ProductCategorysActive) {
                    ProductCategoryModelList.add(transformer.entityToModel(item));
                }
                data.setCurrentPage(page);
                data.setTotalPage(ProductCategorysActive.getTotalPages());
                data.setTotalRecord(ProductCategorysActive.getTotalElements());
            }
            data.setListProductCategory(ProductCategoryModelList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all ProductCategory active");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);

    }

    @Override
    public String getListProductCategoryActive() {
        Response<MultiProductCategoryModel> response = new Response<MultiProductCategoryModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        try {
            MultiProductCategoryModel data = new MultiProductCategoryModel();
            List<ProductCategoryModel> productCategoryModelList = new ArrayList<>();
                List<ProductCategory> productCategorysActive = service.getAllProductCategorysAdmin();
                for (ProductCategory item : productCategorysActive) {
                    productCategoryModelList.add(transformer.entityToModel(item));
                }
            data.setListProductCategory(productCategoryModelList);
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all ProductCategory active");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);

    }

    @Override
    public String loadAllProductCategory(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiProductCategoryModel> response = new Response<MultiProductCategoryModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        Sort sortable = null;
        if (sort.equals("ASC")) {
            sortable = Sort.by(sortBy).ascending();
        }
        if (sort.equals("DESC")) {
            sortable = Sort.by(sortBy).descending();
        }

        Pageable pageable = null;
        if (page > 0) {
            pageable = PageRequest.of(page - 1, size, sortable);
        }

        LOGGER.info("Start load all ProductCategory deactive");

        try {
            MultiProductCategoryModel data = new MultiProductCategoryModel();

            List<ProductCategoryModel> ProductCategoryList = new ArrayList<>();
            if (page > 0) {
                Page<ProductCategory> ProductCategorys = service.getAllProductCategorys(pageable);

                for (ProductCategory ProductCategory : ProductCategorys) {
                    ProductCategoryList.add(transformer.entityToModel(ProductCategory));
                }
                data.setCurrentPage(page);
                data.setTotalPage(ProductCategorys.getTotalPages());
                data.setTotalRecord(ProductCategorys.getTotalElements());
            }
            data.setListProductCategory(ProductCategoryList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all ProductCategory deactive");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String loadAllProductCategoryAdmin() {
        Response response = new Response<MultiProductCategoryModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        LOGGER.info("Start load all ProductCategory deactive");

        try {
            List<ProductCategoryModel> ProductCategoryList = new ArrayList<>();
            List<ProductCategory> ProductCategorys = service.getAllProductCategorysAdmin();

            for (ProductCategory ProductCategory : ProductCategorys) {
                ProductCategoryList.add(transformer.entityToModel(ProductCategory));
            }
            DatatableModel result = new DatatableModel();
            result.setData(ProductCategoryList);
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, ProductCategoryList);
            LOGGER.info("End load all ProductCategory deactive");
            return gson.toJson(result);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String loadProductCategoryById(int id) {
        Response response = new Response<ProductCategoryModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        LOGGER.info("Start load  ProductCategory Id");
        try {

            ProductCategory ProductCategory = service.getProductCategoryById(id);

           ProductCategoryModel model = transformer.entityToModel(ProductCategory);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, model);
            LOGGER.info("End load  ProductCategory by Id");
            return gson.toJson(response);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String deleteProductCategoryById(int id) {
        String msg = "Product category can not delete.";
        Response response = new Response<>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL,msg);
        LOGGER.info("Start delete  ProductCategory Id");
        try {

            service.delete(id);
             msg = "Product category is deleted.";
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, msg);
            LOGGER.info("End delete  ProductCategory by Id");
            return gson.toJson(response);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String updateProductCategoryById(int id) {
        String msg = "Product category can not update status.";
        Response response = new Response<>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL,msg);
        LOGGER.info("Start update status  ProductCategory Id");
        try {

            service.updateStatus(id);
            msg = "Product category status is updated.";
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, msg);
            LOGGER.info("End update ProductCategory status by Id");
            return gson.toJson(response);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }
}
