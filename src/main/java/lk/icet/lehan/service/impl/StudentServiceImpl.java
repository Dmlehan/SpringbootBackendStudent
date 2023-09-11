package lk.icet.lehan.service.impl;

import lk.icet.lehan.dto.StudentDto;
import lk.icet.lehan.entity.Student;
import lk.icet.lehan.repositary.custom.StudentRepositary;
import lk.icet.lehan.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepositary repo;
    @Autowired
    ModelMapper modelMapper;
    public void saveStudent(StudentDto student){
        Student entity = modelMapper.map(student, Student.class);
        repo.save(entity);
    }

    @Override
    public StudentDto getStudent(Long id) {
        return repo.findById(id).map(entity -> modelMapper.map(entity, StudentDto.class)).orElse(null);
    }
    @Override
    public List<StudentDto> findByFirstName(String name) {
        Iterable<Student> byName = repo.findByName(name);
        ArrayList<StudentDto> list = new ArrayList<>();
        for (Student studentEntity : byName) {
            list.add(modelMapper.map(studentEntity, StudentDto.class));
        }
        return list;
    }
}
