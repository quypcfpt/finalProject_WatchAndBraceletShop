package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.ProductCategoryController;
import com.spring2019.entity.ProductCategory;
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
}
