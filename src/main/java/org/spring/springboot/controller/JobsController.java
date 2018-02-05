package org.spring.springboot.controller;

import org.spring.springboot.domain.Job;
import org.spring.springboot.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by haodong on 2018/2/2.
 */
@Controller
public class JobsController {
    @Autowired
    private JobsService jobsService;
    /**
     * 获取职位
     * @return
     */
    @RequestMapping(value="/api/jobs/{countNum}", method = RequestMethod.GET)
    @ResponseBody
    public List jobs(@PathVariable("countNum") Long countNum) {
        List<Job> list = jobsService.findAllJob(countNum);
        return list;
    }

    /**
     * 通过id获取职位
     * @param id_ 职位id
     * @return
     */
    @RequestMapping(value="/api/job/{id_}", method = RequestMethod.GET)
    @ResponseBody
    public Job job(@PathVariable("id_") String id_) {
        Job job = jobsService.findOneJob(id_);
        return job;
    }

    /***
     * 通过名字搜索职位
     * @param name 职位名称
     * @return
     */
    @RequestMapping(value="/api/jobname", method = RequestMethod.GET)
    @ResponseBody
    public List jobname(@RequestParam("name") String name,@RequestParam("countNum") Long countNum) {
        List<Job> list = jobsService.findJobByName(name,countNum);
        return list;
    }

}
