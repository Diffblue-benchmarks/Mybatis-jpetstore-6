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
import java.util.ArrayList;
import java.util.List;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.domain.Product;

class AccountActionBeanDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>
   * Methods under test:
   *
   * <ul>
   * <li>{@link AccountActionBean#setMyList(List)}
   * <li>{@link AccountActionBean#getAccount()}
   * <li>{@link AccountActionBean#getCategories()}
   * <li>{@link AccountActionBean#getLanguages()}
   * <li>{@link AccountActionBean#getMyList()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Account AccountActionBean.getAccount()", "List AccountActionBean.getCategories()",
      "List AccountActionBean.getLanguages()", "List AccountActionBean.getMyList()",
      "void AccountActionBean.setMyList(List)" })
  void testGettersAndSetters() {
    // Arrange
    AccountActionBean accountActionBean = new AccountActionBean();
    ArrayList<Product> myList = new ArrayList<>();

    // Act
    accountActionBean.setMyList(myList);
    Account actualAccount = accountActionBean.getAccount();
    List<String> actualCategories = accountActionBean.getCategories();
    List<String> actualLanguages = accountActionBean.getLanguages();
    List<Product> actualMyList = accountActionBean.getMyList();

    // Assert
    assertEquals(5, actualCategories.size());
    assertEquals("BIRDS", actualCategories.get(4));
    assertEquals("CATS", actualCategories.get(3));
    assertEquals("DOGS", actualCategories.get(1));
    assertEquals("FISH", actualCategories.get(0));
    assertEquals("REPTILES", actualCategories.get(2));
    assertEquals(2, actualLanguages.size());
    assertEquals("english", actualLanguages.get(0));
    assertEquals("japanese", actualLanguages.get(1));
    assertNull(actualAccount.getAddress1());
    assertNull(actualAccount.getAddress2());
    assertNull(actualAccount.getBannerName());
    assertNull(actualAccount.getCity());
    assertNull(actualAccount.getCountry());
    assertNull(actualAccount.getEmail());
    assertNull(actualAccount.getFavouriteCategoryId());
    assertNull(actualAccount.getFirstName());
    assertNull(actualAccount.getLanguagePreference());
    assertNull(actualAccount.getLastName());
    assertNull(actualAccount.getPassword());
    assertNull(actualAccount.getPhone());
    assertNull(actualAccount.getState());
    assertNull(actualAccount.getStatus());
    assertNull(actualAccount.getUsername());
    assertNull(actualAccount.getZip());
    assertFalse(actualAccount.isBannerOption());
    assertFalse(actualAccount.isListOption());
    assertTrue(actualMyList.isEmpty());
    assertSame(myList, actualMyList);
  }

  /**
   * Test {@link AccountActionBean#getUsername()}.
   *
   * <p>
   * Method under test: {@link AccountActionBean#getUsername()}
   */
  @Test
  @DisplayName("Test getUsername()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "String AccountActionBean.getUsername()" })
  void testGetUsername() {
    // Arrange, Act and Assert
    assertNull(new AccountActionBean().getUsername());
  }

  /**
   * Test {@link AccountActionBean#setUsername(String)}.
   *
   * <p>
   * Method under test: {@link AccountActionBean#setUsername(String)}
   */
  @Test
  @DisplayName("Test setUsername(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void AccountActionBean.setUsername(String)" })
  void testSetUsername() {
    // Arrange
    AccountActionBean accountActionBean = new AccountActionBean();

    // Act
    accountActionBean.setUsername("janedoe");

    // Assert
    assertEquals("janedoe", accountActionBean.getAccount().getUsername());
    assertEquals("janedoe", accountActionBean.getUsername());
  }

  /**
   * Test {@link AccountActionBean#getPassword()}.
   *
   * <p>
   * Method under test: {@link AccountActionBean#getPassword()}
   */
  @Test
  @DisplayName("Test getPassword()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "String AccountActionBean.getPassword()" })
  void testGetPassword() {
    // Arrange, Act and Assert
    assertNull(new AccountActionBean().getPassword());
  }

  /**
   * Test {@link AccountActionBean#setPassword(String)}.
   *
   * <p>
   * Method under test: {@link AccountActionBean#setPassword(String)}
   */
  @Test
  @DisplayName("Test setPassword(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void AccountActionBean.setPassword(String)" })
  void testSetPassword() {
    // Arrange
    AccountActionBean accountActionBean = new AccountActionBean();

    // Act
    accountActionBean.setPassword("iloveyou");

    // Assert
    assertEquals("iloveyou", accountActionBean.getAccount().getPassword());
    assertEquals("iloveyou", accountActionBean.getPassword());
  }

  /**
   * Test {@link AccountActionBean#newAccountForm()}.
   *
   * <ul>
   * <li>Given {@link AccountActionBean} (default constructor).
   * <li>Then return {@link ForwardResolution}.
   * </ul>
   *
   * <p>
   * Method under test: {@link AccountActionBean#newAccountForm()}
   */
  @Test
  @DisplayName("Test newAccountForm(); given AccountActionBean (default constructor); then return ForwardResolution")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Resolution AccountActionBean.newAccountForm()" })
  void testNewAccountForm_givenAccountActionBean_thenReturnForwardResolution() {
    // Arrange and Act
    Resolution actualNewAccountFormResult = new AccountActionBean().newAccountForm();

    // Assert
    assertTrue(actualNewAccountFormResult instanceof ForwardResolution);
    assertEquals("/WEB-INF/jsp/account/NewAccountForm.jsp", ((ForwardResolution) actualNewAccountFormResult).getPath());
    assertNull(((ForwardResolution) actualNewAccountFormResult).getStatus());
    assertNull(((ForwardResolution) actualNewAccountFormResult).getEvent());
    assertFalse(((ForwardResolution) actualNewAccountFormResult).isEventSpecified());
    assertTrue(((ForwardResolution) actualNewAccountFormResult).getParameters().isEmpty());
  }

  /**
   * Test {@link AccountActionBean#editAccountForm()}.
   *
   * <ul>
   * <li>Given {@link AccountActionBean} (default constructor).
   * <li>Then return {@link ForwardResolution}.
   * </ul>
   *
   * <p>
   * Method under test: {@link AccountActionBean#editAccountForm()}
   */
  @Test
  @DisplayName("Test editAccountForm(); given AccountActionBean (default constructor); then return ForwardResolution")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Resolution AccountActionBean.editAccountForm()" })
  void testEditAccountForm_givenAccountActionBean_thenReturnForwardResolution() {
    // Arrange and Act
    Resolution actualEditAccountFormResult = new AccountActionBean().editAccountForm();

    // Assert
    assertTrue(actualEditAccountFormResult instanceof ForwardResolution);
    assertEquals("/WEB-INF/jsp/account/EditAccountForm.jsp",
        ((ForwardResolution) actualEditAccountFormResult).getPath());
    assertNull(((ForwardResolution) actualEditAccountFormResult).getStatus());
    assertNull(((ForwardResolution) actualEditAccountFormResult).getEvent());
    assertFalse(((ForwardResolution) actualEditAccountFormResult).isEventSpecified());
    assertTrue(((ForwardResolution) actualEditAccountFormResult).getParameters().isEmpty());
  }

  /**
   * Test {@link AccountActionBean#signonForm()}.
   *
   * <ul>
   * <li>Given {@link AccountActionBean} (default constructor).
   * <li>Then return {@link ForwardResolution}.
   * </ul>
   *
   * <p>
   * Method under test: {@link AccountActionBean#signonForm()}
   */
  @Test
  @DisplayName("Test signonForm(); given AccountActionBean (default constructor); then return ForwardResolution")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Resolution AccountActionBean.signonForm()" })
  void testSignonForm_givenAccountActionBean_thenReturnForwardResolution() {
    // Arrange and Act
    Resolution actualSignonFormResult = new AccountActionBean().signonForm();

    // Assert
    assertTrue(actualSignonFormResult instanceof ForwardResolution);
    assertEquals("/WEB-INF/jsp/account/SignonForm.jsp", ((ForwardResolution) actualSignonFormResult).getPath());
    assertNull(((ForwardResolution) actualSignonFormResult).getStatus());
    assertNull(((ForwardResolution) actualSignonFormResult).getEvent());
    assertFalse(((ForwardResolution) actualSignonFormResult).isEventSpecified());
    assertTrue(((ForwardResolution) actualSignonFormResult).getParameters().isEmpty());
  }

  /**
   * Test {@link AccountActionBean#isAuthenticated()}.
   *
   * <p>
   * Method under test: {@link AccountActionBean#isAuthenticated()}
   */
  @Test
  @DisplayName("Test isAuthenticated()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "boolean AccountActionBean.isAuthenticated()" })
  void testIsAuthenticated() {
    // Arrange, Act and Assert
    assertFalse(new AccountActionBean().isAuthenticated());
  }

  /**
   * Test new {@link AccountActionBean} (default constructor).
   *
   * <p>
   * Method under test: default or parameterless constructor of {@link AccountActionBean}
   */
  @Test
  @DisplayName("Test new AccountActionBean (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void AccountActionBean.<init>()" })
  void testNewAccountActionBean() {
    // Arrange and Act
    AccountActionBean actualAccountActionBean = new AccountActionBean();

    // Assert
    assertNull(actualAccountActionBean.getPassword());
    assertNull(actualAccountActionBean.getUsername());
    assertNull(actualAccountActionBean.getMyList());
    assertNull(actualAccountActionBean.getContext());
    assertEquals(2, actualAccountActionBean.getLanguages().size());
    assertEquals(5, actualAccountActionBean.getCategories().size());
    assertFalse(actualAccountActionBean.isAuthenticated());
  }
}
