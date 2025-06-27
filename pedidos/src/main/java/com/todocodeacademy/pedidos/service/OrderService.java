package com.todocodeacademy.pedidos.service;


import com.todocodeacademy.pedidos.dto.CartDTO;
import com.todocodeacademy.pedidos.dto.CurrentProductDTO;
import com.todocodeacademy.pedidos.dto.PaymentDTO;
import com.todocodeacademy.pedidos.dto.ProductDTO;
import com.todocodeacademy.pedidos.repository.ICartAPI;
import com.todocodeacademy.pedidos.repository.IPaymentsAPI;
import com.todocodeacademy.pedidos.repository.IProductAPI;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService implements  IOrderService{

    @Autowired
    private ICartAPI cartAPI;

    @Autowired
    private IProductAPI productAPI;

    @Autowired
    private IPaymentsAPI paymentsAPI;

    @Override
    public CartDTO createCart() {
        return cartAPI.createCart();
    }

    @Override
    @CircuitBreaker(name = "cart-service", fallbackMethod = "fallbackAddProductToCard")
    public CartDTO addProductToCart(Long idProduct) {
        CurrentProductDTO product = productAPI.getProduct(idProduct);
        ProductDTO request = new ProductDTO();
        request.setIdProduct(product.getIdProduct());
        request.setName(product.getName());
        request.setPrice(product.getPrice());
        request.setQuantity(3);

        return cartAPI.addProductToCart(request);
    }

    public CartDTO fallbackAddProductToCard( Throwable throwable){
        CartDTO response = new CartDTO();
        response.setIdCarrito(9999L);
        response.setTotal(null);
        return response;
    }

    @Override
    public PaymentDTO savePayment(Long idCart) {
        CartDTO cart = cartAPI.getCart(idCart);
        return paymentsAPI.savePayment(cart);
    }

    @Override
    public PaymentDTO getPayment(Long id) {
        return paymentsAPI.getPayment(id);
    }
}
