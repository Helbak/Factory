package code.service;

import code.dao.RawRepository;
import code.domain.Raw;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class RawServiceImpl implements RawService{
   private RawRepository rawRepository;

    @Override
    @Transactional
    public void addRaw(Raw raw){
        rawRepository.save(raw);
    }
    @Override
    @Transactional
    public void supplyRaw(Raw raw, float plusAmount, float newPurchasePrice){
        addRaw(raw);
        newAmount(raw,plusAmount);
        newCostPrice(raw,plusAmount,newPurchasePrice);

    }
    @Override
    @Transactional
    public void newAmount(Raw raw,float plusAmount){
        float newAmount = raw.getAmount()+plusAmount;
        raw.setAmount(newAmount);
    }
    @Override
    @Transactional
    public void newCostPrice(Raw raw, float plusAmount, float newPurchasePrice){
        float newCostPrice= (raw.getCostPrice()*raw.getAmount() +newPurchasePrice*plusAmount)/(raw.getAmount()+plusAmount);
        raw.setCostPrice(newCostPrice);
    }
    @Override
    @Transactional
    public List<Raw> findRaws(){
        return rawRepository.findAll();
    }
    @Override
    @Transactional
    public Raw getRawById(Long id) {
        List<Raw> raws = findRaws();
        for (Raw raw : raws) {
            if (id == raw.getId())
                return raw;
           }
        return null;
    }
    @Override
    @Transactional
    public boolean inProcessRaw (Raw raw, Float inProcessAmount){
        if(inProcessAmount>raw.getAmount()){
            return false;
        }
        supplyRaw(raw,-inProcessAmount, raw.getCostPrice());
        return true;
    }

    @Override
    @Transactional
    public float getSumOfRows(){

        List<Raw> raws = findRaws();
        float sumOfRaws=0;
        for (Raw raw:raws){
            sumOfRaws=sumOfRaws+raw.getAmount()*raw.getCostPrice();}
                return sumOfRaws;
    }

}
