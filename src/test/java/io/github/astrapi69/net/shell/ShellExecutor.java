/**
 * The MIT License
 *
 * Copyright (C) 2022 Asterios Raptis
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
package io.github.astrapi69.net.shell;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellExecutor
{

	public static String execute(String shellPath, String executionPath, String command)
		throws IOException, InterruptedException
	{
		if (executionPath.contains("~"))
		{
			executionPath = executionPath.replace("~", System.getProperty("user.home"));
		}
		File executionDirectory = new File(executionPath);
		if (!executionDirectory.exists())
		{
			throw new IllegalArgumentException("Execution directory does not exist");
		}
		String cdToExecutionPath = "cd " + executionPath;
		String commands = cdToExecutionPath + " && " + command;
		ProcessBuilder processBuilder = new ProcessBuilder();
		processBuilder.command(shellPath, "-c", commands);

		Process process = processBuilder.start();
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

		String line;
		while ((line = reader.readLine()) != null)
		{
			stringBuilder.append(line + "\n");
		}
		int waitFor = process.waitFor();

		if (waitFor != 0)
			stringBuilder.append("Exit code: ").append(waitFor).append("\n");
		return stringBuilder.toString();
	}
}
