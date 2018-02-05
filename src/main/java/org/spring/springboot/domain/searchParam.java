package org.spring.springboot.domain;

/**
 * Created by haodong on 2018/2/4.
 */
public class searchParam {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCountNum() {
        return countNum;
    }

    public void setCountNum(Long countNum) {
        this.countNum = countNum;
    }

    private Long countNum;

}
