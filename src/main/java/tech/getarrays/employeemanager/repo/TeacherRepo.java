package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.Teacher;

import java.util.Optional;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
    void deleteTeacherById(Long id);

    Optional<Teacher> findTeacherById(Long id);
}

