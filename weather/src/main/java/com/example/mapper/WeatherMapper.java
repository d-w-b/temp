package com.example.mapper;

import com.example.model.Weather;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;


// MyBatis 활용하기 위해 메서드와 SQL 쿼리를 연결해주는 클래스입니다.

@Mapper
public interface WeatherMapper
{
    List<Weather> findAll();
    Weather findByDateAndRegion(@Param("date") LocalDate date, @Param("region") String region);
    boolean insertWeather(Weather weatherEntity);
    boolean updateWeather(Weather weatherEntity);
    boolean deleteWeather(@Param("date") LocalDate date, @Param("region") String region);
}
