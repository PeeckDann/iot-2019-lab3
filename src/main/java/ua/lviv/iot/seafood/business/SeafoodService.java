package ua.lviv.iot.seafood.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.iot.seafood.dataaccess.SeafoodRepository;
import ua.lviv.iot.seafood.model.Seafood;

@Service
public class SeafoodService {

    @Autowired
    private SeafoodRepository seafoodRepository;

    public Seafood createSeafood(Seafood seafood) {
        return seafoodRepository.save(seafood);
    }

    public void deleteSeafood(Integer seafoodId) {
        seafoodRepository.deleteById(seafoodId);
    }

    public List<Seafood> findSeafood() {
        return seafoodRepository.findAll();
    }

    public Seafood findPieceOfSeafood(Integer seafoodId) {
        return seafoodRepository.findById(seafoodId).get();
    }

    public boolean checkForSeafoodExistence(Integer seafoodId) {
        return seafoodRepository.existsById(seafoodId);
    }

    public Seafood updateSeafood(Integer seafoodId, Seafood seafood) {
        Seafood previousSeafood = seafoodRepository.findById(seafoodId).get();
        Seafood seafoodToReturn = new Seafood(previousSeafood.getPriceInGryvnias(), previousSeafood.getProducer(),
                previousSeafood.getSpeciesOfProduct(), previousSeafood.getConditionOfProduct());
        seafoodToReturn.setId(seafoodId);
        seafood.setId(seafoodId);
        seafoodRepository.save(seafood);
        return seafoodToReturn;
    }
}