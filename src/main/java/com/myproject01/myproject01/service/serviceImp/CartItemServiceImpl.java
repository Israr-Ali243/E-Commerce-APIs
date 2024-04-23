package com.myproject01.myproject01.service.serviceImp;

import com.myproject01.myproject01.dto.CartItemDTO;
import com.myproject01.myproject01.dto.CategoryDTO;
import com.myproject01.myproject01.entity.Product;
import com.myproject01.myproject01.entity.User;
import com.myproject01.myproject01.entity.cartItem;
import com.myproject01.myproject01.repository.CartItemRepository;
import com.myproject01.myproject01.repository.ProductRepository;
import com.myproject01.myproject01.repository.UserRepository;
import com.myproject01.myproject01.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;
    @Override
    public CartItemDTO findCartItemById(Integer Id) {
    Optional<cartItem> cartItem= this.cartItemRepository.findById(Long.valueOf(Id));
    if (cartItem.isPresent()) {
        cartItem cartItem1 = cartItem.get();

        return this.cartItemToDTO(cartItem1);
    }

        return null;
    }



    @Override
    public CartItemDTO CreateCartItem(CartItemDTO cartItemDTO, Integer userId,Integer categoryId, Integer productId) {

        Optional<User> user = this.userRepository.findById(Long.valueOf(userId));
        Optional<Product> product = this.productRepository.findById(Long.valueOf(productId));

        cartItem cartItem = new cartItem();
        cartItem.setUser(user.get());
        cartItem.setProduct(product.get());
        cartItem.setCartId(cartItemDTO.getId());
        cartItem.setQty(cartItemDTO.getQuantity());
        cartItem.setSubtotal(cartItemDTO.getSubtotal());
        this.cartItemRepository.save(cartItem);
      return this.cartItemToDTO(cartItem);

    }

    @Override
    public CartItemDTO UpdateCartItem(CartItemDTO cartItemDTO, Integer Id) {
       Optional<cartItem> cartItem= this.cartItemRepository.findById(Long.valueOf(Id));

       if(cartItem.isPresent()){
           cartItem updatedCart = cartItem.get();
           updatedCart.setCartId(cartItemDTO.getId());
           updatedCart.setQty(cartItemDTO.getQuantity());
           updatedCart.setSubtotal(cartItemDTO.getSubtotal());
         this.cartItemRepository.save(updatedCart);
         return this.cartItemToDTO(updatedCart);
       }

        return null;
    }

    @Override
    public void DeleteCartItemById(Integer ID) {
        this.cartItemRepository.deleteById(Long.valueOf(ID));
        return;
    }

    @Override
    public List<CartItemDTO> getAllrtItem() {
        List<cartItem> cartItemList = this.cartItemRepository.findAll();

        List<CartItemDTO> cartDTOList =cartItemList.stream().map(cartItem -> this.cartItemToDTO(cartItem)).collect(Collectors.toList());

        return cartDTOList;
    }

    public cartItem DTOToCartItem(CartItemDTO cartItemDTO){
        cartItem cartItem = new cartItem();
        cartItem.setCartId(cartItemDTO.getId());
        cartItem.setQty(cartItemDTO.getQuantity());
        cartItem.setSubtotal(cartItemDTO.getSubtotal());

        return  cartItem;
    }

    public CartItemDTO cartItemToDTO(cartItem cartItem){
        CartItemDTO cartItemDTO = new CartItemDTO();
        cartItemDTO.setId(cartItem.getCartId());
        cartItemDTO.setSubtotal(cartItem.getSubtotal());
        cartItemDTO.setQuantity(cartItem.getQty());
        return cartItemDTO;
    }

}
