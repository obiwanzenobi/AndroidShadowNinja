
# Be a shadow ninja!
![ninja](/images/androidNinja.png)
### Android elevation
---
## Elevation
- Dwa źródła światła Spot i Ambient |
- Jest bezpośrednio propercją RenderNode |
- Rysuje sie poza granicami widoku i jest ograniczony przez ClipBounds |
- Podstawą rysowania jest Outline widoku |
- Domyślnie Outline pobierany jest z Background |
+++
## Elevation to nie tylko cień
![translation](/images/shadowZ.png)
---
## Najczęstsze problemy
- Brak cienia |
- Cień nie jest rysowany w całości |
- Widok jest niewidoczny lub widoczny częściowo |
- Brak animacji cieni |
- Cienie, nie będące elevation (np. bitmapy) |

+++?image=images/shadowsTranslation.png

## Jak elevation jest rysowane?
- View.java |
- RenderNode.java -> RenderNode.cpp |
- FrameBuilder.cpp |
- TesselationCache.cpp |
- ShadowTessellator.cpp -> Ambient/SpotShadow.cpp |

---
## Elevation, dropshadow czy image?
---
### Questions?

<br>

@fa[twitter gp-contact](@wojciech_warwas)

@fa[github gp-contact](@obiwanzenobi)
