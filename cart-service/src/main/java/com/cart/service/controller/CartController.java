package com.cart.service.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cart.service.bean.Cart;
import com.cart.service.bean.Product;

@RestController
@RequestMapping("v1/cart")
public class CartController {
	
	@GetMapping(value="/{userId}")
	public Cart getCart(@Valid @PathVariable long userId) {
		List<Product> products = new ArrayList<>();
		
		//p1
        Product p1 = new Product(1,"keyboard", 250, 2);
        p1.setTotlalPrice(p1.getBasePrice()*p1.getQuantity());
        products.add(p1);

        //p2
        Product p2 = new Product(2, "mouse", 150, 2);
        p2.setTotlalPrice(p2.getBasePrice()*p2.getQuantity());
        products.add(p2);

        // calculating total price
        double totalPrice = products.stream().mapToDouble(p ->p.getTotlalPrice()).sum();
        System.out.println("CartController totalPrice " + totalPrice);
        
        Cart cart = new Cart(products.size(), totalPrice, products);
        return cart;
	}
}
