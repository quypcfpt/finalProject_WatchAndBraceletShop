package com.spring2019.serviceImpl;

import com.spring2019.entity.*;
import com.spring2019.model.ProductDetailModel;
import com.spring2019.repository.*;
import com.spring2019.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Autowired
    WireTypeRepository wireTypeRepository;

    @Autowired
    GlassTypeRepository glassTypeRepository;

    @Autowired
    MachineTypeRepository machineTypeRepository;

    @Autowired
    LabelRepository labelRepository;

    @Autowired
    OriginRepository originRepository;

    @Override
    public Page<Product>  getAllProductsActive(Pageable pageable) {
        return repository.findAllByActive(true, pageable);
    }

    @Override
    public Page<Product>  getAllProducts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<Product> getAllProductList() {
        return repository.findAllByActive(true);
    }

    @Override
    public List<Product> getAllProductListByStatus(int status) {
        return repository.findAllByStatusAndActiveTrue(status);
    }

    @Override
    public boolean save(Product product) {
        if(product.getId() == null){
            Product found = repository.findByProductCodeAndActiveIsTrue(product.getProductCode());
            if (found != null ) {
                return false;
            }
        }else {
            Product found = repository.findByProductCodeAndActiveIsTrue(product.getProductCode());
            if (found != null && !(found.getId().equals(product.getId()))) {
                return false;
            }
        }

        repository.save(product);
        return true;
    }

    @Override
    public Product getProductById(int id) {
        return repository.findByIdAndActiveIsTrue(id);
    }

    @Override
    public void delete(int id) {
        Product entity = repository.findByIdAndActiveIsTrue(id);
        if (entity != null) {
            entity.setActive(false);
            repository.save(entity);
        }
    }

    @Override
    public void updateStatus(int id) {
        Product entity = repository.findByIdAndActiveIsTrue(id);
        if (entity != null) {
            if (entity.getStatus() == 0) {
                entity.setStatus(1);
            } else {
                entity.setStatus(0);
            }
            repository.save(entity);
        }
    }

    @Override
    public List<Product> getAllProductActiveByCategoryId(int categoryId) {
        return repository.findAllByActiveAndCategoryId(true, categoryId);
    }

    @Override
    public List<Product> getAllProductsActive() {
        return repository.findAllByActive(true);
    }

    @Override
    public ProductDetailModel getProductDetail(int id) {
        ProductDetailModel productDetailModel = new ProductDetailModel();
        Optional<Product> product = repository.findById(id);
        product.ifPresent(p -> {
            WireType wireType = wireTypeRepository.findById(p.getWireTypeId());
            GlassType glassType = glassTypeRepository.findById(p.getGlassTypeId());
            MachineType machineType = machineTypeRepository.findById(p.getMachineTypeId());
            Label label = labelRepository.findById(p.getLabelId());
            Origin origin = originRepository.findById(p.getOriginId());

            productDetailModel.setId(p.getId());
            productDetailModel.setName(p.getName());
            productDetailModel.setPrice(p.getPrice());
            productDetailModel.setDescription(p.getDescription());
            productDetailModel.setImage(p.getImge());
            productDetailModel.setWireType(wireType.getName());
            productDetailModel.setGlassType(glassType.getName());
            productDetailModel.setMachineType(machineType.getName());
            productDetailModel.setLabel(label.getName());
            productDetailModel.setOrigin(origin.getName());
            productDetailModel.setStatus(p.getStatus());
            productDetailModel.setProductCode(p.getProductCode());
            productDetailModel.setActive(p.isActive());
        });

        return productDetailModel;
    }

    @Override
    public Product findByName(String name) {
        return repository.findByNameAndActiveIsTrue(name);
    }
}
