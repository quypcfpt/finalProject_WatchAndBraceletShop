package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.MachineTypeController;
import com.spring2019.entity.MachineType;
import com.spring2019.model.DatatableModel;
import com.spring2019.model.MachineTypeModel;
import com.spring2019.model.MultiMachineTypeModel;
import com.spring2019.model.Response;
import com.spring2019.repository.MachineTypeRepository;
import com.spring2019.service.MachineTypeService;
import com.spring2019.transformer.MachineTypeTransformer;
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
public class MachineTypeControllerImpl extends AbstractController implements MachineTypeController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MachineTypeControllerImpl.class);

    @Autowired
    MachineTypeService service;

    @Autowired
    MachineTypeRepository repository;

    @Autowired
    MachineTypeTransformer transformer;


    @Override
    public String loadAllMachineTypeActive(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiMachineTypeModel> response = new Response<MultiMachineTypeModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all MachineType active");

        try {
            MultiMachineTypeModel data = new MultiMachineTypeModel();

            List<MachineTypeModel> MachineTypeModelList = new ArrayList<>();
            if (page > 0) {
                Page<MachineType> MachineTypesActive = service.getAllMachineTypesActive(pageable);

                for (MachineType item : MachineTypesActive) {
                    MachineTypeModelList.add(transformer.entityToModel(item));
                }
                data.setCurrentPage(page);
                data.setTotalPage(MachineTypesActive.getTotalPages());
                data.setTotalRecord(MachineTypesActive.getTotalElements());
            }
            data.setListMachineType(MachineTypeModelList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all MachineType active");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);

    }

    @Override
    public String loadAllMachineType(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiMachineTypeModel> response = new Response<MultiMachineTypeModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all MachineType deactive");

        try {
            MultiMachineTypeModel data = new MultiMachineTypeModel();

            List<MachineTypeModel> MachineTypeList = new ArrayList<>();
            if (page > 0) {
                Page<MachineType> MachineTypes = service.getAllMachineTypes(pageable);

                for (MachineType MachineType : MachineTypes) {
                    MachineTypeList.add(transformer.entityToModel(MachineType));
                }
                data.setCurrentPage(page);
                data.setTotalPage(MachineTypes.getTotalPages());
                data.setTotalRecord(MachineTypes.getTotalElements());
            }
            data.setListMachineType(MachineTypeList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all MachineType deactive");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String loadAllMachineTypesAdmin() {
        Response response = new Response<>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        LOGGER.info("Start load all Machine Type Active");

        try {
            List<MachineTypeModel> machineTypeModels = new ArrayList<>();
            List<MachineType> machineTypes = service.getAllMachineTypesAdmin();

            for (MachineType machineType : machineTypes) {
                machineTypeModels.add(transformer.entityToModel(machineType));
            }
            DatatableModel result = new DatatableModel();
            result.setData(machineTypeModels);
            LOGGER.info("End load all Machine Type Active");
            return gson.toJson(result);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String loadMachineTypeById(int id) {
        Response response = new Response<MachineTypeModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
        LOGGER.info("Start load  machineType Id");
        try {

            MachineType machineType = service.getMachineTypeById(id);

            MachineTypeModel model = transformer.entityToModel(machineType);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, model);
            LOGGER.info("End load  machineType by Id");
            return gson.toJson(response);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }

    @Override
    public String deleteMachineTypeById(int id) {
        String msg = "Machine Type can not delete.";
        Response response = new Response<>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL,msg);
        LOGGER.info("Start delete  Machine Type by Id");
        try {

            service.delete(id);
            msg = "Machine Type is deleted.";
            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, msg);
            LOGGER.info("End delete  Machine Type by Id");
            return gson.toJson(response);
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }
}
