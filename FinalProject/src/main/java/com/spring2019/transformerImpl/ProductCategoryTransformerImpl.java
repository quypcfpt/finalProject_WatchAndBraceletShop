package com.spring2019.transformerImpl;

import com.spring2019.entity.ProductCategory;
import com.spring2019.model.CameraModel;
import com.spring2019.model.ProductCategoryModel;
import com.spring2019.transformer.ProductCategoryTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class ProductCategoryTransformerImpl implements ProductCategoryTransformer {


    @Override
    public ProductCategoryModel entityToModel(ProductCategory entity) {
        ProductCategoryModel model = new ProductCategoryModel();

        model.setId(entity.getId());
        model.setName(entity.getName());
        model.setDescription(entity.getDescription());
        model.setStatus(entity.getStatus());
        model.setActive(entity.isActive());
        return model;
    }

    @Override
    public ProductCategory modelToEntity(ProductCategoryModel model) {
        ProductCategory entity = new ProductCategory();

        entity.setId(model.getId());
        entity.setName(model.getName());
        entity.setDescription(model.getDescription());
        entity.setStatus(model.getStatus());
        entity.setActive(model.isActive());
        return entity;


    }
}
