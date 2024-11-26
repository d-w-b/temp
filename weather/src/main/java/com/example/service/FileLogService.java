package com.example.service;

import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class FileLogService implements ILogService
{
    @Override
    public void Read()
    {
        //TODO
    }

    @Override
    public void Write(String content)
    {
        try (FileWriter writer = new FileWriter("logs.txt", true))
        {
            writer.write(content + "\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
