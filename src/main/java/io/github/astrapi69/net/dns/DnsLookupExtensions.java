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
package io.github.astrapi69.net.dns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility class for performing DNS lookups, reverse lookups, and running external DNS commands like
 * nslookup and dig
 */
public final class DnsLookupExtensions
{

	private DnsLookupExtensions()
	{
	}

	/**
	 * Public DNS server of Google
	 */
	public static final String PUBLIC_DNS_SERVER_OF_GOOGLE = "8.8.8.8";

	/**
	 * Resolves a domain name using the default system DNS resolver
	 *
	 * @param domain
	 *            the domain name (e.g., "google.com")
	 * @return the resolved IP addresses
	 * @throws UnknownHostException
	 *             if the domain cannot be resolved
	 */
	public static List<String> resolveDomain(String domain) throws UnknownHostException
	{
		InetAddress[] addresses = InetAddress.getAllByName(domain);
		return Arrays.stream(addresses).map(InetAddress::getHostAddress).toList();
	}

	/**
	 * Performs a reverse DNS lookup to find the hostname for a given IP address
	 *
	 * @param ipAddress
	 *            the IP address (e.g., "8.8.8.8")
	 * @return the resolved hostname
	 * @throws UnknownHostException
	 *             if the IP address cannot be resolved
	 */
	public static String reverseLookup(String ipAddress) throws UnknownHostException
	{
		InetAddress address = InetAddress.getByName(ipAddress);
		return address.getHostName();
	}

	/**
	 * Runs the nslookup command for a given domain and returns the output
	 *
	 * @param domain
	 *            the domain to look up (e.g., "google.com")
	 * @return the output of the nslookup command
	 * @throws IOException
	 *             if an error occurs while executing the command
	 */
	public static String runNslookup(String domain) throws IOException
	{
		return executeCommand("nslookup " + domain);
	}

	/**
	 * Runs the dig command for a given domain and returns the output
	 *
	 * @param domain
	 *            the domain to look up (e.g., "google.com")
	 * @return the output of the dig command
	 * @throws IOException
	 *             if an error occurs while executing the command
	 */
	public static String runDig(String domain) throws IOException
	{
		return executeCommand("dig " + domain + " +short");
	}

	/**
	 * Executes a system command and returns its output
	 *
	 * @param command
	 *            the system command to execute
	 * @return the command output
	 * @throws IOException
	 *             if an error occurs while executing the command
	 */
	private static String executeCommand(String command) throws IOException
	{
		ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
		Process process = processBuilder.start();
		try (BufferedReader reader = new BufferedReader(
			new InputStreamReader(process.getInputStream())))
		{
			return reader.lines().collect(Collectors.joining("\n"));
		}
	}
}