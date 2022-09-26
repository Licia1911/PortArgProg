package com.miPortfolio.lgc.Controller;


import com.miPortfolio.lgc.Dto.dtoAcercaDe;
import com.miPortfolio.lgc.Service.SAcercaDe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/acerca")
@CrossOrigin(origins = "http://localhost:4200")
public class CAcercaDe {
    @Autowired
    SAcercaDe sAcercaDe;

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sAcercaDe.existById(id)){
            return new ResponseEntity<>(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sAcercaDe.delete(id);
        return new ResponseEntity<>(new Mensaje("Se eliminó correctamente"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcercaDe dtoAcercaDe){
        if(StringUtils.isBlank())
    }
}
