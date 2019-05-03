package com.spring2019.serviceImpl;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.Label;
import com.spring2019.repository.LabelRepository;
import com.spring2019.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {

    @Autowired
    LabelRepository repository;

    @Override
    public Page<Label> getAllLabelsActive(Pageable pageable) {
        return repository.findAllByActive(true, pageable);
    }

    @Override
    public List<Label> getAllLabels() {
        return repository.findAllByActive(true);
    }

    @Override
    public void save(Label label) {
        repository.save(label);
    }

    @Override
    public Label getLabelById(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(int id) {
        Label entity = repository.findById(id);
        if (entity != null) {
            entity.setActive(false);
            repository.save(entity);
        }
    }

    @Override
    public void updateStatus(int id) {
        Label entity = repository.findById(id);
        if (entity != null) {
            if (entity.getStatus() == 1) {
                entity.setStatus(2);
            } else {
                entity.setStatus(1);
            }
            repository.save(entity);
        }
    }
}
