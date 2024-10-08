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
package io.github.astrapi69.design.pattern.state.wizard.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import io.github.astrapi69.design.pattern.state.wizard.BaseWizardState;
import io.github.astrapi69.design.pattern.state.wizard.WizardStateMachine;

public class BaseWizardStateMachineModelTest
{

	/**
	 * Test method for the methods previous and next of the {@link WizardStateMachine}.
	 */
	@Test
	public void testWizardStateMachine()
	{
		BaseWizardStateModel expected;
		BaseWizardState<BaseWizardStateMachineModel<WizardModel>> actual;
		final BaseWizardStateMachineModel<WizardModel> stateMachine = BaseWizardStateMachineModel
			.<WizardModel> builder().currentState(BaseWizardStateModel.FIRST)
			.modelObject(WizardModel.builder().build()).build();

		expected = BaseWizardStateModel.FIRST;
		stateMachine.previous();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// next not valid
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// set next to valid
		stateMachine.getModelObject().setValidNext(true);
		expected = BaseWizardStateModel.SECOND;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// set next to valid
		stateMachine.getModelObject().setValidNext(true);
		expected = BaseWizardStateModel.THIRD;
		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		stateMachine.next();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// cancel not valid
		stateMachine.cancel();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// set cancel to valid
		stateMachine.getModelObject().setValidCancel(true);
		expected = BaseWizardStateModel.CANCELED;
		stateMachine.cancel();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// finish not valid
		stateMachine.finish();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

		// set cancel to valid
		stateMachine.getModelObject().setValidFinish(true);

		expected = BaseWizardStateModel.FINISHED;
		stateMachine.finish();
		actual = stateMachine.getCurrentState();
		assertEquals(expected, actual);

	}

}
