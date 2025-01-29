package io.github.astrapi69.net.shell;

import java.io.IOException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ShellExecutorTest
{

	@Test
	@Disabled("run only locally")
	public void testExecute() throws IOException, InterruptedException
	{

		String shellPath = "/usr/bin/zsh";
		String executionPath = "~/dev/tmp";
		String command = "touch foo.txt";

		String shellOutput = ShellExecutor.execute(shellPath, executionPath, command);
		System.out.println(shellOutput);

	}
}