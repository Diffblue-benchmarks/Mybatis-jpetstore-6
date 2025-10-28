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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SequenceDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>
   * Methods under test:
   *
   * <ul>
   * <li>{@link Sequence#Sequence()}
   * <li>{@link Sequence#setName(String)}
   * <li>{@link Sequence#setNextId(int)}
   * <li>{@link Sequence#getName()}
   * <li>{@link Sequence#getNextId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Sequence.<init>()", "void Sequence.<init>(String, int)", "String Sequence.getName()",
      "int Sequence.getNextId()", "void Sequence.setName(String)", "void Sequence.setNextId(int)" })
  void testGettersAndSetters() {
    // Arrange and Act
    Sequence actualSequence = new Sequence();
    actualSequence.setName("Bella");
    actualSequence.setNextId(1);
    String actualName = actualSequence.getName();

    // Assert
    assertEquals("Bella", actualName);
    assertEquals(1, actualSequence.getNextId());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   * <li>When {@code Bella}.
   * </ul>
   *
   * <p>
   * Methods under test:
   *
   * <ul>
   * <li>{@link Sequence#Sequence(String, int)}
   * <li>{@link Sequence#setName(String)}
   * <li>{@link Sequence#setNextId(int)}
   * <li>{@link Sequence#getName()}
   * <li>{@link Sequence#getNextId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'Bella'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({ "void Sequence.<init>()", "void Sequence.<init>(String, int)", "String Sequence.getName()",
      "int Sequence.getNextId()", "void Sequence.setName(String)", "void Sequence.setNextId(int)" })
  void testGettersAndSetters_whenBella() {
    // Arrange and Act
    Sequence actualSequence = new Sequence("Bella", 1);
    actualSequence.setName("Bella");
    actualSequence.setNextId(1);
    String actualName = actualSequence.getName();

    // Assert
    assertEquals("Bella", actualName);
    assertEquals(1, actualSequence.getNextId());
  }
}
