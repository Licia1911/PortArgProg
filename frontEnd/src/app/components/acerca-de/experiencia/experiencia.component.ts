import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Experiencia } from 'src/app/model/experiencia';
import { SExperienciaService } from 'src/app/service/s-experiencia.service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-experiencia',
  templateUrl: './experiencia.component.html',
  styleUrls: ['./experiencia.component.css']
})
export class ExperienciaComponent implements OnInit {
  experiencias: Experiencia[] = [];
  public editExperiencia: Experiencia | undefined;
  public deleteExperiencia: Experiencia | undefined;

  constructor(private sExperiencia: SExperienciaService, private tokenService: TokenService) { }
  isLogged = false;

  ngOnInit(): void {
    this.cargarExperiencia();

    if (this.tokenService.getToken()) {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  }

  cargarExperiencia(): void {
    this.sExperiencia.lista().subscribe(data => { this.experiencias = data; });
  }

  public onOpenModal(mode: string, experiencia?: Experiencia): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'save') {
      button.setAttribute('data-target', '#addExperienciaModal');
    } else if (mode === 'delete') {
      this.deleteExperiencia = experiencia;
      button.setAttribute('data-target', '#deleteExperienciaModal');
    } else if (mode === 'edit') {
      this.editExperiencia = experiencia;
      button.setAttribute('data-target', '#editExperienciaModal');
    }

    container?.appendChild(button);
    button.click();
  }
  public onAddExperiencia(addForm: NgForm){
    document.getElementById('add-experiencia-form')?.click();
    this.sExperiencia.save(addForm.value).subscribe({
      next: (response:Experiencia)=>{
        console.log(response);
        this.cargarExperiencia();
        addForm.reset();
      },
      error:(error:HttpErrorResponse)=>{
        alert(error.message);
        addForm.reset();
      }
    })
  }

  public onUpdateExperiencia(experiencia: Experiencia){
    this.editExperiencia=experiencia;
    document.getElementById('add-experiencia-form')?.click();
    this.sExperiencia.update(experiencia).subscribe({
      next: (response:Experiencia)=>{
        console.log(response);
        this.cargarExperiencia();
      },error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

  public onDeleteExperiencia(idExpe: number):void{
    this.sExperiencia.delete(idExpe).subscribe({
      next: (response:void)=>{
        console.log(response);
        this.cargarExperiencia();
      },error:(error:HttpErrorResponse)=>{
        alert(error.message);
      }
    })
  }

}
