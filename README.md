# No GE Inventory Blink

A RuneLite plugin that stops the inventory from blinking/flashing (yellow pulse) while the Grand Exchange window is open.

## Why?

While the Grand Exchange window is open, the OSRS client runs a script (`ge_offer_side_draw` / `script811`) every game tick that pulses the transparency of the yellow glow (`GeOffersSide.GLOW`) around the inventory grid shown in the GE window. This makes the inventory appear to blink/flash yellow, which many players find distracting.

This plugin stops the effect by hiding the GE glow component (`GeOffersSide.GLOW`) while the GE window is open, and keeps the main inventory item layer fully opaque as a safety net. It does not interfere with clicking, dragging, or hovering items.

## Features

- Hides the pulsing GE glow while the Grand Exchange window is open (configurable)
- Keeps the main inventory item layer fully opaque while the GE window is open (configurable)
