package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.OrderController;
import com.spring2019.entity.Order;
import com.spring2019.entity.Order;
import com.spring2019.model.MultiOrderModel;
import com.spring2019.model.OrderModel;
import com.spring2019.model.MultiOrderModel;
import com.spring2019.model.OrderModel;
import com.spring2019.model.Response;
import com.spring2019.repository.OrderRepository;
import com.spring2019.service.OrderService;
import com.spring2019.transformer.OrderTransformer;
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
public class OrderControllerImpl extends AbstractController implements OrderController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderControllerImpl.class);

    @Autowired
    OrderService service;

    @Autowired
    OrderRepository repository;

    @Autowired
    OrderTransformer transformer;


    @Override
    public String loadAllOrderActive(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiOrderModel> response = new Response<MultiOrderModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all Order active");

        try {
            MultiOrderModel data = new MultiOrderModel();

            List<OrderModel> OrderList = new ArrayList<>();
            if (page > 0) {
                Page<Order> OrdersActive = service.getAllOrdersActive(pageable);

                for (Order item : OrdersActive) {
                    OrderList.add(transformer.entityToModel(item));
                }
                data.setCurrentPage(page);
                data.setTotalPage(OrdersActive.getTotalPages());
                data.setTotalRecord(OrdersActive.getTotalElements());
            }
            data.setListOrder(OrderList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all Order active");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);

    }

    @Override
    public String loadAllOrder(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiOrderModel> response = new Response<MultiOrderModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all Order deactive");

        try {
            MultiOrderModel data = new MultiOrderModel();

            List<OrderModel> OrderList = new ArrayList<>();
            if (page > 0) {
                Page<Order> Orders = service.getAllOrders(pageable);

                for (Order Order : Orders) {
                    OrderList.add(transformer.entityToModel(Order));
                }
                data.setCurrentPage(page);
                data.setTotalPage(Orders.getTotalPages());
                data.setTotalRecord(Orders.getTotalElements());
            }
            data.setListOrder(OrderList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all Order deactive");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }
}
