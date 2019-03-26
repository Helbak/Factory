package code.service;

import code.dao.RawRepository;
import code.domain.Raw;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RawServiceImpl implements RawService{
   private RawRepository rawRepository;

    @Override
    @Transactional
    public void addRaw(Raw raw){

        rawRepository.save(raw);
    }


}
