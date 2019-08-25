import { Component, OnInit } from '@angular/core';
import {Cliente} from './cliente';
import {ClienteService} from './cliente.service';
import {Router,ActivatedRoute} from '@angular/router';
import swal from 'sweetalert2';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit {

 private cliente : Cliente = new Cliente();
 private titulo : string ="Crear Cliente";

 private errores : String[];


  constructor(private clienteService : ClienteService,
    private router: Router,
  private activatedRoute : ActivatedRoute) { }

  ngOnInit() {
    this.cargarCliente();
  }



  cargarCliente() : void{
    this.activatedRoute.params.subscribe(params => {
      let id = params['id']
      if(id){
        this.clienteService.getCliente(id).subscribe( (cliente) => this.cliente = cliente)
      }
    })

  }




/**
Metodo para crear
**/
public create() : void{
  this.clienteService.create(this.cliente).subscribe(
    //Una vez creado vuelve a la lista de clientes
    cliente => {
      this.router.navigate(['/clientes'])
      swal('Nuevo cliente', `El cliente ${cliente.nombre} ha sido creado con exito`,'success');
    },
    err =>{

        this.errores = err.error.errors as String[];
          console.log("Codigo de error desde el backend" + err.status);
        console.log(err.error.errors)

    }

  );
  //console.log("Cliked!");
  //console.log(this.cliente);
}

update() : void{
  this.clienteService.update(this.cliente).
  subscribe(
    json =>{
      this.router.navigate(['/clientes'])
      swal('Cliente Actualizado',`${json.mensaje} : ${json.cliente.nombre}`, 'success');
    },
    err =>{

        this.errores = err.error.errors as String[];
        console.log("Codigo de error desde el backend" + err.status);
        console.log(err.error.errors)

    }

  )
}









}
