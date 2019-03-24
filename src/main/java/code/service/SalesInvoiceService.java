package code.service;

import code.domain.SalesInvoice;

import java.util.List;

public interface SalesInvoiceService {
    void addSalesInvoice(SalesInvoice salesInvoice);
    List<SalesInvoice> findSalesInvoice ();
    float getSumOfInvoice (SalesInvoice salesInvoice);
    float getsumSales();
}
