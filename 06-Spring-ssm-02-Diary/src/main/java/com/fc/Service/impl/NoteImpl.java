package com.fc.Service.impl;

import com.fc.Service.NoteService;
import com.fc.dao.TbNoteMapper;
import com.fc.entity.TbNote;
import com.fc.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class NoteImpl implements NoteService {
    @Autowired
    private  TbNoteMapper noteMapper;

    @Override
    public ModelAndView view(Integer id , HttpServletRequest req , HttpServletResponse resp) {
        ResultVo resultVo;
        HttpSession session = req.getSession(true);
        if (id==null){
            resultVo=new ResultVo(400,"失败",false,null);
        }else {
            TbNote tbNote = noteMapper.selectByPrimaryKey(id);
            session.setAttribute("noteInfo",tbNote);
        }
        return null;
    }
}
