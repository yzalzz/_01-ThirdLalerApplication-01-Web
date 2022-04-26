package com.fc.Service;

import com.fc.vo.ResultVo;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public interface UserService {
//    ResultVo login(String username, String password);

    ModelAndView login(HttpServletRequest req, HttpServletResponse resp) throws IOException;

    Map<String,Object> checkNick(String username);

    ModelAndView logout(HttpServletRequest req, HttpServletResponse resp);
}
