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
package org.mybatis.jpetstore.web.actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Message;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.validation.ValidationErrors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mybatis.jpetstore.domain.Category;
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.Product;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;

class CatalogActionBeanDiffblueTest {
  /**
   * Test {@link CatalogActionBean#viewMain()}.
   *
   * <p>
   * Method under test: {@link CatalogActionBean#viewMain()}
   */
  @Test
  @DisplayName("Test viewMain()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "ForwardResolution CatalogActionBean.viewMain()" })
  void testViewMain() {
    // Arrange and Act
    ForwardResolution actualViewMainResult = new CatalogActionBean().viewMain();

    // Assert
    assertEquals("/WEB-INF/jsp/catalog/Main.jsp", actualViewMainResult.getPath());
    assertNull(actualViewMainResult.getStatus());
    assertNull(actualViewMainResult.getEvent());
    assertFalse(actualViewMainResult.isEventSpecified());
    assertTrue(actualViewMainResult.getParameters().isEmpty());
  }

  /**
   * Test {@link CatalogActionBean#viewCategory()}.
   *
   * <ul>
   * <li>Then return Path is {@code /WEB-INF/jsp/catalog/Category.jsp}.
   * </ul>
   *
   * <p>
   * Method under test: {@link CatalogActionBean#viewCategory()}
   */
  @Test
  @DisplayName("Test viewCategory(); then return Path is '/WEB-INF/jsp/catalog/Category.jsp'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "ForwardResolution CatalogActionBean.viewCategory()" })
  void testViewCategory_thenReturnPathIsWebInfJspCatalogCategoryJsp() {
    // Arrange and Act
    ForwardResolution actualViewCategoryResult = new CatalogActionBean().viewCategory();

    // Assert
    assertEquals("/WEB-INF/jsp/catalog/Category.jsp", actualViewCategoryResult.getPath());
    assertNull(actualViewCategoryResult.getStatus());
    assertNull(actualViewCategoryResult.getEvent());
    assertFalse(actualViewCategoryResult.isEventSpecified());
    assertTrue(actualViewCategoryResult.getParameters().isEmpty());
  }

  /**
   * Test {@link CatalogActionBean#viewProduct()}.
   *
   * <ul>
   * <li>Then return Path is {@code /WEB-INF/jsp/catalog/Product.jsp}.
   * </ul>
   *
   * <p>
   * Method under test: {@link CatalogActionBean#viewProduct()}
   */
  @Test
  @DisplayName("Test viewProduct(); then return Path is '/WEB-INF/jsp/catalog/Product.jsp'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "ForwardResolution CatalogActionBean.viewProduct()" })
  void testViewProduct_thenReturnPathIsWebInfJspCatalogProductJsp() {
    // Arrange and Act
    ForwardResolution actualViewProductResult = new CatalogActionBean().viewProduct();

    // Assert
    assertEquals("/WEB-INF/jsp/catalog/Product.jsp", actualViewProductResult.getPath());
    assertNull(actualViewProductResult.getStatus());
    assertNull(actualViewProductResult.getEvent());
    assertFalse(actualViewProductResult.isEventSpecified());
    assertTrue(actualViewProductResult.getParameters().isEmpty());
  }

  /**
   * Test {@link CatalogActionBean#searchProducts()}.
   *
   * <ul>
   * <li>Then {@link CatalogActionBean} (default constructor) Context Messages size is one.
   * </ul>
   *
   * <p>
   * Method under test: {@link CatalogActionBean#searchProducts()}
   */
  @Test
  @DisplayName("Test searchProducts(); then CatalogActionBean (default constructor) Context Messages size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "ForwardResolution CatalogActionBean.searchProducts()" })
  void testSearchProducts_thenCatalogActionBeanContextMessagesSizeIsOne() {
    // Arrange
    ActionBeanContext context = new ActionBeanContext();
    context.setEventName("Please enter a keyword to search for, then press the search button.");
    context.setRequest(new MockHttpServletRequest());
    context.setResponse(new MockHttpServletResponse());
    context.setServletContext(new MockServletContext());
    context.setValidationErrors(new ValidationErrors());

    CatalogActionBean catalogActionBean = new CatalogActionBean();
    catalogActionBean.setContext(context);

    // Act
    ForwardResolution actualSearchProductsResult = catalogActionBean.searchProducts();

    // Assert
    List<Message> messages = catalogActionBean.getContext().getMessages();
    assertEquals(1, messages.size());
    Message getResult = messages.get(0);
    assertTrue(getResult instanceof SimpleMessage);
    assertEquals("/WEB-INF/jsp/common/Error.jsp", actualSearchProductsResult.getPath());
    assertEquals("Please enter a keyword to search for, then press the search button.",
        ((SimpleMessage) getResult).getMessage());
    assertNull(actualSearchProductsResult.getStatus());
    assertNull(actualSearchProductsResult.getEvent());
    assertEquals(0, ((SimpleMessage) getResult).getReplacementParameters().length);
    assertFalse(actualSearchProductsResult.isEventSpecified());
    assertTrue(actualSearchProductsResult.getParameters().isEmpty());
  }

  /**
   * Test {@link CatalogActionBean#searchProducts()}.
   *
   * <ul>
   * <li>Then {@link CatalogActionBean} (default constructor) Context Messages size is one.
   * </ul>
   *
   * <p>
   * Method under test: {@link CatalogActionBean#searchProducts()}
   */
  @Test
  @DisplayName("Test searchProducts(); then CatalogActionBean (default constructor) Context Messages size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "ForwardResolution CatalogActionBean.searchProducts()" })
  void testSearchProducts_thenCatalogActionBeanContextMessagesSizeIsOne2() {
    // Arrange
    ActionBeanContext context = new ActionBeanContext();
    context.setEventName("Please enter a keyword to search for, then press the search button.");
    context.setRequest(new MockHttpServletRequest());
    context.setResponse(new MockHttpServletResponse());
    context.setServletContext(new MockServletContext());
    context.setValidationErrors(new ValidationErrors());

    CatalogActionBean catalogActionBean = new CatalogActionBean();
    catalogActionBean.setContext(context);
    catalogActionBean.setKeyword("");

    // Act
    ForwardResolution actualSearchProductsResult = catalogActionBean.searchProducts();

    // Assert
    List<Message> messages = catalogActionBean.getContext().getMessages();
    assertEquals(1, messages.size());
    Message getResult = messages.get(0);
    assertTrue(getResult instanceof SimpleMessage);
    assertEquals("/WEB-INF/jsp/common/Error.jsp", actualSearchProductsResult.getPath());
    assertEquals("Please enter a keyword to search for, then press the search button.",
        ((SimpleMessage) getResult).getMessage());
    assertNull(actualSearchProductsResult.getStatus());
    assertNull(actualSearchProductsResult.getEvent());
    assertEquals(0, ((SimpleMessage) getResult).getReplacementParameters().length);
    assertFalse(actualSearchProductsResult.isEventSpecified());
    assertTrue(actualSearchProductsResult.getParameters().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>
   * Methods under test:
   *
   * <ul>
   * <li>default or parameterless constructor of {@link CatalogActionBean}
   * <li>{@link CatalogActionBean#setCategory(Category)}
   * <li>{@link CatalogActionBean#setCategoryId(String)}
   * <li>{@link CatalogActionBean#setCategoryList(List)}
   * <li>{@link CatalogActionBean#setItem(Item)}
   * <li>{@link CatalogActionBean#setItemId(String)}
   * <li>{@link CatalogActionBean#setItemList(List)}
   * <li>{@link CatalogActionBean#setKeyword(String)}
   * <li>{@link CatalogActionBean#setProduct(Product)}
   * <li>{@link CatalogActionBean#setProductId(String)}
   * <li>{@link CatalogActionBean#setProductList(List)}
   * <li>{@link CatalogActionBean#getCategory()}
   * <li>{@link CatalogActionBean#getCategoryId()}
   * <li>{@link CatalogActionBean#getCategoryList()}
   * <li>{@link CatalogActionBean#getItem()}
   * <li>{@link CatalogActionBean#getItemId()}
   * <li>{@link CatalogActionBean#getItemList()}
   * <li>{@link CatalogActionBean#getKeyword()}
   * <li>{@link CatalogActionBean#getProduct()}
   * <li>{@link CatalogActionBean#getProductId()}
   * <li>{@link CatalogActionBean#getProductList()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void CatalogActionBean.<init>()", "Category CatalogActionBean.getCategory()",
      "String CatalogActionBean.getCategoryId()", "List CatalogActionBean.getCategoryList()",
      "Item CatalogActionBean.getItem()", "String CatalogActionBean.getItemId()",
      "List CatalogActionBean.getItemList()", "String CatalogActionBean.getKeyword()",
      "Product CatalogActionBean.getProduct()", "String CatalogActionBean.getProductId()",
      "List CatalogActionBean.getProductList()", "void CatalogActionBean.setCategory(Category)",
      "void CatalogActionBean.setCategoryId(String)", "void CatalogActionBean.setCategoryList(List)",
      "void CatalogActionBean.setItem(Item)", "void CatalogActionBean.setItemId(String)",
      "void CatalogActionBean.setItemList(List)", "void CatalogActionBean.setKeyword(String)",
      "void CatalogActionBean.setProduct(Product)", "void CatalogActionBean.setProductId(String)",
      "void CatalogActionBean.setProductList(List)" })
  void testGettersAndSetters() {
    // Arrange and Act
    CatalogActionBean actualCatalogActionBean = new CatalogActionBean();
    Category category = new Category();
    category.setCategoryId("42");
    category.setDescription("The characteristics of someone or something");
    category.setName("Bella");
    actualCatalogActionBean.setCategory(category);
    actualCatalogActionBean.setCategoryId("42");
    ArrayList<Category> categoryList = new ArrayList<>();
    actualCatalogActionBean.setCategoryList(categoryList);
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
    actualCatalogActionBean.setItem(item);
    actualCatalogActionBean.setItemId("42");
    ArrayList<Item> itemList = new ArrayList<>();
    actualCatalogActionBean.setItemList(itemList);
    actualCatalogActionBean.setKeyword("Keyword");
    Product product2 = new Product();
    product2.setCategoryId("42");
    product2.setDescription("The characteristics of someone or something");
    product2.setName("Bella");
    product2.setProductId("42");
    actualCatalogActionBean.setProduct(product2);
    actualCatalogActionBean.setProductId("42");
    ArrayList<Product> productList = new ArrayList<>();
    actualCatalogActionBean.setProductList(productList);
    Category actualCategory = actualCatalogActionBean.getCategory();
    String actualCategoryId = actualCatalogActionBean.getCategoryId();
    List<Category> actualCategoryList = actualCatalogActionBean.getCategoryList();
    Item actualItem = actualCatalogActionBean.getItem();
    String actualItemId = actualCatalogActionBean.getItemId();
    List<Item> actualItemList = actualCatalogActionBean.getItemList();
    String actualKeyword = actualCatalogActionBean.getKeyword();
    Product actualProduct = actualCatalogActionBean.getProduct();
    String actualProductId = actualCatalogActionBean.getProductId();
    List<Product> actualProductList = actualCatalogActionBean.getProductList();

    // Assert
    assertEquals("42", actualCategoryId);
    assertEquals("42", actualItemId);
    assertEquals("42", actualProductId);
    assertEquals("Keyword", actualKeyword);
    assertNull(actualCatalogActionBean.getContext());
    assertTrue(actualCategoryList.isEmpty());
    assertTrue(actualItemList.isEmpty());
    assertTrue(actualProductList.isEmpty());
    assertSame(categoryList, actualCategoryList);
    assertSame(itemList, actualItemList);
    assertSame(productList, actualProductList);
    assertSame(category, actualCategory);
    assertSame(item, actualItem);
    assertSame(product2, actualProduct);
  }
}
