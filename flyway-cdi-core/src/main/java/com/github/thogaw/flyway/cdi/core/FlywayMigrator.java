/*
 * Copyright 2015 G3S (Gawantka Software, Security and Service).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.thogaw.flyway.cdi.core;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import org.flywaydb.core.Flyway;

/**
 *
 * @author thogaw
 */
@ApplicationScoped
public class FlywayMigrator {
    
    /**
     * 
     */
    private Flyway flyway;

    /**
     * 
     * @param event 
     */
    public void migrationHandler(
            @Observes @Initialized(ApplicationScoped.class) Object event) {
        flyway.migrate();
    }
    
    /**
     * 
     * @param flyway 
     */
    @Inject
    void setFlyway(Flyway flyway) {
        this.flyway = flyway;
    }
    
}
