
// Con el ? decimos que un paremetro es opcional
function activar( quien:string , 
                  objeto:string = "Batiseñal" , 
                  momento?:string){
let mensaje:string;

if(momento){
    mensaje = ` ${quien} activo la ${ objeto } en la ${momento}`;
}
else{
    mensaje = ` ${quien} activo la ${ objeto }`;
}



console.log(mensaje);



}

activar("Gordon","batiseñal","tarde")