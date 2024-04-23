package com.myproject01.myproject01.service.serviceImp;

import com.myproject01.myproject01.dto.ProductDTO;
import com.myproject01.myproject01.entity.Category;
import com.myproject01.myproject01.entity.Product;
import com.myproject01.myproject01.entity.User;
import com.myproject01.myproject01.repository.CategoryRepository;
import com.myproject01.myproject01.repository.ProductRepository;
import com.myproject01.myproject01.repository.UserRepository;
import com.myproject01.myproject01.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl  implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public ProductDTO CreateProduct(ProductDTO productDTO, Integer userId, Integer categoryID, MultipartFile file) throws IOException {


        Optional<User> user = this.userRepository.findById(Long.valueOf(userId));
        Optional<Category> category= this.categoryRepository.findById(Long.valueOf(categoryID));
        Product product= this.dtoToProduct(productDTO);
        product.setAddDate(new Date());
        product.setUser(user.get());
        product.setImageName(file.getBytes());
        product.setCategory(category.get());
        this.productRepository.save(product);
        return this.productTodto(product);
    }

//    @Override
//    public Integer findCategoryIdbyProduct(Integer productID) {
//
//        Optional<Product> product = this.productRepository.findById(Long.valueOf(productID));
//        if (product.isPresent()) {
//            Product p1 = product.get();
//            Integer CategoryId = p1.getCategory().getCategoryId();
//            return CategoryId;
//        }
//        return null;
//    }

    @Override
    public ProductDTO getProductByID(Integer ID) {
        Optional<Product> product = this.productRepository.findById(Long.valueOf(ID));
        ProductDTO productDTO = null;
        if (product.isPresent()) {
            Product p1 = product.get();
            productDTO = this.productTodto(p1);
            return productDTO;
        }
       return null;
    }

    @Override
    public List<ProductDTO> getAllProducts() {

        List<Product> products= this.productRepository.findAll();
        List<ProductDTO> dtoList = products.stream().map(product ->this.productTodto(product)).collect(Collectors.toList());

        for(int i=0; i<dtoList.size(); i++){

            if (dtoList.get(i).getImageName() != null){
                byte[] bytes1 = dtoList.get(i).getImageName().toString().getBytes();
                System.out.println("byte 1" + bytes1);
                byte[] bytes = dtoList.get(i).getImageName();
                System.out.println("byte 2 "+bytes);
                String base64Image = Base64.getEncoder().encodeToString(bytes);
                dtoList.get(i).setImage(base64Image);
            }
        }


        return dtoList;
    }

    @Override
    public void deleteProduct(Integer Id) {

      this.productRepository.deleteById(Long.valueOf(Id));
    }

    @Override
    public ProductDTO updateProduct(ProductDTO productDTO, Integer Id) {

        Optional<Product> product = this.productRepository.findById(Long.valueOf(Id));
        Product updatedProduct = null;

        if (product.isPresent()){
            updatedProduct=product.get();

            updatedProduct.setProductDescription(productDTO.getProductDescription());
            updatedProduct.setProductPrice(productDTO.getProductPrice());
            updatedProduct.setProducttitle(productDTO.getProducttitle());
            updatedProduct.setProductId(productDTO.getProductId());
            this.productRepository.save(updatedProduct);
            return this.productTodto(updatedProduct);
        }else
        return null;

    }

    @Override
    public List<ProductDTO> getProductByCategory(String keyword) {

        List<Product> byCategoryTitle = this.productRepository.findByCategoryTitle(keyword);

        List<ProductDTO> productDTOList = byCategoryTitle.stream().map(product -> this.productTodto(product)).collect(Collectors.toList());
        System.out.println(productDTOList.toString());
        return  productDTOList;
    }

    @Override
    public List<ProductDTO> getProductByUser(Integer userId) {

        Optional<User> user = this.userRepository.findById(Long.valueOf(userId));
        User foundUser=null;
        if (user.isPresent()){
            foundUser=user.get();

            List<Product> productsList = this.productRepository.findByUser(foundUser);
            List<ProductDTO> productDTOList = productsList.stream().map(product -> this.productTodto(product)).collect(Collectors.toList());
            return productDTOList;
        }

        return null;
    }

    @Override
    public List<ProductDTO> searchProduct(String keyword) {
        return null;
    }

    public Product dtoToProduct(ProductDTO productDTO){
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setProductPrice(productDTO.getProductPrice());
        product.setProductDescription(productDTO.getProductDescription());
        product.setInStock(productDTO.isInStock());
        product.setImageName(productDTO.getImageName());
        product.setProducttitle(productDTO.getProducttitle());

        return product;

    }

    public ProductDTO productTodto(Product product){
     ProductDTO productDTO = new ProductDTO();

        productDTO.setProductId(product.getProductId());
        productDTO.setProductPrice(product.getProductPrice());
        productDTO.setProductDescription(product.getProductDescription());
        productDTO.setInStock(product.isInStock());
        productDTO.setImageName(product.getImageName());
        productDTO.setProducttitle(product.getProducttitle());

        return productDTO;
    }

}
