/**
 * The MIT License
 *
 * Copyright (C) 2024 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.design.pattern.state.button;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Test class for {@link SigninButtonStateMachine}.
 */
public class TestSigninButtonStateMachine
{

	/**
	 * Test the state transitions of the {@link SigninButtonStateMachine}.
	 */
	@Test
	public void testState()
	{
		SigninButtonCurrentState expected;
		ButtonState<SigninButtonStateMachine> actual;
		SigninButtonStateMachine buttonStateMachine = SigninButtonStateMachine.builder()
			.button(MyButton.builder().text("OK").enabled(false).build())
			.current(SigninButtonCurrentState.DISABLED).build();

		// Test case: no operation, the current state is initially SigninButtonCurrentState.DISABLED
		expected = SigninButtonCurrentState.DISABLED;
		actual = buttonStateMachine.getCurrent();
		assertEquals(expected, actual);
		assertFalse(buttonStateMachine.getButton().isEnabled());

		// Test case: add application file, the current state is still
		// SigninButtonCurrentState.DISABLED
		// because both application file and password should be true to get the enabled state
		buttonStateMachine.onApplicationFileAdded();
		expected = SigninButtonCurrentState.DISABLED;
		actual = buttonStateMachine.getCurrent();
		assertEquals(expected, actual);
		assertFalse(buttonStateMachine.getButton().isEnabled());

		// Test case: both application file and password are true, so the current state is
		// SigninButtonCurrentState.ENABLED
		buttonStateMachine.onChangeWithMasterPassword();
		expected = SigninButtonCurrentState.ENABLED;
		actual = buttonStateMachine.getCurrent();
		assertEquals(expected, actual);
		assertTrue(buttonStateMachine.getButton().isEnabled());

		// Toggle password to false will cause the disabled state transition
		buttonStateMachine.onChangeWithMasterPassword();
		expected = SigninButtonCurrentState.DISABLED;
		actual = buttonStateMachine.getCurrent();
		assertEquals(expected, actual);
		assertFalse(buttonStateMachine.getButton().isEnabled());

		// Toggle password to true will cause the enabled state transition
		buttonStateMachine.onChangeWithMasterPassword();
		expected = SigninButtonCurrentState.ENABLED;
		actual = buttonStateMachine.getCurrent();
		assertEquals(expected, actual);
		assertTrue(buttonStateMachine.getButton().isEnabled());
	}
}
