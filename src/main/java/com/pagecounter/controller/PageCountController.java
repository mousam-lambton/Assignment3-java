package com.pagecounter.controller;

import com.pagecounter.service.PageCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageCountController {
    private final PageCounter pageCounter;

    @Autowired
    public PageCountController(PageCounter pageCounter) {
        this.pageCounter = pageCounter;
    }

    @GetMapping("/currentcount")
    public Integer getCurrentCount() {
        return pageCounter.getPageCount();
    }
}