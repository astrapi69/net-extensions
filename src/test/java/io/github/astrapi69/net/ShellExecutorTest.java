package io.github.astrapi69.net;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class ShellExecutorTest
{

	@Test
	public void testExecute() throws IOException, InterruptedException
	{

		String shellPath = "/usr/bin/zsh";
		String executionPath = "~/dev/tmp";
		String command = "touch foo.txt";

		String shellOutput = ShellExecutor.execute(shellPath, executionPath, command);
		System.out.println(shellOutput);

	}
}