package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.OrderDetailController;
import com.spring2019.entity.OrderDetail;
import com.spring2019.model.*;
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
    public String loadAllOrderDetail(Integer page, Integer size, String sort, String sortBy) {
        Response response = new Response<OrderDetailModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        LOGGER.info("Start load all OrderDetail");

        try {
            List<OrderDetailModel> orderDetailModels = new ArrayList<>();
            List<OrderDetail> ordersList = service.getAllListOrderDetail();

            for (OrderDetail orders : ordersList) {
                orderDetailModels.add(transformer.entityToModel(orders));

            }

            DatatableModel result = new DatatableModel();
            result.setData(orderDetailModels);
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, orderDetailModels);
            LOGGER.info("End load all  OrderDetail");
            return gson.toJson(result);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String loadOrderDetailById(int id) {
        Response response = new Response<OrderDetailModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        LOGGER.info("Start load  OrderDetail Id");
        try {

            OrderDetail orders = service.getOrderDetailById(id);

            OrderDetailModel model = transformer.entityToModel(orders);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, model);
            LOGGER.info("End load  OrderDetail by Id");
            return gson.toJson(response);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }


    @Override
    public String updateOrderDetailById(int id) {
        String msg = "OrderDetail can not update status.";
        Response response = new Response<>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL,msg);
        LOGGER.info("Start update status  GlassType Id");
        try {

            service.updateStatus(id);
            msg = "OrderDetail status is updated.";
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
