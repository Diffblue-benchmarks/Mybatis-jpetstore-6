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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ProductDiffblueTest {
  /**
   * Test {@link Product#setProductId(String)}.
   *
   * <ul>
   * <li>When {@code 42}.
   * <li>Then {@link Product} (default constructor) ProductId is {@code 42}.
   * </ul>
   *
   * <p>
   * Method under test: {@link Product#setProductId(String)}
   */
  @Test
  @DisplayName("Test setProductId(String); when '42'; then Product (default constructor) ProductId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Product.setProductId(String)" })
  void testSetProductId_when42_thenProductProductIdIs42() {
    // Arrange
    Product product = new Product();

    // Act
    product.setProductId("42");

    // Assert
    assertEquals("42", product.getProductId());
  }

  /**
   * Test getters and setters.
   *
   * <p>
   * Methods under test:
   *
   * <ul>
   * <li>default or parameterless constructor of {@link Product}
   * <li>{@link Product#setCategoryId(String)}
   * <li>{@link Product#setDescription(String)}
   * <li>{@link Product#setName(String)}
   * <li>{@link Product#toString()}
   * <li>{@link Product#getCategoryId()}
   * <li>{@link Product#getDescription()}
   * <li>{@link Product#getName()}
   * <li>{@link Product#getProductId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Product.<init>()", "String Product.getCategoryId()", "String Product.getDescription()",
      "String Product.getName()", "String Product.getProductId()", "void Product.setCategoryId(String)",
      "void Product.setDescription(String)", "void Product.setName(String)", "String Product.toString()" })
  void testGettersAndSetters() {
    // Arrange and Act
    Product actualProduct = new Product();
    actualProduct.setCategoryId("42");
    actualProduct.setDescription("The characteristics of someone or something");
    actualProduct.setName("Bella");
    String actualToStringResult = actualProduct.toString();
    String actualCategoryId = actualProduct.getCategoryId();
    String actualDescription = actualProduct.getDescription();
    String actualName = actualProduct.getName();

    // Assert
    assertEquals("42", actualCategoryId);
    assertEquals("Bella", actualName);
    assertEquals("Bella", actualToStringResult);
    assertEquals("The characteristics of someone or something", actualDescription);
    assertNull(actualProduct.getProductId());
  }
}
