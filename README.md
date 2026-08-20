# No GE Inventory Blink

A RuneLite plugin that stops the inventory from blinking/flashing (yellow pulse) while the Grand Exchange window is open.

## Why?

While the Grand Exchange window is open, the OSRS client runs a script (`ge_offer_side_draw` / `script811`) every game tick that pulses the transparency of the yellow glow (`GeOffersSide.GLOW`) around the inventory grid shown in the GE window. This makes the inventory appear to blink/flash yellow, which many players find distracting.

This plugin stops the effect by hiding the GE glow component (`GeOffersSide.GLOW`) while the GE window is open, and keeps the main inventory item layer fully opaque as a safety net. It does not interfere with clicking, dragging, or hovering items.

## Features

- Hides the pulsing GE glow while the Grand Exchange window is open (configurable)
- Keeps the main inventory item layer fully opaque while the GE window is open (configurable)

## Requirements

- JDK 11 (the RuneLite build targets Java 11)

## Building

```sh
./gradlew build          # compile + tests
./gradlew shadowJar      # build the plugin jar
./gradlew run            # launch the RuneLite dev client with this plugin loaded
```

## Installing

**Locally (dev):** run `./gradlew run` and log in with your OSRS account.

**Normal launcher:** build the jar with `./gradlew shadowJar`, then start RuneLite with

```
java -jar RuneLite.jar --plugin path/to/no-ge-inventory-blink-all.jar
```

**Plugin Hub:** push this repository to GitHub (public), add a BSD 2-Clause license, and submit a pull request to the [plugin-hub](https://github.com/runelite/plugin-hub) repository with the repository URL and commit hash in `plugins/no-ge-inventory-blink`.