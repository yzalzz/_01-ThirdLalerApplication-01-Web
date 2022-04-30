package com.fc.service.impl;

import com.fc.Vo.ResultVO;
import com.fc.dao.TbUserMapper;
import com.fc.entity.TbUser;
import com.fc.entity.TbUserExample;
import com.fc.service.UserService;
import com.fc.util.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserImpl implements UserService {
    @Autowired
    public TbUserMapper tbUserMapper;
    @Override
    public ResultVO login(String username, String password) {
        ResultVO vo ;
        //声明一个例子
        TbUserExample example = new TbUserExample();
        //通过例子创建一个标准
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);

        List<TbUser> users = tbUserMapper.selectByExample(example);

        if (users.size()>0){
            //users.get(0) 查出来的user
            vo=new ResultVO(200,"登录成功",true,users.get(0));
        }else {
            vo=new ResultVO(0,"登录失败，用户名或密码错误",false,"");
        }
        return vo;
    }

    @Override
    public ResultVO update(MultipartFile img, TbUser tbUser) {
        ResultVO resultVO=null;
        if (!img.isEmpty()){
            FileUploadUtil.fileUpload(img);
            resultVO=new ResultVO(200,"666",true,"http://localhost:8081/upload/"+img.getOriginalFilename());
        }else {
            int i = tbUserMapper.updateByPrimaryKeySelective(tbUser);
            if (i>0){
                TbUser user = tbUserMapper.selectByPrimaryKey(tbUser.getId());
                resultVO=new ResultVO(200,"666",true,user);
            }else {
                resultVO=new ResultVO(400,"666",true,"");
            }
        }
        return resultVO;
    }

    @Override
    public Map<String,Object> checkNick(String username) {
        Map<String, Object> map = new HashMap<>();
        TbUser byName = tbUserMapper.findByName(username);
        if (username.equals(byName.getUsername())){
            map.put("查到了",0);
            return map;
        }else {
            map.put("没查到",1);
        }
        return map;
    }



}
