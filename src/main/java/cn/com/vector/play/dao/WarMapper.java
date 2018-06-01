package cn.com.vector.play.dao;

import java.util.List;

import cn.com.vector.play.entity.War;

public interface WarMapper {
    int deleteByPrimaryKey(Long id);

    int insert(War record);

    int insertSelective(War record);

    War selectByPrimaryKey(Long id);
    
    War selectByTxHash(String txHash);
    
    List<War> selectByAwardUser(String awardUser);

    int updateByPrimaryKeySelective(War record);

    int updateByPrimaryKey(War record);
}