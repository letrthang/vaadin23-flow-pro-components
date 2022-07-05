package com.example.application.views.mappro;

import com.vaadin.flow.component.map.Map;
import com.vaadin.flow.component.map.configuration.Coordinate;
import com.vaadin.flow.component.map.configuration.View;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Map Pro")
@Route(value = "map-pro")
public class MapProView extends VerticalLayout {

    private Map map = new Map();

    public MapProView() {
        setSizeFull();
        setPadding(false);
        map.getElement().setAttribute("theme", "borderless");
        View view = map.getView();
        view.setCenter(Coordinate.fromLonLat(10.0, 55.0));
        view.setZoom(4);
        addAndExpand(map);
    }
}
