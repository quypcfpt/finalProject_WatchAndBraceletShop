package com.spring2019.transformerImpl;

import com.spring2019.entity.Product;
import com.spring2019.model.ProductModel;
import com.spring2019.transformer.ProductTransformer;
import org.springframework.stereotype.Service;

@Service
public class ProductTransformerImpl implements ProductTransformer {

    @Override
    public ProductModel entityToModel(Product entity) {
        ProductModel model = new ProductModel();

        model.setId(entity.getId());
        model.setCategoryId(entity.getCategoryId());
        model.setDescription(entity.getDescription());
        model.setName(entity.getName());
        model.setImage(entity.getImge());
        model.setGlassTypeId(entity.getGlassTypeId());
        model.setLabelId(entity.getLabelId());
        model.setMachineTypeId(entity.getMachineTypeId());
        model.setOriginId(entity.getOriginId());
        model.setPrice(entity.getPrice());
        model.setStockAmount(entity.getStockAmount());
        model.setStockIn(entity.getStockIn());
        model.setStockOut(entity.getStockOut());
        model.setProductCode(entity.getProductCode());
        model.setStatus(entity.getStatus());
        model.setWireTypeId(entity.getWireTypeId());
        return model;
    }

    @Override
    public Product modelToEntity(ProductModel model) {
        Product entity = new Product();

        entity.setId(model.getId());
        entity.setCategoryId(model.getCategoryId());
        entity.setDescription(model.getDescription());
        entity.setName(model.getName());
        entity.setImge(model.getImage());
        entity.setGlassTypeId(model.getGlassTypeId());
        entity.setLabelId(model.getLabelId());
        entity.setMachineTypeId(model.getMachineTypeId());
        entity.setOriginId(model.getOriginId());
        entity.setPrice(model.getPrice());
        entity.setStockAmount(model.getStockAmount());
        entity.setStockIn(model.getStockIn());
        entity.setStockOut(model.getStockOut());
        entity.setProductCode(model.getProductCode());
        entity.setStatus(model.getStatus());
        entity.setWireTypeId(model.getWireTypeId());
        return entity;
    }

    @Override
    public Product modelToEntity2(ProductModel model) {
        Product entity = new Product();

        return entity;
    }

}
