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

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * Junit-Runner with Weld-SE/CDI-Integration.
 *
 * @author thogaw
 */
public class WeldJunit4Runner extends BlockJUnit4ClassRunner {

    /**
     * The Weld container.
     */
    private final WeldContainer container;

    /**
     * Creates a new Junit4-Runner.
     *
     * @param klass The test-class.
     * @throws InitializationError If an error occurs while validating the
     * test-class.
     */
    public WeldJunit4Runner(Class<?> klass) throws InitializationError {
        super(klass);
        Weld weld = new Weld();
        container = weld.initialize();
    }

    @Override
    protected Object createTest() throws Exception {
        return container.instance().select(getTestClass().getJavaClass()).get();
    }

}
