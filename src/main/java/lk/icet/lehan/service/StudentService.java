package lk.icet.lehan.service;

import lk.icet.lehan.dto.StudentDto;

import java.util.List;

public interface StudentService {
    void saveStudent(StudentDto student);

    StudentDto getStudent(Long id);

    List<StudentDto> findByFirstName(String name);
}
