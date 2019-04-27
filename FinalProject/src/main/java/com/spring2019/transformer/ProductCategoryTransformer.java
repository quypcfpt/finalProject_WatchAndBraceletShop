package com.spring2019.transformer;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.ProductCategory;
import com.spring2019.model.GlassTypeModel;
import com.spring2019.model.ProductCategoryModel;


public interface ProductCategoryTransformer {
    public ProductCategoryModel entityToModel(ProductCategory entity);

    public ProductCategory modelToEntity(ProductCategoryModel model);
}
