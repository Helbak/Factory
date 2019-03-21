package code.dao;

import code.domain.IncomingInvoice;
import code.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomingInvoiceRepository extends JpaRepository<IncomingInvoice, Long> {
}
