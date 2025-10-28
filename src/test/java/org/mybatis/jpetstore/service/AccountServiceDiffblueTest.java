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

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mybatis.jpetstore.domain.Account;
import org.mybatis.jpetstore.mapper.AccountMapper;

class AccountServiceDiffblueTest {
  /**
   * Test {@link AccountService#getAccount(String)} with {@code username}.
   *
   * <p>
   * Method under test: {@link AccountService#getAccount(String)}
   */
  @Test
  @DisplayName("Test getAccount(String) with 'username'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Account AccountService.getAccount(String)" })
  void testGetAccountWithUsername() {
    // Arrange
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

    AccountMapper accountMapper = mock(AccountMapper.class);
    when(accountMapper.getAccountByUsername(Mockito.<String> any())).thenReturn(account);

    // Act
    Account actualAccount = new AccountService(accountMapper).getAccount("janedoe");

    // Assert
    verify(accountMapper).getAccountByUsername("janedoe");
    assertSame(account, actualAccount);
  }

  /**
   * Test {@link AccountService#getAccount(String, String)} with {@code username}, {@code password}.
   *
   * <p>
   * Method under test: {@link AccountService#getAccount(String, String)}
   */
  @Test
  @DisplayName("Test getAccount(String, String) with 'username', 'password'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "Account AccountService.getAccount(String, String)" })
  void testGetAccountWithUsernamePassword() {
    // Arrange
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

    AccountMapper accountMapper = mock(AccountMapper.class);
    when(accountMapper.getAccountByUsernameAndPassword(Mockito.<String> any(), Mockito.<String> any()))
        .thenReturn(account);

    // Act
    Account actualAccount = new AccountService(accountMapper).getAccount("janedoe", "iloveyou");

    // Assert
    verify(accountMapper).getAccountByUsernameAndPassword("janedoe", "iloveyou");
    assertSame(account, actualAccount);
  }

  /**
   * Test {@link AccountService#insertAccount(Account)}.
   *
   * <p>
   * Method under test: {@link AccountService#insertAccount(Account)}
   */
  @Test
  @DisplayName("Test insertAccount(Account)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void AccountService.insertAccount(Account)" })
  void testInsertAccount() {
    // Arrange
    AccountMapper accountMapper = mock(AccountMapper.class);
    doNothing().when(accountMapper).insertAccount(Mockito.<Account> any());
    doNothing().when(accountMapper).insertProfile(Mockito.<Account> any());
    doNothing().when(accountMapper).insertSignon(Mockito.<Account> any());
    AccountService accountService = new AccountService(accountMapper);

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
    accountService.insertAccount(account);

    // Assert
    verify(accountMapper).insertAccount(isA(Account.class));
    verify(accountMapper).insertProfile(isA(Account.class));
    verify(accountMapper).insertSignon(isA(Account.class));
  }

  /**
   * Test {@link AccountService#updateAccount(Account)}.
   *
   * <ul>
   * <li>Given empty string.
   * <li>When {@link Account} (default constructor) Password is empty string.
   * </ul>
   *
   * <p>
   * Method under test: {@link AccountService#updateAccount(Account)}
   */
  @Test
  @DisplayName("Test updateAccount(Account); given empty string; when Account (default constructor) Password is empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void AccountService.updateAccount(Account)" })
  void testUpdateAccount_givenEmptyString_whenAccountPasswordIsEmptyString() {
    // Arrange
    AccountMapper accountMapper = mock(AccountMapper.class);
    doNothing().when(accountMapper).updateAccount(Mockito.<Account> any());
    doNothing().when(accountMapper).updateProfile(Mockito.<Account> any());
    AccountService accountService = new AccountService(accountMapper);

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
    account.setPassword("");
    account.setPhone("6625550144");
    account.setState("MD");
    account.setStatus("Status");
    account.setUsername("janedoe");
    account.setZip("21654");

    // Act
    accountService.updateAccount(account);

    // Assert
    verify(accountMapper).updateAccount(isA(Account.class));
    verify(accountMapper).updateProfile(isA(Account.class));
  }

  /**
   * Test {@link AccountService#updateAccount(Account)}.
   *
   * <ul>
   * <li>Given {@code null}.
   * <li>When {@link Account} (default constructor) Password is {@code null}.
   * </ul>
   *
   * <p>
   * Method under test: {@link AccountService#updateAccount(Account)}
   */
  @Test
  @DisplayName("Test updateAccount(Account); given 'null'; when Account (default constructor) Password is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void AccountService.updateAccount(Account)" })
  void testUpdateAccount_givenNull_whenAccountPasswordIsNull() {
    // Arrange
    AccountMapper accountMapper = mock(AccountMapper.class);
    doNothing().when(accountMapper).updateAccount(Mockito.<Account> any());
    doNothing().when(accountMapper).updateProfile(Mockito.<Account> any());
    AccountService accountService = new AccountService(accountMapper);

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
    account.setPassword(null);
    account.setPhone("6625550144");
    account.setState("MD");
    account.setStatus("Status");
    account.setUsername("janedoe");
    account.setZip("21654");

    // Act
    accountService.updateAccount(account);

    // Assert
    verify(accountMapper).updateAccount(isA(Account.class));
    verify(accountMapper).updateProfile(isA(Account.class));
  }

  /**
   * Test {@link AccountService#updateAccount(Account)}.
   *
   * <ul>
   * <li>Then calls {@link AccountMapper#updateSignon(Account)}.
   * </ul>
   *
   * <p>
   * Method under test: {@link AccountService#updateAccount(Account)}
   */
  @Test
  @DisplayName("Test updateAccount(Account); then calls updateSignon(Account)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void AccountService.updateAccount(Account)" })
  void testUpdateAccount_thenCallsUpdateSignon() {
    // Arrange
    AccountMapper accountMapper = mock(AccountMapper.class);
    doNothing().when(accountMapper).updateAccount(Mockito.<Account> any());
    doNothing().when(accountMapper).updateProfile(Mockito.<Account> any());
    doNothing().when(accountMapper).updateSignon(Mockito.<Account> any());
    AccountService accountService = new AccountService(accountMapper);

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
    accountService.updateAccount(account);

    // Assert
    verify(accountMapper).updateAccount(isA(Account.class));
    verify(accountMapper).updateProfile(isA(Account.class));
    verify(accountMapper).updateSignon(isA(Account.class));
  }
}
