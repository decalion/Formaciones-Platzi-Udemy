import { Component, OnInit } from '@angular/core';
import { Cliente } from './cliente';
import { ClienteService} from './cliente.service';
import swal from 'sweetalert2';
import {tap} from 'rxjs/operators';

@Component({
  selector: 'app-clientes',
  templateUrl: './clientes.component.html',
  styleUrls: ['./clientes.component.css']
})
export class ClientesComponent implements OnInit {

  clientes : Cliente[] = [];

    //Si declaramos la variable como private en el constructor automaticamente la asigna por injeccion
  constructor(private clienteService: ClienteService) { }

  ngOnInit() {
    
    this.clienteService.getClientes().pipe(
      tap( clientes => {
        console.log("ClienteComponent tap 3");
        clientes.forEach( cliente =>{
          console.log(cliente.nombre);
        })
      })
    )
    .subscribe(
      //Actualizamos la lista de clientes
      clientes => this.clientes = clientes
    );

  }

  delete(cliente : Cliente) : void{
    //SweetAlert
    swal({
      title: 'Estas seguro?',
      text: `¿Seguro que quieres eliminar al cliente ${cliente.nombre} ${cliente.apellido}?`,
      type: 'warning',
      showCancelButton: true,
      confirmButtonText: 'Si, eliminar!',
      cancelButtonText: 'No, cancelar!',
      reverseButtons: true,
      confirmButtonClass: 'btn btn-success',
      cancelButtonClass: 'btn btn-danger',
      buttonsStyling: false
    }).then((result) => {
      if (result.value) {
        this.clienteService.delete(cliente.id).subscribe(
          response => {
            this.clientes = this.clientes.filter(cli => cli !== cliente);
            swal(
              'Cliente Eliminado',
            `Cliente ${cliente.nombre} Eliminado con Exito`,
              'success'
            )
          }
        )
      }
    });

  }

}
