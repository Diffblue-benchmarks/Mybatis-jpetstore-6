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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AccountDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>
   * Methods under test:
   *
   * <ul>
   * <li>default or parameterless constructor of {@link Account}
   * <li>{@link Account#setAddress1(String)}
   * <li>{@link Account#setAddress2(String)}
   * <li>{@link Account#setBannerName(String)}
   * <li>{@link Account#setBannerOption(boolean)}
   * <li>{@link Account#setCity(String)}
   * <li>{@link Account#setCountry(String)}
   * <li>{@link Account#setEmail(String)}
   * <li>{@link Account#setFavouriteCategoryId(String)}
   * <li>{@link Account#setFirstName(String)}
   * <li>{@link Account#setLanguagePreference(String)}
   * <li>{@link Account#setLastName(String)}
   * <li>{@link Account#setListOption(boolean)}
   * <li>{@link Account#setPassword(String)}
   * <li>{@link Account#setPhone(String)}
   * <li>{@link Account#setState(String)}
   * <li>{@link Account#setStatus(String)}
   * <li>{@link Account#setUsername(String)}
   * <li>{@link Account#setZip(String)}
   * <li>{@link Account#getAddress1()}
   * <li>{@link Account#getAddress2()}
   * <li>{@link Account#getBannerName()}
   * <li>{@link Account#getCity()}
   * <li>{@link Account#getCountry()}
   * <li>{@link Account#getEmail()}
   * <li>{@link Account#getFavouriteCategoryId()}
   * <li>{@link Account#getFirstName()}
   * <li>{@link Account#getLanguagePreference()}
   * <li>{@link Account#getLastName()}
   * <li>{@link Account#getPassword()}
   * <li>{@link Account#getPhone()}
   * <li>{@link Account#getState()}
   * <li>{@link Account#getStatus()}
   * <li>{@link Account#getUsername()}
   * <li>{@link Account#getZip()}
   * <li>{@link Account#isBannerOption()}
   * <li>{@link Account#isListOption()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Account.<init>()", "String Account.getAddress1()", "String Account.getAddress2()",
      "String Account.getBannerName()", "String Account.getCity()", "String Account.getCountry()",
      "String Account.getEmail()", "String Account.getFavouriteCategoryId()", "String Account.getFirstName()",
      "String Account.getLanguagePreference()", "String Account.getLastName()", "String Account.getPassword()",
      "String Account.getPhone()", "String Account.getState()", "String Account.getStatus()",
      "String Account.getUsername()", "String Account.getZip()", "boolean Account.isBannerOption()",
      "boolean Account.isListOption()", "void Account.setAddress1(String)", "void Account.setAddress2(String)",
      "void Account.setBannerName(String)", "void Account.setBannerOption(boolean)", "void Account.setCity(String)",
      "void Account.setCountry(String)", "void Account.setEmail(String)", "void Account.setFavouriteCategoryId(String)",
      "void Account.setFirstName(String)", "void Account.setLanguagePreference(String)",
      "void Account.setLastName(String)", "void Account.setListOption(boolean)", "void Account.setPassword(String)",
      "void Account.setPhone(String)", "void Account.setState(String)", "void Account.setStatus(String)",
      "void Account.setUsername(String)", "void Account.setZip(String)" })
  void testGettersAndSetters() {
    // Arrange and Act
    Account actualAccount = new Account();
    actualAccount.setAddress1("42 Main St");
    actualAccount.setAddress2("42 Main St");
    actualAccount.setBannerName("Bella");
    actualAccount.setBannerOption(true);
    actualAccount.setCity("Oxford");
    actualAccount.setCountry("GB");
    actualAccount.setEmail("jane.doe@example.org");
    actualAccount.setFavouriteCategoryId("42");
    actualAccount.setFirstName("Jane");
    actualAccount.setLanguagePreference("en");
    actualAccount.setLastName("Doe");
    actualAccount.setListOption(true);
    actualAccount.setPassword("iloveyou");
    actualAccount.setPhone("6625550144");
    actualAccount.setState("MD");
    actualAccount.setStatus("Status");
    actualAccount.setUsername("janedoe");
    actualAccount.setZip("21654");
    String actualAddress1 = actualAccount.getAddress1();
    String actualAddress2 = actualAccount.getAddress2();
    String actualBannerName = actualAccount.getBannerName();
    String actualCity = actualAccount.getCity();
    String actualCountry = actualAccount.getCountry();
    String actualEmail = actualAccount.getEmail();
    String actualFavouriteCategoryId = actualAccount.getFavouriteCategoryId();
    String actualFirstName = actualAccount.getFirstName();
    String actualLanguagePreference = actualAccount.getLanguagePreference();
    String actualLastName = actualAccount.getLastName();
    String actualPassword = actualAccount.getPassword();
    String actualPhone = actualAccount.getPhone();
    String actualState = actualAccount.getState();
    String actualStatus = actualAccount.getStatus();
    String actualUsername = actualAccount.getUsername();
    String actualZip = actualAccount.getZip();
    boolean actualIsBannerOptionResult = actualAccount.isBannerOption();

    // Assert
    assertEquals("21654", actualZip);
    assertEquals("42 Main St", actualAddress1);
    assertEquals("42 Main St", actualAddress2);
    assertEquals("42", actualFavouriteCategoryId);
    assertEquals("6625550144", actualPhone);
    assertEquals("Bella", actualBannerName);
    assertEquals("Doe", actualLastName);
    assertEquals("GB", actualCountry);
    assertEquals("Jane", actualFirstName);
    assertEquals("MD", actualState);
    assertEquals("Oxford", actualCity);
    assertEquals("Status", actualStatus);
    assertEquals("en", actualLanguagePreference);
    assertEquals("iloveyou", actualPassword);
    assertEquals("jane.doe@example.org", actualEmail);
    assertEquals("janedoe", actualUsername);
    assertTrue(actualIsBannerOptionResult);
    assertTrue(actualAccount.isListOption());
  }
}
