package com.miPortfolio.lgc.Controller;


import com.miPortfolio.lgc.Dto.dtoAcercaDe;
import com.miPortfolio.lgc.Entity.AcercaDe;
import com.miPortfolio.lgc.Security.Controller.Mensaje;
import com.miPortfolio.lgc.Service.SAcercaDe;
import org.apache.commons.lang3.StringUtils;
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
        if(StringUtils.isBlank(dtoAcercaDe.getNombreAE())){
            return new ResponseEntity<>(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sAcercaDe.existByNombreAD(dtoAcercaDe.getNombreAE())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        AcercaDe acercaDe = new AcercaDe(dtoAcercaDe.getNombreAE(), dtoAcercaDe.getDescripcionAE());
        sAcercaDe.save(acercaDe);
        return new ResponseEntity(new Mensaje("Acerca de creado"), HttpStatus.OK)
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercaDe dtoacercade){
        if(!sAcercaDe.existById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }

        if (sAcercaDe.existByNombreAD(dtoacercade.getNombreAE()) && sAcercaDe.getByNombreAD(dtoacercade.getNombreAE()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST)
        }

        if (StringUtils.isBlank(dtoacercade.getNombreAE())){
            return new ResponseEntity(new Mensaje)
        }
    }
}
