package com.eazybytes.loans.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AuditAwareImpl implements AuditorAware<String> {

    /**
     * This method returns the current auditor's name.
     * In this implementation, it returns a fixed value "LOANS_MS".
     *
     * @return an Optional containing the auditor's name
     */
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("LOANS_MS");
    }

}
