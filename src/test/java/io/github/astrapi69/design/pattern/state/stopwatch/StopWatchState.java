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
 * The enum {@link StopWatchState} represents the states of a stopwatch and defines the transitions
 * between them.
 */
public enum StopWatchState implements StopWatchTransition
{

	/** The READY state. */
	READY {
		@Override
		public void pause(final StopWatchStateContextMachine context)
		{
			context.setCurrent(this);
		}

		@Override
		public void reset(final StopWatchStateContextMachine context)
		{
			context.setCurrent(this);
		}

		@Override
		public void start(final StopWatchStateContextMachine context)
		{
			System.out.println("started time in milliseconds: "
				+ context.getStopWatch().getElapsedTimeInMilliseconds());
			context.getStopWatch().start();
			context.setCurrent(RUNNING);
		}

		@Override
		public void stop(final StopWatchStateContextMachine context)
		{
			context.setCurrent(this);
		}
	},

	/** The RUNNING state. */
	RUNNING {
		@Override
		public void pause(final StopWatchStateContextMachine context)
		{
			System.out.println("paused time in milliseconds: "
				+ context.getStopWatch().getElapsedTimeInMilliseconds());
			context.getStopWatch().stop();
			context.setCurrent(PAUSED);
		}

		@Override
		public void reset(final StopWatchStateContextMachine context)
		{
			context.setCurrent(this);
		}

		@Override
		public void start(final StopWatchStateContextMachine context)
		{
			context.setCurrent(this);
		}

		@Override
		public void stop(final StopWatchStateContextMachine context)
		{
			System.out.println("stopped time in milliseconds: "
				+ context.getStopWatch().getElapsedTimeInMilliseconds());
			context.getStopWatch().stop();
			context.setCurrent(STOPPED);
		}
	},

	/** The PAUSED state. */
	PAUSED {
		@Override
		public void pause(final StopWatchStateContextMachine context)
		{
			context.setCurrent(this);
		}

		@Override
		public void reset(final StopWatchStateContextMachine context)
		{
			context.setCurrent(this);
		}

		@Override
		public void start(final StopWatchStateContextMachine context)
		{
			System.out.println("started time in milliseconds: "
				+ context.getStopWatch().getElapsedTimeInMilliseconds());
			context.getStopWatch().start();
			context.setCurrent(RUNNING);
		}

		@Override
		public void stop(final StopWatchStateContextMachine context)
		{
			System.out.println("stopped time in milliseconds: "
				+ context.getStopWatch().getElapsedTimeInMilliseconds());
			context.getStopWatch().stop();
			context.setCurrent(STOPPED);
		}
	},

	/** The STOPPED state. */
	STOPPED {
		@Override
		public void pause(final StopWatchStateContextMachine context)
		{
			context.setCurrent(this);
		}

		@Override
		public void reset(final StopWatchStateContextMachine context)
		{
			System.out.println("reset time in milliseconds: "
				+ context.getStopWatch().getElapsedTimeInMilliseconds());
			context.setStopWatch(new StopWatch());
			context.setCurrent(READY);
		}

		@Override
		public void start(final StopWatchStateContextMachine context)
		{
			System.out.println("started time in milliseconds: "
				+ context.getStopWatch().getElapsedTimeInMilliseconds());
			context.getStopWatch().start();
			context.setCurrent(RUNNING);
		}

		@Override
		public void stop(final StopWatchStateContextMachine context)
		{
			context.setCurrent(this);
		}
	}
}
