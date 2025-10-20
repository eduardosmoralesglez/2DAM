package com.docencia.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

public class JsonServiceNote {
    ObjectMapper mapper;

    public JsonServiceNote() {
        mapper = new JsonMapper();
    }

}
