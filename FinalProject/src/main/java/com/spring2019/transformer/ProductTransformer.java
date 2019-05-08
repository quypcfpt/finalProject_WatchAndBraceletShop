package com.spring2019.transformer;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.Product;
import com.spring2019.model.GlassTypeModel;
import com.spring2019.model.ProductModel;


public interface ProductTransformer {
    public ProductModel entityToModel(Product entity);

    public Product modelToEntity(ProductModel model);


    public Product modelToEntity2(ProductModel model);
}
