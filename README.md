# Auris

> AirPods companion app for Android and Linux — unlocked features, no compromises.

Auris implements the proprietary protocol used to exchange data between AirPods and Apple devices, enabling features like changing noise control modes, fast ear detection, accurate battery status, head gestures, conversational awareness, and more on non-Apple platforms.

**All features are available for free — no premium restrictions.**

---

## Features

| Feature | Linux | Android |
|---|---|---|
| Changing Listening Mode | ✅ | ✅ |
| Ear Detection | ✅ | ✅ |
| Battery Status | ✅ | ✅ |
| Renaming AirPods | ✅ | ✅ |
| Head Gestures | ⛔ | ✅ |
| Conversational Awareness | ✅ | ✅ |
| Automatic Connection | ✅ | ✅ |
| Hearing Aid | 🔴 | ⚪ |
| Transparency Mode Customization | 🔴 | ⚪ |
| Multi-device Connectivity | ⚪ | ⚪ |
| Accessibility Settings | 🔴 | ✅ |
| Spatial Audio | ❓ | ❓ |
| Heart Rate Monitoring | ⛔ | 🔴 |

| Symbol | Meaning |
|---|---|
| ✅ | Implemented and works |
| ⚪ | Requires VendorID spoofing |
| 🔴 | Not yet implemented |
| ⛔ | Will not be implemented |
| ❓ | Unknown |

## Installation

- **[Android](/android/README.md)** — Download the APK from [Releases](https://github.com/GARFIELD5211/Auris/releases)
- **[Linux](/linux/README.md)** — AppImage or binary available

## Building from Source

### Android

```bash
# Requirements: JDK 21, Android SDK (API 37), NDK 30
cd android

# Generate a signing key (if you don't have one)
keytool -genkeypair -v -keystore ../my-release.jks -keyalg RSA -keysize 2048 -validity 10000 -alias mykey

# Configure local.properties with your SDK path and signing config
# Then build:
./gradlew assembleFossRelease
```

### Linux

```bash
# Requirements: Qt 6, CMake, PulseAudio dev headers
cd linux
mkdir build && cd build
cmake ..
make
```

## VendorID Spoofing

Changing the VendorID in the DID Profile to Apple's (`004C`) unlocks special features:

- **Linux:** Edit `/etc/bluetooth/main.conf` and add `DeviceID = bluetooth:004C:0000:0000`
- **Android:** Enable "Act as Apple device" in app settings (requires Xposed)

## Credits

### Special Thanks
- @tyalie for the first protocol documentation ([AAP-Protocol-Definition](https://github.com/tyalie/AAP-Protocol-Defintion))
- @rithvikvibhu for helping with the hearing aid feature
- @pabloaul for the Wireshark dissector ([apple-wireshark](https://github.com/pabloaul/apple-wireshark))
- @devnoname120 for the first root patch
- @timgromeyer for the first version of the Linux app

## License

```
Auris - AirPods companion for Android

Copyright (C) 2025 Auris contributors

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program. If not, see <https://www.gnu.org/licenses/>.
```

## Trademark Notice

AirPods, AirPods Pro, AirPods Max, and the AirPods logo are trademarks of Apple Inc. This project is not affiliated with or endorsed by Apple Inc.
