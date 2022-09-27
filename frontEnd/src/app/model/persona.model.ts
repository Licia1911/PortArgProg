

export class persona{
    id?: number;
    nombre: string;
    git: string;
    link: string;
    fotoPerfil: string;
    banner: string;


    constructor(nombre: string, git: string, link: string, fotoPerfil: string, banner: string){ this.nombre = nombre 
        this.git = git 
        this.link = link 
        this.fotoPerfil = fotoPerfil 
        this.banner = banner;
    }
}