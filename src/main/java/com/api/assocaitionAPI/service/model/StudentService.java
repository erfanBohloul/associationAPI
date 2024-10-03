package com.api.assocaitionAPI.service.model;

import com.api.assocaitionAPI.model.account.Student;

import java.util.List;

public interface StudentService {

    public Student findById(Long id);
    public Student save(Student student);
    public Student update(Student student);
    public void delete(Long id);
    public List<Student> findAll();

}
