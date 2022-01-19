package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.PrintingOperation;
import tech.getarrays.employeemanager.model.Teacher;
import tech.getarrays.employeemanager.repo.TeacherRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class TeacherService {
    private final TeacherRepo teacherRepo;


    @Autowired
    public TeacherService(TeacherRepo teacherRepo) {
        this.teacherRepo = teacherRepo;

    }

    public Teacher addTeacher(Teacher teacher) {
        teacher.setTeacherCode(UUID.randomUUID().toString());
        return teacherRepo.save(teacher);
    }

    public List<Teacher> findAllTeachers() {
        return teacherRepo.findAll();
    }

    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepo.save(teacher);
    }

    public Teacher findTeacherById(Long id) {
        return teacherRepo.findTeacherById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteTeacher(Long id){
        teacherRepo.deleteTeacherById(id);
    }

}
