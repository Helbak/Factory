package code.service;

import code.domain.IncomingInvoice;

import java.util.List;

public interface IncomingInvoiceService {
    void addIncomingInvoice(IncomingInvoice incomingInvoice);
    List<IncomingInvoice> findIncomingInvoice ();
    float getSumOfInvoice (IncomingInvoice incomingInvoice);
}
