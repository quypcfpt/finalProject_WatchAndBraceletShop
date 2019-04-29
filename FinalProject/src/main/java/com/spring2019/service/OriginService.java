package com.spring2019.service;

import com.spring2019.entity.Origin;
import com.spring2019.entity.Origin;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OriginService {
    public Page<Origin> getAllOriginsActive(Pageable pageable);
    public Page<Origin>  getAllOrigins(Pageable pageable);
}
