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
package io.github.astrapi69.design.pattern.state.component;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;

import javax.swing.JButton;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * The class {@link BtnSaveStateMachine} represents a state machine for a save button component. It
 * implements the {@link BtnSaveComponentState} interface and extends
 * {@link AbstractJComponentStateMachine}.
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class BtnSaveStateMachine
	extends
		AbstractJComponentStateMachine<JButton, BtnSaveComponentState>
	implements
		BtnSaveComponentState
{

	/**
	 * The model object associated with the state machine.
	 */
	NewPrivateKeyModelBean modelObject;

	/**
	 * Updates the state of the save button based on the model object.
	 */
	@Override
	protected void updateComponentState()
	{
		if (modelObject == null)
		{
			setEnabled(false);
			return;
		}
		boolean filenameOfPrivateKeyPresent = modelObject.getFilenameOfPrivateKey() != null;
		boolean privateKeyDirectoryPresent = modelObject.getPrivateKeyDirectory() != null;
		boolean privateKeyObjectPresent = modelObject.getPrivateKey() != null;
		boolean keySizePresent = modelObject.getKeySize() != null;
		if (filenameOfPrivateKeyPresent && privateKeyDirectoryPresent && privateKeyObjectPresent
			&& keySizePresent)
		{
			setEnabled(true);
			return;
		}
		setEnabled(false);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onInitialize()
	{
		updateComponentState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onGenerate()
	{
		updateComponentState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onClear()
	{
		updateComponentState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onChangeFilename()
	{
		updateComponentState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onChangeDirectory()
	{
		updateComponentState();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onChangeKeySize()
	{
		updateComponentState();
	}

	/**
	 * Checks if the given object is empty.
	 *
	 * @param obj
	 *            the object to check
	 * @return true if the object is empty, otherwise false
	 */
	public boolean isEmpty(Object obj)
	{
		if (obj == null)
		{
			return true;
		}
		if (obj instanceof Optional)
		{
			return !((Optional<?>)obj).isPresent();
		}
		if (obj instanceof CharSequence)
		{
			return ((CharSequence)obj).length() == 0;
		}
		if (obj.getClass().isArray())
		{
			return Array.getLength(obj) == 0;
		}
		if (obj instanceof Collection)
		{
			return ((Collection<?>)obj).isEmpty();
		}
		if (obj instanceof Map)
		{
			return ((Map<?, ?>)obj).isEmpty();
		}
		return false;
	}
}
