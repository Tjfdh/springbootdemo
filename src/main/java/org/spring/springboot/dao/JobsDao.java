package org.spring.springboot.dao;

import org.apache.ibatis.annotations.Param;
import org.spring.springboot.domain.Job;

import java.util.List;

/**
 * Created by haodong on 2018/2/2.
 */
public interface JobsDao {

    /**
     * 获取城市信息列表
     *
     * @return
     */
    List<Job> findAllJobs(Long countNum);

    /**
     * 通过id获取职位
     * @param id_  职位id
     * @return
     */
    Job findOneJob( String id_);

    /**
     * 通过名字搜索
     * @param name 职位名称
     * @return
     */
    List<Job> findJobByName(@Param("name") String name,@Param("countNum") Long countNum);
}
