package com.fc.service;

import com.fc.entity.VolunteerRecruitment;

import java.util.Date;
import java.util.Map;

public interface recruitmentService {
    Map<String, Object> list(Integer pageNum, Integer pageSize);

    Map<String, Object> add(VolunteerRecruitment volunteerRecruitment);

    Map<String, Object> update(VolunteerRecruitment volunteerRecruitment);

    Map<String, Object> del(VolunteerRecruitment id);

    Map<String, Object> click(Long id,Date lastClickTime);
}
