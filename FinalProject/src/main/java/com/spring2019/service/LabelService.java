package com.spring2019.service;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.Label;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LabelService {
    public Page<Label> getAllLabelsActive(Pageable pageable);
    public Page<Label>  getAllLabels(Pageable pageable);
}
