package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.PrintingOperation;
import tech.getarrays.employeemanager.repo.PrintingOperationRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;


@Service
@Transactional
public class PrintingOperationService {
    private final PrintingOperationRepo printingOperationRepo;


    @Autowired
    public PrintingOperationService(PrintingOperationRepo printingOperationRepo) {
        this.printingOperationRepo = printingOperationRepo;
    }

    public PrintingOperation addPrintingOperation(PrintingOperation printingOperation) {

        return printingOperationRepo.saveAndFlush(printingOperation);
    }

    public List<PrintingOperation> findAllPrintingOperations() {
        return printingOperationRepo.findAll();
    }

    public PrintingOperation updatePrintingOperation(PrintingOperation printingOperation) {
        return printingOperationRepo.save(printingOperation);
    }

    public PrintingOperation findPrintingOperationById(Long id) {
        return printingOperationRepo.getOne(id);
                //.orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deletePrintingOperation(Long id){
        printingOperationRepo.deleteById(id);
    }
}
