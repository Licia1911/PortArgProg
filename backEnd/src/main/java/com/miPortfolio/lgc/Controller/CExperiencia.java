package com.miPortfolio.lgc.Controller;

import com.miPortfolio.lgc.Dto.dtoExperiencia;
import com.miPortfolio.lgc.Entity.Experiencia;
import com.miPortfolio.lgc.Service.SExperiencia;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/explab")
@CrossOrigin(origins = "http://localhost:4200")
public class CExperiencia {
    @Autowired
    SExperiencia sExperiencia;

    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = sExperiencia.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexperiencia){
        if (StringUtils.isBlank(dtoexperiencia.getNombreExp()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        if (sExperiencia.existByNombreExp(dtoexperiencia.getNombreExp()))
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);

    Experiencia experiencia = new Experiencia(dtoexperiencia.getNombreExp(), dtoexperiencia.getDescripcionExp());
    sExperiencia.save(experiencia);
    return new ResponseEntity<>(new Mensaje("Experiencia agregada"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoExperiencia dtoexperiencia){
        if (!sExperiencia.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

        if (sExperiencia.existByNombreExp(dtoexperiencia.getNombreExp())&& sExperiencia.getByNombreExp(dtoexperiencia.getNombreExp()).get().getId() != id)
            return new ResponseEntity(new Mensaje("Esa experiencia ya existe"), HttpStatus.BAD_REQUEST);

        if (StringUtils.isBlank(dtoexperiencia.getNombreExp()))
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);

        Experiencia experiencia = sExperiencia.getOne(id).get();
        experiencia.setNombreExp(dtoexperiencia.getNombreExp());
        experiencia.setDescripcionExp(dtoexperiencia.getDescripcionExp());

        sExperiencia.save(experiencia);
        return new ResponseEntity<>(new Mensaje("Experiencia actualizada"), HttpStatus.OK);
    }

    public ResponseEntity<?> delete(@PathVariable("id") int id){
        if (!sExperiencia.existById(id))
            return new ResponseEntity(new Mensaje("El ID no existe"), HttpStatus.BAD_REQUEST);

        sExperiencia.delete(id);
        return new ResponseEntity<>(new Mensaje("Experiencia eliminada"), HttpStatus.OK);
    }
}