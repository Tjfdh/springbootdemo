package org.spring.springboot.controller;

import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Controller
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/api/city/{id}", method = RequestMethod.GET)
    public String findOneCity(Model model, @PathVariable("id") Long id) {
        model.addAttribute("city", cityService.findCityById(id));
        return "city";
    }

    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public String findAllCity(Model model) {
        List<City> cityList = cityService.findAllCity();
        model.addAttribute("cityList",cityList);
        return "cityList";
    }
    @RequestMapping(value = "/api/mapgps")
    public String mapgps(Model model){

        return "mapgps";
    }
    @RequestMapping(value = "/api/signday")
    public String signday(Model model){

        return "signDay";
    }




    @RequestMapping(value="/api/photo")
    public String photo(Model model) {
        return "photo";
    }
    @RequestMapping(value="/api/jiexi")
    public String jiexi(Model model) {
        return "update";
    }
    @RequestMapping(value = "api/crowl")
    public void crowl() throws IOException {
        String url="http://sou.zhaopin.com/jobs/searchresult.ashx?jl=%E6%9D%AD%E5%B7%9E&sm=0&sg=9aeb5b8c59ee4e06bac0342e5369ffbb&p=3";
        URL urlObj = null;
        try {
            urlObj = new URL(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        HttpURLConnection urlConnection= null;
        try {
            urlConnection =(HttpURLConnection) urlObj.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        urlConnection.setConnectTimeout(60 * 1000);
//					urlConnection.setReadTimeout(60 * 1000);
        try {
            urlConnection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取服务器响应代码
        int responsecode = 0;
        try {
            responsecode = urlConnection.getResponseCode();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(responsecode==200){
            // 得到输入流，即获得了网页的内容
            String str =null;
           BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "utf8"));
            while (( str=reader.readLine()) != null) {
                System.out.println(str);
            }
            reader.close();
        }
    }

}
