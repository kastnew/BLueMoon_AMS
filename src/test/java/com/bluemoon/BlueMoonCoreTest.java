package com.bluemoon;

import com.bluemoon.service.BillingService;
import com.bluemoon.service.HouseholdService;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Kiểm thử đơn vị cho các nghiệp vụ cốt lõi: Tính phí BigDecimal (NFR-03) & Tuổi cử tri (RAW-027).
 */
public class BlueMoonCoreTest {

    @Test
    void testCalculateAreaBasedFeeAccuracy() {
        BillingService service = new BillingService();
        BigDecimal area = new BigDecimal("78.50");
        BigDecimal unitPrice = new BigDecimal("7000.00");
        BigDecimal prevDebt = new BigDecimal("150000.00");

        BigDecimal total = service.calculateAreaBasedFee(area, unitPrice, prevDebt);
        assertEquals(new BigDecimal("699500.00"), total);
    }

    @Test
    void testEligibleVoterExact18Years() {
        HouseholdService service = new HouseholdService();
        LocalDate electionDate = LocalDate.of(2026, 5, 23);

        assertTrue(service.isEligibleVoter(LocalDate.of(2008, 5, 23), electionDate));
        assertFalse(service.isEligibleVoter(LocalDate.of(2008, 5, 24), electionDate));
    }
}
