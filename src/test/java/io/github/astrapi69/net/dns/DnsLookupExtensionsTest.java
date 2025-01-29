package io.github.astrapi69.net.dns;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.List;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link DnsLookupExtensions}
 */
class DnsLookupExtensionsTest
{

	/**
	 * Test resolving a valid domain
	 *
	 * @throws UnknownHostException
	 *             if the domain cannot be resolved
	 */
	@Test
	void testResolveDomainValid() throws UnknownHostException
	{
		List<String> ips = DnsLookupExtensions.resolveDomain("google.com");
		System.out.println("Resolved IPs for google.com: " + ips);
		assertNotNull(ips, "Resolved IP list should not be null");
		assertFalse(ips.isEmpty(), "Resolved IP list should not be empty");
	}

	/**
	 * Test resolving an invalid domain
	 */
	@Test
	void testResolveDomainInvalid()
	{
		assertThrows(UnknownHostException.class,
			() -> DnsLookupExtensions.resolveDomain("invalid.nonexistent.domain"));
	}

	/**
	 * Test reverse lookup for a known IP
	 *
	 * @throws UnknownHostException
	 *             if the IP cannot be resolved
	 */
	@Test
	void testReverseLookupValid() throws UnknownHostException
	{
		String hostname = DnsLookupExtensions
			.reverseLookup(DnsLookupExtensions.PUBLIC_DNS_SERVER_OF_GOOGLE);
		System.out.println(
			"Hostname for " + DnsLookupExtensions.PUBLIC_DNS_SERVER_OF_GOOGLE + ": " + hostname);
		assertNotNull(hostname, "Hostname should not be null");
		assertFalse(hostname.isEmpty(), "Hostname should not be empty");
	}

	/**
	 * Test running nslookup for a valid domain
	 *
	 * @throws IOException
	 *             if an error occurs while executing the command
	 */
	@Test
	@Disabled
	void testRunNslookupValid() throws IOException
	{
		String domain = "google.com";
		String result = DnsLookupExtensions.runNslookup(domain);
		System.out.println("Nslookup output for " + domain + ":\n" + result);

		assertNotNull(result, "Nslookup result should not be null");
		assertFalse(result.isEmpty(), "Nslookup result should not be empty");
	}

	/**
	 * Test running nslookup for an invalid domain
	 *
	 * @throws IOException
	 *             if an error occurs while executing the command
	 */
	@Test
	@Disabled
	void testRunNslookupInvalid() throws IOException
	{
		String result = DnsLookupExtensions.runNslookup("invalid.nonexistent.domain");
		System.out.println("Nslookup output for invalid domain:\n" + result);

		assertNotNull(result, "Nslookup result should not be null");
	}

	/**
	 * Test running dig for a valid domain
	 *
	 * @throws IOException
	 *             if an error occurs while executing the command
	 */
	@Test
	@Disabled
	void testRunDigValid() throws IOException
	{
		String domain = "google.com";
		String result = DnsLookupExtensions.runDig(domain);
		System.out.println("Dig output for " + domain + ":\n" + result);

		assertNotNull(result, "Dig result should not be null");
		assertFalse(result.isEmpty(), "Dig result should not be empty");
	}
}
