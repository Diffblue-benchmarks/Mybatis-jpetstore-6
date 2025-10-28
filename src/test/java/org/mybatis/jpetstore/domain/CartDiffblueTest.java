/**
 *    Copyright 2010-2025 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.mybatis.jpetstore.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CartDiffblueTest {
  /**
   * Test {@link Cart#getCartItems()}.
   *
   * <p>
   * Method under test: {@link Cart#getCartItems()}
   */
  @Test
  @DisplayName("Test getCartItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Iterator Cart.getCartItems()" })
  void testGetCartItems() {
    // Arrange, Act and Assert
    assertFalse(new Cart().getCartItems().hasNext());
  }

  /**
   * Test {@link Cart#getCartItemList()}.
   *
   * <p>
   * Method under test: {@link Cart#getCartItemList()}
   */
  @Test
  @DisplayName("Test getCartItemList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "List Cart.getCartItemList()" })
  void testGetCartItemList() {
    // Arrange, Act and Assert
    assertTrue(new Cart().getCartItemList().isEmpty());
  }

  /**
   * Test {@link Cart#getNumberOfItems()}.
   *
   * <p>
   * Method under test: {@link Cart#getNumberOfItems()}
   */
  @Test
  @DisplayName("Test getNumberOfItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "int Cart.getNumberOfItems()" })
  void testGetNumberOfItems() {
    // Arrange, Act and Assert
    assertEquals(0, new Cart().getNumberOfItems());
  }

  /**
   * Test {@link Cart#getAllCartItems()}.
   *
   * <p>
   * Method under test: {@link Cart#getAllCartItems()}
   */
  @Test
  @DisplayName("Test getAllCartItems()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Iterator Cart.getAllCartItems()" })
  void testGetAllCartItems() {
    // Arrange, Act and Assert
    assertFalse(new Cart().getAllCartItems().hasNext());
  }

  /**
   * Test {@link Cart#containsItemId(String)}.
   *
   * <ul>
   * <li>Given {@link Cart} (default constructor).
   * <li>Then return {@code false}.
   * </ul>
   *
   * <p>
   * Method under test: {@link Cart#containsItemId(String)}
   */
  @Test
  @DisplayName("Test containsItemId(String); given Cart (default constructor); then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "boolean Cart.containsItemId(String)" })
  void testContainsItemId_givenCart_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(new Cart().containsItemId("42"));
  }

  /**
   * Test {@link Cart#containsItemId(String)}.
   *
   * <ul>
   * <li>Given {@link Product} (default constructor) CategoryId is {@code 42}.
   * <li>Then return {@code true}.
   * </ul>
   *
   * <p>
   * Method under test: {@link Cart#containsItemId(String)}
   */
  @Test
  @DisplayName("Test containsItemId(String); given Product (default constructor) CategoryId is '42'; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "boolean Cart.containsItemId(String)" })
  void testContainsItemId_givenProductCategoryIdIs42_thenReturnTrue() {
    // Arrange
    Product product = new Product();
    product.setCategoryId("42");
    product.setDescription("The characteristics of someone or something");
    product.setName("Bella");
    product.setProductId("42");

    Item item = new Item();
    item.setAttribute1("Attribute1");
    item.setAttribute2("Attribute2");
    item.setAttribute3("Attribute3");
    item.setAttribute4("Attribute4");
    item.setAttribute5("Attribute5");
    item.setItemId("42");
    item.setListPrice(new BigDecimal("2.3"));
    item.setProduct(product);
    item.setQuantity(5);
    item.setStatus("Status");
    item.setSupplierId(1);
    item.setUnitCost(new BigDecimal("2.3"));

    Cart cart = new Cart();
    cart.addItem(item, true);

    // Act and Assert
    assertTrue(cart.containsItemId("42"));
  }

  /**
   * Test {@link Cart#addItem(Item, boolean)}.
   *
   * <ul>
   * <li>Given {@link Cart} (default constructor).
   * <li>Then {@link Cart} (default constructor) AllCartItems next Quantity is one.
   * </ul>
   *
   * <p>
   * Method under test: {@link Cart#addItem(Item, boolean)}
   */
  @Test
  @DisplayName("Test addItem(Item, boolean); given Cart (default constructor); then Cart (default constructor) AllCartItems next Quantity is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Cart.addItem(Item, boolean)" })
  void testAddItem_givenCart_thenCartAllCartItemsNextQuantityIsOne() {
    // Arrange
    Cart cart = new Cart();

    Item item = new Item();
    item.setAttribute1("Attribute1");
    item.setAttribute2("Attribute2");
    item.setAttribute3("Attribute3");
    item.setAttribute4("Attribute4");
    item.setAttribute5("Attribute5");
    item.setItemId("42");
    item.setListPrice(new BigDecimal("2.3"));

    Product product = new Product();
    product.setCategoryId("42");
    product.setDescription("The characteristics of someone or something");
    product.setName("Bella");
    product.setProductId("42");
    item.setProduct(product);
    item.setQuantity(1);
    item.setStatus("Status");
    item.setSupplierId(1);
    item.setUnitCost(new BigDecimal("2.3"));

    // Act
    cart.addItem(item, true);

    // Assert
    Iterator<CartItem> allCartItems = cart.getAllCartItems();
    CartItem nextResult = allCartItems.next();
    assertFalse(allCartItems.hasNext());
    assertSame(item, nextResult.getItem());
    assertEquals(1, nextResult.getQuantity());
    assertEquals(new BigDecimal("2.3"), nextResult.getTotal());
    assertTrue(nextResult.isInStock());
    List<CartItem> cartItemList = cart.getCartItemList();
    assertEquals(1, cartItemList.size());
    assertSame(nextResult, cartItemList.get(0));
    Iterator<CartItem> cartItems = cart.getCartItems();
    CartItem actualNextResult = cartItems.next();
    assertFalse(cartItems.hasNext());
    assertSame(nextResult, actualNextResult);
    assertEquals(1, cart.getNumberOfItems());
    assertEquals(new BigDecimal("2.3"), cart.getSubTotal());
  }

  /**
   * Test {@link Cart#addItem(Item, boolean)}.
   *
   * <ul>
   * <li>Then {@link Cart} (default constructor) AllCartItems next Quantity is two.
   * </ul>
   *
   * <p>
   * Method under test: {@link Cart#addItem(Item, boolean)}
   */
  @Test
  @DisplayName("Test addItem(Item, boolean); then Cart (default constructor) AllCartItems next Quantity is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Cart.addItem(Item, boolean)" })
  void testAddItem_thenCartAllCartItemsNextQuantityIsTwo() {
    // Arrange
    Cart cart = new Cart();

    Item item = new Item();
    item.setAttribute1("Attribute1");
    item.setAttribute2("Attribute2");
    item.setAttribute3("Attribute3");
    item.setAttribute4("Attribute4");
    item.setAttribute5("Attribute5");
    item.setItemId("42");
    item.setListPrice(new BigDecimal("2.3"));

    Product product = new Product();
    product.setCategoryId("42");
    product.setDescription("The characteristics of someone or something");
    product.setName("Bella");
    product.setProductId("42");
    item.setProduct(product);
    item.setQuantity(1);
    item.setStatus("Status");
    item.setSupplierId(1);
    item.setUnitCost(new BigDecimal("2.3"));
    cart.addItem(item, true);

    Item item2 = new Item();
    item2.setAttribute1("Attribute1");
    item2.setAttribute2("Attribute2");
    item2.setAttribute3("Attribute3");
    item2.setAttribute4("Attribute4");
    item2.setAttribute5("Attribute5");
    item2.setItemId("42");
    item2.setListPrice(new BigDecimal("2.3"));

    Product product2 = new Product();
    product2.setCategoryId("42");
    product2.setDescription("The characteristics of someone or something");
    product2.setName("Bella");
    product2.setProductId("42");
    item2.setProduct(product2);
    item2.setQuantity(1);
    item2.setStatus("Status");
    item2.setSupplierId(1);
    item2.setUnitCost(new BigDecimal("2.3"));

    // Act
    cart.addItem(item2, true);

    // Assert
    Iterator<CartItem> allCartItems = cart.getAllCartItems();
    CartItem nextResult = allCartItems.next();
    assertFalse(allCartItems.hasNext());
    assertSame(item, nextResult.getItem());
    assertEquals(2, nextResult.getQuantity());
    assertEquals(new BigDecimal("4.6"), nextResult.getTotal());
    assertTrue(nextResult.isInStock());
    List<CartItem> cartItemList = cart.getCartItemList();
    assertEquals(1, cartItemList.size());
    assertSame(nextResult, cartItemList.get(0));
    Iterator<CartItem> cartItems = cart.getCartItems();
    CartItem actualNextResult = cartItems.next();
    assertFalse(cartItems.hasNext());
    assertSame(nextResult, actualNextResult);
    assertEquals(1, cart.getNumberOfItems());
    assertEquals(new BigDecimal("4.6"), cart.getSubTotal());
  }

  /**
   * Test {@link Cart#removeItemById(String)}.
   *
   * <ul>
   * <li>Given {@link Cart} (default constructor).
   * <li>Then return {@code null}.
   * </ul>
   *
   * <p>
   * Method under test: {@link Cart#removeItemById(String)}
   */
  @Test
  @DisplayName("Test removeItemById(String); given Cart (default constructor); then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Item Cart.removeItemById(String)" })
  void testRemoveItemById_givenCart_thenReturnNull() {
    // Arrange
    Cart cart = new Cart();

    // Act and Assert
    assertNull(cart.removeItemById("42"));
    assertEquals(0, cart.getNumberOfItems());
    assertFalse(cart.getAllCartItems().hasNext());
    assertFalse(cart.getCartItems().hasNext());
    assertTrue(cart.getCartItemList().isEmpty());
    assertEquals(new BigDecimal("0"), cart.getSubTotal());
  }

  /**
   * Test {@link Cart#removeItemById(String)}.
   *
   * <ul>
   * <li>Given {@link Product} (default constructor) CategoryId is {@code 42}.
   * <li>Then return {@link Item} (default constructor).
   * </ul>
   *
   * <p>
   * Method under test: {@link Cart#removeItemById(String)}
   */
  @Test
  @DisplayName("Test removeItemById(String); given Product (default constructor) CategoryId is '42'; then return Item (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Item Cart.removeItemById(String)" })
  void testRemoveItemById_givenProductCategoryIdIs42_thenReturnItem() {
    // Arrange
    Product product = new Product();
    product.setCategoryId("42");
    product.setDescription("The characteristics of someone or something");
    product.setName("Bella");
    product.setProductId("42");

    Item item = new Item();
    item.setAttribute1("Attribute1");
    item.setAttribute2("Attribute2");
    item.setAttribute3("Attribute3");
    item.setAttribute4("Attribute4");
    item.setAttribute5("Attribute5");
    item.setItemId("42");
    item.setListPrice(new BigDecimal("2.3"));
    item.setProduct(product);
    item.setQuantity(1);
    item.setStatus("Status");
    item.setSupplierId(1);
    item.setUnitCost(new BigDecimal("2.3"));

    Cart cart = new Cart();
    cart.addItem(item, true);

    // Act
    Item actualRemoveItemByIdResult = cart.removeItemById("42");

    // Assert
    assertEquals(0, cart.getNumberOfItems());
    assertFalse(cart.getAllCartItems().hasNext());
    assertFalse(cart.getCartItems().hasNext());
    assertTrue(cart.getCartItemList().isEmpty());
    assertEquals(new BigDecimal("0"), cart.getSubTotal());
    assertSame(item, actualRemoveItemByIdResult);
  }

  /**
   * Test {@link Cart#incrementQuantityByItemId(String)}.
   *
   * <ul>
   * <li>Then {@link Cart} (default constructor) AllCartItems next Quantity is two.
   * </ul>
   *
   * <p>
   * Method under test: {@link Cart#incrementQuantityByItemId(String)}
   */
  @Test
  @DisplayName("Test incrementQuantityByItemId(String); then Cart (default constructor) AllCartItems next Quantity is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Cart.incrementQuantityByItemId(String)" })
  void testIncrementQuantityByItemId_thenCartAllCartItemsNextQuantityIsTwo() {
    // Arrange
    Product product = new Product();
    product.setCategoryId("42");
    product.setDescription("The characteristics of someone or something");
    product.setName("Bella");
    product.setProductId("42");

    Item item = new Item();
    item.setAttribute1("Attribute1");
    item.setAttribute2("Attribute2");
    item.setAttribute3("Attribute3");
    item.setAttribute4("Attribute4");
    item.setAttribute5("Attribute5");
    item.setItemId("42");
    item.setListPrice(new BigDecimal("2.3"));
    item.setProduct(product);
    item.setQuantity(1);
    item.setStatus("Status");
    item.setSupplierId(1);
    item.setUnitCost(new BigDecimal("2.3"));

    Cart cart = new Cart();
    cart.addItem(item, true);

    // Act
    cart.incrementQuantityByItemId("42");

    // Assert
    Iterator<CartItem> allCartItems = cart.getAllCartItems();
    CartItem nextResult = allCartItems.next();
    assertEquals(2, nextResult.getQuantity());
    assertFalse(allCartItems.hasNext());
    assertEquals(new BigDecimal("4.6"), cart.getSubTotal());
    assertEquals(new BigDecimal("4.6"), nextResult.getTotal());
  }

  /**
   * Test {@link Cart#getSubTotal()}.
   *
   * <ul>
   * <li>Given {@link Cart} (default constructor).
   * <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 0}.
   * </ul>
   *
   * <p>
   * Method under test: {@link Cart#getSubTotal()}
   */
  @Test
  @DisplayName("Test getSubTotal(); given Cart (default constructor); then return BigDecimal(String) with '0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "BigDecimal Cart.getSubTotal()" })
  void testGetSubTotal_givenCart_thenReturnBigDecimalWith0() {
    // Arrange and Act
    BigDecimal actualSubTotal = new Cart().getSubTotal();

    // Assert
    assertEquals(new BigDecimal("0"), actualSubTotal);
  }

  /**
   * Test {@link Cart#getSubTotal()}.
   *
   * <ul>
   * <li>Given {@link Item} (default constructor) ListPrice is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>
   * Method under test: {@link Cart#getSubTotal()}
   */
  @Test
  @DisplayName("Test getSubTotal(); given Item (default constructor) ListPrice is BigDecimal(String) with '2.3'; then return BigDecimal(String) with '2.3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "BigDecimal Cart.getSubTotal()" })
  void testGetSubTotal_givenItemListPriceIsBigDecimalWith23_thenReturnBigDecimalWith23() {
    // Arrange
    Product product = new Product();
    product.setCategoryId("42");
    product.setDescription("The characteristics of someone or something");
    product.setName("Bella");
    product.setProductId("42");

    Item item = new Item();
    item.setAttribute1("Attribute1");
    item.setAttribute2("Attribute2");
    item.setAttribute3("Attribute3");
    item.setAttribute4("Attribute4");
    item.setAttribute5("Attribute5");
    item.setItemId("42");
    item.setListPrice(new BigDecimal("2.3"));
    item.setProduct(product);
    item.setQuantity(1);
    item.setStatus("Status");
    item.setSupplierId(1);
    item.setUnitCost(new BigDecimal("2.3"));

    Cart cart = new Cart();
    cart.addItem(item, true);

    // Act
    BigDecimal actualSubTotal = cart.getSubTotal();

    // Assert
    assertEquals(new BigDecimal("2.3"), actualSubTotal);
  }

  /**
   * Test {@link Cart#getSubTotal()}.
   *
   * <ul>
   * <li>Given {@link Product} (default constructor) CategoryId is {@code Category Id}.
   * <li>Then return {@link BigDecimal#BigDecimal(String)} with {@code 4.6}.
   * </ul>
   *
   * <p>
   * Method under test: {@link Cart#getSubTotal()}
   */
  @Test
  @DisplayName("Test getSubTotal(); given Product (default constructor) CategoryId is 'Category Id'; then return BigDecimal(String) with '4.6'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "BigDecimal Cart.getSubTotal()" })
  void testGetSubTotal_givenProductCategoryIdIsCategoryId_thenReturnBigDecimalWith46() {
    // Arrange
    Product product = new Product();
    product.setCategoryId("42");
    product.setDescription("The characteristics of someone or something");
    product.setName("Bella");
    product.setProductId("42");

    Item item = new Item();
    item.setAttribute1("Attribute1");
    item.setAttribute2("Attribute2");
    item.setAttribute3("Attribute3");
    item.setAttribute4("Attribute4");
    item.setAttribute5("Attribute5");
    item.setItemId("42");
    item.setListPrice(new BigDecimal("2.3"));
    item.setProduct(product);
    item.setQuantity(1);
    item.setStatus("Status");
    item.setSupplierId(1);
    item.setUnitCost(new BigDecimal("2.3"));

    Product product2 = new Product();
    product2.setCategoryId("Category Id");
    product2.setDescription("Description");
    product2.setName("Name");
    product2.setProductId("Product Id");

    Item item2 = new Item();
    item2.setAttribute1("42");
    item2.setAttribute2("42");
    item2.setAttribute3("42");
    item2.setAttribute4("42");
    item2.setAttribute5("42");
    item2.setItemId("Item Id");
    item2.setListPrice(new BigDecimal("2.3"));
    item2.setProduct(product2);
    item2.setQuantity(0);
    item2.setStatus("42");
    item2.setSupplierId(2);
    item2.setUnitCost(new BigDecimal("2.3"));

    Cart cart = new Cart();
    cart.addItem(item2, false);
    cart.addItem(item, true);

    // Act
    BigDecimal actualSubTotal = cart.getSubTotal();

    // Assert
    assertEquals(new BigDecimal("4.6"), actualSubTotal);
  }

  /**
   * Test new {@link Cart} (default constructor).
   *
   * <p>
   * Method under test: default or parameterless constructor of {@link Cart}
   */
  @Test
  @DisplayName("Test new Cart (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Cart.<init>()" })
  void testNewCart() {
    // Arrange and Act
    Cart actualCart = new Cart();

    // Assert
    assertEquals(0, actualCart.getNumberOfItems());
    assertFalse(actualCart.getAllCartItems().hasNext());
    assertFalse(actualCart.getCartItems().hasNext());
    assertTrue(actualCart.getCartItemList().isEmpty());
    assertEquals(new BigDecimal("0"), actualCart.getSubTotal());
  }
}
