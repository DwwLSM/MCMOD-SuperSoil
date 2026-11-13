# MCMOD-SuperSoil

NeoForge mod for Minecraft 1.21.1. It adds darkened Farmer's Delight rich soil and farmland. Crops on the custom farmland advance exactly one age whenever their crop random tick runs.

## Build

Use Java 21 and Gradle:

```sh
gradle build
```

The build uses NeoForge 21.1.219, Farmer's Delight 1.21.1-1.3.4 from Modrinth Maven, and SpongePowered Mixin. The Farmer's Delight minimum runtime version is 1.2.9.

Farmer's Delight's parent classes hard-code their own block IDs in hoe conversion, fertility checks, and farmland fallback. The addon redirects those few cases to its corresponding custom blocks; the inherited crop boost, mushroom conversion, moisture ticks, and other parent behavior remain intact.

## Texture edits

The four PNGs under `assets/superrichsoil/textures/block` are darkened copies of Farmer's Delight's rich soil textures. To regenerate them from the corresponding Farmer's Delight textures, with ImageMagick:

```sh
magick rich_soil.png -channel RGB -evaluate Multiply 0.65 +channel super_rich_soil.png
magick rich_soil_farmland.png -channel RGB -evaluate Multiply 0.65 +channel super_rich_soil_farmland.png
magick rich_soil_farmland_moist.png -channel RGB -evaluate Multiply 0.65 +channel super_rich_soil_farmland_moist.png
magick rich_soil_farmland_moist_side.png -channel RGB -evaluate Multiply 0.65 +channel super_rich_soil_farmland_moist_side.png
```

In Photoshop, GIMP, or Aseprite, open each source PNG, preserve its original dimensions and alpha channel, and reduce RGB brightness to 65% (or use a black Multiply layer at 35% opacity). Export each as PNG using the destination names above.

## In-game checks

1. Craft one Super Rich Soil from 4 Farmer's Delight Rich Soil and 5 Bone Meal in any 3x3 arrangement.
2. Place the soil and a crop above it; verify Farmer's Delight's normal rich-soil random bonemeal boost still works.
3. Till it with a hoe and verify the custom farmland hydrates, dries, and converts back to custom soil if it cannot survive.
4. Plant wheat on custom farmland. In darkness it should still advance by one stage on every crop random tick; mature crops must not change.
5. Plant wheat on ordinary farmland and verify vanilla light and growth-probability checks remain unchanged.
6. Compare the four custom soil textures with Farmer's Delight's originals: they should be visibly darker while retaining pixel detail.

The mixin intentionally bypasses the crop's ordinary light and chance checks only when the block below is `superrichsoil:super_rich_soil_farmland`. It does not change ordinary farmland or crop random ticks elsewhere.
