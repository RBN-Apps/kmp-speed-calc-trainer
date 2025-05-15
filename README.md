[![Build Status](https://github.com/RBN-Apps/kmp-speed-calc-trainer/actions/workflows/build.yml/badge.svg)](https://github.com/RBN-Apps/kmp-speed-calc-trainer/actions)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.1.0-blue.svg?style=flat-square)](https://kotlinlang.org)
[![Compose MP](https://img.shields.io/badge/Compose%20MP-1.7.0-purple.svg?style=flat-square)](https://github.com/JetBrains/compose-multiplatform)
[![Platforms](https://img.shields.io/badge/Targets-Android%20|%20iOS%20|%20Desktop%20|%20WASM-lightgrey.svg?style=flat-square)](#features)
[![Ask DeepWiki](https://deepwiki.com/badge.svg)](https://deepwiki.com/RBN-Apps/kmp-speed-calc-trainer)

# Speed Calc Trainer

A Kotlin Multiplatform application built with Compose that helps you train your multiplication speed.  
Available on **Android**, **iOS**, **Desktop** (Windows/macOS/Linux) and **WebAssembly**.

## Table of Contents

- [Features](#features)  
- [Getting Started](#getting-started)  
- [Prerequisites](#prerequisites) 
- [Project Structure](#project-structure)  

## Features

- **Practice Mode** – Random multiplication questions with instant feedback  
- **Configurable Ranges** – Set minimum and maximum values for each factor  
- **Smooth Animations** – Feedback fades in/out and slides for a polished feel  
- **Multiplatform UI** – Single codebase sharing Compose UI across all targets  
- **Easy Deployment** – GitHub Actions to build & release artifacts for every platform  

## Getting Started

1. **Clone** this repo  
   ```bash
   git clone https://github.com/RBN-Apps/kmp-speed-calc-trainer.git
   cd kmp-speed-calc-trainer
   ```

2. **Build** all targets with Gradle

   ```bash
   ./gradlew build
   ```
3. **Run** on your platform of choice:

   * **Android**: Open `composeApp` in Android Studio and run on emulator/device
   * **Desktop**:

     ```bash
     ./gradlew :composeApp:runDesktop
     ```
   * **Web (WASM)**:

     ```bash
     ./gradlew :composeApp:wasmJsBrowserDevelopmentRun
     ```

## Prerequisites

* **JDK 17+**
* **Gradle 8.9** (wrapper included)
* **Android Studio Flamingo** (for Android/iOS)
* **Xcode 15+** (for iOS)
* **Yarn & Node.js** (for WebAssembly)

## Project Structure

```
.
├── composeApp       # Multiplatform Compose module
│   ├── src
│   │   ├── commonMain  # Shared UI & logic
│   │   ├── androidMain
│   │   ├── iosMain
│   │   ├── desktopMain
│   │   └── wasmJsMain
│   └── build.gradle.kts
├── iosApp           # SwiftUI wrapper for iOS
├── build.gradle.kts
├── settings.gradle.kts
└── .github           # CI workflows
```
