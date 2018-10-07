# Be a shadow ninja!

### Android elevation
---
## Elevation
- Dwa źródła światła Spot i Ambient |
- Jest bezpośrednio propercją RenderNode |
- Rysuje sie poza granicami widoku i jest ograniczony przez ClipBounds |
- Podstawą rysowania jest Outline widoku |
- Domyślnie Outline pobierany jest z Background |
![magic1](/images/shadowZ.png)
+++?image=images/shadowZ.png&size=auto 70%
## Elevation to nie tylko cień
---
## Najczęstsze problemy
- Brak cienia |
- Cień nie jest rysowany w całości |
- Widok jest niewidoczny lub widoczny częściowo |
- Brak animacji cieni |
- Cienie, nie będące elevation (np. bitmapy) |
---
## Jak elevation jest rysowane?
![magic1](/assets/wizardMagic1.jpg)
- View.java |
- RenderNode.java -> RenderNode.cpp |
- FrameBuilder.cpp |
- TesselationCache.cpp |
- ShadowTessellator.cpp -> Ambient/Spot.cpp |

---
## Elevation, dropshadow czy image?
---
### Questions?

<br>

@fa[twitter gp-contact](@wojciech_warwas)

@fa[github gp-contact](@obiwanzenobi)
