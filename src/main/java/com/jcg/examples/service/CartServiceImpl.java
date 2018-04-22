package com.jcg.examples.service;

import com.jcg.examples.model.Cart;
import com.jcg.examples.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    CartRepository cartRepository;

    @Override
    public Cart findById(long id) {
        return null;
    }

    @Override
    public List<Cart> selectAll() {
        return null;
    }

    @Override
    public void save(Cart cart) {

    }

    @Override
    public void update(Cart cart) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
