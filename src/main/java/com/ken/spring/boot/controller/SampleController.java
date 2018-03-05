package com.ken.spring.boot.controller;

import com.ken.spring.boot.service.SampleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by s on 2018/3/1.
 */

@RestController
@RequestMapping("sample")
public class SampleController {

    @Resource
    private SampleService sampleService;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String home() {
        return sampleService.shouldGetSample();
//        return  "sample application!";
    }
}
