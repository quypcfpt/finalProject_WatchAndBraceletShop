package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.OriginController;
import com.spring2019.entity.Origin;
import com.spring2019.model.DatatableModel;
import com.spring2019.model.OriginModel;
import com.spring2019.model.MultiOriginModel;
import com.spring2019.model.Response;
import com.spring2019.repository.OriginRepository;
import com.spring2019.service.OriginService;
import com.spring2019.transformer.OriginTransformer;
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
public class OriginControllerImpl extends AbstractController implements OriginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OriginControllerImpl.class);

    @Autowired
    OriginService service;

    @Autowired
    OriginRepository repository;

    @Autowired
    OriginTransformer transformer;


    @Override
    public String loadAllOriginActive(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiOriginModel> response = new Response<MultiOriginModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all Origin active");

        try {
            MultiOriginModel data = new MultiOriginModel();

            List<OriginModel> OriginModelList = new ArrayList<>();
            if (page > 0) {
                Page<Origin> OriginsActive = service.getAllOriginsActive(pageable);

                for (Origin item : OriginsActive) {
                    OriginModelList.add(transformer.entityToModel(item));
                }
                data.setCurrentPage(page);
                data.setTotalPage(OriginsActive.getTotalPages());
                data.setTotalRecord(OriginsActive.getTotalElements());
            }
            data.setListOrigin(OriginModelList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all Origin active");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);

    }

    @Override
    public String loadAllOrigin(Integer page, Integer size, String sort, String sortBy) {
        Response response = new Response<OriginModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        LOGGER.info("Start load all Glass type");

        try {
            List<OriginModel> originModels = new ArrayList<>();
            List<Origin> origins = service.getAllOrigin();

            for (Origin type : origins) {
                originModels.add(transformer.entityToModel(type));
            }
            DatatableModel result = new DatatableModel();
            result.setData(originModels);
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, originModels);
            LOGGER.info("End load all  Glass type");
            return gson.toJson(result);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String loadOriginById(int id) {
        Response response = new Response<OriginModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        LOGGER.info("Start load  GlassType Id");
        try {

            Origin glassType = service.getOriginById(id);

            OriginModel model = transformer.entityToModel(glassType);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, model);
            LOGGER.info("End load  GlassType by Id");
            return gson.toJson(response);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String deleteOriginById(int id) {
        String msg = "Glass Type can not delete.";
        Response response = new Response<>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL,msg);
        LOGGER.info("Start delete  GlassType Id");
        try {

            service.delete(id);
            msg = "Glass Type is deleted.";
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, msg);
            LOGGER.info("End delete  GlassType by Id");
            return gson.toJson(response);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String updateOriginById(int id) {
        String msg = "Glass Type can not update status.";
        Response response = new Response<>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL,msg);
        LOGGER.info("Start update status  GlassType Id");
        try {

            service.updateStatus(id);
            msg = "Glass Type status is updated.";
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
