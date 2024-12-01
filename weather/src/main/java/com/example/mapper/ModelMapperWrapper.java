package com.example.mapper;

import org.modelmapper.ModelMapper;

public class ModelMapperWrapper implements IModelMapper
{
    private final ModelMapper modelMapper;

    public ModelMapperWrapper()
    {
        this.modelMapper = new ModelMapper();
    }

    @Override
    public <D> D map(Object source, Class<D> destinationType)
    {
        return modelMapper.map(source, destinationType);
    }
}

