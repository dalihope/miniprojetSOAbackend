package tech.getarrays.employeemanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.PrintingOperation;
import tech.getarrays.employeemanager.model.Teacher;
import tech.getarrays.employeemanager.service.PrintingOperationService;
import tech.getarrays.employeemanager.service.TeacherService;

import java.util.List;


@RestController
@RequestMapping("/printingOperation")
public class PrintingOperationController {
    private final PrintingOperationService printingOperationService;
    private final TeacherService teacherService;

    public PrintingOperationController(PrintingOperationService printingOperationService , TeacherService teacherService) {
        this.printingOperationService = printingOperationService;
        this.teacherService = teacherService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PrintingOperation>> getAllPrintingOperations() {
        List<PrintingOperation> printingOperations = printingOperationService.findAllPrintingOperations();
        return new ResponseEntity<>(printingOperations, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PrintingOperation> getPrintingOperationById(@PathVariable("id") Long id) {
        PrintingOperation printingOperation = printingOperationService.findPrintingOperationById(id);
        return new ResponseEntity<>(printingOperation, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PrintingOperation> addPrintingOperation(@RequestBody PrintingOperation printingOperation) {


        PrintingOperation newPrintingOperation = printingOperationService.addPrintingOperation(printingOperation);
        return new ResponseEntity<>(newPrintingOperation, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PrintingOperation> updatePrintingOperation(@RequestBody PrintingOperation printingOperation) {
        PrintingOperation updatePrintingOperation = printingOperationService.updatePrintingOperation(printingOperation);
        return new ResponseEntity<>(updatePrintingOperation, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePrintingOperation(@PathVariable("id") Long id) {
        printingOperationService.deletePrintingOperation(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}