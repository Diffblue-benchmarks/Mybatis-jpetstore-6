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
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class OrderDiffblueTest {
  /**
   * Test {@link Order#initOrder(Account, Cart)}.
   *
   * <ul>
   * <li>Given {@link Product} (default constructor) CategoryId is {@code 42}.
   * <li>Then {@link Order} (default constructor) LineItems size is one.
   * </ul>
   *
   * <p>
   * Method under test: {@link Order#initOrder(Account, Cart)}
   */
  @Test
  @DisplayName("Test initOrder(Account, Cart); given Product (default constructor) CategoryId is '42'; then Order (default constructor) LineItems size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Order.initOrder(Account, Cart)" })
  void testInitOrder_givenProductCategoryIdIs42_thenOrderLineItemsSizeIsOne() {
    // Arrange
    Order order = new Order();

    Account account = new Account();
    account.setAddress1("42 Main St");
    account.setAddress2("42 Main St");
    account.setBannerName("Bella");
    account.setBannerOption(true);
    account.setCity("Oxford");
    account.setCountry("GB");
    account.setEmail("jane.doe@example.org");
    account.setFavouriteCategoryId("42");
    account.setFirstName("Jane");
    account.setLanguagePreference("en");
    account.setLastName("Doe");
    account.setListOption(true);
    account.setPassword("iloveyou");
    account.setPhone("6625550144");
    account.setState("MD");
    account.setStatus("Status");
    account.setUsername("janedoe");
    account.setZip("21654");

    Product product = new Product();
    product.setCategoryId("42");
    product.setDescription("The characteristics of someone or something");
    product.setName("Bella");
    product.setProductId("42");

    Item item = new Item();
    item.setAttribute1("999 9999 9999 9999");
    item.setAttribute2("999 9999 9999 9999");
    item.setAttribute3("999 9999 9999 9999");
    item.setAttribute4("999 9999 9999 9999");
    item.setAttribute5("999 9999 9999 9999");
    item.setItemId("42");
    BigDecimal listPrice = new BigDecimal("2.3");
    item.setListPrice(listPrice);
    item.setProduct(product);
    item.setQuantity(1);
    item.setStatus("999 9999 9999 9999");
    item.setSupplierId(1);
    item.setUnitCost(new BigDecimal("2.3"));

    Cart cart = new Cart();
    cart.addItem(item, true);

    // Act
    order.initOrder(account, cart);

    // Assert
    List<LineItem> lineItems = order.getLineItems();
    assertEquals(1, lineItems.size());
    LineItem getResult = lineItems.get(0);
    assertEquals("42", getResult.getItemId());
    assertEquals(0, getResult.getOrderId());
    assertEquals(1, getResult.getLineNumber());
    assertEquals(1, getResult.getQuantity());
    assertEquals(new BigDecimal("2.3"), getResult.getTotal());
    assertEquals(new BigDecimal("2.3"), order.getTotalPrice());
    assertSame(listPrice, getResult.getUnitPrice());
    assertSame(item, getResult.getItem());
  }

  /**
   * Test {@link Order#initOrder(Account, Cart)}.
   *
   * <ul>
   * <li>When {@link Cart} (default constructor).
   * <li>Then {@link Order} (default constructor) ExpiryDate is {@code 12/03}.
   * </ul>
   *
   * <p>
   * Method under test: {@link Order#initOrder(Account, Cart)}
   */
  @Test
  @DisplayName("Test initOrder(Account, Cart); when Cart (default constructor); then Order (default constructor) ExpiryDate is '12/03'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Order.initOrder(Account, Cart)" })
  void testInitOrder_whenCart_thenOrderExpiryDateIs1203() {
    // Arrange
    Order order = new Order();

    Account account = new Account();
    account.setAddress1("42 Main St");
    account.setAddress2("42 Main St");
    account.setBannerName("Bella");
    account.setBannerOption(true);
    account.setCity("Oxford");
    account.setCountry("GB");
    account.setEmail("jane.doe@example.org");
    account.setFavouriteCategoryId("42");
    account.setFirstName("Jane");
    account.setLanguagePreference("en");
    account.setLastName("Doe");
    account.setListOption(true);
    account.setPassword("iloveyou");
    account.setPhone("6625550144");
    account.setState("MD");
    account.setStatus("Status");
    account.setUsername("janedoe");
    account.setZip("21654");

    // Act
    order.initOrder(account, new Cart());

    // Assert
    assertEquals("12/03", order.getExpiryDate());
    assertEquals("21654", order.getBillZip());
    assertEquals("21654", order.getShipZip());
    assertEquals("42 Main St", order.getBillAddress1());
    assertEquals("42 Main St", order.getBillAddress2());
    assertEquals("42 Main St", order.getShipAddress1());
    assertEquals("42 Main St", order.getShipAddress2());
    assertEquals("999 9999 9999 9999", order.getCreditCard());
    assertEquals("CA", order.getLocale());
    assertEquals("Doe", order.getBillToLastName());
    assertEquals("Doe", order.getShipToLastName());
    assertEquals("GB", order.getBillCountry());
    assertEquals("GB", order.getShipCountry());
    assertEquals("Jane", order.getBillToFirstName());
    assertEquals("Jane", order.getShipToFirstName());
    assertEquals("MD", order.getBillState());
    assertEquals("MD", order.getShipState());
    assertEquals("Oxford", order.getBillCity());
    assertEquals("Oxford", order.getShipCity());
    assertEquals("P", order.getStatus());
    assertEquals("UPS", order.getCourier());
    assertEquals("Visa", order.getCardType());
    assertEquals("janedoe", order.getUsername());
    assertTrue(order.getLineItems().isEmpty());
  }

  /**
   * Test {@link Order#addLineItem(CartItem)} with {@code cartItem}.
   *
   * <ul>
   * <li>Then {@link Order} (default constructor) LineItems first Total is {@code null}.
   * </ul>
   *
   * <p>
   * Method under test: {@link Order#addLineItem(CartItem)}
   */
  @Test
  @DisplayName("Test addLineItem(CartItem) with 'cartItem'; then Order (default constructor) LineItems first Total is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Order.addLineItem(CartItem)" })
  void testAddLineItemWithCartItem_thenOrderLineItemsFirstTotalIsNull() {
    // Arrange
    Order order = new Order();

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
    order.addLineItem(cartItem);

    // Assert
    List<LineItem> lineItems = order.getLineItems();
    assertEquals(1, lineItems.size());
    LineItem getResult = lineItems.get(0);
    assertEquals("42", getResult.getItemId());
    assertNull(getResult.getTotal());
    assertNull(getResult.getUnitPrice());
    assertEquals(0, getResult.getOrderId());
    assertEquals(0, getResult.getQuantity());
    assertEquals(1, getResult.getLineNumber());
    assertSame(item, getResult.getItem());
  }

  /**
   * Test {@link Order#addLineItem(CartItem)} with {@code cartItem}.
   *
   * <ul>
   * <li>Then {@link Order} (default constructor) LineItems first UnitPrice is {@link BigDecimal#BigDecimal(String)}
   * with {@code 2.3}.
   * </ul>
   *
   * <p>
   * Method under test: {@link Order#addLineItem(CartItem)}
   */
  @Test
  @DisplayName("Test addLineItem(CartItem) with 'cartItem'; then Order (default constructor) LineItems first UnitPrice is BigDecimal(String) with '2.3'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Order.addLineItem(CartItem)" })
  void testAddLineItemWithCartItem_thenOrderLineItemsFirstUnitPriceIsBigDecimalWith23() {
    // Arrange
    Order order = new Order();

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
    order.addLineItem(cartItem);

    // Assert
    List<LineItem> lineItems = order.getLineItems();
    assertEquals(1, lineItems.size());
    LineItem getResult = lineItems.get(0);
    assertEquals("42", getResult.getItemId());
    assertEquals(0, getResult.getOrderId());
    assertEquals(0, getResult.getQuantity());
    assertEquals(1, getResult.getLineNumber());
    assertSame(listPrice, getResult.getUnitPrice());
    assertSame(item, getResult.getItem());
  }

  /**
   * Test {@link Order#addLineItem(LineItem)} with {@code lineItem}.
   *
   * <p>
   * Method under test: {@link Order#addLineItem(LineItem)}
   */
  @Test
  @DisplayName("Test addLineItem(LineItem) with 'lineItem'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Order.addLineItem(LineItem)" })
  void testAddLineItemWithLineItem() {
    // Arrange
    Order order = new Order();
    LineItem lineItem = new LineItem();

    // Act
    order.addLineItem(lineItem);

    // Assert
    List<LineItem> lineItems = order.getLineItems();
    assertEquals(1, lineItems.size());
    assertSame(lineItem, lineItems.get(0));
  }

  /**
   * Test getters and setters.
   *
   * <p>
   * Methods under test:
   *
   * <ul>
   * <li>default or parameterless constructor of {@link Order}
   * <li>{@link Order#setBillAddress1(String)}
   * <li>{@link Order#setBillAddress2(String)}
   * <li>{@link Order#setBillCity(String)}
   * <li>{@link Order#setBillCountry(String)}
   * <li>{@link Order#setBillState(String)}
   * <li>{@link Order#setBillToFirstName(String)}
   * <li>{@link Order#setBillToLastName(String)}
   * <li>{@link Order#setBillZip(String)}
   * <li>{@link Order#setCardType(String)}
   * <li>{@link Order#setCourier(String)}
   * <li>{@link Order#setCreditCard(String)}
   * <li>{@link Order#setExpiryDate(String)}
   * <li>{@link Order#setLineItems(List)}
   * <li>{@link Order#setLocale(String)}
   * <li>{@link Order#setOrderDate(Date)}
   * <li>{@link Order#setOrderId(int)}
   * <li>{@link Order#setShipAddress1(String)}
   * <li>{@link Order#setShipAddress2(String)}
   * <li>{@link Order#setShipCity(String)}
   * <li>{@link Order#setShipCountry(String)}
   * <li>{@link Order#setShipState(String)}
   * <li>{@link Order#setShipToFirstName(String)}
   * <li>{@link Order#setShipToLastName(String)}
   * <li>{@link Order#setShipZip(String)}
   * <li>{@link Order#setStatus(String)}
   * <li>{@link Order#setTotalPrice(BigDecimal)}
   * <li>{@link Order#setUsername(String)}
   * <li>{@link Order#getBillAddress1()}
   * <li>{@link Order#getBillAddress2()}
   * <li>{@link Order#getBillCity()}
   * <li>{@link Order#getBillCountry()}
   * <li>{@link Order#getBillState()}
   * <li>{@link Order#getBillToFirstName()}
   * <li>{@link Order#getBillToLastName()}
   * <li>{@link Order#getBillZip()}
   * <li>{@link Order#getCardType()}
   * <li>{@link Order#getCourier()}
   * <li>{@link Order#getCreditCard()}
   * <li>{@link Order#getExpiryDate()}
   * <li>{@link Order#getLineItems()}
   * <li>{@link Order#getLocale()}
   * <li>{@link Order#getOrderDate()}
   * <li>{@link Order#getOrderId()}
   * <li>{@link Order#getShipAddress1()}
   * <li>{@link Order#getShipAddress2()}
   * <li>{@link Order#getShipCity()}
   * <li>{@link Order#getShipCountry()}
   * <li>{@link Order#getShipState()}
   * <li>{@link Order#getShipToFirstName()}
   * <li>{@link Order#getShipToLastName()}
   * <li>{@link Order#getShipZip()}
   * <li>{@link Order#getStatus()}
   * <li>{@link Order#getTotalPrice()}
   * <li>{@link Order#getUsername()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Order.<init>()", "String Order.getBillAddress1()", "String Order.getBillAddress2()",
      "String Order.getBillCity()", "String Order.getBillCountry()", "String Order.getBillState()",
      "String Order.getBillToFirstName()", "String Order.getBillToLastName()", "String Order.getBillZip()",
      "String Order.getCardType()", "String Order.getCourier()", "String Order.getCreditCard()",
      "String Order.getExpiryDate()", "List Order.getLineItems()", "String Order.getLocale()",
      "Date Order.getOrderDate()", "int Order.getOrderId()", "String Order.getShipAddress1()",
      "String Order.getShipAddress2()", "String Order.getShipCity()", "String Order.getShipCountry()",
      "String Order.getShipState()", "String Order.getShipToFirstName()", "String Order.getShipToLastName()",
      "String Order.getShipZip()", "String Order.getStatus()", "BigDecimal Order.getTotalPrice()",
      "String Order.getUsername()", "void Order.setBillAddress1(String)", "void Order.setBillAddress2(String)",
      "void Order.setBillCity(String)", "void Order.setBillCountry(String)", "void Order.setBillState(String)",
      "void Order.setBillToFirstName(String)", "void Order.setBillToLastName(String)", "void Order.setBillZip(String)",
      "void Order.setCardType(String)", "void Order.setCourier(String)", "void Order.setCreditCard(String)",
      "void Order.setExpiryDate(String)", "void Order.setLineItems(List)", "void Order.setLocale(String)",
      "void Order.setOrderDate(Date)", "void Order.setOrderId(int)", "void Order.setShipAddress1(String)",
      "void Order.setShipAddress2(String)", "void Order.setShipCity(String)", "void Order.setShipCountry(String)",
      "void Order.setShipState(String)", "void Order.setShipToFirstName(String)",
      "void Order.setShipToLastName(String)", "void Order.setShipZip(String)", "void Order.setStatus(String)",
      "void Order.setTotalPrice(BigDecimal)", "void Order.setUsername(String)" })
  void testGettersAndSetters() {
    // Arrange and Act
    Order actualOrder = new Order();
    actualOrder.setBillAddress1("42 Main St");
    actualOrder.setBillAddress2("42 Main St");
    actualOrder.setBillCity("Bill City");
    actualOrder.setBillCountry("GB");
    actualOrder.setBillState("Bill State");
    actualOrder.setBillToFirstName("Jane");
    actualOrder.setBillToLastName("Doe");
    actualOrder.setBillZip("127.0.0.1");
    actualOrder.setCardType("Card Type");
    actualOrder.setCourier("Courier");
    actualOrder.setCreditCard("Credit Card");
    actualOrder.setExpiryDate("2020-03-01");
    ArrayList<LineItem> lineItems = new ArrayList<>();
    actualOrder.setLineItems(lineItems);
    actualOrder.setLocale("en");
    Date orderDate = Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
    actualOrder.setOrderDate(orderDate);
    actualOrder.setOrderId(1);
    actualOrder.setShipAddress1("42 Main St");
    actualOrder.setShipAddress2("42 Main St");
    actualOrder.setShipCity("Ship City");
    actualOrder.setShipCountry("GB");
    actualOrder.setShipState("Ship State");
    actualOrder.setShipToFirstName("Jane");
    actualOrder.setShipToLastName("Doe");
    actualOrder.setShipZip("127.0.0.1");
    actualOrder.setStatus("Status");
    BigDecimal totalPrice = new BigDecimal("2.3");
    actualOrder.setTotalPrice(totalPrice);
    actualOrder.setUsername("janedoe");
    String actualBillAddress1 = actualOrder.getBillAddress1();
    String actualBillAddress2 = actualOrder.getBillAddress2();
    String actualBillCity = actualOrder.getBillCity();
    String actualBillCountry = actualOrder.getBillCountry();
    String actualBillState = actualOrder.getBillState();
    String actualBillToFirstName = actualOrder.getBillToFirstName();
    String actualBillToLastName = actualOrder.getBillToLastName();
    actualOrder.getBillZip();
    String actualCardType = actualOrder.getCardType();
    String actualCourier = actualOrder.getCourier();
    String actualCreditCard = actualOrder.getCreditCard();
    String actualExpiryDate = actualOrder.getExpiryDate();
    List<LineItem> actualLineItems = actualOrder.getLineItems();
    String actualLocale = actualOrder.getLocale();
    Date actualOrderDate = actualOrder.getOrderDate();
    int actualOrderId = actualOrder.getOrderId();
    String actualShipAddress1 = actualOrder.getShipAddress1();
    String actualShipAddress2 = actualOrder.getShipAddress2();
    String actualShipCity = actualOrder.getShipCity();
    String actualShipCountry = actualOrder.getShipCountry();
    String actualShipState = actualOrder.getShipState();
    String actualShipToFirstName = actualOrder.getShipToFirstName();
    String actualShipToLastName = actualOrder.getShipToLastName();
    actualOrder.getShipZip();
    String actualStatus = actualOrder.getStatus();
    BigDecimal actualTotalPrice = actualOrder.getTotalPrice();

    // Assert
    assertEquals("2020-03-01", actualExpiryDate);
    assertEquals("42 Main St", actualBillAddress1);
    assertEquals("42 Main St", actualBillAddress2);
    assertEquals("42 Main St", actualShipAddress1);
    assertEquals("42 Main St", actualShipAddress2);
    assertEquals("Bill City", actualBillCity);
    assertEquals("Bill State", actualBillState);
    assertEquals("Card Type", actualCardType);
    assertEquals("Courier", actualCourier);
    assertEquals("Credit Card", actualCreditCard);
    assertEquals("Doe", actualBillToLastName);
    assertEquals("Doe", actualShipToLastName);
    assertEquals("GB", actualBillCountry);
    assertEquals("GB", actualShipCountry);
    assertEquals("Jane", actualBillToFirstName);
    assertEquals("Jane", actualShipToFirstName);
    assertEquals("Ship City", actualShipCity);
    assertEquals("Ship State", actualShipState);
    assertEquals("Status", actualStatus);
    assertEquals("en", actualLocale);
    assertEquals("janedoe", actualOrder.getUsername());
    assertEquals(1, actualOrderId);
    assertTrue(actualLineItems.isEmpty());
    assertEquals(new BigDecimal("2.3"), actualTotalPrice);
    assertSame(totalPrice, actualTotalPrice);
    assertSame(lineItems, actualLineItems);
    assertSame(orderDate, actualOrderDate);
  }
}
