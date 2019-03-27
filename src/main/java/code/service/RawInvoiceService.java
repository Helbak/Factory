package code.service;

import code.domain.RawInvoice;

import java.util.List;

public interface RawInvoiceService {

    void addRawInvoice(RawInvoice rawInvoice);
    List<RawInvoice> findRawInvoice ();
    float getSumOfInvoice (RawInvoice rawInvoice);
    float getsumRaws();
}
