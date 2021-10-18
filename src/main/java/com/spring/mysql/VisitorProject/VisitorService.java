package com.spring.mysql.VisitorProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;

    public List<Visitor> listAllVisitors() {
        return visitorRepository.findAll();
    }

    public List<Visitor> listAllInHaifa() { return visitorRepository.findAllInHaifa();}

    public List<Visitor> listAllInJerusalem() { return visitorRepository.findAllInJerusalem();}

    public List<Visitor> listAllInTelAviv() { return visitorRepository.findAllInTelAviv();}

    public void saveVisitor(Visitor visitor) {
        visitorRepository.save(visitor);
    }

    public Visitor getVisitor(Integer id) {
        return visitorRepository.getById(id);
    }

    public void deleteVisitor(Integer id) {
        visitorRepository.deleteById(id);
    }
}
