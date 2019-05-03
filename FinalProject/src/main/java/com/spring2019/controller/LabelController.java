package com.spring2019.controller;

import com.spring2019.common.CoreConstant;
import org.springframework.web.bind.annotation.*;

public interface LabelController {
    @GetMapping(CoreConstant.API_LABEL+"/active")
    String loadAllLabelActive(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                                  @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                                  @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                                  @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);
    @GetMapping(CoreConstant.API_LABEL)
    String loadAllLabel(@RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                            @RequestParam(name = "size", required = false, defaultValue = "5") Integer size,
                            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
                            @RequestParam(name = "sortBy", required = false, defaultValue = "id") String sortBy);

    @GetMapping(CoreConstant.API_LABEL+"/{id}")
    String loadLabelById(@PathVariable("id") int id);
    @DeleteMapping(CoreConstant.API_LABEL+"/delete/{id}")
    String deleteLabelById(@PathVariable("id") int id);
    @PutMapping(CoreConstant.API_LABEL+"/updatestatus/{id}")
    String updateLabelById(@PathVariable("id") int id);
}
