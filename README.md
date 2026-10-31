# Overview

<div style="text-align: center">

[![Java CI with Gradle](https://github.com/astrapi69/state-pattern/actions/workflows/gradle.yml/badge.svg)](https://github.com/astrapi69/state-pattern/actions/workflows/gradle.yml)
[![Coverage Status](https://codecov.io/gh/astrapi69/state-pattern/branch/develop/graph/badge.svg)](https://codecov.io/gh/astrapi69/state-pattern)
[![Open Issues](https://img.shields.io/github/issues/astrapi69/state-pattern.svg?style=flat)](https://github.com/astrapi69/state-pattern/issues)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/state-pattern/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/state-pattern)
[![Javadocs](http://www.javadoc.io/badge/io.github.astrapi69/state-pattern.svg)](http://www.javadoc.io/doc/io.github.astrapi69/state-pattern)
[![MIT License](http://img.shields.io/badge/license-MIT-brightgreen.svg?style=flat)](http://opensource.org/licenses/MIT)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits Of Code](https://hitsofcode.com/github/astrapi69/state-pattern?branch=develop)](https://hitsofcode.com/github/astrapi69/state-pattern/view?branch=develop)

</div>

# State Pattern Library

Welcome to the State Pattern Library! This library provides implementations of the state pattern for managing the states of various components such as buttons and wizards.

> Please support this project by simply putting a Github <a class="github-button" href="https://github.com/astrapi69/state-pattern" data-icon="octicon-star" aria-label="Star astrapi69/state-pattern on GitHub">
> Star ⭐</a>
>
> Share this library with friends on Twitter and everywhere else you can
>
> If you love this project
> [![Donation](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)


## Table of Contents

- [State Pattern Library](#state-pattern-library)
    - [Table of Contents](#table-of-contents)
    - [Installation](#import-dependencies-to-your-project)
    - [Usage](#usage)
        - [Button State Machine](#button-state-machine)
        - [Component State Machine](#component-state-machine)
        - [Wizard State Machine](#wizard-state-machine)
    - [Classes and Interfaces](#classes-and-interfaces)
    - [License](#license)


## Usage

### Button State Machine

The `ButtonStateMachine` class is an abstract class that provides states for buttons.

```java
import io.github.astrapi69.design.pattern.state.button.ButtonStateMachine;

public class MyButtonStateMachine extends ButtonStateMachine<JButton, MyButtonState> {

    @Override
    protected void updateButtonState() {
        // Implementation
    }

    @Override
    protected void setEnabled(boolean enabled) {
        button.setEnabled(enabled);
    }
}
```

### Component State Machine
The ComponentStateMachine class is an abstract class that provides states for components.

```java
import io.github.astrapi69.design.pattern.state.component.ComponentStateMachine;

public class MyComponentStateMachine extends ComponentStateMachine<JComponent, MyComponentState> {

    @Override
    protected void updateComponentState() {
        // Implementation
    }

    @Override
    protected void setEnabled(boolean enabled) {
        component.setEnabled(enabled);
    }
}
```
### Wizard State Machine
The WizardStateMachine class manages the state transitions for a wizard.

```java
import io.github.astrapi69.design.pattern.state.wizard.WizardStateMachine;
import io.github.astrapi69.design.pattern.state.wizard.WizardState;

public class MyWizardStateMachine extends WizardStateMachine {

    public MyWizardStateMachine() {
        setCurrentState(new MyFirstWizardState());
    }

    // Define your wizard states
}
```

## Note

No animals were harmed in the making of this library.

## License

The source code comes under the liberal MIT License, making state-pattern great for all types of applications.

## Import dependencies to your project

<details>
  <summary>gradle (click to expand)</summary>

## gradle dependency

Replace the variable ${latestVersion} with the current latest version: [![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/state-pattern/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.astrapi69/state-pattern)

You can first define the version in the ext section and add than the following gradle dependency to
your project `build.gradle` if you want to import the core functionality of state-pattern:

define version in file gradle.properties

```
statePatternVersion=${latestVersion}
```

or in build.gradle ext area

```
    statePatternVersion = "${latestVersion}"
```

then add the dependency to the dependencies area

```
    implementation("io.github.astrapi69:state-pattern:$statePatternVersion")
```

# with new libs.versions.toml file

If you use the new libs.versions.toml file for new automatic catalog versions update

```
[versions]
state-pattern-version= "${latestVersion}"

[libraries]
state-pattern = { module = "io.github.astrapi69:state-pattern", version.ref = "state-pattern-version" }
```
then add the dependency to the dependencies area

```
    implementation libs.state.pattern
```
</details>

<details>
  <summary>Maven (click to expand)</summary>

## Maven dependency

Maven dependency is now on sonatype.
Check out [sonatype repository](https://oss.sonatype.org/index.html#nexus-search;gav~io.github.astrapi69~state-pattern~~~) for latest snapshots and releases.

Add the following maven dependency to your project `pom.xml` if you want to import the core
functionality of state-pattern:

Then you can add the dependency to your dependencies:

    <properties>
        ...
```xml
        <!-- state-pattern version -->
        <state-pattern.version>${latestVersion}</state-pattern.version>
```
        ...
    </properties>
        ...
        <dependencies>
        ...
```xml
            <!-- state-pattern DEPENDENCY -->
            <dependency>
                <groupId>io.github.astrapi69</groupId>
                <artifactId>state-pattern</artifactId>
                <version>${state-pattern.version}</version>
            </dependency>
```
        ...
        </dependencies>
</details>


<details>
  <summary>Snapshots (click to expand)</summary>

## 📸 Snapshots

[![Snapshot](https://img.shields.io/badge/dynamic/xml?url=https://oss.sonatype.org/service/local/repositories/snapshots/content/io/github/astrapi69/state-pattern/maven-metadata.xml&label=snapshot&color=red&query=.//versioning/latest)](https://oss.sonatype.org/content/repositories/snapshots/io/github/astrapi69/state-pattern/)

This section describes how to import snapshot versions into your project.
Add the following code snippet to your gradle file in the repositories section:
```
repositories {
   //...
```
```groovy
    maven {
        name "Sonatype Nexus Snapshots"
        url "https://oss.sonatype.org/content/repositories/snapshots"
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

If state-pattern is useful to you, a star on [GitHub](https://github.com/astrapi69/state-pattern) helps others find it.
Sharing it or reporting a bug helps just as much.

If you would like to contribute financially, the channels are on the repository's Sponsor button, which
reads [.github/FUNDING.yml](.github/FUNDING.yml): GitHub Sponsors, Liberapay, Ko-fi and PayPal.

## Semantic Versioning

The versions of state-pattern are maintained with the Semantic Versioning guidelines.

Release version numbers will be incremented in the following format:

`<major>.<minor>.<patch>`

For detailed information on versioning you can visit the [wiki page](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

## What can i do to support this project

You can donate or contribute solve issues or pull request. Every support are welcome.

## Want to Help and improve it? ###

The source code for state-pattern are on GitHub. Please feel free to fork and send pull requests!

Create your own fork of [astrapi69/state-pattern/fork](https://github.com/astrapi69/state-pattern/fork)

To share your changes, [submit a pull request](https://github.com/astrapi69/state-pattern/pull/new/develop).

Don't forget to add new units tests on your changes.

## Contacting the Developers

Do not hesitate to contact the state-pattern developers with your questions, concerns, comments, bug reports, or feature requests.
- Feature requests, questions and bug reports can be reported at the [issues page](https://github.com/astrapi69/state-pattern/issues).

## Similar projects

## Credits
