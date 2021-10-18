package com.spring.mysql.VisitorProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class VisitorController {
    @Autowired
    VisitorService visitorService;

    @GetMapping("visitors")
    public List<Visitor> list() {
        return visitorService.listAllVisitors();
    }

    @GetMapping("/visitors/{id}")
    public ResponseEntity<Visitor> get(@PathVariable Integer id) {
        try {
            Visitor visitor = visitorService.getVisitor(id);
            return new ResponseEntity<Visitor>(visitor, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<Visitor>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/visitors")
    public void add(@RequestBody Visitor visitor) {
        visitorService.saveVisitor(visitor);
    }

    @PutMapping("/visitors/{id}")
    public ResponseEntity<HttpStatus> update(@RequestBody Visitor visitor, @PathVariable Integer id) {
        try {
           Visitor existVisitor = visitorService.getVisitor(id);
           existVisitor.setFirstName(visitor.getFirstName());
           existVisitor.setLastName(visitor.getLastName());
           existVisitor.setCity(visitor.getCity());
           visitorService.saveVisitor(existVisitor);
           return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/visitors/{id}")
    public void delete(@PathVariable Integer id) {
        visitorService.deleteVisitor(id);
    }

    @GetMapping("/visitors/haifa")
    public List<Visitor> list2() {
        return visitorService.listAllInHaifa();
    }

    @GetMapping("/visitors/jerusalem")
    public List<Visitor> list3() {
        return visitorService.listAllInJerusalem();
    }

    @GetMapping("/visitors/tel-aviv")
    public List<Visitor> list4() {
        return visitorService.listAllInTelAviv();
    }

}
