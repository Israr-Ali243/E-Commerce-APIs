package com.myproject01.myproject01.service;

import com.myproject01.myproject01.dto.CartItemDTO;
import com.myproject01.myproject01.entity.User;
import com.myproject01.myproject01.entity.cartItem;

import java.util.List;


public interface CartItemService {
    public CartItemDTO findCartItemById(Integer Id);

    public CartItemDTO CreateCartItem(CartItemDTO cartItemDTO, Integer userId,Integer CategoryId, Integer productId);

    public CartItemDTO UpdateCartItem(CartItemDTO cartItemDTO, Integer Id);

    public void DeleteCartItemById(Integer ID);
    public List<CartItemDTO> getAllrtItem();

}

