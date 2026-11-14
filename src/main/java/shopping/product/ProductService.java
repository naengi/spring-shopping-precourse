package shopping.product;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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

    @Transactional
    public ProductResponse update(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));
        product.update(request.name(), request.price(), request.imageUrl());
        return ProductResponse.from(product);
    }

    @Transactional
    public void delete(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다."));
        productRepository.delete(product);
    }

    public List<ProductResponse> findAll() {
        return productRepository.findAll().stream()
                .map(ProductResponse::from).toList();
    }
}
