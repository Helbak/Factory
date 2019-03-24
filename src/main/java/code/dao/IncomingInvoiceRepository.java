package code.dao;

import code.domain.IncomingInvoice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IncomingInvoiceRepository extends JpaRepository<IncomingInvoice, Long> {
}
