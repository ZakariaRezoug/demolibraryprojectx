package com.example.demolibraryprojectx.business.concretes;

import com.example.demolibraryprojectx.business.abstracts.UserService;
import com.example.demolibraryprojectx.core.utilities.results.DataResult;
import com.example.demolibraryprojectx.core.utilities.results.Result;
import com.example.demolibraryprojectx.core.utilities.results.SuccessDataResult;
import com.example.demolibraryprojectx.core.utilities.results.SuccessResult;
import com.example.demolibraryprojectx.dataAcces.abstracts.UserDao;
import com.example.demolibraryprojectx.entity.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userDao.findAll(),"Kullanıcılar getirildi.");
    }

    @Override
    public Result add(User user) {
        this.userDao.save(user);
        return new SuccessResult("Başarıyla eklendi");
    }
}
