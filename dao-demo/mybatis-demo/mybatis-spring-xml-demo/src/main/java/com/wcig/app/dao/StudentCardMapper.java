package com.wcig.app.dao;

import com.wcig.app.model.Card;
import com.wcig.app.model.Student;
import com.wcig.app.model.StudentCard;

public interface StudentCardMapper {
    Student selectStudentByPk(Integer studentId);
    Card selectCardByPk(Integer cardId);
    StudentCard selectStudentCardByPk(Integer studentId);
}
