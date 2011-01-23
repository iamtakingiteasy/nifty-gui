package de.lessvoid.nifty.controls.slider.builder;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.NiftyIdCreator;
import de.lessvoid.nifty.controls.dynamic.attributes.ControlAttributes;
import de.lessvoid.nifty.controls.listbox.ListBoxControl;
import de.lessvoid.nifty.elements.Element;
import de.lessvoid.nifty.loaderv2.types.ControlType;
import de.lessvoid.nifty.loaderv2.types.ElementType;
import de.lessvoid.nifty.screen.Screen;

public class CreateSliderControl extends ControlAttributes {
  public CreateSliderControl(final boolean vertical) {
    setId(NiftyIdCreator.generate());
    initName(vertical);
  }

  public CreateSliderControl(final boolean vertical, final String id) {
    setId(id);
    initName(vertical);
  }

  private void initName(final boolean vertical) {
    if (vertical) {
      setName("verticalSlider");
    } else {
      setName("horizontalSlider");
    }
  }

  @SuppressWarnings("rawtypes")
  public ListBoxControl create(
      final Nifty nifty,
      final Screen screen,
      final Element parent) {
    nifty.addControl(screen, parent, getStandardControl());
    nifty.addControlsWithoutStartScreen();
    return parent.findControl(attributes.get("id"), ListBoxControl.class);
  }

  @Override
  public ElementType createType() {
    return new ControlType(attributes);
  }
}
