package lk.icet.lehan.repositary.custom;

import lk.icet.lehan.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepositary extends CrudRepository<Student, Long> {
    Iterable<Student> findByName(String name);
}
