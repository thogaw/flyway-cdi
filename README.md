<!--
 ~ Copyright 2015 G3S (Gawantka Software, Security and Service)
 ~
 ~ Licensed under the Apache License, Version 2.0 (the "License");
 ~ you may not use this file except in compliance with the License.
 ~ You may obtain a copy of the License at
 ~
 ~     http://www.apache.org/licenses/LICENSE-2.0
 ~
 ~ Unless required by applicable law or agreed to in writing, software
 ~ distributed under the License is distributed on an "AS IS" BASIS,
 ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 ~ See the License for the specific language governing permissions and
 ~ limitations under the License.
 -->

# Flyway-CDI

Flyway-CDI is a support-library that integrates flyway into CDI.


## Usage

The simplest way to use this library is to include the api as compile-dependency:

```xml
<dependency>
    <groupId>com.github.thogaw.flyway-cdi</groupId>
    <artifactId>flyway-cdi-api</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

And include the core as runtime-dependency:

```xml
<dependency>
    <groupId>com.github.thogaw.flyway-cdi</groupId>
    <artifactId>flyway-cdi-core</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <scope>runtime</scope>
</dependency>
```

Further you have to implement a producer for your DataSource like this:

```java
@ApplicationScoped
public class DataSourceProducer {

    @Resource
    private DataSource dataSource;

    @Produces
    @Flyway
    public DataSource produce() {
        return dataSource;
    }
}
```


## License

```
Copyright 2015 G3S (Gawantka Software, Security and Service)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
