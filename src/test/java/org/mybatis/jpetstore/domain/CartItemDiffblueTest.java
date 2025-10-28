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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CartItemDiffblueTest {
  /**
   * Test {@link CartItem#setItem(Item)}.
   *
   * <ul>
   * <li>Given {@code null}.
   * <li>When {@link Item} (default constructor) ListPrice is {@code null}.
   * <li>Then {@link CartItem} (default constructor) Total is {@code null}.
   * </ul>
   *
   * <p>
   * Method under test: {@link CartItem#setItem(Item)}
   */
  @Test
  @DisplayName("Test setItem(Item); given 'null'; when Item (default constructor) ListPrice is 'null'; then CartItem (default constructor) Total is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void CartItem.setItem(Item)" })
  void testSetItem_givenNull_whenItemListPriceIsNull_thenCartItemTotalIsNull() {
    // Arrange
    CartItem cartItem = new CartItem();

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
    item.setListPrice(null);
    item.setProduct(product);
    item.setQuantity(1);
    item.setStatus("Status");
    item.setSupplierId(1);
    item.setUnitCost(new BigDecimal("2.3"));

    // Act
    cartItem.setItem(item);

    // Assert
    assertNull(cartItem.getTotal());
    assertSame(item, cartItem.getItem());
  }

  /**
   * Test {@link CartItem#setItem(Item)}.
   *
   * <ul>
   * <li>Then {@link CartItem} (default constructor) Total is {@link BigDecimal#BigDecimal(String)} with {@code 0.0}.
   * </ul>
   *
   * <p>
   * Method under test: {@link CartItem#setItem(Item)}
   */
  @Test
  @DisplayName("Test setItem(Item); then CartItem (default constructor) Total is BigDecimal(String) with '0.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void CartItem.setItem(Item)" })
  void testSetItem_thenCartItemTotalIsBigDecimalWith00() {
    // Arrange
    CartItem cartItem = new CartItem();

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

    // Act
    cartItem.setItem(item);

    // Assert
    assertEquals(new BigDecimal("0.0"), cartItem.getTotal());
    assertSame(item, cartItem.getItem());
  }

  /**
   * Test {@link CartItem#setQuantity(int)}.
   *
   * <ul>
   * <li>Given {@link CartItem} (default constructor).
   * <li>Then {@link CartItem} (default constructor) Total is {@code null}.
   * </ul>
   *
   * <p>
   * Method under test: {@link CartItem#setQuantity(int)}
   */
  @Test
  @DisplayName("Test setQuantity(int); given CartItem (default constructor); then CartItem (default constructor) Total is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void CartItem.setQuantity(int)" })
  void testSetQuantity_givenCartItem_thenCartItemTotalIsNull() {
    // Arrange
    CartItem cartItem = new CartItem();

    // Act
    cartItem.setQuantity(1);

    // Assert
    assertNull(cartItem.getTotal());
    assertEquals(1, cartItem.getQuantity());
  }

  /**
   * Test {@link CartItem#setQuantity(int)}.
   *
   * <ul>
   * <li>Given {@link Product} (default constructor) CategoryId is {@code 42}.
   * <li>Then {@link CartItem} (default constructor) Total is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>
   * Method under test: {@link CartItem#setQuantity(int)}
   */
  @Test
  @DisplayName("Test setQuantity(int); given Product (default constructor) CategoryId is '42'; then CartItem (default constructor) Total is BigDecimal(String) with '2.3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void CartItem.setQuantity(int)" })
  void testSetQuantity_givenProductCategoryIdIs42_thenCartItemTotalIsBigDecimalWith23() {
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

    CartItem cartItem = new CartItem();
    cartItem.setItem(item);

    // Act
    cartItem.setQuantity(1);

    // Assert
    assertEquals(1, cartItem.getQuantity());
    assertEquals(new BigDecimal("2.3"), cartItem.getTotal());
  }

  /**
   * Test {@link CartItem#incrementQuantity()}.
   *
   * <ul>
   * <li>Given {@link CartItem} (default constructor).
   * <li>Then {@link CartItem} (default constructor) Total is {@code null}.
   * </ul>
   *
   * <p>
   * Method under test: {@link CartItem#incrementQuantity()}
   */
  @Test
  @DisplayName("Test incrementQuantity(); given CartItem (default constructor); then CartItem (default constructor) Total is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void CartItem.incrementQuantity()" })
  void testIncrementQuantity_givenCartItem_thenCartItemTotalIsNull() {
    // Arrange
    CartItem cartItem = new CartItem();

    // Act
    cartItem.incrementQuantity();

    // Assert
    assertNull(cartItem.getTotal());
    assertEquals(1, cartItem.getQuantity());
  }

  /**
   * Test {@link CartItem#incrementQuantity()}.
   *
   * <ul>
   * <li>Then {@link CartItem} (default constructor) Total is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>
   * Method under test: {@link CartItem#incrementQuantity()}
   */
  @Test
  @DisplayName("Test incrementQuantity(); then CartItem (default constructor) Total is BigDecimal(String) with '2.3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void CartItem.incrementQuantity()" })
  void testIncrementQuantity_thenCartItemTotalIsBigDecimalWith23() {
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

    CartItem cartItem = new CartItem();
    cartItem.setItem(item);

    // Act
    cartItem.incrementQuantity();

    // Assert
    assertEquals(1, cartItem.getQuantity());
    assertEquals(new BigDecimal("2.3"), cartItem.getTotal());
  }

  /**
   * Test getters and setters.
   *
   * <p>
   * Methods under test:
   *
   * <ul>
   * <li>default or parameterless constructor of {@link CartItem}
   * <li>{@link CartItem#setInStock(boolean)}
   * <li>{@link CartItem#getItem()}
   * <li>{@link CartItem#getQuantity()}
   * <li>{@link CartItem#getTotal()}
   * <li>{@link CartItem#isInStock()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void CartItem.<init>()", "Item CartItem.getItem()", "int CartItem.getQuantity()",
      "BigDecimal CartItem.getTotal()", "boolean CartItem.isInStock()", "void CartItem.setInStock(boolean)" })
  void testGettersAndSetters() {
    // Arrange and Act
    CartItem actualCartItem = new CartItem();
    actualCartItem.setInStock(true);
    Item actualItem = actualCartItem.getItem();
    int actualQuantity = actualCartItem.getQuantity();
    BigDecimal actualTotal = actualCartItem.getTotal();

    // Assert
    assertNull(actualTotal);
    assertNull(actualItem);
    assertEquals(0, actualQuantity);
    assertTrue(actualCartItem.isInStock());
  }
}
