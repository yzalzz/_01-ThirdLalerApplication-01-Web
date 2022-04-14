package com.fc.service.impl;

import com.fc.dao.UserMapper;
import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.DataVo;
import com.fc.vo.ResultVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResultVo updata(User user) {
        int affect = userMapper.updateByPrimaryKeySelective(user);
        ResultVo resultVo;
        if (affect>0){
            //把修改后的user拿来
            User result = userMapper.selectByPrimaryKey(user.getId());
            resultVo=new ResultVo(200,"用户修改成功",true,result);
        }else {
            resultVo=new ResultVo(400,"用户修改失败",false,null);
        }
        return resultVo;

    }
//del
    @Override
    public ResultVo del(Long id) {

        int affect = userMapper.deleteByPrimaryKey(id);
        ResultVo resultVo;
        if (affect>0){
            resultVo=new ResultVo(200,"删除成功",true,null);
        }else {
            resultVo=new ResultVo(400,"删除失败",false,null);
        }
        return resultVo;
    }

    //add
    @Override
    public ResultVo add(User user) {
       //如果前端给我们创建时间我们就用他给的
        if (user.getCreateTime()==null){
            user.setCreateTime(new Date());
        }
        int affect = userMapper.insertSelective(user);


        ResultVo resultVo;
        if (affect>0){
            resultVo=new ResultVo(200,"添加成功",true,user);
        }else {
            resultVo=new ResultVo(400,"添加失败",false,null);
        }
        return resultVo;
    }


    //list
    @Override
    public ResultVo list(Integer pageNum, Integer pageSize, Long id) {
        List<User> users;

        ResultVo resultVO;

        try {
            if (id == null) {
                PageHelper.startPage(pageNum, pageSize);

                users = userMapper.selectByExample(null);
            } else {
                User user = userMapper.selectByPrimaryKey(id);
                users = new ArrayList<>();
                users.add(user);
            }

            PageInfo<User> pageInfo = new PageInfo<>(users);

            DataVo<User> dataVO = new DataVo<>(pageInfo.getTotal(), users, pageNum, pageSize);

            resultVO = new ResultVo(200, "查询成功", true, dataVO);
        } catch (Exception e) {
            resultVO = new ResultVo(400, "查询失败", false, null);
        }

        return resultVO;
    }
}
