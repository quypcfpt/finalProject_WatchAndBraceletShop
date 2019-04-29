package com.spring2019.controllerImpl;

import com.spring2019.common.CoreConstant;
import com.spring2019.controller.RoleController;
import com.spring2019.entity.Role;
import com.spring2019.model.RoleModel;
import com.spring2019.model.MultiRoleModel;
import com.spring2019.model.Response;
import com.spring2019.repository.RoleRepository;
import com.spring2019.service.RoleService;
import com.spring2019.transformer.RoleTransformer;
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
public class RoleControllerImpl extends AbstractController implements RoleController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoleControllerImpl.class);

    @Autowired
    RoleService service;

    @Autowired
    RoleRepository repository;

    @Autowired
    RoleTransformer transformer;


    @Override
    public String loadAllRoleActive(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiRoleModel> response = new Response<MultiRoleModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all Role active");

        try {
            MultiRoleModel data = new MultiRoleModel();

            List<RoleModel> RoleModelList = new ArrayList<>();
            if (page > 0) {
                Page<Role> RolesActive = service.getAllRolesActive(pageable);

                for (Role item : RolesActive) {
                    RoleModelList.add(transformer.entityToModel(item));
                }
                data.setCurrentPage(page);
                data.setTotalPage(RolesActive.getTotalPages());
                data.setTotalRecord(RolesActive.getTotalElements());
            }
            data.setListRole(RoleModelList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all Role active");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);

    }

    @Override
    public String loadAllRole(Integer page, Integer size, String sort, String sortBy) {
        Response<MultiRoleModel> response = new Response<MultiRoleModel>(CoreConstant.STATUS_CODE_FAIL, CoreConstant.MESSAGE_FAIL);
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

        LOGGER.info("Start load all Role deactive");

        try {
            MultiRoleModel data = new MultiRoleModel();

            List<RoleModel> RoleList = new ArrayList<>();
            if (page > 0) {
                Page<Role> Roles = service.getAllRoles(pageable);

                for (Role Role : Roles) {
                    RoleList.add(transformer.entityToModel(Role));
                }
                data.setCurrentPage(page);
                data.setTotalPage(Roles.getTotalPages());
                data.setTotalRecord(Roles.getTotalElements());
            }
            data.setListRole(RoleList);

            response.setResponse(CoreConstant.STATUS_CODE_SUCCESS, CoreConstant.MESSAGE_SUCCESS, data);
            LOGGER.info("End load all Role deactive");
        } catch (Exception e) {
            response.setResponse(CoreConstant.STATUS_CODE_SERVER_ERROR, CoreConstant.MESSAGE_SERVER_ERROR);
            LOGGER.error(e.getMessage());
        }
        return gson.toJson(response);
    }
}
