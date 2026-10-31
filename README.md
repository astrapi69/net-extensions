
<div style="text-align: center">

[![Build Status](https://github.com/astrapi69/net-extensions/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/net-extensions/actions/workflows/gradle.yml)
[![Coverage Status](https://codecov.io/gh/astrapi69/net-extensions/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/net-extensions)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/net-extensions.svg?style=flat)](https://github.com/astrapi69/net-extensions/issues)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.astrapi69/net-extensions?style=plastic)](https://search.maven.org/artifact/io.github.astrapi69/net-extensions)
[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/net-extensions.svg)](http://www.javadoc.io/doc/io.github.astrapi69/net-extensions)
[![MIT License](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/net-extensions?branch=develop)](https://hitsofcode.com/github/astrapi69/net-extensions/view?branch=develop)

</div>

# Overview

repository that holds utility classes for net operations.  A small documentation how to use this template project in in the
[wiki](https://github.com/astrapi69/net-extensions/wiki)

> Please support this project by simply putting a Github <!-- Place this tag where you want the button to render. -->
<a class="github-button" href="https://github.com/astrapi69/net-extensions" data-icon="octicon-star" aria-label="Star astrapi69/net-extensions on GitHub">Star ⭐</a>
>
> Share this library with friends on Twitter and everywhere else you can
>
> If you love this project [![donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)

## Note

No animals were harmed in the making of this library.

## License

The source code comes under the liberal MIT License, making net-extensions great for all types of applications.

## Import dependencies to your project

<details>
  <summary>gradle (click to expand)</summary>

## gradle dependency

Replace the variable ${latestVersion} with the current latest
version: [![Maven Central](https://img.shields.io/maven-central/v/io.github.astrapi69/net-extensions?style=plastic)](https://search.maven.org/artifact/io.github.astrapi69/net-extensions)

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of net-extensions:

define version in file gradle.properties

```
netExtensionsVersion=${latestVersion}
```

or in build.gradle ext area

```
    netExtensionsVersion = "${latestVersion}"
```

then add the dependency to the dependencies area

```
    implementation("io.github.astrapi69:net-extensions:$netExtensionsVersion")
```

# with new libs.versions.toml file

If you use the new libs.versions.toml file for new automatic catalog versions update

```
[versions]
```
```
net-extensions-version= "${latestVersion}"
```
```
[libraries]
```
```
net-extensions = { module = "io.github.astrapi69:net-extensions", version.ref = "net-extensions-version" }
```

then add the dependency to the dependencies area

```
    implementation libs.net.extensions
```

</details>

<details>
  <summary>Maven (click to expand)</summary>

## Maven dependency

The library is on Maven Central. Check out [Maven Central](https://central.sonatype.com/artifact/io.github.astrapi69/net-extensions) for the latest release.

Add the following maven dependency to your project `pom.xml` if you want to import the core
functionality of net-extensions:

Then you can add the dependency to your dependencies:

    <properties>
        ...

```xml
        <!-- net-extensions version -->
        <net-extensions.version>${latestVersion}</net-extensions.version>
```

        ...
    </properties>
        ...
        <dependencies>
        ...

```xml
            <!-- net-extensions DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>net-extensions</artifactId>
                <version>${net-extensions.version}</version>
            </dependency>
```

        ...
        </dependencies>

</details>


<details>
  <summary>Snapshots (click to expand)</summary>

## 📸 Snapshots

This section describes how to import snapshot versions into your project.
Add the following code snippet to your gradle file in the repositories section:

```
repositories {
   //...
```

```groovy
    maven {
        name "Central Portal Snapshots"
        url "https://central.sonatype.com/repository/maven-snapshots/"
        mavenContent {
            snapshotsOnly()
        }
    }
```

```
}
```

</details>

## Support this project

If net-extensions is useful to you, a star on [GitHub](https://github.com/astrapi69/net-extensions) helps others find it.
Sharing it or reporting a bug helps just as much.

If you would like to contribute financially, the channels are on the repository's Sponsor button, which
reads [.github/FUNDING.yml](.github/FUNDING.yml): GitHub Sponsors, Liberapay, Ko-fi and PayPal.

## Semantic Versioning

The versions of net-extensions are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning you can visit
the [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## What can i do to support this project

You can donate or contribute solve issues or pull request. Every support are welcome.

## Want to Help and improve it? ###

The source code for net-extensions are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/net-extensions/fork](https://github.com/astrapi69/net-extensions/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/net-extensions/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contributing

Contributions are welcome! Please feel free to submit a pull request or open an issue if you have any suggestions or
improvements.

## Contacting the Developers

Do not hesitate to contact the net-extensions developers with your questions, concerns, comments, bug reports, or
feature requests.

- Feature requests, questions and bug reports can be reported at
  the [issues page](https://github.com/astrapi69/net-extensions/issues).

## Credits

|**Maven Central**|
|     :---:      |
|[![Maven Central](https://img.shields.io/maven-central/v/io.github.astrapi69/net-extensions?style=for-the-badge)](https://central.sonatype.com/artifact/io.github.astrapi69/net-extensions)|
|Special thanks to [sonatype repository](https://www.sonatype.com) for providing a free maven repository service for open source projects|
|     <img width=1000/>     |

|**codecov.io**|
|     :---:      |
|[![Coverage Status](https://codecov.io/gh/astrapi69/net-extensions/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/net-extensions)|
|Special thanks to [codecov.io](https://codecov.io) for providing a free code coverage for open source projects|
|     <img width=1000/>     |

|**javadoc.io**|
|     :---:      |
|[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/net-extensions.svg)](http://www.javadoc.io/doc/io.github.astrapi69/net-extensions)|
|Special thanks to [javadoc.io](http://www.javadoc.io) for providing a free javadoc documentation for open source projects|
|     <img width=1000/>     |
