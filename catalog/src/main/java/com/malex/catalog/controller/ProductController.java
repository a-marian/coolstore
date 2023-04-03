package com.malex.catalog.controller;

import com.malex.catalog.model.Product;
import com.malex.catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Spliterator;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(value="/api/catalog")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Product> getAll(){
        Spliterator<Product> products = productRepository.findAll().spliterator();
        return StreamSupport.stream(products, false).collect(Collectors.toList());
    }
}
