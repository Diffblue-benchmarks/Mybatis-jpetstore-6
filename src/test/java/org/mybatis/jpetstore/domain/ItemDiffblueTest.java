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

class ItemDiffblueTest {
  /**
   * Test {@link Item#setItemId(String)}.
   *
   * <ul>
   * <li>When {@code 42}.
   * <li>Then {@link Item} (default constructor) ItemId is {@code 42}.
   * </ul>
   *
   * <p>
   * Method under test: {@link Item#setItemId(String)}
   */
  @Test
  @DisplayName("Test setItemId(String); when '42'; then Item (default constructor) ItemId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Item.setItemId(String)" })
  void testSetItemId_when42_thenItemItemIdIs42() {
    // Arrange
    Item item = new Item();

    // Act
    item.setItemId("42");

    // Assert
    assertEquals("42", item.getItemId());
  }

  /**
   * Test getters and setters.
   *
   * <p>
   * Methods under test:
   *
   * <ul>
   * <li>default or parameterless constructor of {@link Item}
   * <li>{@link Item#setAttribute1(String)}
   * <li>{@link Item#setAttribute2(String)}
   * <li>{@link Item#setAttribute3(String)}
   * <li>{@link Item#setAttribute4(String)}
   * <li>{@link Item#setAttribute5(String)}
   * <li>{@link Item#setListPrice(BigDecimal)}
   * <li>{@link Item#setProduct(Product)}
   * <li>{@link Item#setQuantity(int)}
   * <li>{@link Item#setStatus(String)}
   * <li>{@link Item#setSupplierId(int)}
   * <li>{@link Item#setUnitCost(BigDecimal)}
   * <li>{@link Item#toString()}
   * <li>{@link Item#getAttribute1()}
   * <li>{@link Item#getAttribute2()}
   * <li>{@link Item#getAttribute3()}
   * <li>{@link Item#getAttribute4()}
   * <li>{@link Item#getAttribute5()}
   * <li>{@link Item#getItemId()}
   * <li>{@link Item#getListPrice()}
   * <li>{@link Item#getProduct()}
   * <li>{@link Item#getQuantity()}
   * <li>{@link Item#getStatus()}
   * <li>{@link Item#getSupplierId()}
   * <li>{@link Item#getUnitCost()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Item.<init>()", "String Item.getAttribute1()", "String Item.getAttribute2()",
      "String Item.getAttribute3()", "String Item.getAttribute4()", "String Item.getAttribute5()",
      "String Item.getItemId()", "BigDecimal Item.getListPrice()", "Product Item.getProduct()",
      "int Item.getQuantity()", "String Item.getStatus()", "int Item.getSupplierId()", "BigDecimal Item.getUnitCost()",
      "void Item.setAttribute1(String)", "void Item.setAttribute2(String)", "void Item.setAttribute3(String)",
      "void Item.setAttribute4(String)", "void Item.setAttribute5(String)", "void Item.setListPrice(BigDecimal)",
      "void Item.setProduct(Product)", "void Item.setQuantity(int)", "void Item.setStatus(String)",
      "void Item.setSupplierId(int)", "void Item.setUnitCost(BigDecimal)", "String Item.toString()" })
  void testGettersAndSetters() {
    // Arrange and Act
    Item actualItem = new Item();
    actualItem.setAttribute1("Attribute1");
    actualItem.setAttribute2("Attribute2");
    actualItem.setAttribute3("Attribute3");
    actualItem.setAttribute4("Attribute4");
    actualItem.setAttribute5("Attribute5");
    BigDecimal listPrice = new BigDecimal("2.3");
    actualItem.setListPrice(listPrice);
    Product product = new Product();
    product.setCategoryId("42");
    product.setDescription("The characteristics of someone or something");
    product.setName("Bella");
    product.setProductId("42");
    actualItem.setProduct(product);
    actualItem.setQuantity(1);
    actualItem.setStatus("Status");
    actualItem.setSupplierId(1);
    BigDecimal unitCost = new BigDecimal("2.3");
    actualItem.setUnitCost(unitCost);
    String actualToStringResult = actualItem.toString();
    String actualAttribute1 = actualItem.getAttribute1();
    String actualAttribute2 = actualItem.getAttribute2();
    String actualAttribute3 = actualItem.getAttribute3();
    String actualAttribute4 = actualItem.getAttribute4();
    String actualAttribute5 = actualItem.getAttribute5();
    String actualItemId = actualItem.getItemId();
    BigDecimal actualListPrice = actualItem.getListPrice();
    Product actualProduct = actualItem.getProduct();
    int actualQuantity = actualItem.getQuantity();
    String actualStatus = actualItem.getStatus();
    int actualSupplierId = actualItem.getSupplierId();
    BigDecimal actualUnitCost = actualItem.getUnitCost();

    // Assert
    assertEquals("(null-42)", actualToStringResult);
    assertEquals("Attribute1", actualAttribute1);
    assertEquals("Attribute2", actualAttribute2);
    assertEquals("Attribute3", actualAttribute3);
    assertEquals("Attribute4", actualAttribute4);
    assertEquals("Attribute5", actualAttribute5);
    assertEquals("Status", actualStatus);
    assertNull(actualItemId);
    assertEquals(1, actualQuantity);
    assertEquals(1, actualSupplierId);
    assertEquals(new BigDecimal("2.3"), actualListPrice);
    assertEquals(new BigDecimal("2.3"), actualUnitCost);
    assertSame(listPrice, actualListPrice);
    assertSame(unitCost, actualUnitCost);
    assertSame(product, actualProduct);
  }
}
