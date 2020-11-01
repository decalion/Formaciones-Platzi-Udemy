package com.icaballero.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.icaballero.app.dto.CreateProductoDTO;
import com.icaballero.app.dto.ProductoDTO;
import com.icaballero.app.dto.converter.ProductoDTOConverter;
import com.icaballero.app.error.ProductoNotFoundException;
import com.icaballero.app.error.SearchProductoNoResultException;
import com.icaballero.app.modelo.Producto;
import com.icaballero.app.service.ProductoServicio;
import com.icaballero.app.service.util.pagination.PaginationLinkUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ProductoController {

	private final ProductoServicio productoServicio;
	private final ProductoDTOConverter productoDTOConverter;
	private final PaginationLinkUtil paginationLinkUtils;

	/**
	 * Obtenemos todos los productos
	 * 
	 * @return 404 si no hay productos, 200 y lista de productos si hay uno o más
	 */
	@GetMapping("/producto")
	public ResponseEntity<?> obtenerTodos(@PageableDefault(size=10,page=0)Pageable pageable, HttpServletRequest request) {
		Page<Producto> result = productoServicio.findAll(pageable);

		if (result.isEmpty()) {
			throw new ProductoNotFoundException();
		} else {

			Page<ProductoDTO> dtoList = result.map(productoDTOConverter::convertToDto);

			UriComponentsBuilder uriBuilder =
					UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());
			
			return ResponseEntity.ok()
					.header("header", paginationLinkUtils.createLinkHeader(dtoList, uriBuilder))
					.body(dtoList);
			//return ResponseEntity.ok(dtoList);
		}

	}
	
	
	/**
	 * Obtener un listado de productos por nombre
	 * @param txt Cadena de caracteres que se usará para buscar en el nombre
	 * @return 404 si no se encuentran resultados. 200 y el conjunto de productos si se encuentra
	 */
	@GetMapping(value = "/producto", params = "nombre")
	public ResponseEntity<?> buscarProductosPorNombre(
			@RequestParam("nombre") String txt,
			Pageable pageable, HttpServletRequest request) {
		
		Page<Producto> result = productoServicio.findByNombre(txt, pageable);		
	
		if (result.isEmpty()) {
			throw new SearchProductoNoResultException(txt);
		} else {

			Page<ProductoDTO> dtoList = result.map(productoDTOConverter::convertToDto);
			UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(request.getRequestURL().toString());

			return ResponseEntity.ok().header("link", paginationLinkUtils.createLinkHeader(dtoList, uriBuilder))
					.body(dtoList);

		}
		
	}
	
	
	
	
	

	/**
	 * Obtenemos un producto en base a su ID
	 * 
	 * @param id
	 * @return 404 si no encuentra el producto, 200 y el producto si lo encuentra
	 */
	@GetMapping("/producto/{id}")
	public Producto obtenerUno(@PathVariable Long id) {

		return productoServicio.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));

	}

	/**
	 * Insertamos un nuevo producto
	 * 
	 * @param nuevo
	 * @return 201 y el producto insertado
	 */
	@PostMapping(value = "/producto", consumes= MediaType.MULTIPART_FORM_DATA_VALUE) //Aunque no es obligatorio, podemos indicar que se consume multipart/form-data
	public ResponseEntity<Producto> nuevoProducto(@RequestPart("nuevo") CreateProductoDTO nuevo, @RequestPart("file") MultipartFile file) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoServicio.nuevoProducto(nuevo, file));
	}

	/**
	 * 
	 * @param editar
	 * @param id
	 * @return 200 Ok si la edición tiene éxito, 404 si no se encuentra el producto
	 */
	@PutMapping("/producto/{id}")
	public Producto editarProducto(@RequestBody Producto editar, @PathVariable Long id) {

		return productoServicio.findById(id).map(p -> {
			p.setNombre(editar.getNombre());
			p.setPrecio(editar.getPrecio());
			return productoServicio.save(p);
		}).orElseThrow(() -> new ProductoNotFoundException(id));

	}

	/**
	 * Borra un producto del catálogo en base a su id
	 * 
	 * @param id
	 * @return Código 204 sin contenido
	 */
	@DeleteMapping("/producto/{id}")
	public ResponseEntity<Void> borrarProducto(@PathVariable Long id) {

		Producto producto = productoServicio.findById(id).orElseThrow(() -> new ProductoNotFoundException(id));

		productoServicio.delete(producto);
		return ResponseEntity.noContent().build();

	}

}
