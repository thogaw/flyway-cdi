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
package com.github.thogaw.flyway.cdi.api;

import java.util.Objects;
import javax.sql.DataSource;

/**
 *
 * @author thogaw
 */
public final class FlywayConfiguration {
    
    private final DataSource dataSource;

    public FlywayConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.dataSource);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FlywayConfiguration other = (FlywayConfiguration) obj;
        return Objects.equals(this.dataSource, other.dataSource);
    }

    @Override
    public String toString() {
        return "FlywayConfiguration{" + "dataSource=" + dataSource + '}';
    }
    
}
