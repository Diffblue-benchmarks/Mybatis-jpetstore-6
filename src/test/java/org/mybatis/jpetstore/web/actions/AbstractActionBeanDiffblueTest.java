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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.List;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.Message;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.validation.ValidationErrors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletContext;

class AbstractActionBeanDiffblueTest {
  /**
   * Test {@link AbstractActionBean#setMessage(String)}.
   *
   * <ul>
   * <li>Then {@link AccountActionBean} (default constructor) Context Messages size is one.
   * </ul>
   *
   * <p>
   * Method under test: {@link AbstractActionBean#setMessage(String)}
   */
  @Test
  @DisplayName("Test setMessage(String); then AccountActionBean (default constructor) Context Messages size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void AbstractActionBean.setMessage(String)" })
  void testSetMessage_thenAccountActionBeanContextMessagesSizeIsOne() {
    // Arrange
    ActionBeanContext context = new ActionBeanContext();
    context.setEventName("Event Name");
    context.setRequest(new MockHttpServletRequest());
    context.setResponse(new MockHttpServletResponse());
    context.setServletContext(new MockServletContext());
    context.setValidationErrors(new ValidationErrors());

    AccountActionBean accountActionBean = new AccountActionBean();
    accountActionBean.setContext(context);

    // Act
    accountActionBean.setMessage("42");

    // Assert
    List<Message> messages = accountActionBean.getContext().getMessages();
    assertEquals(1, messages.size());
    Message getResult = messages.get(0);
    assertTrue(getResult instanceof SimpleMessage);
    assertEquals("42", ((SimpleMessage) getResult).getMessage());
    assertEquals(0, ((SimpleMessage) getResult).getReplacementParameters().length);
  }

  /**
   * Test {@link AbstractActionBean#getContext()}.
   *
   * <p>
   * Method under test: {@link AbstractActionBean#getContext()}
   */
  @Test
  @DisplayName("Test getContext()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "ActionBeanContext AbstractActionBean.getContext()" })
  void testGetContext() {
    // Arrange, Act and Assert
    assertNull(new AccountActionBean().getContext());
  }

  /**
   * Test {@link AbstractActionBean#setContext(ActionBeanContext)}.
   *
   * <p>
   * Method under test: {@link AbstractActionBean#setContext(ActionBeanContext)}
   */
  @Test
  @DisplayName("Test setContext(ActionBeanContext)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void AbstractActionBean.setContext(ActionBeanContext)" })
  void testSetContext() {
    // Arrange
    AccountActionBean accountActionBean = new AccountActionBean();

    ActionBeanContext context = new ActionBeanContext();
    context.setEventName("Event Name");
    context.setRequest(new MockHttpServletRequest());
    context.setResponse(new MockHttpServletResponse());
    context.setServletContext(new MockServletContext());
    context.setValidationErrors(new ValidationErrors());

    // Act
    accountActionBean.setContext(context);

    // Assert
    assertSame(context, accountActionBean.getContext());
  }
}
