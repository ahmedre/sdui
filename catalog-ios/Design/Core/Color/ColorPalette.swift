//
//  ColorPalette.swift
//  Catalog
//
//  Created by Ahmed El-Helw on 9/9/23.
//

import Foundation

enum ColorPalette : UInt64 {
  case lightPrimary = 0x0F61A4
  case lightOnPrimary = 0xFFFFFF
  case lightPrimaryContainer = 0xD2E4FF
  case lightOnPrimaryContainer = 0x001C37
  case lightSecondary = 0x006A67
  // case lightOnSecondary = 0xFFFFFF (lightOnPrimary)
  case lightSecondaryContainer = 0x6FF7F2
  case lightOnSecondaryContainer = 0x00201F
  case lightTertiary = 0x6251A6
  // case lightOnTertiary = 0xFFFFFF (lightOnPrimary)
  case lightTertiaryContainer = 0xE7DEFF
  case lightOnTertiaryContainer = 0x1D0160
  case lightError = 0xBA1A1A
  case lightErrorContainer = 0xFFDAD6
  // case lightOnError = 0xFFFFFF (lightOnPrimary)
  case lightOnErrorContainer = 0x410002
  case lightBackground = 0xFDFCFF
  case lightOnBackground = 0x1A1C1E
  // case lightSurface = 0xFDFCFF (lightBackground)
  // case lightOnSurface = 0x1A1C1E (lightOnBackground)
  case lightSurfaceVariant = 0xDFE2EB
  case lightOnSurfaceVariant = 0x43474E
  case lightOutline = 0x73777F
  case lightInverseOnSurface = 0xF1F0F4
  case lightInverseSurface = 0x2F3033
  // case lightInversePrimary = 0xA1C9FF (darkPrimary)
  case lightShadow = 0x000000
  // case lightSurfaceTint = 0x0F61A4 (lightPrimary)
  case lightOutlineVariant = 0xC3C6CF
  // case lightScrim = 0x000000 (lightShadow)
  
  
  case darkPrimary = 0xA1C9FF
  case darkOnPrimary = 0x00325A
  case darkPrimaryContainer = 0x00487F
  // case darkOnPrimaryContainer = 0xD2E4FF (lightPrimaryContainer)
  case darkSecondary = 0x4DDAD5
  case darkOnSecondary = 0x003735
  case darkSecondaryContainer = 0x00504E
  // case darkOnSecondaryContainer = 0x6FF7F2 (lightSecondaryContainer)
  case darkTertiary = 0xCBBEFF
  case darkOnTertiary = 0x332074
  case darkTertiaryContainer = 0x4A398C
  // case darkOnTertiaryContainer = 0xE7DEFF (lightTertiaryContainer)
  case darkError = 0xFFB4AB
  case darkErrorContainer = 0x93000A
  case darkOnError = 0x690005
  // case darkOnErrorContainer = 0xFFDAD6 (lightErrorContainer)
  // case darkBackground = 0x1A1C1E (lightOnBackground)
  case darkOnBackground = 0xE3E2E6
  // case darkSurface = 0x1A1C1E (lightOnBackground)
  // case darkOnSurface = 0xE3E2E6 (darkOnBackground)
  // case darkSurfaceVariant = 0x43474E (lightOnSurfaceVariant)
  // case darkOnSurfaceVariant = 0xC3C6CF (lightOutlineVariant)
  case darkOutline = 0x8D9199
  // case darkInverseOnSurface = 0x1A1C1E (lightOnBackground)
  // case darkInverseSurface = 0xE3E2E6 (darkOnBackground)
  // case darkInversePrimary = 0x0F61A4 (lightPrimary)
  // case darkShadow = 0x000000 (lightShadow)
  // case darkSurfaceTint = 0xA1C9FF (darkPrimary)
  // case darkOutlineVariant = 0x43474E (lightOnSurfaceVariant)
  // case darkScrim = 0x000000 (lightShadow)
}
