package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.ProductController;
import com.spring2019.entity.Product;
import com.spring2019.model.MultiProductModel;
import com.spring2019.model.ProductModel;
import com.spring2019.model.Response;
import com.spring2019.service.ProductService;
import com.spring2019.transformer.ProductTransformer;
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
public class ProductControllerImpl extends AbstractController implements ProductController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductControllerImpl.class);

    @Autowired
    ProductService productService;

    @Autowired
    ProductTransformer productTransformer;


    @Override
    public String loadAllProductActive(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiProductModel> response = new Response<MultiProductModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all cameras");

        try {
            MultiProductModel data = new MultiProductModel();

            List<ProductModel> productList = new ArrayList<>();
            if (page > 0) {
                Page<Product> products = productService.getAllProductsActive(pageable);

                for (Product product : products) {
                    productList.add(productTransformer.entityToModel(product));
                }
                data.setCurrentPage(page);
                data.setTotalPage(products.getTotalPages());
                data.setTotalRecord(products.getTotalElements());
            }
            data.setListProduct(productList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all cameras");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);

    }

    @Override
    public String loadAllProduct(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiProductModel> response = new Response<MultiProductModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all cameras");

        try {
            MultiProductModel data = new MultiProductModel();

            List<ProductModel> productList = new ArrayList<>();
            if (page > 0) {
                Page<Product> products = productService.getAllProducts(pageable);

                for (Product product : products) {
                    productList.add(productTransformer.entityToModel(product));
                }
                data.setCurrentPage(page);
                data.setTotalPage(products.getTotalPages());
                data.setTotalRecord(products.getTotalElements());
            }
            data.setListProduct(productList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all cameras");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }
}
