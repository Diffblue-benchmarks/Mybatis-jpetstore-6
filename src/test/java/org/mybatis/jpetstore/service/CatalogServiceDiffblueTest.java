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
package org.mybatis.jpetstore.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mybatis.jpetstore.domain.Category;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Product;
import org.mybatis.jpetstore.mapper.CategoryMapper;
import org.mybatis.jpetstore.mapper.ItemMapper;
import org.mybatis.jpetstore.mapper.ProductMapper;

class CatalogServiceDiffblueTest {
  /**
   * Test {@link CatalogService#getCategoryList()}.
   *
   * <p>
   * Method under test: {@link CatalogService#getCategoryList()}
   */
  @Test
  @DisplayName("Test getCategoryList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "List CatalogService.getCategoryList()" })
  void testGetCategoryList() {
    // Arrange
    CategoryMapper categoryMapper = mock(CategoryMapper.class);
    when(categoryMapper.getCategoryList()).thenReturn(new ArrayList<>());
    CatalogService catalogService = new CatalogService(categoryMapper, mock(ItemMapper.class),
        mock(ProductMapper.class));

    // Act
    List<Category> actualCategoryList = catalogService.getCategoryList();

    // Assert
    verify(categoryMapper).getCategoryList();
    assertTrue(actualCategoryList.isEmpty());
  }

  /**
   * Test {@link CatalogService#getCategory(String)}.
   *
   * <p>
   * Method under test: {@link CatalogService#getCategory(String)}
   */
  @Test
  @DisplayName("Test getCategory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Category CatalogService.getCategory(String)" })
  void testGetCategory() {
    // Arrange
    Category category = new Category();
    category.setCategoryId("42");
    category.setDescription("The characteristics of someone or something");
    category.setName("Bella");

    CategoryMapper categoryMapper = mock(CategoryMapper.class);
    when(categoryMapper.getCategory(Mockito.<String> any())).thenReturn(category);
    CatalogService catalogService = new CatalogService(categoryMapper, mock(ItemMapper.class),
        mock(ProductMapper.class));

    // Act
    Category actualCategory = catalogService.getCategory("42");

    // Assert
    verify(categoryMapper).getCategory("42");
    assertSame(category, actualCategory);
  }

