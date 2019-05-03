package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.LabelController;
import com.spring2019.entity.Label;
import com.spring2019.model.DatatableModel;
import com.spring2019.model.LabelModel;
import com.spring2019.model.MultiLabelModel;
import com.spring2019.model.Response;
import com.spring2019.repository.LabelRepository;
import com.spring2019.service.LabelService;
import com.spring2019.transformer.LabelTransformer;
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
public class LabelControllerImpl extends AbstractController implements LabelController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LabelControllerImpl.class);

    @Autowired
    LabelService service;

    @Autowired
    LabelRepository repository;

    @Autowired
    LabelTransformer transformer;


    @Override
    public String loadAllLabelActive(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiLabelModel> response = new Response<MultiLabelModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all Label active");

        try {
            MultiLabelModel data = new MultiLabelModel();

            List<LabelModel> LabelModelList = new ArrayList<>();
            if (page > 0) {
                Page<Label> LabelsActive = service.getAllLabelsActive(pageable);

                for (Label item : LabelsActive) {
                    LabelModelList.add(transformer.entityToModel(item));
                }
                data.setCurrentPage(page);
                data.setTotalPage(LabelsActive.getTotalPages());
                data.setTotalRecord(LabelsActive.getTotalElements());
            }
            data.setListLabel(LabelModelList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all Label active");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);

    }

    @Override
    public String loadAllLabel(Integer page, Integer size, String sort, String sortBy) {
        LOGGER.info("Start load all Label");
        Response<LabelModel> response = new Response<>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);

        try {
            List<LabelModel> labelModels = new ArrayList<>();
            List<Label> labels = service.getAllLabels();

            for (Label type : labels) {
                labelModels.add(transformer.entityToModel(type));
            }
            DatatableModel result = new DatatableModel();
            result.setData(labelModels);
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, labelModels.get(0));
            LOGGER.info("End load all  Label");
            return gson.toJson(result);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String loadLabelById(int id) {
        Response response = new Response<LabelModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        LOGGER.info("Start load  Label Id");
        try {

            Label Label = service.getLabelById(id);

            LabelModel model = transformer.entityToModel(Label);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, model);
            LOGGER.info("End load  Label by Id");
            return gson.toJson(response);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String deleteLabelById(int id) {
        String msg = "Label can not delete.";
        Response response = new Response<>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL,msg);
        LOGGER.info("Start delete  Label Id");
        try {

            service.delete(id);
            msg = "Label is deleted.";
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, msg);
            LOGGER.info("End delete  Label by Id");
            return gson.toJson(response);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String updateLabelById(int id) {
        String msg = "Label can not update status.";
        Response response = new Response<>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL,msg);
        LOGGER.info("Start update status  Label Id");
        try {

            service.updateStatus(id);
            msg = "Label status is updated.";
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, msg);
            LOGGER.info("End update Label status by Id");
            return gson.toJson(response);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }
}
