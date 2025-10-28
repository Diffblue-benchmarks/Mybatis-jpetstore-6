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
import java.util.List;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.validation.ValidationErrors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mybatis.jpetstore.domain.Order;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;

class OrderActionBeanDiffblueTest {
  /**
   * Test {@link OrderActionBean#getOrderId()}.
   *
   * <p>
   * Method under test: {@link OrderActionBean#getOrderId()}
   */
  @Test
  @DisplayName("Test getOrderId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "int OrderActionBean.getOrderId()" })
  void testGetOrderId() {
    // Arrange, Act and Assert
    assertEquals(0, new OrderActionBean().getOrderId());
  }

  /**
   * Test {@link OrderActionBean#setOrderId(int)}.
   *
   * <ul>
   * <li>Given {@link OrderActionBean} (default constructor).
   * <li>Then {@link OrderActionBean} (default constructor) Order OrderId is one.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderActionBean#setOrderId(int)}
   */
  @Test
  @DisplayName("Test setOrderId(int); given OrderActionBean (default constructor); then OrderActionBean (default constructor) Order OrderId is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void OrderActionBean.setOrderId(int)" })
  void testSetOrderId_givenOrderActionBean_thenOrderActionBeanOrderOrderIdIsOne() {
    // Arrange
    OrderActionBean orderActionBean = new OrderActionBean();

    // Act
    orderActionBean.setOrderId(1);

    // Assert
    assertEquals(1, orderActionBean.getOrder().getOrderId());
    assertEquals(1, orderActionBean.getOrderId());
  }

