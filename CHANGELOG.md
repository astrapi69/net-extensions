## Change log
----------------------

Version 6.2-SNAPSHOT
-------------


Version 6.1
-------------

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
- Marked utility classes as `final` to prevent subclassing:
    - `URLExtensions`
    - `IPResolver`
    - `SocketExtensions`
    - `DnsLookupExtensions`
    - `IpInfoExtensions`
- Added private constructors to enforce non-instantiability
- Cleaned up an unnecessary blank line in `IpInfoExtensionsTest`

### Enhancements
- Added `DnsLookupExtensions` in `net.dns` package for DNS lookup utilities
- Added `IpInfoExtensions` in `net.ip` package with utility methods for IP information retrieval

### Improvements
- Improved `URLExtensionsTest` by replacing `new URL(...)` with `new URI(...).toURL()`

### Removals
- Deleted `lombok.config`
- Removed obsolete `package.html` file

### Known issues
6.1 is not binary compatible with 6.0, although it is a minor release. Code compiled against 6.0 that uses one of
the members below fails with 6.1 at run time; recompile it against 6.1 with the change named in its bullet. No
repository of the family is affected (measured 2026-11-18).

- `URLExtensions` (`io.github.astrapi69.net.url`) is now `final` and its constructor is private. `new URLExtensions()`
  throws `IllegalAccessError`, and a subclass throws `IncompatibleClassChangeError` (cannot inherit from final class)
  when it is loaded. The static methods are unchanged: call them on the class, without an instance or a subclass.
- `SocketExtensions` (`io.github.astrapi69.net.socket`) is now `final` and its constructor is private, with the same
  errors as `URLExtensions`. The static methods are unchanged: call them on the class, without an instance or a
  subclass.
- `ProxyPropertyKey` moved from `io.github.astrapi69.net` to `io.github.astrapi69.net.properties`, and the module no
  longer exports `io.github.astrapi69.net`. A caller gets `NoClassDefFoundError: io/github/astrapi69/net/ProxyPropertyKey`.
  Import `io.github.astrapi69.net.properties.ProxyPropertyKey`; its constants and `getValue()` are the same.
- `IPResolver` moved from `io.github.astrapi69.net` to `io.github.astrapi69.net.ip` and is now `final` with a private
  constructor. A caller gets `NoClassDefFoundError: io/github/astrapi69/net/IPResolver`. Import
  `io.github.astrapi69.net.ip.IPResolver`; its static methods are the same.
- `ChatRoom.setChatusers(Collection)` returns `void` instead of the `ChatRoom`. A caller gets
  `NoSuchMethodError: 'io.github.astrapi69.net.chat.ChatRoom io.github.astrapi69.net.chat.ChatRoom.setChatusers(java.util.Collection)'`.
  Recompile against 6.1; a call chained on the returned room calls the next method on the room itself.

Version 6.0
-------------

ADDED:

- new CHANGELOG.md file created

CHANGED:

- moved all related files from lightblueseas repository 'net-extensions' to this repository

Notable links:
[keep a changelog](http://keepachangelog.com/en/1.0.0/) Don’t let your friends dump git logs into changelogs
