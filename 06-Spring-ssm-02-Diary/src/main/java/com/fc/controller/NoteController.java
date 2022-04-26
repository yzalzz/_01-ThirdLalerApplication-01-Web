package com.fc.controller;

import com.fc.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("note")
public class NoteController {
    @Autowired
    private NoteService noteService;
    @PostMapping("view")
    public ModelAndView view(@RequestBody Integer id, HttpServletRequest req , HttpServletResponse resp){
        return noteService.view(id,req,resp);
    }
}
