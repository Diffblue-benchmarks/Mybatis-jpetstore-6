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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LineItemDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>
   * Methods under test:
   *
   * <ul>
   * <li>{@link LineItem#LineItem()}
   * <li>{@link LineItem#setItemId(String)}
   * <li>{@link LineItem#setLineNumber(int)}
   * <li>{@link LineItem#setOrderId(int)}
   * <li>{@link LineItem#setUnitPrice(BigDecimal)}
   * <li>{@link LineItem#getItem()}
   * <li>{@link LineItem#getItemId()}
   * <li>{@link LineItem#getLineNumber()}
   * <li>{@link LineItem#getOrderId()}
   * <li>{@link LineItem#getQuantity()}
   * <li>{@link LineItem#getTotal()}
   * <li>{@link LineItem#getUnitPrice()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void LineItem.<init>()", "Item LineItem.getItem()", "String LineItem.getItemId()",
      "int LineItem.getLineNumber()", "int LineItem.getOrderId()", "int LineItem.getQuantity()",
      "BigDecimal LineItem.getTotal()", "BigDecimal LineItem.getUnitPrice()", "void LineItem.setItemId(String)",
      "void LineItem.setLineNumber(int)", "void LineItem.setOrderId(int)", "void LineItem.setUnitPrice(BigDecimal)" })
  void testGettersAndSetters() {
    // Arrange and Act
    LineItem actualLineItem = new LineItem();
    actualLineItem.setItemId("42");
    actualLineItem.setLineNumber(2);
    actualLineItem.setOrderId(1);
    BigDecimal unitprice = new BigDecimal("2.3");
    actualLineItem.setUnitPrice(unitprice);
    Item actualItem = actualLineItem.getItem();
    String actualItemId = actualLineItem.getItemId();
    int actualLineNumber = actualLineItem.getLineNumber();
    int actualOrderId = actualLineItem.getOrderId();
    int actualQuantity = actualLineItem.getQuantity();
    BigDecimal actualTotal = actualLineItem.getTotal();
    BigDecimal actualUnitPrice = actualLineItem.getUnitPrice();

    // Assert
    assertEquals("42", actualItemId);
    assertNull(actualTotal);
    assertNull(actualItem);
    assertEquals(0, actualQuantity);
    assertEquals(1, actualOrderId);
    assertEquals(2, actualLineNumber);
    assertEquals(new BigDecimal("2.3"), actualUnitPrice);
    assertSame(unitprice, actualUnitPrice);
  }

  /**
   * Test {@link LineItem#LineItem(int, CartItem)}.
   *
   * <ul>
   * <li>Given {@link Item} (default constructor) ListPrice is {@code null}.
   * <li>Then return ItemId is {@code 42}.
   * </ul>
   *
   * <p>
   * Method under test: {@link LineItem#LineItem(int, CartItem)}
   */
  @Test
  @DisplayName("Test new LineItem(int, CartItem); given Item (default constructor) ListPrice is 'null'; then return ItemId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void LineItem.<init>(int, CartItem)" })
  void testNewLineItem_givenItemListPriceIsNull_thenReturnItemIdIs42() {
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
    item.setListPrice(null);
    item.setProduct(product);
    item.setQuantity(1);
    item.setStatus("Status");
    item.setSupplierId(1);
    item.setUnitCost(new BigDecimal("2.3"));

    CartItem cartItem = new CartItem();
    cartItem.setItem(item);

    // Act
    LineItem actualLineItem = new LineItem(2, cartItem);

    // Assert
    assertEquals("42", actualLineItem.getItemId());
    assertNull(actualLineItem.getTotal());
    assertNull(actualLineItem.getUnitPrice());
    assertEquals(0, actualLineItem.getOrderId());
    assertEquals(0, actualLineItem.getQuantity());
    assertEquals(2, actualLineItem.getLineNumber());
    assertSame(item, actualLineItem.getItem());
  }

  /**
   * Test {@link LineItem#LineItem(int, CartItem)}.
   *
   * <ul>
   * <li>Then return Total is {@link BigDecimal#BigDecimal(String)} with {@code 0.0}.
   * </ul>
   *
   * <p>
   * Method under test: {@link LineItem#LineItem(int, CartItem)}
   */
  @Test
  @DisplayName("Test new LineItem(int, CartItem); then return Total is BigDecimal(String) with '0.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void LineItem.<init>(int, CartItem)" })
  void testNewLineItem_thenReturnTotalIsBigDecimalWith00() {
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
    BigDecimal listPrice = new BigDecimal("2.3");
    item.setListPrice(listPrice);
    item.setProduct(product);
    item.setQuantity(1);
    item.setStatus("Status");
    item.setSupplierId(1);
    item.setUnitCost(new BigDecimal("2.3"));

    CartItem cartItem = new CartItem();
    cartItem.setItem(item);

    // Act
    LineItem actualLineItem = new LineItem(2, cartItem);

    // Assert
    assertEquals(new BigDecimal("0.0"), actualLineItem.getTotal());
    assertEquals(new BigDecimal("2.3"), actualLineItem.getUnitPrice());
    assertSame(listPrice, actualLineItem.getItem().getListPrice());
  }

  /**
   * Test {@link LineItem#setItem(Item)}.
   *
   * <ul>
   * <li>Given {@code null}.
   * <li>When {@link Item} (default constructor) ListPrice is {@code null}.
   * <li>Then {@link LineItem#LineItem()} Total is {@code null}.
   * </ul>
   *
   * <p>
   * Method under test: {@link LineItem#setItem(Item)}
   */
  @Test
  @DisplayName("Test setItem(Item); given 'null'; when Item (default constructor) ListPrice is 'null'; then LineItem() Total is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void LineItem.setItem(Item)" })
  void testSetItem_givenNull_whenItemListPriceIsNull_thenLineItemTotalIsNull() {
    // Arrange
    LineItem lineItem = new LineItem();

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
    lineItem.setItem(item);

    // Assert
    assertNull(lineItem.getTotal());
    assertSame(item, lineItem.getItem());
  }

  /**
   * Test {@link LineItem#setItem(Item)}.
   *
   * <ul>
   * <li>Then {@link LineItem#LineItem()} Total is {@link BigDecimal#BigDecimal(String)} with {@code 0.0}.
   * </ul>
   *
   * <p>
   * Method under test: {@link LineItem#setItem(Item)}
   */
  @Test
  @DisplayName("Test setItem(Item); then LineItem() Total is BigDecimal(String) with '0.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void LineItem.setItem(Item)" })
  void testSetItem_thenLineItemTotalIsBigDecimalWith00() {
    // Arrange
    LineItem lineItem = new LineItem();

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
    lineItem.setItem(item);

    // Assert
    assertEquals(new BigDecimal("0.0"), lineItem.getTotal());
    assertSame(item, lineItem.getItem());
  }

  /**
   * Test {@link LineItem#setQuantity(int)}.
   *
   * <ul>
   * <li>Given {@link LineItem#LineItem()}.
   * <li>Then {@link LineItem#LineItem()} Total is {@code null}.
   * </ul>
   *
   * <p>
   * Method under test: {@link LineItem#setQuantity(int)}
   */
  @Test
  @DisplayName("Test setQuantity(int); given LineItem(); then LineItem() Total is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void LineItem.setQuantity(int)" })
  void testSetQuantity_givenLineItem_thenLineItemTotalIsNull() {
    // Arrange
    LineItem lineItem = new LineItem();

    // Act
    lineItem.setQuantity(1);

    // Assert
    assertNull(lineItem.getTotal());
    assertEquals(1, lineItem.getQuantity());
  }

  /**
   * Test {@link LineItem#setQuantity(int)}.
   *
   * <ul>
   * <li>Given {@link Product} (default constructor) CategoryId is {@code 42}.
   * <li>Then {@link LineItem#LineItem()} Total is {@link BigDecimal#BigDecimal(String)} with {@code 2.3}.
   * </ul>
   *
   * <p>
   * Method under test: {@link LineItem#setQuantity(int)}
   */
  @Test
  @DisplayName("Test setQuantity(int); given Product (default constructor) CategoryId is '42'; then LineItem() Total is BigDecimal(String) with '2.3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void LineItem.setQuantity(int)" })
  void testSetQuantity_givenProductCategoryIdIs42_thenLineItemTotalIsBigDecimalWith23() {
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

    LineItem lineItem = new LineItem();
    lineItem.setItem(item);

    // Act
    lineItem.setQuantity(1);

    // Assert
    assertEquals(1, lineItem.getQuantity());
    assertEquals(new BigDecimal("2.3"), lineItem.getTotal());
  }
}
