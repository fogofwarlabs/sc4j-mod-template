<h1 align="center">
  <img src="https://raw.githubusercontent.com/fogofwarlabs/sc4j/main/docs/branding/sc4j-logo.svg" alt="SC4J logo" width="160">
  <br>
  SC4J Mod Template
</h1>

<p align="center">The smallest complete SC4J mod: build, run and install it, then make it your game.</p>

<p align="center">
  <a href="LICENSE"><img src="https://img.shields.io/badge/license-0BSD-blue" alt="License: 0BSD"></a>
</p>

<p align="center"><b>English</b> | <a href="README.ko.md">한국어</a></p>

---

A mod is one jar that the SC4J runtime loads and the launcher lists. This template builds it with the SC4J mod plugin from Maven Central; no local engine is needed.

## Files

| File | Content |
|---|---|
| `src/main/java/com/example/mymod/MyMod.java` | entry: a headless runner that logs one line, and the first screen |
| `src/main/java/com/example/mymod/FirstScene.java` | screen: one colour with a square; Escape ends the run |
| `src/main/resources/sc4j-mod.json` | manifest; the plugin adds `version` and `engine` to the jar's copy |
| `build.gradle` | mod plugin |
| `settings.gradle` | Maven Central, plugin version, project name |
| `gradle.properties` | mod version `version`, SC4J version `sc4jVersion`, install `sc4j.install` |
| `.github/workflows/ci.yml` | build and headless run on every push and pull request |
| `.github/workflows/release.yml` | GitHub release with the jar and its checksum for each tag `v<version>` |

## Make it yours

Click "Use this template" on GitHub, then rename:

| What | Where |
|---|---|
| mod id: lower-case letters and digits in groups joined by single hyphens, unique; the jar is `<id>.jar` | `id` in `sc4j-mod.json` |
| project name | `rootProject.name` in `settings.gradle` |
| package and entry class | folder `src/main/java/com/example/mymod/`, the `package` lines, `entry` in `sc4j-mod.json` |
| name in the launcher | `name` in `sc4j-mod.json` |
| mod version | `version` in `gradle.properties` |
| licence | `LICENSE`; the jar carries it in `META-INF/` |

## Build, run and install

JDK 25 is required; the Gradle wrapper fetches Gradle. Commands run in PowerShell (`./gradlew` on Linux).

| Command | Result |
|---|---|
| `.\gradlew.bat build` | compiles and builds `build/libs/<id>.jar` |
| `.\gradlew.bat run` | runs the jar in a window with the SC4J runtime of `sc4jVersion` |
| `.\gradlew.bat run --args=--headless` | runs the headless runner; ends with exit code 0 |
| `.\gradlew.bat installMod -Psc4j.install=<install>` | copies the jar into `<install>/mods/` |

An install is an unpacked `SC4J-<version>.zip` of the [SC4J releases](https://github.com/fogofwarlabs/sc4j/releases). `SC4J.exe --list` there shows the mod `READY`; the launcher starts it. `sc4j.install=<install>` in `gradle.properties` (Windows path with forward slashes) replaces `-Psc4j.install`; `run` then uses the install's user data, else `build/sc4j-run/`.

## Release

1. Set `version` in `gradle.properties` and commit.
2. Push the tag `v<version>` (`git tag v1.0.0`, `git push origin v1.0.0`). The workflow `release.yml` builds the jar and creates the GitHub release with `<id>.jar` and `<id>.jar.sha256`. Players install the latest release from the launcher by the repository name `owner/name`.
3. To list the mod in the launcher's catalog, open a pull request to [`fogofwarlabs/sc4j-mods`](https://github.com/fogofwarlabs/sc4j-mods) that adds `{"name": "...", "repository": "owner/name", "description": "..."}` to `mods.json`.

## Documentation

| Guide | Topic |
|---|---|
| [Mod author guide](https://github.com/fogofwarlabs/sc4j/blob/main/docs/mod-guide.md) | manifest, content, rules, maps, screens, network play |
| [Engine API policy](https://github.com/fogofwarlabs/sc4j/blob/main/docs/api-policy.md) | API scope, versions, internal elements |

## Licence

The template's files are under [0BSD](LICENSE): use them for any purpose, without keeping a notice.
