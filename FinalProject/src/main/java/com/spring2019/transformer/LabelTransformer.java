package com.spring2019.transformer;

import com.spring2019.entity.GlassType;
import com.spring2019.entity.Label;
import com.spring2019.model.GlassTypeModel;
import com.spring2019.model.LabelModel;


public interface LabelTransformer {
    public LabelModel entityToModel(Label entity);

    public Label modelToEntity(LabelModel model);
}
