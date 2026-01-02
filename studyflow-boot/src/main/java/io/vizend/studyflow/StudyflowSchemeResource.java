/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow;

import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import org.springframework.core.io.Resource;
import org.springframework.beans.factory.annotation.Value;
import java.io.IOException;
import io.vizend.accent.util.json.JsonUtil;
import io.vizend.studyflow.domain.role.StudyflowRoles;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StudyflowSchemeResource {
    /* Gen by Vizend Vista v7.0.0 */
    private final Map<String, Object> scheme;

    public StudyflowSchemeResource(@Value("classpath:drama.json") Resource resourceFile) throws IOException {
        /* Gen by Vizend Vista v7.0.0 */
        String json = new String(resourceFile.getInputStream().readAllBytes());
        this.scheme = JsonUtil.fromJson(json, Map.class);
    }

    @GetMapping("/scheme")
    public Map<String, Object> scheme() {
        /* Gen by Vizend Vista v7.0.0 */
        return this.scheme;
    }
}
