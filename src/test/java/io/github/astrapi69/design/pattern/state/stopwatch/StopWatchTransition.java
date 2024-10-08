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

/**
 * The interface {@link StopWatchTransition} defines the transitions for the states of a stopwatch.
 */
public interface StopWatchTransition
{

	/**
	 * Stops the stopwatch.
	 *
	 * @param context
	 *            the state context
	 */
	void stop(final StopWatchStateContextMachine context);

	/**
	 * Starts the stopwatch.
	 *
	 * @param context
	 *            the state context
	 */
	void start(final StopWatchStateContextMachine context);

	/**
	 * Resets the stopwatch.
	 *
	 * @param context
	 *            the state context
	 */
	void reset(final StopWatchStateContextMachine context);

	/**
	 * Pauses the stopwatch.
	 *
	 * @param context
	 *            the state context
	 */
	void pause(final StopWatchStateContextMachine context);
}
