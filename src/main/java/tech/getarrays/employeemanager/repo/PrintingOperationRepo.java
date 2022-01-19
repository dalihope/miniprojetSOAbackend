package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.PrintingAgent;
import tech.getarrays.employeemanager.model.PrintingOperation;

import java.util.Optional;

public interface PrintingOperationRepo extends JpaRepository<PrintingOperation ,Long> {
    //void deletePrintingOperationBy(Long id);

    //Optional<PrintingOperation> findPrintingOperationBy(Long id);
}
