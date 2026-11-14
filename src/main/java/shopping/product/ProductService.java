package shopping.product;

import org.springframework.stereotype.Service;
import shopping.product.dto.ProductRequest;
import shopping.product.dto.ProductResponse;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse create(ProductRequest request) {
        Product product = new Product(request.name(), request.price(), request.imageUrl());
        Product saved = productRepository.save(product);
        return ProductResponse.from(saved);
    }

    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));
        return ProductResponse.from(product);
    }
}
