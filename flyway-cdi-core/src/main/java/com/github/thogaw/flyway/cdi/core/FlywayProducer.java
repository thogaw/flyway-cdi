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
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;
import org.flywaydb.core.Flyway;

/**
 * The producer for the applications flyway instance.
 *
 * @author thogaw
 */
@ApplicationScoped
public class FlywayProducer {

    /**
     * Producer-Method for the applications flyway instance.
     *
     * @param dataSource The dependent datasource, required for the flyway
     * setup.
     * @return The applications flyway instance.
     */
    @Produces
    public Flyway produceFlyway(
            @com.github.thogaw.flyway.cdi.api.Flyway DataSource dataSource) {
        Flyway f = new Flyway();
        f.setDataSource(dataSource);
        return f;
    }

}
