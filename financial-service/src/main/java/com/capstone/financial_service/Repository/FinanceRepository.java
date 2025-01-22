package com.capstone.financial_service.Repository;

import com.capstone.financial_service.Model.Finance;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FinanceRepository extends MongoRepository<Finance, String> {
}
