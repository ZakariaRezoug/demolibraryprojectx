package com.example.demolibraryprojectx.business.abstracts;



import com.example.demolibraryprojectx.core.utilities.results.DataResult;
import com.example.demolibraryprojectx.core.utilities.results.Result;
import com.example.demolibraryprojectx.entity.concretes.User;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getAll();

    Result add(User user);
}
