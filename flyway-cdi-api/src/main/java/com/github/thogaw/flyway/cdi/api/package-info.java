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
/**
 * API-Packge of flyway-cdi library. This package contains all public API
 * artifacts required by clients to integration flyway into its CDI graph.
 *
 * The simplest way to initialize flyway and provide its dependencies, is to
 * create a producer for your applications {@link java.sql.DataSource} like the
 * following example:
 *
 * <pre>
 * <code>
 * &#64;ApplicationScoped
 * class DataSourceProducer {
 *     &#64;Resource private DataSource ds;
 *
 *     &#64;Produces
 *     &#64;Flyway
 *     DataSource produce() {
 *         return ds;
 *     }
 * }
 * </code>
 * </pre>
 *
 * @author thogaw
 */
package com.github.thogaw.flyway.cdi.api;
