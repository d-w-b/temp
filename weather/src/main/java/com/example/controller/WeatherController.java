package com.example.controller;

import com.example.service.WeatherService;
import com.example.dto.WeatherDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/weather")
@ResponseBody
public class WeatherController
{
    private final WeatherService weatherService;
    @Autowired
    WeatherController(WeatherService weatherService)
    {
        this.weatherService = weatherService;
    }

    @GetMapping("/")
    public List<WeatherDTO> getAll()
    {
        return weatherService.findAll();
    }

    @GetMapping("")
    public WeatherDTO getOne(@RequestParam("date") LocalDate date, @RequestParam("region") String region )
    {
        return weatherService.findByDateAndRegion(date, region);
    }

    @PostMapping("")
    public boolean addOne(@RequestBody WeatherDTO weatherDTO)
    {
        return weatherService.insertOne(weatherDTO);
    }

    @DeleteMapping("")
    public boolean deleteOne(@RequestParam("date") LocalDate date, @RequestParam("region") String region )
    {
        return weatherService.deleteOne(date, region);
    }

    @PutMapping("")
    public boolean updateOne(@RequestBody WeatherDTO weatherDTO)
    {
        return weatherService.updateOne(weatherDTO);
    }
}


