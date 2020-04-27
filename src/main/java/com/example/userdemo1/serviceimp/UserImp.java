package com.example.userdemo1.serviceimp;

import com.example.userdemo1.dao.UserDao;
import com.example.userdemo1.entity.TUser;
import com.example.userdemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public  class UserImp implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<TUser> findEmail(String email) {
        List<TUser> userList=UserImp.toList(userDao.findByEmail(email));
        return userList;
    }
    //Optional转换为List
    public static <T> List <T> toList(Optional<T> optional){
        return optional.map(Collections::singletonList).orElse(Collections.emptyList());
    }

    @Override
    public void save(TUser u) throws Exception{
        try{
            userDao.save(u);
        }catch (Exception ex){
            throw ex;
        }

    }

    @Override
    public TUser findById(long id) {
        return userDao.findById(id).get();
    }

    @Override
    public void delete(TUser u) {
        userDao.delete(u);
    }

    @Override
    public void deleteById(long id) {
        userDao.deleteById(id);
    }

    @Override
    @Transactional//保证数据删除的完整性
    public void deletes(List<TUser> users) {
        for (TUser u:users){
            userDao.delete(u);
        }
    }

    @Override
    public TUser findByEmail(String email) {
        return userDao.findByEmail(email).get();
    }


    //分页查询
    @Override
    public Page<TUser> findBookNoCriteria(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, "id");
        return userDao.findAll(pageable);
    }
    //关键字分页查询
    @Override
    public Page<TUser> findBookCriteria(Integer page, Integer size, String kw) {
        Pageable pageable =  PageRequest.of(page, size, Sort.Direction.ASC, "id");
        Page<TUser> userPage = userDao.findByKeyword(kw, pageable);
        return userPage;
    }

}
