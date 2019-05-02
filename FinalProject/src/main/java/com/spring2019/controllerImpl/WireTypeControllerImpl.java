package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.WireTypeController;
import com.spring2019.entity.WireType;
import com.spring2019.model.WireTypeModel;
import com.spring2019.model.MultiWireTypeModel;
import com.spring2019.model.Response;
import com.spring2019.repository.WireTypeRepository;
import com.spring2019.service.WireTypeService;
import com.spring2019.transformer.WireTypeTransformer;
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
public class WireTypeControllerImpl extends AbstractController implements WireTypeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(WireTypeControllerImpl.class);

    @Autowired
    WireTypeService service;

    @Autowired
    WireTypeRepository repository;

    @Autowired
    WireTypeTransformer transformer;


    @Override
    public String loadAllWireTypeActive(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiWireTypeModel> response = new Response<MultiWireTypeModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all WireType active");

        try {
            MultiWireTypeModel data = new MultiWireTypeModel();

            List<WireTypeModel> WireTypeModelList = new ArrayList<>();
            if (page > 0) {
                Page<WireType> WireTypesActive = service.getAllWireTypesActive(pageable);

                for (WireType item : WireTypesActive) {
                    WireTypeModelList.add(transformer.entityToModel(item));
                }
                data.setCurrentPage(page);
                data.setTotalPage(WireTypesActive.getTotalPages());
                data.setTotalRecord(WireTypesActive.getTotalElements());
            }
            data.setListWireType(WireTypeModelList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all WireType active");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);

    }

    @Override
    public String loadAllWireType(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiWireTypeModel> response = new Response<MultiWireTypeModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all WireType deactive");

        try {
            MultiWireTypeModel data = new MultiWireTypeModel();

            List<WireTypeModel> WireTypeList = new ArrayList<>();
            if (page > 0) {
                Page<WireType> WireTypes = service.getAllWireTypes(pageable);

                for (WireType WireType : WireTypes) {
                    WireTypeList.add(transformer.entityToModel(WireType));
                }
                data.setCurrentPage(page);
                data.setTotalPage(WireTypes.getTotalPages());
                data.setTotalRecord(WireTypes.getTotalElements());
            }
            data.setListWireType(WireTypeList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all WireType deactive");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }
}
