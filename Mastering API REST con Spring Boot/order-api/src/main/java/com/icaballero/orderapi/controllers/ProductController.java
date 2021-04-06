package com.icaballero.orderapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.icaballero.orderapi.converters.ProductConverter;
import com.icaballero.orderapi.dtos.ProductDTO;
import com.icaballero.orderapi.entity.Product;
import com.icaballero.orderapi.service.IProductService;
import com.icaballero.orderapi.utils.PathConstants;
import com.icaballero.orderapi.utils.WrapperResponse;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private ProductConverter converter;

	@GetMapping(value = PathConstants.PRODUCTS)
	public ResponseEntity<WrapperResponse<List<ProductDTO>>> findAll(
			@RequestParam(value = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(value = "pageSize", required = false, defaultValue = "5") int pageSize) {

		Pageable page = PageRequest.of(pageNumber, pageSize);

		List<Product> products = productService.findAll(page);

		List<ProductDTO> dtoProducts = converter.fromEntity(products);

		return new WrapperResponse<List<ProductDTO>>(true, "success", dtoProducts).createResponse(HttpStatus.OK);
	}

	@GetMapping(value = PathConstants.PRODUCTS_ID)
	public ResponseEntity<WrapperResponse<ProductDTO>> findById(@PathVariable("id") Long productId) {

		Product product = productService.findById(productId);

		ProductDTO productDTO = converter.fromEntity(product);

		return new WrapperResponse<ProductDTO>(true, "success", productDTO).createResponse(HttpStatus.OK);
	}

	@PostMapping(value = PathConstants.PRODUCTS)
	public ResponseEntity<WrapperResponse<ProductDTO>> create(@RequestBody ProductDTO product) {
		Product newProduct = productService.save(converter.fromDTO(product));

		ProductDTO productDTO = converter.fromEntity(newProduct);

		return new WrapperResponse<ProductDTO>(true, "success", productDTO).createResponse(HttpStatus.CREATED);
	}

	@PutMapping(value = PathConstants.PRODUCTS)
	public ResponseEntity<WrapperResponse<ProductDTO>> update(@RequestBody ProductDTO product) {

		Product updateProduct = productService.save(converter.fromDTO(product));

		ProductDTO productDTO = converter.fromEntity(updateProduct);

		return new WrapperResponse<ProductDTO>(true, "success", productDTO).createResponse(HttpStatus.OK);
	}

	@DeleteMapping(value = PathConstants.PRODUCTS_ID)
	public ResponseEntity<?> delete(@PathVariable("id") Long id) {

		productService.delete(id);

		return new WrapperResponse<Object>(true, "success", null).createResponse(HttpStatus.OK);
	}

}
