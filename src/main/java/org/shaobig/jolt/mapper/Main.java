package org.shaobig.jolt.mapper;

import org.shaobig.jolt.mapper.transformer.RequestJson;

public class Main {

    private static final JoltMapper<Object> JOLT_MAPPER = JoltMapper.create("/scratch.json", Object.class);

    public static void main(String[] args) {
        RequestJson requestJson = new RequestJson("ABC");
        System.out.println(JOLT_MAPPER.transform(requestJson));
    }

}
