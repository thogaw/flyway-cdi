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

import com.github.thogaw.flyway.cdi.api.Flyway;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.sql.DataSource;
import org.apache.derby.jdbc.EmbeddedDataSource;
import org.flywaydb.core.api.MigrationInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Integration-Test for migrating the database with flyway CDI integration.
 *
 * @author thogaw
 */
@RunWith(WeldJunit4Runner.class)
public class MigrationIT {

    /**
     * The DataSource-Producer for the integration-test.
     */
    @ApplicationScoped
    public static class DataSourceProducer {

        /**
         * Produce the data-source for the integration-test.
         *
         * @return The data-source.
         */
        @Produces
        @Flyway
        public DataSource produce() {
            EmbeddedDataSource eds = new EmbeddedDataSource();
            eds.setCreateDatabase("create");
            eds.setPassword("sa");
            eds.setUser("sa");
            eds.setDatabaseName("memory:test");

            return eds;
        }
    }

    /**
     * The flyway-instance used.
     */
    @Inject
    private org.flywaydb.core.Flyway flyway;

    /**
     * Test the migration results.
     */
    @Test
    public void testMigration() {
        MigrationInfoService info = flyway.info();

        assertThat(info.pending().length, is(0));
        assertThat(info.current().getVersion().getVersion(), is("1"));
    }
}
