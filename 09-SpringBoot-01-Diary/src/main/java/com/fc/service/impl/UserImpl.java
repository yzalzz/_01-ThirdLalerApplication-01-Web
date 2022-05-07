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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public ResultVO update(MultipartFile img, TbUser user) {
        ResultVO resultVO = new ResultVO();

        if (img != null && !img.isEmpty()) {
            String path="D:\\ideaWorkSpace\\dev01\\09-SpringBoot-01-Diary\\src\\main\\resources\\META-INF\\resources\\upload";

            // 获取文件名
            String filename = img.getOriginalFilename();

            File pathFile = new File(path);

            String suffix = filename.substring(filename.lastIndexOf('.'));

            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmssSSS");

            String prefix = formatter.format(new Date());

            filename = prefix + suffix;

            try {
                img.transferTo(new File(pathFile, filename));

                // 如果上传成功，一定要把user中的头像给重新设置一下
                user.setHead(filename);
            } catch (IOException e) {
                e.printStackTrace();

                resultVO.setCode(0);
                resultVO.setSuccess(false);
                resultVO.setMessage("头像上传失败");
                return resultVO;
            }
        }

        int affectedRows = tbUserMapper.updateByPrimaryKeySelective(user);

        if (affectedRows > 0) {
            resultVO.setCode(1);
            resultVO.setMessage("更新个人信息成功！");

            user = tbUserMapper.selectByPrimaryKey(user.getId());

            resultVO.setData(user);
        } else {
            resultVO.setMessage("头像上传成功，但是修改失败");
            resultVO.setCode(0);
            resultVO.setSuccess(false);
        }

        return resultVO;
    }

    @Override
    public Integer checkNick(String nick) {
        TbUserExample tbUserExample = new TbUserExample();

        TbUserExample.Criteria criteria = tbUserExample.createCriteria();

        criteria.andNickEqualTo(nick);

        List<TbUser> users = tbUserMapper.selectByExample(tbUserExample);

        return users.size();
    }


}
