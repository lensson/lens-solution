package com.lens.auth.exception;


import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import lombok.SneakyThrows;



public class OAuth2ExceptionSerializer extends StdSerializer<CustomOAuth2Exception> {

    public OAuth2ExceptionSerializer() {
        super(CustomOAuth2Exception.class);
    }

    @Override
    @SneakyThrows
    public void serialize(CustomOAuth2Exception e, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeObjectField("code",e.getOAuth2ErrorCode());
        jsonGenerator.writeStringField("msg", e.getMessage());
        jsonGenerator.writeStringField("data", e.getOAuth2ErrorCode());
        jsonGenerator.writeEndObject();
    }
}
