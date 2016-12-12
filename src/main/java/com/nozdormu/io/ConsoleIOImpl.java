package com.nozdormu.io;

import org.springframework.stereotype.Component;

import com.nozdormu.io.interfaces.ConsoleIO;

@Component
public class ConsoleIOImpl implements ConsoleIO {
    @Override
    public void write(String line) {
        System.out.println(line);
    }
}
