package com.kernel360.product.controller;
import com.kernel360.main.code.ProductsResponse;
import com.kernel360.product.dto.ProductDto;
import com.kernel360.product.service.ProductService;
import com.kernel360.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/products")
    ResponseEntity<ApiResponse<List<ProductDto>>> findProductList(){
        final List<ProductDto> productDtoList = productService.getProductList();

        return ApiResponse.toResponseEntity(ProductsResponse.GET_PRODUCT_DATA_SUCCESS, productDtoList);
    }

    @GetMapping("/product/{id}")
    ResponseEntity<ApiResponse<ProductDto>> findProductById(@PathVariable("id") Long productId) {
        ProductDto product = productService.getProductById(productId);

        return ApiResponse.toResponseEntity(ProductsResponse.GET_PRODUCT_DATA_SUCCESS, product);
    }

    @GetMapping("/products/search")
    ResponseEntity<ApiResponse<List<ProductDto>>> findProductByKeyword(@RequestParam("keyword") String keyword){
        final List<ProductDto> list = productService.getProductListByKeyword(keyword);

        return ApiResponse.toResponseEntity(ProductsResponse.GET_PRODUCT_DATA_SUCCESS, list);
    }

}
