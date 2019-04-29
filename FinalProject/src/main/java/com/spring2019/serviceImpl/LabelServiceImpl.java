package com.spring2019.serviceImpl;

import com.spring2019.entity.Label;
import com.spring2019.repository.LabelRepository;
import com.spring2019.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    LabelRepository repository;
    @Override
    public Page<Label>  getAllLabelsActive(Pageable pageable) {
        return repository.findAllByActive(true, pageable);
    }

    @Override
    public Page<Label>  getAllLabels(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
