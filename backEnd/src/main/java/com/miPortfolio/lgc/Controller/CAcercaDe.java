package com.miPortfolio.lgc.Controller;


import com.miPortfolio.lgc.Dto.dtoAcercaDe;
import com.miPortfolio.lgc.Entity.AcercaDe;
import com.miPortfolio.lgc.Security.Controller.Mensaje;
import com.miPortfolio.lgc.Service.SAcercaDe;
import lombok.Getter;
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

    @GetMapping("/detail/{id}")
    public ResponseEntity<AcercaDe>getById(@PathVariable("id") int id){
        if (!sAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"),HttpStatus.BAD_REQUEST);
        }
        AcercaDe acercaDe = sAcercaDe.getOne(id).get();
        return new ResponseEntity(acercaDe, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if(!sAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sAcercaDe.delete(id);
        return new ResponseEntity(new Mensaje("Se eliminó correctamente"), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoAcercaDe dtoAcercaDe){
        if(StringUtils.isBlank(dtoAcercaDe.getNombreAD())){
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        if (sAcercaDe.existsByNombreAD(dtoAcercaDe.getNombreAD())){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        AcercaDe acercaDe = new AcercaDe(dtoAcercaDe.getNombreAD(), dtoAcercaDe.getDescripcionAD());
        sAcercaDe.save(acercaDe);
        return new ResponseEntity(new Mensaje("Acerca de creado"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoAcercaDe dtoacercade){
        if(!sAcercaDe.existsById(id)){
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }

        if (sAcercaDe.existsByNombreAD(dtoacercade.getNombreAD()) && sAcercaDe.getByNombreAD(dtoacercade.getNombreAD()).get().getId() != id){
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(dtoacercade.getNombreAD())){
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }

        AcercaDe acercaDe = sAcercaDe.getOne(id).get();
        acercaDe.setNombreAD(dtoacercade.getNombreAD());
        acercaDe.setDescripcionAD(dtoacercade.getDescripcionAD());

        sAcercaDe.save(acercaDe);

        return new ResponseEntity(new Mensaje("Acerca de actualizado"), HttpStatus.OK);

    }
}
