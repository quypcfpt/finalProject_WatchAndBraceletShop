package com.spring2019.service;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.Label;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LabelService {
    public Page<Label> getAllLabelsActive(Pageable pageable);
    public List<Label> getAllLabels();
    void save(Label label);
    public Label getLabelById(int id);
    void delete(int id);
    void updateStatus(int id);
}
