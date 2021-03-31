package com.neux.garden.ec.runtime.service;

import com.neux.garden.ec.runtime.api.model.GenerationResponse;
import com.neux.garden.ec.runtime.api.model.ListShoppingCarResponse;
import com.neux.garden.ec.runtime.exception.ErrorCode;
import com.neux.garden.ec.runtime.exception.ProfileException;
import com.neux.garden.ec.runtime.jpa.model.*;
import com.neux.garden.ec.runtime.service.data.ExProductFavoriteService;
import com.neux.garden.ec.runtime.service.data.ExProductShoppingCarService;
import com.neux.garden.ec.runtime.service.data.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingService {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ExProductFavoriteService exProductFavoriteService;

    @Autowired
    private ExProductShoppingCarService exProductShoppingCarService;

    @Autowired
    private ProductService productService;

    public GenerationResponse addFavorite(String authorization , String productId) {
        GenerationResponse generationResponse = new GenerationResponse();

        String account = tokenService.getUsernameFromToken(authorization);

        ExProductFavoriteIdentity exProductFavoriteIdentity = new ExProductFavoriteIdentity();
        exProductFavoriteIdentity.setAccount(account);
        exProductFavoriteIdentity.setProductId(productId);

        ExProductFavorite exProductFavorite = exProductFavoriteService.findByID(exProductFavoriteIdentity);
        if(exProductFavorite == null) {
            exProductFavorite = new ExProductFavorite();
            exProductFavorite.setIdentity(exProductFavoriteIdentity);
            exProductFavorite.setCreateBy(account);
            exProductFavorite.setUpdateBy(account);
            exProductFavoriteService.save(exProductFavorite);
        } else {
            exProductFavoriteService.deleteByID(exProductFavoriteIdentity);
        }


        return generationResponse;
    }

    public GenerationResponse addShoppingCart(String authorization , String productId) {
        GenerationResponse generationResponse = new GenerationResponse();

        String account = tokenService.getUsernameFromToken(authorization);

        ExProductShoppingCarIdentity exProductShoppingCarIdentity = new ExProductShoppingCarIdentity();
        exProductShoppingCarIdentity.setAccount(account);
        exProductShoppingCarIdentity.setProductId(productId);

        ExProductShoppingCar exProductShoppingCar = exProductShoppingCarService.findByID(exProductShoppingCarIdentity);
        if(exProductShoppingCar == null) {
            exProductShoppingCar = new ExProductShoppingCar();
            exProductShoppingCar.setIdentity(exProductShoppingCarIdentity);
            exProductShoppingCar.setCreateBy(account);
            exProductShoppingCar.setUpdateBy(account);
            exProductShoppingCarService.save(exProductShoppingCar);
        }


        return generationResponse;
    }

    public ListShoppingCarResponse listMyFavorite(String authorization) {

        ListShoppingCarResponse response = new ListShoppingCarResponse();

        String account = tokenService.getUsernameFromToken(authorization);

        List<ExProduct> exProducts =  exProductFavoriteService.listMyFavorite(account);

        exProducts.forEach(exProduct -> response.addProduct(productService.convertAPIProduct(exProduct)));

        return response;
    }

    public ListShoppingCarResponse listShoppingCart(String authorization) {

        ListShoppingCarResponse response = new ListShoppingCarResponse();

        String account = tokenService.getUsernameFromToken(authorization);

        List<ExProduct> exProducts =  exProductShoppingCarService.listMyShoppingCart(account);

        exProducts.forEach(exProduct -> response.addProduct(productService.convertAPIProduct(exProduct)));

        return response;
    }
}
