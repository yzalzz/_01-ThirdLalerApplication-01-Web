package com.fc.Vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//vo传给前端的
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVo {
    private Integer id;
    private String username;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastAccessTime;

}
