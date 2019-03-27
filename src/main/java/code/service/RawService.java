package code.service;

import code.domain.Raw;

import java.util.List;

public interface RawService {

    void addRaw(Raw raw);

    void supplyRaw(Raw raw, float plusAmount, float newCostPrice);
    List<Raw> findRaws();
    void newCostPrice(Raw raw, float plusAmount, float newPurchasePrice);
    void newAmount(Raw raw,float plusAmount);
    Raw getRawById(Long id);
    float getSumOfRow();
    boolean inProcessRaw (Raw raw, Float inProcessAmount);

}
