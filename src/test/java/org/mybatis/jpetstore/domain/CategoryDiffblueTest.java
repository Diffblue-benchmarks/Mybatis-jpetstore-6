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

class CategoryDiffblueTest {
  /**
   * Test {@link Category#setCategoryId(String)}.
   *
   * <ul>
   * <li>When {@code 42}.
   * <li>Then {@link Category} (default constructor) CategoryId is {@code 42}.
   * </ul>
   *
   * <p>
   * Method under test: {@link Category#setCategoryId(String)}
   */
  @Test
  @DisplayName("Test setCategoryId(String); when '42'; then Category (default constructor) CategoryId is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Category.setCategoryId(String)" })
  void testSetCategoryId_when42_thenCategoryCategoryIdIs42() {
    // Arrange
    Category category = new Category();

    // Act
    category.setCategoryId("42");

    // Assert
    assertEquals("42", category.getCategoryId());
  }

  /**
   * Test getters and setters.
   *
   * <p>
   * Methods under test:
   *
   * <ul>
   * <li>default or parameterless constructor of {@link Category}
   * <li>{@link Category#setDescription(String)}
   * <li>{@link Category#setName(String)}
   * <li>{@link Category#toString()}
   * <li>{@link Category#getCategoryId()}
   * <li>{@link Category#getDescription()}
   * <li>{@link Category#getName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Category.<init>()", "String Category.getCategoryId()", "String Category.getDescription()",
      "String Category.getName()", "void Category.setDescription(String)", "void Category.setName(String)",
      "String Category.toString()" })
  void testGettersAndSetters() {
    // Arrange and Act
    Category actualCategory = new Category();
    actualCategory.setDescription("The characteristics of someone or something");
    actualCategory.setName("Bella");
    String actualToStringResult = actualCategory.toString();
    String actualCategoryId = actualCategory.getCategoryId();
    String actualDescription = actualCategory.getDescription();

    // Assert
    assertEquals("Bella", actualCategory.getName());
    assertEquals("The characteristics of someone or something", actualDescription);
    assertNull(actualCategoryId);
    assertNull(actualToStringResult);
  }
}
