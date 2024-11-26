package com.example.config;
import com.example.mapper.IModelMapper;
import com.example.mapper.ModelMapperWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig
{
    @Bean
    public IModelMapper modelMapper() {
        return new ModelMapperWrapper();
    }
}

