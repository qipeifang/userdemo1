package com.example.userdemo1.dao;

import com.example.userdemo1.entity.TUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.Optional;

public interface UserDao extends JpaRepository<TUser, Long>
        , JpaSpecificationExecutor<TUser> {
    @Modifying
    @Transactional
        //保存用户
    TUser save(TUser user);

    Optional<TUser> findByEmail(String email);

    //通过关键字查询用户信息
    @Query("select u from TUser u where username like ?1 or email like ?1")
    public Page<TUser> findByKeyword(String kw, Pageable pageable);
}

