package com.nsy.homepage.controller;

import com.nsy.homepage.service.CommonBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CommonBoardController {

    @Autowired
    CommonBoardService commonBoardService;


}
