package com.spring2019.service;

import com.spring2019.entity.Origin;
import com.spring2019.entity.Origin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OriginService {
    public Page<Origin> getAllOriginsActive(Pageable pageable);
    public List<Origin> getAllOrigin();
    void save(Origin origin);
    public Origin getOriginById(int id);
    void delete(int id);
    void updateStatus(int id);
}