  /**
   * Test getters and setters.
   *
   * <p>
   * Methods under test:
   *
   * <ul>
   * <li>{@link OrderActionBean#setConfirmed(boolean)}
   * <li>{@link OrderActionBean#setOrder(Order)}
   * <li>{@link OrderActionBean#setShippingAddressRequired(boolean)}
   * <li>{@link OrderActionBean#getCreditCardTypes()}
   * <li>{@link OrderActionBean#getOrder()}
   * <li>{@link OrderActionBean#getOrderList()}
   * <li>{@link OrderActionBean#isConfirmed()}
   * <li>{@link OrderActionBean#isShippingAddressRequired()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "List OrderActionBean.getCreditCardTypes()", "Order OrderActionBean.getOrder()",
      "List OrderActionBean.getOrderList()", "boolean OrderActionBean.isConfirmed()",
      "boolean OrderActionBean.isShippingAddressRequired()", "void OrderActionBean.setConfirmed(boolean)",
      "void OrderActionBean.setOrder(Order)", "void OrderActionBean.setShippingAddressRequired(boolean)" })
  void testGettersAndSetters() {
    // Arrange
    OrderActionBean orderActionBean = new OrderActionBean();

    // Act
    orderActionBean.setConfirmed(true);
    Order order = new Order();
    orderActionBean.setOrder(order);
    orderActionBean.setShippingAddressRequired(true);
    List<String> actualCreditCardTypes = orderActionBean.getCreditCardTypes();
    Order actualOrder = orderActionBean.getOrder();
    List<Order> actualOrderList = orderActionBean.getOrderList();
    boolean actualIsConfirmedResult = orderActionBean.isConfirmed();

    // Assert
    assertEquals(3, actualCreditCardTypes.size());
    assertEquals("American Express", actualCreditCardTypes.get(2));
    assertEquals("MasterCard", actualCreditCardTypes.get(1));
    assertEquals("Visa", actualCreditCardTypes.get(0));
    assertNull(actualOrderList);
    assertTrue(actualIsConfirmedResult);
    assertTrue(orderActionBean.isShippingAddressRequired());
    assertSame(order, actualOrder);
  }

  /**
   * Test {@link OrderActionBean#newOrder()}.
   *
   * <ul>
   * <li>Then return Path is {@code /WEB-INF/jsp/order/ConfirmOrder.jsp}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderActionBean#newOrder()}
   */
  @Test
  @DisplayName("Test newOrder(); then return Path is '/WEB-INF/jsp/order/ConfirmOrder.jsp'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Resolution OrderActionBean.newOrder()" })
  void testNewOrder_thenReturnPathIsWebInfJspOrderConfirmOrderJsp() {
    // Arrange
    ActionBeanContext context = new ActionBeanContext();
    context.setEventName("Event Name");
    context.setRequest(new MockHttpServletRequest());
    context.setResponse(new MockHttpServletResponse());
    context.setServletContext(new MockServletContext());
    context.setValidationErrors(new ValidationErrors());

    OrderActionBean orderActionBean = new OrderActionBean();
    orderActionBean.setContext(context);

    // Act
    Resolution actualNewOrderResult = orderActionBean.newOrder();

    // Assert
    assertTrue(actualNewOrderResult instanceof ForwardResolution);
    assertEquals("/WEB-INF/jsp/order/ConfirmOrder.jsp", ((ForwardResolution) actualNewOrderResult).getPath());
    assertNull(((ForwardResolution) actualNewOrderResult).getStatus());
    assertNull(((ForwardResolution) actualNewOrderResult).getEvent());
    assertFalse(((ForwardResolution) actualNewOrderResult).isEventSpecified());
    assertFalse(orderActionBean.isShippingAddressRequired());
    assertTrue(((ForwardResolution) actualNewOrderResult).getParameters().isEmpty());
  }

  /**
   * Test {@link OrderActionBean#newOrder()}.
   *
   * <ul>
   * <li>Then return Path is {@code /WEB-INF/jsp/order/ShippingForm.jsp}.
   * </ul>
   *
   * <p>
   * Method under test: {@link OrderActionBean#newOrder()}
   */
  @Test
  @DisplayName("Test newOrder(); then return Path is '/WEB-INF/jsp/order/ShippingForm.jsp'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Resolution OrderActionBean.newOrder()" })
  void testNewOrder_thenReturnPathIsWebInfJspOrderShippingFormJsp() {
    // Arrange
    ActionBeanContext context = new ActionBeanContext();
    context.setEventName("Event Name");
    context.setRequest(new MockHttpServletRequest());
    context.setResponse(new MockHttpServletResponse());
    context.setServletContext(new MockServletContext());
    context.setValidationErrors(new ValidationErrors());

    OrderActionBean orderActionBean = new OrderActionBean();
    orderActionBean.setShippingAddressRequired(true);
    orderActionBean.setContext(context);

    // Act
    Resolution actualNewOrderResult = orderActionBean.newOrder();

    // Assert
    assertTrue(actualNewOrderResult instanceof ForwardResolution);
    assertEquals("/WEB-INF/jsp/order/ShippingForm.jsp", ((ForwardResolution) actualNewOrderResult).getPath());
    assertNull(((ForwardResolution) actualNewOrderResult).getStatus());
    assertNull(((ForwardResolution) actualNewOrderResult).getEvent());
    assertFalse(((ForwardResolution) actualNewOrderResult).isEventSpecified());
    assertFalse(orderActionBean.isShippingAddressRequired());
    assertTrue(((ForwardResolution) actualNewOrderResult).getParameters().isEmpty());
  }

  /**
   * Test new {@link OrderActionBean} (default constructor).
   *
   * <p>
   * Method under test: default or parameterless constructor of {@link OrderActionBean}
   */
  @Test
  @DisplayName("Test new OrderActionBean (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void OrderActionBean.<init>()" })
  void testNewOrderActionBean() {
    // Arrange and Act
    OrderActionBean actualOrderActionBean = new OrderActionBean();

    // Assert
    assertNull(actualOrderActionBean.getOrderList());
    assertNull(actualOrderActionBean.getContext());
    assertEquals(0, actualOrderActionBean.getOrderId());
    assertEquals(3, actualOrderActionBean.getCreditCardTypes().size());
    assertFalse(actualOrderActionBean.isConfirmed());
    assertFalse(actualOrderActionBean.isShippingAddressRequired());
  }
}
