/*
 COPYRIGHT (c) NEXTREE Inc. 2014
 This software is the proprietary of NEXTREE Inc.
 @since 2014. 6. 10.
*/
package io.vizend.studyflow;

import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.SpringApplication;

@SpringBootApplication(scanBasePackages = { "io.vizend.studyflow" }, exclude = MongoAutoConfiguration.class)
@EnableJpaRepositories(basePackages = { "io.vizend.studyflow" })
@EntityScan(basePackages = { "io.vizend.studyflow" })
public class StudyflowBootApplication {
    /* Gen by Vizend Vista v7.0.0 */

    public static void main(String[] args) {
        /* Gen by Vizend Vista v7.0.0 */
        SpringApplication.run(StudyflowBootApplication.class, args);
    }
}