  /**
   * Test {@link CatalogService#getProduct(String)}.
   *
   * <p>
   * Method under test: {@link CatalogService#getProduct(String)}
   */
  @Test
  @DisplayName("Test getProduct(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Product CatalogService.getProduct(String)" })
  void testGetProduct() {
    // Arrange
    Product product = new Product();
    product.setCategoryId("42");
    product.setDescription("The characteristics of someone or something");
    product.setName("Bella");
    product.setProductId("42");

    ProductMapper productMapper = mock(ProductMapper.class);
    when(productMapper.getProduct(Mockito.<String> any())).thenReturn(product);
    CatalogService catalogService = new CatalogService(mock(CategoryMapper.class), mock(ItemMapper.class),
        productMapper);

    // Act
    Product actualProduct = catalogService.getProduct("42");

    // Assert
    verify(productMapper).getProduct("42");
    assertSame(product, actualProduct);
  }

  /**
   * Test {@link CatalogService#getProductListByCategory(String)}.
   *
   * <p>
   * Method under test: {@link CatalogService#getProductListByCategory(String)}
   */
  @Test
  @DisplayName("Test getProductListByCategory(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "List CatalogService.getProductListByCategory(String)" })
  void testGetProductListByCategory() {
    // Arrange
    ProductMapper productMapper = mock(ProductMapper.class);
    when(productMapper.getProductListByCategory(Mockito.<String> any())).thenReturn(new ArrayList<>());
    CatalogService catalogService = new CatalogService(mock(CategoryMapper.class), mock(ItemMapper.class),
        productMapper);

    // Act
    List<Product> actualProductListByCategory = catalogService.getProductListByCategory("42");

    // Assert
    verify(productMapper).getProductListByCategory("42");
    assertTrue(actualProductListByCategory.isEmpty());
  }

  /**
   * Test {@link CatalogService#searchProductList(String)}.
   *
   * <p>
   * Method under test: {@link CatalogService#searchProductList(String)}
   */
  @Test
  @DisplayName("Test searchProductList(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "List CatalogService.searchProductList(String)" })
  void testSearchProductList() {
    // Arrange
    ProductMapper productMapper = mock(ProductMapper.class);
    when(productMapper.searchProductList(Mockito.<String> any())).thenReturn(new ArrayList<>());
    CatalogService catalogService = new CatalogService(mock(CategoryMapper.class), mock(ItemMapper.class),
        productMapper);

    // Act
    List<Product> actualSearchProductListResult = catalogService.searchProductList("Keywords");

    // Assert
    verify(productMapper).searchProductList("%keywords%");
    assertTrue(actualSearchProductListResult.isEmpty());
  }

  /**
   * Test {@link CatalogService#getItemListByProduct(String)}.
   *
   * <p>
   * Method under test: {@link CatalogService#getItemListByProduct(String)}
   */
  @Test
  @DisplayName("Test getItemListByProduct(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "List CatalogService.getItemListByProduct(String)" })
  void testGetItemListByProduct() {
    // Arrange
    ItemMapper itemMapper = mock(ItemMapper.class);
    when(itemMapper.getItemListByProduct(Mockito.<String> any())).thenReturn(new ArrayList<>());
    CatalogService catalogService = new CatalogService(mock(CategoryMapper.class), itemMapper,
        mock(ProductMapper.class));

    // Act
    List<Item> actualItemListByProduct = catalogService.getItemListByProduct("42");

    // Assert
    verify(itemMapper).getItemListByProduct("42");
    assertTrue(actualItemListByProduct.isEmpty());
  }

  /**
   * Test {@link CatalogService#getItem(String)}.
   *
   * <p>
   * Method under test: {@link CatalogService#getItem(String)}
   */
  @Test
  @DisplayName("Test getItem(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Item CatalogService.getItem(String)" })
  void testGetItem() {
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

    ItemMapper itemMapper = mock(ItemMapper.class);
    when(itemMapper.getItem(Mockito.<String> any())).thenReturn(item);
    CatalogService catalogService = new CatalogService(mock(CategoryMapper.class), itemMapper,
        mock(ProductMapper.class));

    // Act
    Item actualItem = catalogService.getItem("42");

    // Assert
    verify(itemMapper).getItem("42");
    assertSame(item, actualItem);
  }

  /**
   * Test {@link CatalogService#isItemInStock(String)}.
   *
   * <ul>
   * <li>Given {@link ItemMapper} {@link ItemMapper#getInventoryQuantity(String)} return one.
   * <li>Then return {@code true}.
   * </ul>
   *
   * <p>
   * Method under test: {@link CatalogService#isItemInStock(String)}
   */
  @Test
  @DisplayName("Test isItemInStock(String); given ItemMapper getInventoryQuantity(String) return one; then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "boolean CatalogService.isItemInStock(String)" })
  void testIsItemInStock_givenItemMapperGetInventoryQuantityReturnOne_thenReturnTrue() {
    // Arrange
    ItemMapper itemMapper = mock(ItemMapper.class);
    when(itemMapper.getInventoryQuantity(Mockito.<String> any())).thenReturn(1);
    CatalogService catalogService = new CatalogService(mock(CategoryMapper.class), itemMapper,
        mock(ProductMapper.class));

    // Act
    boolean actualIsItemInStockResult = catalogService.isItemInStock("42");

    // Assert
    verify(itemMapper).getInventoryQuantity("42");
    assertTrue(actualIsItemInStockResult);
  }

  /**
   * Test {@link CatalogService#isItemInStock(String)}.
   *
   * <ul>
   * <li>Given {@link ItemMapper} {@link ItemMapper#getInventoryQuantity(String)} return zero.
   * <li>Then return {@code false}.
   * </ul>
   *
   * <p>
   * Method under test: {@link CatalogService#isItemInStock(String)}
   */
  @Test
  @DisplayName("Test isItemInStock(String); given ItemMapper getInventoryQuantity(String) return zero; then return 'false'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "boolean CatalogService.isItemInStock(String)" })
  void testIsItemInStock_givenItemMapperGetInventoryQuantityReturnZero_thenReturnFalse() {
    // Arrange
    ItemMapper itemMapper = mock(ItemMapper.class);
    when(itemMapper.getInventoryQuantity(Mockito.<String> any())).thenReturn(0);
    CatalogService catalogService = new CatalogService(mock(CategoryMapper.class), itemMapper,
        mock(ProductMapper.class));

    // Act
    boolean actualIsItemInStockResult = catalogService.isItemInStock("42");

    // Assert
    verify(itemMapper).getInventoryQuantity("42");
    assertFalse(actualIsItemInStockResult);
  }
}
