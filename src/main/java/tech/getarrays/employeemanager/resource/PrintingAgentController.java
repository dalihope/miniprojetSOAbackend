package tech.getarrays.employeemanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.PrintingAgent;
import tech.getarrays.employeemanager.service.PrintingAgentService;

import java.util.List;


@RestController
@RequestMapping("/printingAgent")
public class PrintingAgentController {
    private final PrintingAgentService printingAgentService;

    public PrintingAgentController(PrintingAgentService printingAgentService) {
        this.printingAgentService = printingAgentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<PrintingAgent>> getAllPrintingAgents() {
        List<PrintingAgent> printingAgents = printingAgentService.findAllPrintingAgents();
        return new ResponseEntity<>(printingAgents, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<PrintingAgent> getPrintingAgentById(@PathVariable("id") Long id) {
        PrintingAgent printingAgent = printingAgentService.findPrintingAgentById(id);
        return new ResponseEntity<>(printingAgent, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<PrintingAgent> addPrintingAgent(@RequestBody PrintingAgent printingAgent) {
        PrintingAgent newPrintingAgent = printingAgentService.addPrintingAgent(printingAgent);
        return new ResponseEntity<>(newPrintingAgent, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<PrintingAgent> updatePrintingAgent(@RequestBody PrintingAgent printingAgent) {
        PrintingAgent updatePrintingAgent = printingAgentService.updatePrintingAgent(printingAgent);
        return new ResponseEntity<>(updatePrintingAgent, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePrintingAgent(@PathVariable("id") Long id) {
        printingAgentService.deletePrintingAgent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
