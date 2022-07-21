package com.example.application.views;

import com.vaadin.flow.component.AttachEvent;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.DetachEvent;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.shared.Registration;

@Route("ui-eventbus")
public class UIEventBusRecipe extends VerticalLayout {

    public UIEventBusRecipe() {
        for (int i = 0; i < 5; i++) {
            add(new MyButton());
        }
    }

    private class ButtonActivateEvent extends ComponentEvent<Button> {

        public ButtonActivateEvent(Button source, boolean fromClient) {
            super(source, fromClient);
        }
    }

    private class MyButton extends Button {
        private Registration registration;

        private MyButton() {
            deactivate();
            addClickListener(event -> {
                activate();
                // Fire an event on the event bus
                ComponentUtil.fireEvent(UI.getCurrent(), new ButtonActivateEvent(this, false));
            });
        }

        private void activate() {
            this.setText("Active!");
        }

        private void deactivate() {
            this.setText("Click me");
        }

        @Override
        protected void onAttach(AttachEvent attachEvent) {
            super.onAttach(attachEvent);
            // Register to events from the event bus
            registration = ComponentUtil.addListener(attachEvent.getUI(), ButtonActivateEvent.class, event -> {
                if (event.getSource() != this) {
                    deactivate();
                }
            });
        }

        @Override
        protected void onDetach(DetachEvent detachEvent) {
            super.onDetach(detachEvent);
            // Unregister from the event bus
            registration.remove();
        }
    }
}