package net.dmly.apiapplication.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class ControllerUtils {

    public static URI getLocation(Long id) {
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(id)
                .toUri();
    }

}
