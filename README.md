# Tally

Дневник питания на Kotlin Multiplatform + Compose Multiplatform для Android и iOS.
Продукты берутся из [Open Food Facts](https://world.openfoodfacts.org) и хранятся локально.

## Структура

```
androidApp/              Android-приложение (точка входа)
iosApp/                  iOS-приложение (Xcode-проект, точка входа)
shared/                  Собирает все feature:*:impl, Koin и навигацию; iOS-фреймворк Shared
core/
  domain/                Модели и use case
  data/                  Репозитории
  database/              Room KMP, DAO; схема в core/database/schemas
  network/               Ktor, Open Food Facts API
  ui/                    Тема, базовый MVI
  logging/               Kermit
feature/<name>/
  api/                   Маршруты и контракты фичи
  impl/                  Экраны и логика; зависит только от api других фич и core
convention-plugins/
  base/                  Базовая настройка: KMP-таргеты, Android SDK, Compose, тесты, хелперы
  project/               Плагины для модулей: kmp.library, kmp.compose.library, feature.api/impl,
                         kmp.room, kmp.ktor, kmp.koin, kmp.coroutines, kmp.serialization
config/detekt/           Конфиг detekt (только отличия от стандартного)
```

Фичи: `diary`, `products`, `scanner`, `profile`.
Версии библиотек — в `gradle/libs.versions.toml`.

## Требования

- JDK 17
- Android: minSdk 26
- iOS: Xcode (не только Command Line Tools) для сборки фреймворка и запуска приложения

## Сборка и запуск

- Android: `./gradlew :androidApp:assembleDebug` или run-конфигурация в Android Studio
- iOS: открыть `iosApp/iosApp.xcodeproj` в Xcode и запустить

## Тесты

- Android (JVM): `./gradlew testAndroidHostTest`
- iOS (симулятор): `./gradlew iosSimulatorArm64Test`

## Статический анализ

- Проверка: `./gradlew detekt`
- Автоисправление форматирования: `./gradlew detekt --auto-correct`
- Отчёты: `build/reports/detekt/` (HTML и SARIF)