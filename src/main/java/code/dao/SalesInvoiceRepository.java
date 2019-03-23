package code.dao;

import code.domain.IncomingInvoice;
import code.domain.Product;
import code.domain.SalesInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesInvoiceRepository extends JpaRepository<SalesInvoice, Long>{
}
