package com.innovation.innovation_clone_be.Product.Service;

import com.innovation.innovation_clone_be.Error.Dto.ResponseDto;
import com.innovation.innovation_clone_be.Product.Dto.Response.ProductResponseDto;
import com.innovation.innovation_clone_be.Product.Entity.Product;
import com.innovation.innovation_clone_be.Product.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional
    public ResponseDto<?> getAllProduct() {

        List<Product> products = productRepository.findAll();
        List<ProductResponseDto> productResponseDtos = new ArrayList<>();

        for(Product product: products){
            productResponseDtos.add(new ProductResponseDto(product));
        }

        return ResponseDto.success(productResponseDtos);
    }
}
