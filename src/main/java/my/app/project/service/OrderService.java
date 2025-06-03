package my.app.project.service;

import my.app.project.enumeration.OrderStatus;
import my.app.project.model.Order;
import my.app.project.model.Product;
import my.app.project.repo.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repo;
    @Autowired
    private SellerService sellerService;


    public Order getById(Long id){
        return repo.findById(id).get();
    }

    public void createOrder(Long custId, HashMap<Product, Integer> orders){
        Order order = new Order();
        order.setDateOfCreation(Calendar.getInstance());
        order.setStatus(OrderStatus.CREATED);
        order.setCustomerId(custId);
        order.setProductQtyMap(orders);
        for(Map.Entry<Product, Integer> entry : orders.entrySet()){
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            sellerService.sellProduct(product.getSeller().getId(), product, quantity);
        }
        closeOrder(order.getOrderId());
    }

    public void closeOrder(Long orderId){
        Order order = repo.findById(orderId).get();
        order.setStatus(OrderStatus.COMPLETED);
        order.setDateOfDelivery(Calendar.getInstance());
        repo.save(order);
    }

}
