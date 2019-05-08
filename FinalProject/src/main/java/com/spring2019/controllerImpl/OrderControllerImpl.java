package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.OrderController;
import com.spring2019.entity.Orders;
import com.spring2019.model.*;
import com.spring2019.model.OrderModel;
import com.spring2019.repository.OrderRepository;
import com.spring2019.service.OrderService;
import com.spring2019.transformer.OrderTransformer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String loadAllOrder(Integer page, Integer size, String sort, String sortBy) {
        Response response = new Response<OrderModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        LOGGER.info("Start load all Orders");

        try {
            List<OrderModel> orderModels = new ArrayList<>();
            List<Orders> ordersList = service.getAllListOrders();

            for (Orders orders : ordersList) {
                orderModels.add(transformer.entityToModel(orders));
            }
            DatatableModel result = new DatatableModel();
            result.setData(orderModels);
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, orderModels);
            LOGGER.info("End load all  Orders");
            return gson.toJson(result);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String loadOrderById(int id) {
        Response response = new Response<OrderModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        LOGGER.info("Start load  Orders Id");
        try {

            Orders orders = service.getOrderById(id);

            OrderModel model = transformer.entityToModel(orders);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, model);
            LOGGER.info("End load  Orders by Id");
            return gson.toJson(response);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String deleteOrderById(int id) {
        String msg = "Orders can not delete.";
        Response response = new Response<>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL,msg);
        LOGGER.info("Start delete  Orders Id");
        try {

//            service.delete(id);
            msg = "Orders is deleted.";
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, msg);
            LOGGER.info("End delete  Orders by Id");
            return gson.toJson(response);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String updateOrderById(int id) {
        String msg = "Orders can not update status.";
        Response response = new Response<>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL,msg);
        LOGGER.info("Start update status  GlassType Id");
        try {

            service.updateStatus(id);
            msg = "Orders status is updated.";
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, msg);
            LOGGER.info("End update GlassType status by Id");
            return gson.toJson(response);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }
}
