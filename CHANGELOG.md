## Change log
----------------------

Version 6.1-SNAPSHOT
-------------

## [Unreleased]

### Chores
- Updated copyright year from **2015** to **2022** across all project files
- Applied changes to source files, test files, and module-info.java for consistency
- No functional modifications, purely metadata updates

### Refactoring
- Moved `SshConnector` to `net.ssh` package
- Moved `ProxyPropertyKey` to `net.properties` package
- Moved `IPResolver` and `IPResolverTest` to `net.ip` package
- Moved `ShellExecutorTest` to `net.shell` package
- Moved `SocketExtensionsTest` to `net.socket` package
- Updated `module-info.java` to export new packages

### Enhancements
- Added `DnsLookupExtensions` in `net.dns` package for DNS lookup utilities
- Added `IpInfoExtensions` in `net.ip` package with utility methods for IP information retrieval

### Improvements
- Improved `URLExtensionsTest` by replacing `new URL(...)` with `new URI(...).toURL()`

### Removals
- Deleted `lombok.config`
- Removed obsolete `package.html` file

Version 6.0
-------------

ADDED:

- new CHANGELOG.md file created

CHANGED:

- moved all related files from lightblueseas repository 'net-extensions' to this repository

Notable links:
[keep a changelog](http://keepachangelog.com/en/1.0.0/) Don’t let your friends dump git logs into changelogs
