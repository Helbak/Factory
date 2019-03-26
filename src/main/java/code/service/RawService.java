package code.service;

import code.domain.Raw;

import java.util.List;

public interface RawService {

    void addRaw(Raw raw);
//    void supplyProduct(Long id, Float plusAmount, Float newPurchasePrice,Float newSellingPrice);
    void supplyRawFromInvoice(Raw raw, float plusAmount, float newCostPrice);
    List<Raw> findRaws();
    void newCostPrice(Raw raw, float plusAmount, float newPurchasePrice);
    void newAmount(Raw raw,float plusAmount);
    Raw getRawById(Long id);
    void inProcessRaw (long id, Float inProcessAmount);
    float getAmountRow();

}
