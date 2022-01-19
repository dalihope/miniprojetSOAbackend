package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.UserNotFoundException;
import tech.getarrays.employeemanager.model.PrintingAgent;
import tech.getarrays.employeemanager.model.Teacher;
import tech.getarrays.employeemanager.repo.PrintingAgentRepo;
import tech.getarrays.employeemanager.repo.TeacherRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;
@Service
@Transactional
public class PrintingAgentService {
    private final PrintingAgentRepo printingAgentRepo;

    @Autowired
    public PrintingAgentService(PrintingAgentRepo printingAgentRepo) {
        this.printingAgentRepo = printingAgentRepo;
    }

    public PrintingAgent addPrintingAgent(PrintingAgent printingAgent) {

        return printingAgentRepo.save(printingAgent);
    }

    public List<PrintingAgent> findAllPrintingAgents() {

        return printingAgentRepo.findAll();
    }

    public PrintingAgent updatePrintingAgent(PrintingAgent printingAgent) {
        return printingAgentRepo.save(printingAgent);
    }

    public PrintingAgent findPrintingAgentById(Long id) {
        return printingAgentRepo.findPrintingAgentById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deletePrintingAgent(Long id){
        printingAgentRepo.deletePrintingAgentById(id);
    }
}
