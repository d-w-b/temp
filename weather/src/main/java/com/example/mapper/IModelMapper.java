package com.example.mapper;

// ModelMapper 의존성에 변경 사항이 생길 경우, com.mapper.ModelMapperWrapper 에 변경 사항을 적용 해주세요.
// 관련 설정은 com.example.config.ModelMapperConfig 에 있습니다.
public interface IModelMapper
{
    <D> D map(Object source, Class<D> destinationType);
}