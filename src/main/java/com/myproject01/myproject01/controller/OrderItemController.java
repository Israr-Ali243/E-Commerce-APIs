package com.myproject01.myproject01.controller;

import com.myproject01.myproject01.dto.OrderItemDTo;
import com.myproject01.myproject01.service.OrderItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/order")
@Tag(name = "Order-Controller")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping("/getall")
    @Operation( summary = "Get All Orders", tags = "Order-Controller")
    public ResponseEntity<List< OrderItemDTo>> getAll(){
        return ResponseEntity.ok(orderItemService.getall());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItemDTo> getById(@PathVariable("id") int id){
    return ResponseEntity.ok(orderItemService.getOrderbyId(id));
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable("id") int id){

        if (orderItemService.DeleteOrderItem(id))
        return "successfully Deleted";
        else
            return "Error Item Not deleted";
    }


}
