package com.ddcat.entiry;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author dd-cat
 */
@Data
@Component
@ConfigurationProperties(prefix = "file")
public class FileProperties {
    private String prefix;
    private String path;
}
