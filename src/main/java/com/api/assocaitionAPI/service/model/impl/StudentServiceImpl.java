package com.api.assocaitionAPI.service.model.impl;

import com.api.assocaitionAPI.model.account.Student;
import com.api.assocaitionAPI.repo.StudentRepo;
import com.api.assocaitionAPI.service.model.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public Student findById(Long id) {
        return studentRepo.findById(id).orElse(null);
    }

    @Override
    public Student save(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public Student update(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public void delete(Long id) {
        studentRepo.deleteById(id);
    }

    @Override
    public List<Student> findAll() {
        return studentRepo.findAll();
    }
}
