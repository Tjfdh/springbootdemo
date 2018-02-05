package org.spring.springboot.service;

import org.spring.springboot.domain.Job;

import java.util.List;

/**
 * Created by haodong on 2018/2/2.
 */
public interface JobsService {
    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<Job> findAllJob(Long countNum);
    Job findOneJob( String id_);
    List<Job> findJobByName(String name,Long countNum);
}
