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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
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
import org.mybatis.jpetstore.domain.Item;
import org.mybatis.jpetstore.domain.LineItem;
import org.mybatis.jpetstore.domain.Order;
import org.mybatis.jpetstore.domain.Product;
import org.mybatis.jpetstore.domain.Sequence;
import org.mybatis.jpetstore.mapper.ItemMapper;
import org.mybatis.jpetstore.mapper.LineItemMapper;
import org.mybatis.jpetstore.mapper.OrderMapper;
import org.mybatis.jpetstore.mapper.SequenceMapper;

class OrderServiceDiffblueTest {
  /**
   * Test {@link OrderService#insertOrder(Order)}.
   *
   * <ul>
   * <li>Given {@link OrderMapper} {@link OrderMapper#insertOrder(Order)} does nothing.
   * <li>Then {@link Order} (default constructor) OrderId is one.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#insertOrder(Order)}
   */
  @Test
  @DisplayName("Test insertOrder(Order); given OrderMapper insertOrder(Order) does nothing; then Order (default constructor) OrderId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void OrderService.insertOrder(Order)" })
  void testInsertOrder_givenOrderMapperInsertOrderDoesNothing_thenOrderOrderIdIsOne() {
    // Arrange
    OrderMapper orderMapper = mock(OrderMapper.class);
    doNothing().when(orderMapper).insertOrder(Mockito.<Order> any());
    doNothing().when(orderMapper).insertOrderStatus(Mockito.<Order> any());

    SequenceMapper sequenceMapper = mock(SequenceMapper.class);
    doNothing().when(sequenceMapper).updateSequence(Mockito.<Sequence> any());
    when(sequenceMapper.getSequence(Mockito.<Sequence> any())).thenReturn(new Sequence("Bella", 1));

    OrderService orderService = new OrderService(mock(ItemMapper.class), orderMapper, sequenceMapper,
        mock(LineItemMapper.class));
    Order order = new Order();

    // Act
    orderService.insertOrder(order);

    // Assert
    verify(orderMapper).insertOrder(isA(Order.class));
    verify(orderMapper).insertOrderStatus(isA(Order.class));
    verify(sequenceMapper).getSequence(isA(Sequence.class));
    verify(sequenceMapper).updateSequence(isA(Sequence.class));
    assertEquals(1, order.getOrderId());
  }

  /**
   * Test {@link OrderService#insertOrder(Order)}.
   *
   * <ul>
   * <li>Given {@link OrderMapper} {@link OrderMapper#insertOrder(Order)} throw
   * {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#insertOrder(Order)}
   */
  @Test
  @DisplayName("Test insertOrder(Order); given OrderMapper insertOrder(Order) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void OrderService.insertOrder(Order)" })
  void testInsertOrder_givenOrderMapperInsertOrderThrowRuntimeException() {
    // Arrange
    OrderMapper orderMapper = mock(OrderMapper.class);
    doThrow(new RuntimeException()).when(orderMapper).insertOrder(Mockito.<Order> any());

    SequenceMapper sequenceMapper = mock(SequenceMapper.class);
    doNothing().when(sequenceMapper).updateSequence(Mockito.<Sequence> any());
    when(sequenceMapper.getSequence(Mockito.<Sequence> any())).thenReturn(new Sequence("Bella", 1));

    OrderService orderService = new OrderService(mock(ItemMapper.class), orderMapper, sequenceMapper,
        mock(LineItemMapper.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderService.insertOrder(new Order()));
    verify(orderMapper).insertOrder(isA(Order.class));
    verify(sequenceMapper).getSequence(isA(Sequence.class));
    verify(sequenceMapper).updateSequence(isA(Sequence.class));
  }

  /**
   * Test {@link OrderService#insertOrder(Order)}.
   *
   * <ul>
   * <li>Given {@link Sequence} {@link Sequence#getNextId()} throw {@link RuntimeException#RuntimeException()}.
   * <li>Then calls {@link Sequence#getNextId()}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#insertOrder(Order)}
   */
  @Test
  @DisplayName("Test insertOrder(Order); given Sequence getNextId() throw RuntimeException(); then calls getNextId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void OrderService.insertOrder(Order)" })
  void testInsertOrder_givenSequenceGetNextIdThrowRuntimeException_thenCallsGetNextId() {
    // Arrange
    Sequence sequence = mock(Sequence.class);
    when(sequence.getNextId()).thenThrow(new RuntimeException());

    SequenceMapper sequenceMapper = mock(SequenceMapper.class);
    when(sequenceMapper.getSequence(Mockito.<Sequence> any())).thenReturn(sequence);
    OrderService orderService = new OrderService(mock(ItemMapper.class), mock(OrderMapper.class), sequenceMapper,
        mock(LineItemMapper.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderService.insertOrder(new Order()));
    verify(sequence).getNextId();
    verify(sequenceMapper).getSequence(isA(Sequence.class));
  }

  /**
   * Test {@link OrderService#insertOrder(Order)}.
   *
   * <ul>
   * <li>Given {@link SequenceMapper} {@link SequenceMapper#getSequence(Sequence)} return {@code
   *       null}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#insertOrder(Order)}
   */
  @Test
  @DisplayName("Test insertOrder(Order); given SequenceMapper getSequence(Sequence) return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void OrderService.insertOrder(Order)" })
  void testInsertOrder_givenSequenceMapperGetSequenceReturnNull() {
    // Arrange
    SequenceMapper sequenceMapper = mock(SequenceMapper.class);
    when(sequenceMapper.getSequence(Mockito.<Sequence> any())).thenReturn(null);
    OrderService orderService = new OrderService(mock(ItemMapper.class), mock(OrderMapper.class), sequenceMapper,
        mock(LineItemMapper.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderService.insertOrder(new Order()));
    verify(sequenceMapper).getSequence(isA(Sequence.class));
  }

  /**
   * Test {@link OrderService#insertOrder(Order)}.
   *
   * <ul>
   * <li>Given {@link SequenceMapper} {@link SequenceMapper#getSequence(Sequence)} throw
   * {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#insertOrder(Order)}
   */
  @Test
  @DisplayName("Test insertOrder(Order); given SequenceMapper getSequence(Sequence) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void OrderService.insertOrder(Order)" })
  void testInsertOrder_givenSequenceMapperGetSequenceThrowRuntimeException() {
    // Arrange
    SequenceMapper sequenceMapper = mock(SequenceMapper.class);
    when(sequenceMapper.getSequence(Mockito.<Sequence> any())).thenThrow(new RuntimeException());
    OrderService orderService = new OrderService(mock(ItemMapper.class), mock(OrderMapper.class), sequenceMapper,
        mock(LineItemMapper.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderService.insertOrder(new Order()));
    verify(sequenceMapper).getSequence(isA(Sequence.class));
  }

  /**
   * Test {@link OrderService#insertOrder(Order)}.
   *
   * <ul>
   * <li>Given {@link SequenceMapper} {@link SequenceMapper#updateSequence(Sequence)} throw
   * {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#insertOrder(Order)}
   */
  @Test
  @DisplayName("Test insertOrder(Order); given SequenceMapper updateSequence(Sequence) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void OrderService.insertOrder(Order)" })
  void testInsertOrder_givenSequenceMapperUpdateSequenceThrowRuntimeException() {
    // Arrange
    SequenceMapper sequenceMapper = mock(SequenceMapper.class);
    doThrow(new RuntimeException()).when(sequenceMapper).updateSequence(Mockito.<Sequence> any());
    when(sequenceMapper.getSequence(Mockito.<Sequence> any())).thenReturn(new Sequence("Bella", 1));
    OrderService orderService = new OrderService(mock(ItemMapper.class), mock(OrderMapper.class), sequenceMapper,
        mock(LineItemMapper.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderService.insertOrder(new Order()));
    verify(sequenceMapper).getSequence(isA(Sequence.class));
    verify(sequenceMapper).updateSequence(isA(Sequence.class));
  }

  /**
   * Test {@link OrderService#getOrder(int)}.
   *
   * <ul>
   * <li>Given {@link ItemMapper} {@link ItemMapper#getItem(String)} throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#getOrder(int)}
   */
  @Test
  @DisplayName("Test getOrder(int); given ItemMapper getItem(String) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Order OrderService.getOrder(int)" })
  void testGetOrder_givenItemMapperGetItemThrowRuntimeException() {
    // Arrange
    ItemMapper itemMapper = mock(ItemMapper.class);
    when(itemMapper.getItem(Mockito.<String> any())).thenThrow(new RuntimeException());

    OrderMapper orderMapper = mock(OrderMapper.class);
    when(orderMapper.getOrder(anyInt())).thenReturn(new Order());

    ArrayList<LineItem> lineItemList = new ArrayList<>();
    lineItemList.add(new LineItem());

    LineItemMapper lineItemMapper = mock(LineItemMapper.class);
    when(lineItemMapper.getLineItemsByOrderId(anyInt())).thenReturn(lineItemList);

    OrderService orderService = new OrderService(itemMapper, orderMapper, mock(SequenceMapper.class), lineItemMapper);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderService.getOrder(1));
    verify(itemMapper).getItem(null);
    verify(lineItemMapper).getLineItemsByOrderId(1);
    verify(orderMapper).getOrder(1);
  }

  /**
   * Test {@link OrderService#getOrder(int)}.
   *
   * <ul>
   * <li>Given {@link LineItemMapper} {@link LineItemMapper#getLineItemsByOrderId(int)} throw
   * {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#getOrder(int)}
   */
  @Test
  @DisplayName("Test getOrder(int); given LineItemMapper getLineItemsByOrderId(int) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Order OrderService.getOrder(int)" })
  void testGetOrder_givenLineItemMapperGetLineItemsByOrderIdThrowRuntimeException() {
    // Arrange
    OrderMapper orderMapper = mock(OrderMapper.class);
    when(orderMapper.getOrder(anyInt())).thenReturn(new Order());

    LineItemMapper lineItemMapper = mock(LineItemMapper.class);
    when(lineItemMapper.getLineItemsByOrderId(anyInt())).thenThrow(new RuntimeException());

    OrderService orderService = new OrderService(mock(ItemMapper.class), orderMapper, mock(SequenceMapper.class),
        lineItemMapper);

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderService.getOrder(1));
    verify(lineItemMapper).getLineItemsByOrderId(1);
    verify(orderMapper).getOrder(1);
  }

  /**
   * Test {@link OrderService#getOrder(int)}.
   *
   * <ul>
   * <li>Given {@link OrderMapper} {@link OrderMapper#getOrder(int)} return {@link Order} (default constructor).
   * <li>Then return {@link Order} (default constructor).
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#getOrder(int)}
   */
  @Test
  @DisplayName("Test getOrder(int); given OrderMapper getOrder(int) return Order (default constructor); then return Order (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Order OrderService.getOrder(int)" })
  void testGetOrder_givenOrderMapperGetOrderReturnOrder_thenReturnOrder() {
    // Arrange
    OrderMapper orderMapper = mock(OrderMapper.class);
    Order order = new Order();
    when(orderMapper.getOrder(anyInt())).thenReturn(order);

    LineItemMapper lineItemMapper = mock(LineItemMapper.class);
    when(lineItemMapper.getLineItemsByOrderId(anyInt())).thenReturn(new ArrayList<>());

    OrderService orderService = new OrderService(mock(ItemMapper.class), orderMapper, mock(SequenceMapper.class),
        lineItemMapper);

    // Act
    Order actualOrder = orderService.getOrder(1);

    // Assert
    verify(lineItemMapper).getLineItemsByOrderId(1);
    verify(orderMapper).getOrder(1);
    assertSame(order, actualOrder);
  }

  /**
   * Test {@link OrderService#getOrder(int)}.
   *
   * <ul>
   * <li>Given {@link OrderMapper} {@link OrderMapper#getOrder(int)} throw {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#getOrder(int)}
   */
  @Test
  @DisplayName("Test getOrder(int); given OrderMapper getOrder(int) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Order OrderService.getOrder(int)" })
  void testGetOrder_givenOrderMapperGetOrderThrowRuntimeException() {
    // Arrange
    OrderMapper orderMapper = mock(OrderMapper.class);
    when(orderMapper.getOrder(anyInt())).thenThrow(new RuntimeException());
    OrderService orderService = new OrderService(mock(ItemMapper.class), orderMapper, mock(SequenceMapper.class),
        mock(LineItemMapper.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderService.getOrder(1));
    verify(orderMapper).getOrder(1);
  }

  /**
   * Test {@link OrderService#getOrder(int)}.
   *
   * <ul>
   * <li>Given {@link Product} (default constructor) CategoryId is {@code 42}.
   * <li>Then return LineItems is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#getOrder(int)}
   */
  @Test
  @DisplayName("Test getOrder(int); given Product (default constructor) CategoryId is '42'; then return LineItems is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Order OrderService.getOrder(int)" })
  void testGetOrder_givenProductCategoryIdIs42_thenReturnLineItemsIsArrayList() {
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
    when(itemMapper.getInventoryQuantity(Mockito.<String> any())).thenReturn(1);
    when(itemMapper.getItem(Mockito.<String> any())).thenReturn(item);

    OrderMapper orderMapper = mock(OrderMapper.class);
    when(orderMapper.getOrder(anyInt())).thenReturn(new Order());

    ArrayList<LineItem> lineItemList = new ArrayList<>();
    lineItemList.add(new LineItem());

    LineItemMapper lineItemMapper = mock(LineItemMapper.class);
    when(lineItemMapper.getLineItemsByOrderId(anyInt())).thenReturn(lineItemList);

    OrderService orderService = new OrderService(itemMapper, orderMapper, mock(SequenceMapper.class), lineItemMapper);

    // Act
    Order actualOrder = orderService.getOrder(1);

    // Assert
    verify(itemMapper).getInventoryQuantity(null);
    verify(itemMapper).getItem(null);
    verify(lineItemMapper).getLineItemsByOrderId(1);
    verify(orderMapper).getOrder(1);
    assertSame(lineItemList, actualOrder.getLineItems());
  }

  /**
   * Test {@link OrderService#getOrder(int)}.
   *
   * <ul>
   * <li>Given {@link Product} (default constructor) CategoryId is {@code 42}.
   * <li>Then return LineItems size is two.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#getOrder(int)}
   */
  @Test
  @DisplayName("Test getOrder(int); given Product (default constructor) CategoryId is '42'; then return LineItems size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Order OrderService.getOrder(int)" })
  void testGetOrder_givenProductCategoryIdIs42_thenReturnLineItemsSizeIsTwo() {
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
    when(itemMapper.getInventoryQuantity(Mockito.<String> any())).thenReturn(1);
    when(itemMapper.getItem(Mockito.<String> any())).thenReturn(item);

    OrderMapper orderMapper = mock(OrderMapper.class);
    when(orderMapper.getOrder(anyInt())).thenReturn(new Order());

    ArrayList<LineItem> lineItemList = new ArrayList<>();
    lineItemList.add(new LineItem());
    LineItem lineItem = new LineItem();
    lineItemList.add(lineItem);

    LineItemMapper lineItemMapper = mock(LineItemMapper.class);
    when(lineItemMapper.getLineItemsByOrderId(anyInt())).thenReturn(lineItemList);

    OrderService orderService = new OrderService(itemMapper, orderMapper, mock(SequenceMapper.class), lineItemMapper);

    // Act
    Order actualOrder = orderService.getOrder(1);

    // Assert
    verify(itemMapper, atLeast(1)).getInventoryQuantity(null);
    verify(itemMapper, atLeast(1)).getItem(null);
    verify(lineItemMapper).getLineItemsByOrderId(1);
    verify(orderMapper).getOrder(1);
    List<LineItem> lineItems = actualOrder.getLineItems();
    assertEquals(2, lineItems.size());
    assertSame(lineItem, lineItems.get(1));
  }

  /**
   * Test {@link OrderService#getOrdersByUsername(String)}.
   *
   * <ul>
   * <li>Then return Empty.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#getOrdersByUsername(String)}
   */
  @Test
  @DisplayName("Test getOrdersByUsername(String); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "List OrderService.getOrdersByUsername(String)" })
  void testGetOrdersByUsername_thenReturnEmpty() {
    // Arrange
    OrderMapper orderMapper = mock(OrderMapper.class);
    when(orderMapper.getOrdersByUsername(Mockito.<String> any())).thenReturn(new ArrayList<>());
    OrderService orderService = new OrderService(mock(ItemMapper.class), orderMapper, mock(SequenceMapper.class),
        mock(LineItemMapper.class));

    // Act
    List<Order> actualOrdersByUsername = orderService.getOrdersByUsername("janedoe");

    // Assert
    verify(orderMapper).getOrdersByUsername("janedoe");
    assertTrue(actualOrdersByUsername.isEmpty());
  }

  /**
   * Test {@link OrderService#getOrdersByUsername(String)}.
   *
   * <ul>
   * <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#getOrdersByUsername(String)}
   */
  @Test
  @DisplayName("Test getOrdersByUsername(String); then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "List OrderService.getOrdersByUsername(String)" })
  void testGetOrdersByUsername_thenThrowRuntimeException() {
    // Arrange
    OrderMapper orderMapper = mock(OrderMapper.class);
    when(orderMapper.getOrdersByUsername(Mockito.<String> any())).thenThrow(new RuntimeException());
    OrderService orderService = new OrderService(mock(ItemMapper.class), orderMapper, mock(SequenceMapper.class),
        mock(LineItemMapper.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderService.getOrdersByUsername("janedoe"));
    verify(orderMapper).getOrdersByUsername("janedoe");
  }

  /**
   * Test {@link OrderService#getNextId(String)}.
   *
   * <ul>
   * <li>Given {@link Sequence} {@link Sequence#getNextId()} throw {@link RuntimeException#RuntimeException()}.
   * <li>Then calls {@link Sequence#getNextId()}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#getNextId(String)}
   */
  @Test
  @DisplayName("Test getNextId(String); given Sequence getNextId() throw RuntimeException(); then calls getNextId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "int OrderService.getNextId(String)" })
  void testGetNextId_givenSequenceGetNextIdThrowRuntimeException_thenCallsGetNextId() {
    // Arrange
    Sequence sequence = mock(Sequence.class);
    when(sequence.getNextId()).thenThrow(new RuntimeException());

    SequenceMapper sequenceMapper = mock(SequenceMapper.class);
    when(sequenceMapper.getSequence(Mockito.<Sequence> any())).thenReturn(sequence);
    OrderService orderService = new OrderService(mock(ItemMapper.class), mock(OrderMapper.class), sequenceMapper,
        mock(LineItemMapper.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderService.getNextId("Bella"));
    verify(sequence).getNextId();
    verify(sequenceMapper).getSequence(isA(Sequence.class));
  }

  /**
   * Test {@link OrderService#getNextId(String)}.
   *
   * <ul>
   * <li>Given {@link SequenceMapper} {@link SequenceMapper#getSequence(Sequence)} return {@code
   *       null}.
   * <li>Then throw {@link RuntimeException}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#getNextId(String)}
   */
  @Test
  @DisplayName("Test getNextId(String); given SequenceMapper getSequence(Sequence) return 'null'; then throw RuntimeException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "int OrderService.getNextId(String)" })
  void testGetNextId_givenSequenceMapperGetSequenceReturnNull_thenThrowRuntimeException() {
    // Arrange
    SequenceMapper sequenceMapper = mock(SequenceMapper.class);
    when(sequenceMapper.getSequence(Mockito.<Sequence> any())).thenReturn(null);
    OrderService orderService = new OrderService(mock(ItemMapper.class), mock(OrderMapper.class), sequenceMapper,
        mock(LineItemMapper.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderService.getNextId("Bella"));
    verify(sequenceMapper).getSequence(isA(Sequence.class));
  }

  /**
   * Test {@link OrderService#getNextId(String)}.
   *
   * <ul>
   * <li>Given {@link SequenceMapper} {@link SequenceMapper#getSequence(Sequence)} throw
   * {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#getNextId(String)}
   */
  @Test
  @DisplayName("Test getNextId(String); given SequenceMapper getSequence(Sequence) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "int OrderService.getNextId(String)" })
  void testGetNextId_givenSequenceMapperGetSequenceThrowRuntimeException() {
    // Arrange
    SequenceMapper sequenceMapper = mock(SequenceMapper.class);
    when(sequenceMapper.getSequence(Mockito.<Sequence> any())).thenThrow(new RuntimeException());
    OrderService orderService = new OrderService(mock(ItemMapper.class), mock(OrderMapper.class), sequenceMapper,
        mock(LineItemMapper.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderService.getNextId("Bella"));
    verify(sequenceMapper).getSequence(isA(Sequence.class));
  }

  /**
   * Test {@link OrderService#getNextId(String)}.
   *
   * <ul>
   * <li>Given {@link SequenceMapper} {@link SequenceMapper#updateSequence(Sequence)} does nothing.
   * <li>Then return one.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#getNextId(String)}
   */
  @Test
  @DisplayName("Test getNextId(String); given SequenceMapper updateSequence(Sequence) does nothing; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "int OrderService.getNextId(String)" })
  void testGetNextId_givenSequenceMapperUpdateSequenceDoesNothing_thenReturnOne() {
    // Arrange
    SequenceMapper sequenceMapper = mock(SequenceMapper.class);
    doNothing().when(sequenceMapper).updateSequence(Mockito.<Sequence> any());
    when(sequenceMapper.getSequence(Mockito.<Sequence> any())).thenReturn(new Sequence("Bella", 1));
    OrderService orderService = new OrderService(mock(ItemMapper.class), mock(OrderMapper.class), sequenceMapper,
        mock(LineItemMapper.class));

    // Act
    int actualNextId = orderService.getNextId("Bella");

    // Assert
    verify(sequenceMapper).getSequence(isA(Sequence.class));
    verify(sequenceMapper).updateSequence(isA(Sequence.class));
    assertEquals(1, actualNextId);
  }

  /**
   * Test {@link OrderService#getNextId(String)}.
   *
   * <ul>
   * <li>Given {@link SequenceMapper} {@link SequenceMapper#updateSequence(Sequence)} throw
   * {@link RuntimeException#RuntimeException()}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderService#getNextId(String)}
   */
  @Test
  @DisplayName("Test getNextId(String); given SequenceMapper updateSequence(Sequence) throw RuntimeException()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "int OrderService.getNextId(String)" })
  void testGetNextId_givenSequenceMapperUpdateSequenceThrowRuntimeException() {
    // Arrange
    SequenceMapper sequenceMapper = mock(SequenceMapper.class);
    doThrow(new RuntimeException()).when(sequenceMapper).updateSequence(Mockito.<Sequence> any());
    when(sequenceMapper.getSequence(Mockito.<Sequence> any())).thenReturn(new Sequence("Bella", 1));
    OrderService orderService = new OrderService(mock(ItemMapper.class), mock(OrderMapper.class), sequenceMapper,
        mock(LineItemMapper.class));

    // Act and Assert
    assertThrows(RuntimeException.class, () -> orderService.getNextId("Bella"));
    verify(sequenceMapper).getSequence(isA(Sequence.class));
    verify(sequenceMapper).updateSequence(isA(Sequence.class));
  }
}
