package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.OrderDetailController;
import com.spring2019.entity.OrderDetail;
import com.spring2019.model.OrderDetailModel;
import com.spring2019.model.MultiOrderDetailModel;
import com.spring2019.model.Response;
import com.spring2019.repository.OrderDetailRepository;
import com.spring2019.service.OrderDetailService;
import com.spring2019.transformer.OrderDetailTransformer;
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
public class OrderDetailControllerImpl extends AbstractController implements OrderDetailController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderDetailControllerImpl.class);

    @Autowired
    OrderDetailService service;

    @Autowired
    OrderDetailRepository repository;

    @Autowired
    OrderDetailTransformer transformer;


    @Override
    public String loadAllOrderDetailActive(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiOrderDetailModel> response = new Response<MultiOrderDetailModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all OrderDetail active");

        try {
            MultiOrderDetailModel data = new MultiOrderDetailModel();

            List<OrderDetailModel> OrderDetailModelList = new ArrayList<>();
            if (page > 0) {
                Page<OrderDetail> OrderDetailsActive = service.getAllOrderDetailsActive(pageable);

                for (OrderDetail item : OrderDetailsActive) {
                    OrderDetailModelList.add(transformer.entityToModel(item));
                }
                data.setCurrentPage(page);
                data.setTotalPage(OrderDetailsActive.getTotalPages());
                data.setTotalRecord(OrderDetailsActive.getTotalElements());
            }
            data.setListOrderDetail(OrderDetailModelList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all OrderDetail active");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);

    }

    @Override
    public String loadAllOrderDetail(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiOrderDetailModel> response = new Response<MultiOrderDetailModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all OrderDetail deactive");

        try {
            MultiOrderDetailModel data = new MultiOrderDetailModel();

            List<OrderDetailModel> OrderDetailList = new ArrayList<>();
            if (page > 0) {
                Page<OrderDetail> OrderDetails = service.getAllOrderDetails(pageable);

                for (OrderDetail OrderDetail : OrderDetails) {
                    OrderDetailList.add(transformer.entityToModel(OrderDetail));
                }
                data.setCurrentPage(page);
                data.setTotalPage(OrderDetails.getTotalPages());
                data.setTotalRecord(OrderDetails.getTotalElements());
            }
            data.setListOrderDetail(OrderDetailList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all OrderDetail deactive");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }
}
