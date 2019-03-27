package code.dao;

import code.domain.RawInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RawInvoiceRepository extends JpaRepository<RawInvoice, Long> {
}
