package com.example.testingweb;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public int doubleNumber(int number) {
        return number * 2;
    }
}
