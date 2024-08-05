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
package io.github.astrapi69.design.pattern.state.stopwatch;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * The class {@link StopWatchStateContextMachine} represents a context for the state machine of a
 * stopwatch.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StopWatchStateContextMachine
{

	/** The stopwatch. */
	@Builder.Default
	private StopWatch stopWatch = new StopWatch();

	/** The current state of the stopwatch. */
	@Builder.Default
	private StopWatchState current = StopWatchState.READY;

	/**
	 * Pauses the stopwatch.
	 */
	public void pause()
	{
		getCurrent().pause(this);
	}

	/**
	 * Resets the stopwatch.
	 */
	public void reset()
	{
		getCurrent().reset(this);
	}

	/**
	 * Starts the stopwatch.
	 */
	public void start()
	{
		getCurrent().start(this);
	}

	/**
	 * Stops the stopwatch.
	 */
	public void stop()
	{
		getCurrent().stop(this);
	}
}
