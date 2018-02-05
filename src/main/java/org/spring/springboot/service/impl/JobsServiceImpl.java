package org.spring.springboot.service.impl;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.dao.JobsDao;
import org.spring.springboot.domain.Job;
import org.spring.springboot.service.JobsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by haodong on 2018/2/2.
 */

@Service
public class JobsServiceImpl implements JobsService {
    @Autowired
    private JobsDao jobsDao;
    @Override
    public List<Job> findAllJob(Long countNum) {
        return jobsDao.findAllJobs(countNum);
    }
    @Override
    public Job findOneJob( String  id_){
        return jobsDao.findOneJob(id_);
    }
    @Override
    public List<Job> findJobByName(String name,Long countNum){
        return jobsDao.findJobByName(name,countNum);
    }
}
