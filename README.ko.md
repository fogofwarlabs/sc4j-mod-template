<h1 align="center">
  <img src="https://raw.githubusercontent.com/fogofwarlabs/sc4j/main/docs/branding/sc4j-logo.svg" alt="SC4J 로고" width="160">
  <br>
  SC4J Mod Template
</h1>

<p align="center">가장 작은 완전한 SC4J 모드. 빌드하고 실행하고 설치한 뒤 자신의 게임으로 만드세요.</p>

<p align="center">
  <a href="LICENSE"><img src="https://img.shields.io/badge/license-0BSD-blue" alt="License: 0BSD"></a>
</p>

<p align="center"><a href="README.md">English</a> | <b>한국어</b></p>

---

모드는 SC4J 런타임이 불러오고 런처가 보여 주는 jar 하나입니다. 이 템플릿은 Maven Central의 SC4J 모드 플러그인으로 jar를 빌드하며, 로컬 엔진이 필요 없습니다.

## 파일

| 파일 | 내용 |
|---|---|
| `src/main/java/com/example/mymod/MyMod.java` | 진입 클래스: 로그 한 줄을 남기는 헤드리스 러너와 첫 화면 |
| `src/main/java/com/example/mymod/FirstScene.java` | 화면: 한 색과 사각형 하나. Escape로 실행을 끝냅니다 |
| `src/main/resources/sc4j-mod.json` | 매니페스트. 플러그인이 jar의 사본에 `version`과 `engine`을 넣습니다 |
| `build.gradle` | 모드 플러그인 |
| `settings.gradle` | Maven Central, 플러그인 버전, 프로젝트 이름 |
| `gradle.properties` | 모드 버전 `version`, SC4J 버전 `sc4jVersion`, 설치본 `sc4j.install` |
| `.github/workflows/ci.yml` | 푸시와 풀 리퀘스트마다 빌드와 헤드리스 실행 |
| `.github/workflows/release.yml` | 태그 `v<version>`마다 jar와 체크섬을 담은 GitHub 릴리즈 |

## 내 모드로 만들기

GitHub에서 "Use this template"을 누른 뒤 다음을 바꿉니다.

| 항목 | 위치 |
|---|---|
| 모드 id: 소문자와 숫자 묶음을 하이픈 하나로 이은 고유한 이름. jar는 `<id>.jar` | `sc4j-mod.json`의 `id` |
| 프로젝트 이름 | `settings.gradle`의 `rootProject.name` |
| 패키지와 진입 클래스 | 폴더 `src/main/java/com/example/mymod/`, `package` 줄, `sc4j-mod.json`의 `entry` |
| 런처에 보이는 이름 | `sc4j-mod.json`의 `name` |
| 모드 버전 | `gradle.properties`의 `version` |
| 라이선스 | `LICENSE`. jar의 `META-INF/`에 들어갑니다 |

## 빌드, 실행, 설치

JDK 25가 필요하며, Gradle 래퍼가 Gradle을 받아 옵니다. 명령은 PowerShell 기준입니다(Linux에서는 `./gradlew`).

| 명령 | 결과 |
|---|---|
| `.\gradlew.bat build` | 컴파일하고 `build/libs/<id>.jar`를 빌드 |
| `.\gradlew.bat run` | `sc4jVersion`의 SC4J 런타임으로 jar를 창에서 실행 |
| `.\gradlew.bat run --args=--headless` | 헤드리스 러너 실행. 종료 코드 0으로 끝남 |
| `.\gradlew.bat installMod -Psc4j.install=<install>` | jar를 `<install>/mods/`에 복사 |

설치본은 [SC4J 릴리즈](https://github.com/fogofwarlabs/sc4j/releases)의 `SC4J-<version>.zip`을 푼 폴더입니다. 그 폴더에서 `SC4J.exe --list`는 모드를 `READY`로 보여 주고, 런처가 모드를 시작합니다. `gradle.properties`의 `sc4j.install=<install>`(Windows 경로는 슬래시로)은 `-Psc4j.install`을 대신하며, 이때 `run`은 설치본의 사용자 데이터를, 없으면 `build/sc4j-run/`을 씁니다.

## 릴리즈

1. `gradle.properties`의 `version`을 정하고 커밋합니다.
2. 태그 `v<version>`을 push합니다(`git tag v1.0.0`, `git push origin v1.0.0`). 워크플로 `release.yml`이 jar를 빌드하고 `<id>.jar`와 `<id>.jar.sha256`을 담은 GitHub 릴리즈를 만듭니다. 플레이어는 런처에서 저장소 이름 `owner/name`으로 최신 릴리즈를 설치합니다.
3. 런처의 모드 목록에 올리려면 [`fogofwarlabs/sc4j-mods`](https://github.com/fogofwarlabs/sc4j-mods)에 `mods.json`에 `{"name": "...", "repository": "owner/name", "description": "..."}`를 추가하는 풀 리퀘스트를 엽니다.

## 문서

| 가이드 | 주제 |
|---|---|
| [모드 제작 가이드](https://github.com/fogofwarlabs/sc4j/blob/main/docs/mod-guide.ko.md) | 매니페스트, 콘텐츠, 규칙, 맵, 화면, 네트워크 플레이 |
| [엔진 API 정책](https://github.com/fogofwarlabs/sc4j/blob/main/docs/api-policy.ko.md) | API 범위, 버전, 내부 요소 |

## 라이선스

템플릿의 파일은 [0BSD](LICENSE)입니다. 고지 없이 어떤 목적으로든 쓸 수 있습니다.
