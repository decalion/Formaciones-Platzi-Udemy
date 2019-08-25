import { Injectable } from '@angular/core';
import {formatDate, DatePipe,registerLocaleData } from '@angular/common';
import { Cliente } from './cliente';
import { CLIENTES } from './clientes.json';
import {Observable , of, throwError} from  'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { map, catchError, tap } from 'rxjs/operators';
import swal from 'sweetalert2';
import {Router} from '@angular/router';





@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  private urlEndpoint : string = 'http://localhost:8080/api/clientes';

//Cabezaras
  private httpHeaders = new HttpHeaders({'Content-type' : 'application/json'});

  constructor(private http : HttpClient,private router : Router) { }


/**
Metodo que devuelve la lista de clientes
*/
  getClientes(): Observable<Cliente[]>{
    //Con el of convertimos los clientes en un objeto observable
    //return of(CLIENTES);
    //  return this.http.get<Cliente[]>(this.urlEndpoint);

 return this.http.get(this.urlEndpoint).pipe
    (tap(response => {
      console.log("ClienteService tap 1");
      let clientes = response as Cliente[];
      clientes.forEach( cliente =>{
        console.log(cliente.nombre);
      })
    }),
      map (response => {
       let clientes = response as Cliente[];
       return clientes.map(cliente =>{
         cliente.nombre = cliente.nombre.toUpperCase();
        // registerLocaleData(localeES, 'es');
         let datePipe = new DatePipe('es');
        // cliente.createAt = datePipe.transform(cliente.createAt, 'EEEE dd, MMMM yyyy');
         //cliente.createAt = formatDate(cliente.createAt, ' dd-MM-yyyy','en-US');
         return cliente;
       })
    }),tap(response => {
      console.log("ClienteService tap 2");
      response.forEach( cliente =>{
        console.log(cliente.nombre);
      })
    }),);
  }



/**
 Metodo para crear un cliente
**/
  create(cliente :Cliente) : Observable<Cliente>{


    return this.http.post(this.urlEndpoint,cliente,{headers :this.httpHeaders}).pipe(
      map( (response : any) => response.cliente as Cliente),
        catchError( e => {

          if(e.status==400){
            return  throwError(e);
          }

          console.error(e.error.mensaje)
          swal(e.error.mensaje, e.error.error, 'error');
          return  throwError(e);
        })
    );

  }


  getCliente(id) : Observable<Cliente>{
    return this.http.get<Cliente>(`${this.urlEndpoint}/${id}`).pipe(
      catchError(e => {
        this.router.navigate(['/clientes']);
        console.error(e.error.mensaje);
        swal('Error al Editar', e.error.mensaje, 'error');
        return  throwError(e);
      })
    )
  }



  update(cliente : Cliente) : Observable<any>{

    return this.http.put<any>(`${this.urlEndpoint}/${cliente.id}`,cliente,{headers: this.httpHeaders}).pipe(
      catchError( e => {

        if(e.status==400){
          return  throwError(e);
        }


        console.error(e.error.mensaje)
        swal(e.error.mensaje, e.error.error, 'error');
        return  throwError(e);
      })
    );
  }



    delete(id : number) : Observable<Cliente>{

      return this.http.delete<Cliente>(`${this.urlEndpoint}/${id}`, {headers: this.httpHeaders}).pipe(
        catchError( e => {
          console.error(e.error.mensaje)
          swal(e.error.mensaje, e.error.error, 'error');
          return  throwError(e);
        })
      );
   }

 }
