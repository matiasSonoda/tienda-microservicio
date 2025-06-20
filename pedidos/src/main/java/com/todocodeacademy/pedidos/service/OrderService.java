package com.todocodeacademy.pedidos.service;


import com.todocodeacademy.pedidos.dto.CartDTO;
import com.todocodeacademy.pedidos.dto.CurrentProductDTO;
import com.todocodeacademy.pedidos.dto.PaymentRequestDTO;
import com.todocodeacademy.pedidos.dto.ProductDTO;
import com.todocodeacademy.pedidos.repository.ICartAPI;
import com.todocodeacademy.pedidos.repository.IPaymentsAPI;
import com.todocodeacademy.pedidos.repository.IProductAPI;
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
    public CartDTO addProductToCart(Long idProduct) {
        CurrentProductDTO product = productAPI.getProduct(idProduct);
        ProductDTO request = new ProductDTO();
        request.setIdProduct(product.getIdProduct());
        request.setName(product.getName());
        request.setPrice(product.getPrice());
        request.setQuantity(3);

        return cartAPI.addProductToCart(request);
    }

    @Override
    public Boolean payProducts(Double pay) {
        /*Se puede realizar una clase donde reciba un formulario
        * donde pueda crear un objeto de tipo PaymentRequestDTO
        * donde reciba el pago, tipo de pago, id, y demas informacion
        * detallada del pago. En este caso solo recibire el monto y creare
        * el objeto de la clase PaymentRequestDTO*/
        PaymentRequestDTO payment = new PaymentRequestDTO();
        payment.setPay(pay);
        Boolean bool = paymentsAPI.payOrder(payment);
        if(bool.booleanValue()){
           CartDTO cart = cartAPI.getCart();
           String response =productAPI.updateStock(cart.getListProducts());
           System.out.println(response);
           cartAPI.clearCart();
           return bool.booleanValue();
        }
        else{
            return bool.booleanValue();
        }

    }
}
