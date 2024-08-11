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
package io.github.astrapi69.design.pattern.state.wizard;

import io.github.astrapi69.design.pattern.state.wizard.model.WizardStateInfo;

/**
 * The interface {@link WizardState} represents a state in a wizard. This interface provides methods
 * to manage the navigation and identification of different wizard states, including whether the
 * state is the first, last, or has previous and next states.
 *
 * @param <ST>
 *            the generic type of the state machine
 */
public interface WizardState<ST>
{

	/**
	 * Gets the simple name of this {@link WizardState} object. If a {@link WizardStateInfo} is
	 * present, it returns the name from it; otherwise, it returns the simple class name of this
	 * object.
	 *
	 * @return the simple name of this {@link WizardState} object
	 */
	default String getName()
	{
		if (getWizardStateInfo() != null)
		{
			return getWizardStateInfo().getName();
		}
		return this.getClass().getSimpleName();
	}

	/**
	 * Go to the next {@link WizardState} object.
	 *
	 * @param input
	 *            the {@link WizardStateMachine} object
	 */
	void goNext(ST input);

	/**
	 * Go to the previous {@link WizardState} object.
	 *
	 * @param input
	 *            the {@link WizardStateMachine} object
	 */
	void goPrevious(ST input);

	/**
	 * Checks if this {@link WizardState} object has a next {@link WizardState} object. If a
	 * {@link WizardStateInfo} is present, it returns the next flag from it; otherwise, it defaults
	 * to true.
	 *
	 * @return true if this {@link WizardState} object has a next {@link WizardState} object,
	 *         otherwise false
	 */
	default boolean hasNext()
	{
		if (getWizardStateInfo() != null)
		{
			return getWizardStateInfo().isNext();
		}
		return true;
	}

	/**
	 * Checks if this {@link WizardState} object has a previous {@link WizardState} object. If a
	 * {@link WizardStateInfo} is present, it returns the previous flag from it; otherwise, it
	 * defaults to true.
	 *
	 * @return true if this {@link WizardState} object has a previous {@link WizardState} object,
	 *         otherwise false
	 */
	default boolean hasPrevious()
	{
		if (getWizardStateInfo() != null)
		{
			return getWizardStateInfo().isPrevious();
		}
		return true;
	}

	/**
	 * Checks if this {@link WizardState} object is the first {@link WizardState} object. If a
	 * {@link WizardStateInfo} is present, it returns the first flag from it; otherwise, it defaults
	 * to false.
	 *
	 * @return true if this {@link WizardState} object is the first {@link WizardState} object,
	 *         otherwise false
	 */
	default boolean isFirst()
	{
		if (getWizardStateInfo() != null)
		{
			return getWizardStateInfo().isFirst();
		}
		return false;
	}

	/**
	 * Checks if this {@link WizardState} object is the last {@link WizardState} object. If a
	 * {@link WizardStateInfo} is present, it returns the last flag from it; otherwise, it defaults
	 * to false.
	 *
	 * @return true if this {@link WizardState} object is the last {@link WizardState} object,
	 *         otherwise false
	 */
	default boolean isLast()
	{
		if (getWizardStateInfo() != null)
		{
			return getWizardStateInfo().isLast();
		}
		return false;
	}

	/**
	 * Gets the {@link WizardStateInfo} object.
	 *
	 * @return the {@link WizardStateInfo} object
	 */
	WizardStateInfo getWizardStateInfo();

	/**
	 * Sets the new wizard state info object.
	 *
	 * @param wizardStateInfo
	 *            the new wizard state info object
	 */
	void getWizardStateInfo(WizardStateInfo wizardStateInfo);

	/**
	 * Sets the next flag.
	 *
	 * @param next
	 *            the new next flag
	 */
	default void setNext(boolean next)
	{
		if (getWizardStateInfo() != null)
		{
			getWizardStateInfo().setNext(next);
		}
	}

	/**
	 * Sets the first flag.
	 *
	 * @param first
	 *            the new first flag
	 */
	default void setFirst(boolean first)
	{
		if (getWizardStateInfo() != null)
		{
			getWizardStateInfo().setFirst(first);
		}
	}

	/**
	 * Sets the last flag.
	 *
	 * @param last
	 *            the new last flag
	 */
	default void setLast(boolean last)
	{
		if (getWizardStateInfo() != null)
		{
			getWizardStateInfo().setLast(last);
		}
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	default void setName(String name)
	{
		if (getWizardStateInfo() != null)
		{
			getWizardStateInfo().setName(name);
		}
	}

	/**
	 * Sets the previous flag.
	 *
	 * @param previous
	 *            the new previous flag
	 */
	default void setPrevious(boolean previous)
	{
		if (getWizardStateInfo() != null)
		{
			getWizardStateInfo().setPrevious(previous);
		}
	}
}
