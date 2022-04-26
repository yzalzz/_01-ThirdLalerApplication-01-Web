package com.fc.Service;

import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface NoteService {
    ModelAndView view(Integer id,  HttpServletRequest req , HttpServletResponse resp);
}
