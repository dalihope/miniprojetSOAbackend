package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.PrintingAgent;


import java.util.Optional;

public interface PrintingAgentRepo extends JpaRepository<PrintingAgent, Long> {
    void deletePrintingAgentById(Long id);

    Optional<PrintingAgent> findPrintingAgentById(Long id);
}
