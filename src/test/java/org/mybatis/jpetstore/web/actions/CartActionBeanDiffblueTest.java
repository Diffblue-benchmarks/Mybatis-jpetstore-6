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
import net.sourceforge.stripes.action.ForwardResolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mybatis.jpetstore.domain.Cart;

class CartActionBeanDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>
   * Methods under test:
   *
   * <ul>
   * <li>{@link CartActionBean#setCart(Cart)}
   * <li>{@link CartActionBean#setWorkingItemId(String)}
   * <li>{@link CartActionBean#getCart()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Cart CartActionBean.getCart()", "void CartActionBean.setCart(Cart)",
      "void CartActionBean.setWorkingItemId(String)" })
  void testGettersAndSetters() {
    // Arrange
    CartActionBean cartActionBean = new CartActionBean();
    Cart cart = new Cart();

    // Act
    cartActionBean.setCart(cart);
    cartActionBean.setWorkingItemId("42");

    // Assert
    assertSame(cart, cartActionBean.getCart());
  }

  /**
   * Test {@link CartActionBean#viewCart()}.
   *
   * <p>
   * Method under test: {@link CartActionBean#viewCart()}
   */
  @Test
  @DisplayName("Test viewCart()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "ForwardResolution CartActionBean.viewCart()" })
  void testViewCart() {
    // Arrange and Act
    ForwardResolution actualViewCartResult = new CartActionBean().viewCart();

    // Assert
    assertEquals("/WEB-INF/jsp/cart/Cart.jsp", actualViewCartResult.getPath());
    assertNull(actualViewCartResult.getStatus());
    assertNull(actualViewCartResult.getEvent());
    assertFalse(actualViewCartResult.isEventSpecified());
    assertTrue(actualViewCartResult.getParameters().isEmpty());
  }

  /**
   * Test {@link CartActionBean#checkOut()}.
   *
   * <p>
   * Method under test: {@link CartActionBean#checkOut()}
   */
  @Test
  @DisplayName("Test checkOut()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "ForwardResolution CartActionBean.checkOut()" })
  void testCheckOut() {
    // Arrange and Act
    ForwardResolution actualCheckOutResult = new CartActionBean().checkOut();

    // Assert
    assertEquals("/WEB-INF/jsp/cart/Checkout.jsp", actualCheckOutResult.getPath());
    assertNull(actualCheckOutResult.getStatus());
    assertNull(actualCheckOutResult.getEvent());
    assertFalse(actualCheckOutResult.isEventSpecified());
    assertTrue(actualCheckOutResult.getParameters().isEmpty());
  }

  /**
   * Test new {@link CartActionBean} (default constructor).
   *
   * <p>
   * Method under test: default or parameterless constructor of {@link CartActionBean}
   */
  @Test
  @DisplayName("Test new CartActionBean (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void CartActionBean.<init>()" })
  void testNewCartActionBean() {
    // Arrange and Act
    CartActionBean actualCartActionBean = new CartActionBean();

    // Assert
    assertNull(actualCartActionBean.getContext());
    Cart cart = actualCartActionBean.getCart();
    assertEquals(0, cart.getNumberOfItems());
    assertFalse(cart.getAllCartItems().hasNext());
    assertFalse(cart.getCartItems().hasNext());
    assertTrue(cart.getCartItemList().isEmpty());
    assertEquals(new BigDecimal("0"), cart.getSubTotal());
  }
}
