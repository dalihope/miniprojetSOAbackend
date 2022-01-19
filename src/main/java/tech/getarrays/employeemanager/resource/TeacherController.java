package tech.getarrays.employeemanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.PrintingOperation;
import tech.getarrays.employeemanager.model.Teacher;
import tech.getarrays.employeemanager.service.PrintingAgentService;
import tech.getarrays.employeemanager.service.PrintingOperationService;
import tech.getarrays.employeemanager.service.TeacherService;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    private final PrintingOperationService printingOperationService;

    public TeacherController(TeacherService teacherService,PrintingOperationService printingOperationService) {

        this.teacherService = teacherService;
        this.printingOperationService = printingOperationService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Teacher>> getAllTeachers() {
        List<Teacher> teachers = teacherService.findAllTeachers();
        return new ResponseEntity<>(teachers, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable("id") Long id) {
        Teacher teacher = teacherService.findTeacherById(id);
        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher) {
        Teacher newTeacher = teacherService.addTeacher(teacher);
        return new ResponseEntity<>(newTeacher, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher) {
        Teacher updateTeacher = teacherService.updateTeacher(teacher);
        return new ResponseEntity<>(updateTeacher, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable("id") Long id) {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PostMapping("/add-printingOperation")
    public ResponseEntity<PrintingOperation> addPrintingOperation(@RequestBody PrintingOperation printingOperation) {
        PrintingOperation newPrintingOperation = printingOperationService.addPrintingOperation(printingOperation);
        return new ResponseEntity<>(newPrintingOperation, HttpStatus.CREATED);

    }
}
