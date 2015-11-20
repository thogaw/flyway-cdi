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

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;

/**
 * Test-Class for {@link FlywayProducer}.
 * 
 * @author thogaw
 */
public final class FlywayProducerTest {
    
    /**
     * The class under test.
     */
    private FlywayProducer producer;
    
    /**
     * Setting up the tests.
     */
    @Before
    public void setUp() {
        producer = new FlywayProducer();
    }
    
    /**
     * Test for method
     * {@link FlywayProducer#produceFlyway(javax.sql.DataSource)}.
     */
    @Test
    public void testProduceFlyway() {
        DataSource ds = mock(DataSource.class);
        
        Flyway f = producer.produceFlyway(ds);
        
        assertThat(f.getDataSource(), is(ds));
    }
}
