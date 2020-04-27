package com.example.userdemo1.service;

import com.example.userdemo1.entity.TUser;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService extends java.io.Serializable{
    List<TUser> findEmail(String email);
    public void save(TUser u)throws Exception;

    public TUser findById(long id);
    public void delete(TUser u);//删除一条信息
    public void deleteById(long id);
    public void deletes(List<TUser> users);//批量删除

    TUser findByEmail(String email);

    //分页查询
    Page<TUser> findBookNoCriteria(Integer page, Integer size);
    //关键字分页查询
    Page<TUser> findBookCriteria(Integer page, Integer size,String kw);
}


