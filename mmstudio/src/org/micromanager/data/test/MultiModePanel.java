package org.micromanager.data.test;

import com.google.common.eventbus.EventBus;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

/**
 * This class is a JPanel that displays a set of vertically-oriented buttons
 * on the left, each of which is associated with a Component. When the button
 * is clicked, the corresponding component is shown/hidden to the right.
 */
class MultiModePanel extends JPanel {
   HashMap<Component, VerticalButton> widgetToButton_;
   ArrayList<Component> orderedWidgets_;
   JPanel buttonPanel_;
   JPanel modePanel_;
   EventBus bus_;
   public MultiModePanel(EventBus bus) {
      bus_ = bus;
      widgetToButton_ = new HashMap<Component, VerticalButton>();
      orderedWidgets_ = new ArrayList<Component>();
      buttonPanel_ = new JPanel(new MigLayout("insets 0, flowy"));
      modePanel_ = new JPanel(new MigLayout("insets 0, flowy"));
      setLayout(new MigLayout("insets 0"));
      add(buttonPanel_, "growy");
      add(modePanel_, "growy");
   }

   public void addMode(String label, Component widget) {
      final VerticalButton button = new VerticalButton(label);
      widgetToButton_.put(widget, button);
      orderedWidgets_.add(widget);
      buttonPanel_.add(button);
      // Add an event to show/hide the appropriate widget.
      button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent event) {
            redoLayout();
         }
      });
      validate();
   }

   /**
    * Change which widgets we are showing.
    */
   private void redoLayout() {
      modePanel_.removeAll();
      for (Component widget : orderedWidgets_) {
         if (widgetToButton_.get(widget).isSelected()) {
            modePanel_.add(widget);
         }
      }
      bus_.post(new LayoutChangedEvent());
   }
}
