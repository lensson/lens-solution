package com.lens.auth.component;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.lens.auth.exception.CustomOAuth2Exception;
import lombok.SneakyThrows;

/**
 * Desc:
 *
 * @author Lens Chen
 * @created 2020-10-16 2:39 PM
 */
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
