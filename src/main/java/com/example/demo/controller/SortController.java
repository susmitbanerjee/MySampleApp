package com.example.demo.controller;

import com.example.demo.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SortController {
    @Autowired
    @Qualifier("quickSort")
    SortService sortService;

    @GetMapping(value = "/sampleSort")
    public int[] sortedArray(@RequestParam("array")int[] arr){
        sortService.sortArray(arr);
        return arr;
    }

}
