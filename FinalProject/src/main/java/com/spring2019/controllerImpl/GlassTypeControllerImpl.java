package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.GlassTypeController;
import com.spring2019.controller.GlassTypeController;
import com.spring2019.entity.GlassType;
import com.spring2019.entity.GlassType;
import com.spring2019.model.*;
import com.spring2019.repository.GlassTypeRepository;
import com.spring2019.service.GlassTypeService;
import com.spring2019.transformer.GlassTypeTransformer;
import com.spring2019.transformer.GlassTypeTransformer;
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
public class GlassTypeControllerImpl extends AbstractController implements GlassTypeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlassTypeControllerImpl.class);

    @Autowired
    GlassTypeService service;

    @Autowired
    GlassTypeRepository repository;

    @Autowired
    GlassTypeTransformer transformer;


    @Override
    public String loadAllGlassTypeActive(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiGlassTypeModel> response = new Response<MultiGlassTypeModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all GlassType active");

        try {
            MultiGlassTypeModel data = new MultiGlassTypeModel();

            List<GlassTypeModel> glassTypeModelList = new ArrayList<>();
            if (page > 0) {
                Page<GlassType> glassTypesActive = service.getAllGlassTypesActive(pageable);

                for (GlassType item : glassTypesActive) {
                    glassTypeModelList.add(transformer.entityToModel(item));
                }
                data.setCurrentPage(page);
                data.setTotalPage(glassTypesActive.getTotalPages());
                data.setTotalRecord(glassTypesActive.getTotalElements());
            }
            data.setListGlassType(glassTypeModelList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all GlassType active");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);

    }

    @Override
    public String loadAllGlassType(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiGlassTypeModel> response = new Response<MultiGlassTypeModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all GlassType deactive");

        try {
            MultiGlassTypeModel data = new MultiGlassTypeModel();

            List<GlassTypeModel> GlassTypeList = new ArrayList<>();
            if (page > 0) {
                Page<GlassType> GlassTypes = service.getAllGlassTypes(pageable);

                for (GlassType GlassType : GlassTypes) {
                    GlassTypeList.add(transformer.entityToModel(GlassType));
                }
                data.setCurrentPage(page);
                data.setTotalPage(GlassTypes.getTotalPages());
                data.setTotalRecord(GlassTypes.getTotalElements());
            }
            data.setListGlassType(GlassTypeList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all GlassType deactive");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }
}
