package com.spring2019.serviceImpl;

import com.spring2019.entity.Origin;
import com.spring2019.repository.OriginRepository;
import com.spring2019.service.OriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OriginServiceImpl implements OriginService {

    @Autowired
    OriginRepository repository;

    @Override
    public Page<Origin> getAllOriginsActive(Pageable pageable) {
        return repository.findAllByActive(true, pageable);
    }

    @Override
    public List<Origin> getAllOrigin() {
        return repository.findAllByActive(true);
    }

    @Override
    public boolean save(Origin origin) {
        Origin found = repository.findByNameAndActiveIsTrue(origin.getName());
        if (found != null && !(found.getId().equals(origin.getId()))) {
            return false;
        }
        repository.save(origin);
        return true;
    }

    @Override
    public Origin getOriginById(int id) {
        return repository.findById(id);
    }

    @Override
    public void delete(int id) {
        Origin entity = repository.findById(id);
        if(entity != null){
            entity.setActive(false);
            repository.save(entity);
        }
    }

    @Override
    public void updateStatus(int id) {
        Origin entity = repository.findById(id);
        if(entity != null){
            if(entity.getStatus()== 1){
                entity.setStatus(2);
            }else {
                entity.setStatus(1);
            }
            repository.save(entity);
        }
    }


}
