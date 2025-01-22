package com.capstone.financial_service.Service;

import org.springframework.web.reactive.function.client.WebClient;
import com.capstone.financial_service.Model.Finance;
import com.capstone.financial_service.Repository.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FinanceService {

    @Autowired
    private FinanceRepository financeRepository;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public List<Finance> getAllFinances() {
        return financeRepository.findAll();
    }

    public Finance getFinanceById(String id) {
        return financeRepository.findById(id).orElse(null);
    }

    public Finance createFinance(Finance finance) {
        return financeRepository.save(finance);
    }

    public Finance updateFinance(String id, Finance finance) {
        finance.setId(id);
        return financeRepository.save(finance);
    }

    public void deleteFinance(String id) {
        financeRepository.deleteById(id);
    }

    public Mono<String> getProjectDetails(String projectId) {
        return webClientBuilder.build()
                .get()
                .uri("http://project-service/projects/" + projectId)
                .retrieve()
                .bodyToMono(String.class);
    }
}
