package com.example.midterm.entity;

public class CartItem_24162009 {
    private String cartItemId;
    private int quantity;
    private float unitPrice;
    private int productId;
    private String cartId;
    public String getCartItemId() { return cartItemId; }
    public void setCartItemId(String cartItemId) { this.cartItemId = cartItemId; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public float getUnitPrice() { return unitPrice; }
    public void setUnitPrice(float unitPrice) { this.unitPrice = unitPrice; }
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }
    public String getCartId() { return cartId; }
    public void setCartId(String cartId) { this.cartId = cartId; }
    private Product_24162009 product;
    public Product_24162009 getProduct() { return product; }
    public void setProduct(Product_24162009 product) { this.product = product; }
}
