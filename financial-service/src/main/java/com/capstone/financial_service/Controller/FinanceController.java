package com.capstone.financial_service.Controller;

import com.capstone.financial_service.Model.Finance;
import com.capstone.financial_service.Service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/finance")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @GetMapping
    public List<Finance> getAllFinances() {
        return financeService.getAllFinances();
    }

    @GetMapping("/{id}")
    public Finance getFinanceById(@PathVariable String id) {
        return financeService.getFinanceById(id);
    }

    @PostMapping
    public Finance createFinance(@RequestBody Finance finance) {
        return financeService.createFinance(finance);
    }

    @PutMapping("/{id}")
    public Finance updateFinance(@PathVariable String id, @RequestBody Finance finance) {
        return financeService.updateFinance(id, finance);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFinance(@PathVariable String id) {
        financeService.deleteFinance(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/project/{projectId}")
    public Mono<String> getProjectDetails(@PathVariable String projectId) {
        return financeService.getProjectDetails(projectId);
    }
}
