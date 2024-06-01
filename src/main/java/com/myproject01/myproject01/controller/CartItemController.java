package com.myproject01.myproject01.controller;

import com.myproject01.myproject01.dto.CartItemDTO;
import com.myproject01.myproject01.dto.ProductDTO;
import com.myproject01.myproject01.service.CartItemService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cart")
public class CartItemController {
    @Autowired
    private CartItemService cartItemService;

    // get all Product from the cart.
    @GetMapping("/getall")
    @Operation(summary = "Find all CartItems")
    public ResponseEntity<List<CartItemDTO>> getAllCartItem(){
        return ResponseEntity.ok(this.cartItemService.getAllrtItem());
    }


    @GetMapping("/{id}")
    @Operation(summary = "Find cartItem By Id")
    public ResponseEntity<CartItemDTO> getCartItemById(@PathVariable("id") Integer Id){
        CartItemDTO cartItemDTO = this.cartItemService.findCartItemById(Id);
        return ResponseEntity.ok(cartItemDTO);
    }

    @PostMapping("/add/user/{userID}/category/{CategoryId}/product/{productId}")
    @Operation(summary = "Add new Products in  Cart")
    public ResponseEntity<CartItemDTO> createCartItem(@RequestBody CartItemDTO cartItemDTO, @PathVariable("userID") Integer userID, @PathVariable("CategoryId") Integer categoryId,@PathVariable("productId") Integer productId){
        CartItemDTO cartItemDTO1 = this.cartItemService.CreateCartItem(cartItemDTO, userID, categoryId, productId);
        System.out.println(cartItemDTO1);
        return ResponseEntity.ok(cartItemDTO1);
    }


    @PutMapping("/update/{id}")
    @Operation(summary = "Update Cart Item ")
    public ResponseEntity<CartItemDTO> updateCartItem(@RequestBody CartItemDTO cartItemDTO,@PathVariable("id") Integer id){
        CartItemDTO cartItemDTO1 = this.cartItemService.UpdateCartItem(cartItemDTO, id);
        return ResponseEntity.ok(cartItemDTO1);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete CartItems")
    public String DeleteCartItem(@PathVariable("id") Integer Id){
        this.cartItemService.DeleteCartItemById(Id);
        return "Succesfully Deleted";
    }

//    @PostMapping("/add/user/{UserId}/category/{CategoryId}/product/{ProductId}")
//    public ResponseEntity<CartItemDTO> addItemInCart(@RequestBody CartItemDTO cartItemDTO, @PathVariable("UserId") Integer UserId,@PathVariable("CategoryId") Integer categoryId, @PathVariable("ProductId") Integer ProductId){
//
//       return ResponseEntity.ok(this.cartItemService.CreateCartItem(cartItemDTO,UserId, categoryId, ProductId ));
//    }


}
