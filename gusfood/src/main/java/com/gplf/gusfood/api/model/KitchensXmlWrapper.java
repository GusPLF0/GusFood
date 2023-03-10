package com.gplf.gusfood.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.gplf.gusfood.domain.model.Kitchen;
import lombok.Data;
import lombok.NonNull;

import java.util.List;

@JacksonXmlRootElement(localName = "kitchens")
@Data
public class KitchensXmlWrapper {

    @JsonProperty("kitchen")
    @JacksonXmlElementWrapper(useWrapping = false)
    @NonNull
    private List<Kitchen> kitchens;
}
